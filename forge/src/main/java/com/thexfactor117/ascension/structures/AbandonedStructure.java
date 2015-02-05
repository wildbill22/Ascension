package com.thexfactor117.ascension.structures;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.thexfactor117.ascension.help.LogHelper;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;
import com.thexfactor117.ascension.structures.StructureCoordinates.Structures;
import com.thexfactor117.ascension.structures.StructureList;

/**
 * All structures extend this class. The steps to add a structure:
 * 1) Get a schematic with permissions to use (if creating structure from scratch, 
 *    create in a flat world and then skip to step 3.
 * 2) Use mcedit to put structure in flat world.
 * 3) Add a chest in each location where you want a chest to randomly appear. Note the location of the entrance
 * 4) Export the structure with mcedit to a schematic.
 * 5) Use a schematic to Java converter to create a Java class file.
 * 6) Add the Java file to the structures package. 
 * 7) Edit the code, using the Abandoned house as a template.
 * 8) Add generating structure in AscensionWorldGeneration, setting the location of the entrance
 * 
 * @author WILLIAM
*/ 
public abstract class AbandonedStructure extends WorldGenerator implements Runnable
{
	public AbandonedStructure(int structureMissingBlockChance,
			int structureSpawnHeightTolerance, int structureSpawnChance,
			Structures structureType, Block[] validSpawnBlocks,
			String[] mobsToSpawn, int doorX, int doorZ, int xMax, int zMax) {
		super();
		this.structureMissingBlockChance = structureMissingBlockChance;
		this.structureSpawnHeightTolerance = structureSpawnHeightTolerance;
		this.structureSpawnChance = structureSpawnChance;
		this.structureType = structureType;
		this.validSpawnBlocks = validSpawnBlocks;
		this.mobsToSpawn = mobsToSpawn;
		this.doorX = doorX;
		this.doorZ = doorZ;
		this.xMax = xMax;
		this.zMax = zMax;
	}

	protected int structureMissingBlockChance;  // Set this to about 1/10 number of blocks
	protected int structureSpawnHeightTolerance;
	public int structureSpawnChance; // chance n/100
	public Structures structureType = Structures.OTHER;
	protected Block[] validSpawnBlocks;
	protected String[] mobsToSpawn;
	public int doorX;
	public int doorZ;
	public int xMax;
	public int zMax;
	protected Block[] validBaseBlocks = { Blocks.bedrock, Blocks.clay, Blocks.coal_ore, Blocks.cobblestone,
			Blocks.diamond_ore, Blocks.dirt, Blocks.emerald_ore, Blocks.end_stone, Blocks.glass,
			Blocks.glowstone, Blocks.gold_ore, Blocks.gravel, Blocks.hardened_clay, Blocks.ice, Blocks.iron_ore,
			Blocks.lapis_ore, Blocks.mossy_cobblestone, Blocks.netherrack, Blocks.obsidian, 
			Blocks.quartz_ore, Blocks.redstone_ore, Blocks.sandstone, Blocks.soul_sand, Blocks.stone,
			Blocks.wool, Blocks.sand };
	protected int floorLevel = 0;
	public ArrayList<RandomChestItem> randomChestItems;
	
	// For generating chests (if more than one)
	protected int numGenerated = 0;

	// Variables used when using a separate thread to generate structure
	World threadWorld = null;
	Random threadRandom;
	int threadX;
	int threadY;
	int threadZ;
	int threadXBase;
	int threadZBase;
	int threadXBaseMax;
	int threadZBaseMax;
	private boolean generateBase;
	static public boolean running = false;
	protected Block baseBlock; 

	// Used when generateStructureInThread is used instead of generateStructure
	@Override
	public void run() 
	{
		if (threadWorld == null)
			LogHelper.error("Call generateStructureInThread first!");
		generate(threadWorld, threadRandom, threadX, threadY, threadZ);
		
		if (generateBase) {
			if (baseBlock == null)
				baseBlock = Blocks.cobblestone;
				
			generateStructureBase(threadWorld, threadRandom, 
					threadXBase, threadZBase, threadXBaseMax, threadZBaseMax, baseBlock);
		}
	}

	// To use this:
	// 1) Add "if (running) return false;" in generate, to avoid too many threads
	// 2) Call generateStructureInThread(...); instead of: generateStructure(...);
	// 3) Put preventLag() in generateStructure function every 100 lines
	// 4) Set "running" to false at end of last generateStructureX() call 
	public boolean generateStructureInThread(World world, Random random, int x, int y, int z, int xBase, int zBase, int xBaseMax, int zBaseMax, boolean generateBase) 
	{
		threadWorld = world;
		threadRandom = random;
		threadX = x;
		threadY = y;
		threadZ = z;
		// These are for the base. First two are same as x and y, but maybe a offset for a structure with smaller base than top
		// xBaseMax & zBaseMax are the size of the structure at the base 
		threadXBase = xBase;
		threadZBase = zBase;
		threadXBaseMax = xBaseMax;
		threadZBaseMax = zBaseMax;
		this.generateBase = generateBase;
		running = true;
		Thread thread = new Thread(this);
		thread.start();
		
		return true;
	}

	// To use this:
	// 1) Add "if (running) return false;" in generate, to avoid too many threads
	// 2) Call generateStructureInThread(...); instead of: generateStructure(...);
	// 3) Put preventLag() in generateStructure function every 100 lines
	// 4) Set "running" to false at end of last generateStructureX() call 
	public boolean generateStructureInThread(World world, Random random, StructureCoordinates coords, boolean generateBase) 
	{
		threadWorld = world;
		threadRandom = random;
		threadX = coords.posX;
		threadY = coords.posY;
		threadZ = coords.posZ;
		// These are for the base. First two are same as x and y, but maybe a offset for a structure with smaller base than top
		// xBaseMax & zBaseMax are the size of the structure at the base 
		threadXBase = coords.posX;
		threadZBase =coords.posZ ;
		threadXBaseMax = xMax;
		threadZBaseMax = zMax;
		this.generateBase = generateBase;
		running = true;
		Thread thread = new Thread(this);
		thread.start();
		
		return true;
	}

	protected void preventLag()
	{
		try           
		{              
			Thread.sleep(400);            
		}          
		catch (InterruptedException interruptedException)          
		{              
			LogHelper.error("generateStructure interrupted while sleeping! " + interruptedException);
		}  
	}

	// Put blocks under structure so it isn't floating in air
	public void generateStructureBase(World world, Random random, int x, int z, int xMax, int zMax, Block block) {
		if (floorLevel == 0) {
			LogHelper.error("Set floorLevel in generateStructure method!!!!!");
			return;
		}
		LogHelper.info("Generating base of structure at: " + x + "," + floorLevel + "," + z + "!");
		boolean placedBlock = true;
		for (int baseY = floorLevel - 1; baseY >= floorLevel - structureSpawnHeightTolerance && placedBlock == true; baseY--) {
			placedBlock = false;
			for (int baseX = x; baseX <= x + xMax; baseX++) {
				for (int baseZ = z; baseZ <= z + zMax; baseZ++) {
					if (!isValidBaseBlock(world, baseX, baseY, baseZ)) {
						world.setBlock(baseX, baseY, baseZ, block);
						placedBlock = true;
					}
				}
			}
		}
	}

	// Checks that block under structure is a valid block (mostly just not air)
	protected boolean isValidBaseBlock(World world, int x, int y, int z)
	{
		Block block = world.getBlock(x, y, z);
		for (Block spawnBlock : validBaseBlocks){
			if (block == spawnBlock)
			{
				return true;
			}
		}
		return false;
	}

	// Generates some random loot in the chest
	private void setRandomSlots(TileEntityChest chestEntity, int slot, Item item, int min, int max, int chance) 
	{
		Random rand = new Random();
		int randomChance = rand.nextInt(100);
		if (chestEntity.getStackInSlot(slot) == null && chance > randomChance)
		{
			int randomQty = rand.nextInt(max - min + 1) + min;
			ItemStack items = new ItemStack(item, randomQty);
			chestEntity.setInventorySlotContents(slot, items);
		}
	}

	/**
	 * Replace a setBlock for a chest with this function with all the parameters, and a few extra 
	 * @param world 
	 * @param random
	 * @param x
	 * @param y
	 * @param z
	 * @param metaData
	 * @param chance 1/n chance that the chest will be created at the x, y, z location (set to 1 generate chest)
	 * @param generated set to true to not generate a chest
	 * @return true if chest is generated
	 */
	protected boolean generateChest(World world, Random random, int x, int y, int z, int metaData, int chance, boolean generated){
		if (!generated && random.nextInt(chance) == 0)
		{			
			//adding a chest with random stuff
			setBlock(world, random, x, y, z, Blocks.chest, metaData, 2);
			TileEntityChest chestEntity = new TileEntityChest();
			world.setTileEntity(x, y, z, chestEntity);
			if (randomChestItems != null) {
				// item, min to add, max to add, chance N/100
				// Add items with lowest chance first
				for (int i = 0; i < randomChestItems.size(); i++) {
					if (i > 26) {
						LogHelper.error("Too many items assigned to spawn in chest!");
						break;
					}
					setRandomSlots(chestEntity, randomChestItems.get(i).slot, randomChestItems.get(i).item, randomChestItems.get(i).min,
							randomChestItems.get(i).max, randomChestItems.get(i).probability);
				}
			}
			return true;
		}		
		return generated;
	}
	
	/**
	 * Replace a setBlock for a chest with this function with all the parameters, and a few extra 
	 * @param world 
	 * @param random
	 * @param x1 First Chest x, y, z
	 * @param y1
	 * @param z1
	 * @param x2 2nd Chest x, y, z
	 * @param y2
	 * @param z2
	 * @param metaData
	 * @param generated set to true to generate the 2nd chest
	 * @return true if chest is generated
	 */
	protected boolean generateDoubleChest(World world, Random random, int x1, int y1, int z1, int x2, int y2, int z2, int metaData, int chance, boolean generated){
		if (!generated && random.nextInt(chance) == 0)
		{			
			//adding a chest with random stuff
			setBlock(world, random, x1, y1, z1, Blocks.chest, metaData, 2);
			setBlock(world, random, x2, y2, z2, Blocks.chest, metaData, 2);
			TileEntityChest chestEntity = new TileEntityChest();
			world.setTileEntity(x1, y1, z1, chestEntity);
			if (randomChestItems != null) {
				// item, min to add, max to add, chance N/100
				// Add items with lowest chance first
				for (int i = 0; i < randomChestItems.size(); i++) {
					if (i > 53) {
						LogHelper.error("Too many items assigned to spawn in chest!");
						break;
					}
					setRandomSlots(chestEntity, randomChestItems.get(i).slot, randomChestItems.get(i).item, 
							randomChestItems.get(i).min, randomChestItems.get(i).max, randomChestItems.get(i).probability);
				}
			}
			return true;
		}		
		return generated;
	}
	
	/**
	 * Replace a setBlock for a chest with this function with all the parameters, and a few extra 
	 * @param world 
	 * @param random
	 * @param x
	 * @param y
	 * @param z
	 * @param metaData
	 * @param chance 1/n chance that the chest will be created at the x, y, z location (set to 1 generate chest)
	 * @param numToGenerate set to the number of chests to generate
	 * @return true if chest is generated
	 */
	protected boolean generateChest(World world, Random random, int x, int y, int z, int metaData, int chance, int numToGenerate){
		if (this.numGenerated < numToGenerate && random.nextInt(chance) == 0)
		{			
			//adding a chest with random stuff
			setBlock(world, random, x, y, z, Blocks.chest, metaData, 2);
			TileEntityChest chestEntity = new TileEntityChest();
			world.setTileEntity(x, y, z, chestEntity);
			if (randomChestItems != null) {
				// item, min to add, max to add, chance N/1000
				// Add items with lowest chance first
				for (int i = 0; i < randomChestItems.size(); i++) {
					setRandomSlots(chestEntity, randomChestItems.get(i).slot, randomChestItems.get(i).item, randomChestItems.get(i).min,
							randomChestItems.get(i).max, randomChestItems.get(i).probability);				
				}
			}
			return true;
		}		
		return false;
	}

	/**
	 * Adds item(s) to a chest in the designated slot with the probability given 
	 * @param slot slot where the item will randomly appear
	 * @param item item to add randomly to chest 
	 * @param min minimum to add to a slot (0 - 64)
	 * @param max maximum to add to a slot (1 - 64)
	 * @param probability n/100 chance of any one slot having this item
	 */
	protected void addRandomChestItem(int slot, Item item, int min, int max, int probability) {
		if (randomChestItems == null)
			randomChestItems = new ArrayList<RandomChestItem>();
		if (probability > 100)
			probability = 100;
		if (min <= max && max <= 64 && slot < 27 && probability >= 0)
			randomChestItems.add(new RandomChestItem(slot, item, min, max, probability));
		else
			LogHelper.error("One of the parameters for adding " + item.getUnlocalizedName() + " to chest is wrong!");
	}
	
//	/**
//	 * Adds item(s) to a chest in the designated slot with the probability given 
//	 * @param slot slot where the item will randomly appear
//	 * @param item item to add randomly to chest 
//	 * @param min minimum to add to a slot (0 - 64)
//	 * @param max maximum to add to a slot (1 - 64)
//	 * @param probability n/100 chance of any one slot having this item
//	 */
//	protected void addRandomDoubleChestItem(int slot, Item item, int min, int max, int probability) {
//		if (randomChestItems == null)
//			randomChestItems = new ArrayList<RandomChestItems>();
//		if (min <= max && max <= 64 && slot < 54 && probability >= 0 && probability <= 100)
//			randomChestItems.add(new RandomChestItems(slot, item, min, max, probability));
//		else
//			LogHelper.error("One of the parameters for adding " + item.getUnlocalizedName() + " to chest is wrong!");
//	}
	
	/**
	 * Replace a setBlock for a mob_spawner with this function with all the parameters, and a few extra 
	 * @param world 
	 * @param random
	 * @param x
	 * @param y
	 * @param z
	 * @param metaData
	 */
	protected void generateMobSpawner(World world, Random random, int x, int y, int z, int metaData){
		boolean setEntity = false;

		if (mobsToSpawn == null || mobsToSpawn.length == 0)
			return;
		
		setBlock(world, random, x, y, z, Blocks.mob_spawner, 0, 3);
		TileEntityMobSpawner spawner = new TileEntityMobSpawner();
		world.setTileEntity(x, y, z, spawner);

		// Set to a random entity from an array of possible mobs
		for (int i = 0; i < mobsToSpawn.length && setEntity == false; i++) {
			if (random.nextInt(mobsToSpawn.length) == 0) {
				LogHelper.info("Generating a mob spawner with " + mobsToSpawn[i]);
				spawner.func_145881_a().setEntityName(mobsToSpawn[i]);
			}				
		}
		if (setEntity == false) {
			spawner.func_145881_a().setEntityName(mobsToSpawn[0]);			
		}
	}
	
	protected class RandomChestItem {
		int slot;
		Item item;
		int min;
		int max;
		int probability;
		
		protected RandomChestItem(int slot, Item item, int min, int max, int probability) {
			this.slot = slot;
			this.item = item;
			this.min = min;
			this.max = max;
			this.probability = probability;
		}
	}

	// Checks that chunk has been created and meets the spawn requirements
	private boolean spawnedAtLocationEdges(World world, int x, int y, int z, int xMax, int zMax)
	{
		y = world.getHeightValue(x + doorX, z + doorZ);
		if (y == 0 || (!world.blockExists(x, y, z) || !world.blockExists(x + xMax, y, z) ||
				 !world.blockExists(x, y, z + zMax) || !world.blockExists(x + xMax, y, z + zMax)))
			return false;
		y = world.getHeightValue(x + doorX, z + doorZ);
		int xHalf = x + (xMax / 2);
		int zHalf = z + (zMax / 2);
		// check that each side has valid spawn blocks
		// Check top, left, right, and bottom
		if(locationIsValidSpawn(world, x + 3, y, z) && locationIsValidSpawn(world, xHalf, y, z) && locationIsValidSpawn(world, x + xMax - 3, y, z)  
			&& locationIsValidSpawn(world, x, y, z + 3) && locationIsValidSpawn(world, x, y, z + zHalf) && locationIsValidSpawn(world, x, y, z + zMax - 3)  
			&& locationIsValidSpawn(world, x + xMax, y, z + 3) && locationIsValidSpawn(world, x + xMax, y, z + zHalf) && locationIsValidSpawn(world, x + xMax, y, z + zMax - 3)  
			&& locationIsValidSpawn(world, x + 3, y, z+ zMax) && locationIsValidSpawn(world, x + 15, y, z+ zMax) && locationIsValidSpawn(world, x + xMax - 3, y, z+ zMax))
		{
			return true;
		}
		return false;
	}
	
	// Tries 4 locations around selected spawn point to avoid placing in a chunk not yet created
	public boolean isValidSpawnEdges(World world, StructureCoordinates coords)
	{
		int x = coords.posX;
		int z = coords.posZ;
		int y = world.getHeightValue(x + doorX, z + doorZ);
		
		// Don't place if another structures is nearby
		if (y == 0 || StructureList.findNearestStructure(x, y, z) < 64)
			return false;
		
		if (spawnedAtLocationEdges(world, x, y, z, xMax, zMax)) {
			return true;			
		}
		// try the North
		if (spawnedAtLocationEdges(world, x, y, z - zMax, xMax, zMax)) {
			coords.posZ = z - zMax;
			return true;			
		}
		// try to the West
		if (spawnedAtLocationEdges(world, x - xMax, y, z, xMax, zMax)) {
			coords.posX = x - xMax;
			return true;			
		}
		// try to the South
		if (spawnedAtLocationEdges(world, x, y, z + zMax, xMax, zMax)) {
			coords.posZ = z + zMax;
			return true;			
		}
		// try to the East
		if (spawnedAtLocationEdges(world, x + xMax, y, z, xMax, zMax)) {
			coords.posX = x + xMax;
			return true;
		}

		return false;
	}

	// Checks that chunk has been created and meets the spawn requirements
	private boolean spawnedAtLocation(World world, int x, int y, int z, int xMax, int zMax)
	{
		y = world.getHeightValue(x + doorX, z + doorZ);
		if (y == 0 || (!world.blockExists(x, y, z) || world.blockExists(x + xMax, y, z) ||
				 world.blockExists(x, y, z + zMax) || world.blockExists(x + xMax, y, z + zMax)))
		if (world.blockExists(x + xMax, y, z + zMax))
		{
			if(locationIsValidSpawn(world, x, y, z) 
					&& locationIsValidSpawn(world, x + xMax, y, z) 
					&& locationIsValidSpawn(world, x + xMax, y, z + zMax) 
					&& locationIsValidSpawn(world, x, y, z + zMax)){
				return true;
			}
		}
		return false;
	}
	
	// Tries 4 locations around selected spawn point to avoid placing in a chunk not yet created
	public boolean isValidSpawnCorners(World world, StructureCoordinates coords)
	{
		int x = coords.posX;
		int z = coords.posZ;
		int y = world.getHeightValue(x + doorX, z + doorZ);
		
		// Don't place if another structures is nearby
		if (y == 0 || StructureList.findNearestStructure(x, y, z) < 64)
			return false;
		
		if (spawnedAtLocation(world, x, y, z, xMax, zMax)) {
			return true;			
		}
		// try the North
		if (spawnedAtLocation(world, x, y, z - zMax, xMax, zMax)) {
			coords.posZ = z - zMax;
			return true;			
		}
		// try to the West
		if (spawnedAtLocation(world, x - xMax, y, z, xMax, zMax)){
			coords.posX = x - xMax;
			return true;			
		}
		// try to the South
		if (spawnedAtLocation(world, x, y, z + zMax, xMax, zMax)) {
			coords.posZ = z + zMax;
			return true;			
		}
		// try to the East
		if (spawnedAtLocation(world, x + xMax, y, z, xMax, zMax)) {
			coords.posX = x + xMax;
			return true;			
		}

		return false;
	}

	// Works fairly well to place the building where the stairs are on ground level
	// Could be improved to rotate structure so none of it is in the air
	public boolean locationIsValidSpawn(World world, int x, int y, int z)
	{
		int distanceToAir = 0;
		Block check = world.getBlock(x, y, z);
		while (check != Blocks.air){
			if (distanceToAir > structureSpawnHeightTolerance)
			{
				return false;
			}
			distanceToAir++;
			check = world.getBlock(x, y + distanceToAir, z);
		}
		y += distanceToAir - 1;
		Block block = world.getBlock(x, y, z);
		Block blockAbove = world.getBlock(x, y+1, z);
		Block blockBelow = world.getBlock(x, y-1, z);
		for (Block spawnBlock : validSpawnBlocks){
			if (blockAbove != Blocks.air)
			{
				return false;
			}
			if (block == spawnBlock)
			{
				return true;
			}
			else if ((block == Blocks.snow || block == Blocks.tallgrass) && blockBelow == spawnBlock)
			{
				return true;
			}
		}
		return false;
	}

	// This is where the "abandonded" look of the building is created. Some blocks are not placed.
	protected void setBlock(World world, Random random, int x, int y, int z, Block block, int metadata, int flag)
	{
		int chance = random.nextInt(structureMissingBlockChance); // put here, doesn't work in if block (weird bug)
		// Don't place some blocks that are above floor level
		if(block == Blocks.air || block == Blocks.chest || y == floorLevel || block == Blocks.wooden_door || structureMissingBlockChance == 1 || chance > 0)
			world.setBlock(x, y, z, block, metadata, flag);
	}
	
	// Chest stuff
	protected int addItemsForAllChests(int i, int m) {
		// 8 total
		
		// In all chests - minecraft vanilla
		Random random = new Random();
		int n = 3;
		switch (random.nextInt(n)) {
			case 0:
				addRandomChestItem(i++, Items.iron_ingot, 1, 3, 7 * n * m);
				break;
			case 1:
				addRandomChestItem(i++, Items.gold_ingot, 1, 2, 7 * n * m);
				break;
			case 2:
				addRandomChestItem(i++, Items.diamond, 1, 2, 3 * n * m);
				break;
		}
		n = 4;
		switch (random.nextInt(n)) {
			case 0:
				addRandomChestItem(i++, Items.emerald, 1, 1, 2 * n * m);
				break;
			case 1:
				addRandomChestItem(i++, Items.rotten_flesh, 1, 4, 10 * n * m);
				break;
			case 2:
				addRandomChestItem(i++, Items.bone, 1, 3, 8 * n * m);
				break;
			case 3:
				addRandomChestItem(i++, Items.wheat, 1, 4, 10 * n * m);
				break;
			}
		
		// In all chests - modItems
		n = 3;
		switch (random.nextInt(n)) {
			case 0:
				addRandomChestItem(i++, ModItems.titaniumIngot, 1, 2, 6 * n * m);
				break;
			case 1:
				addRandomChestItem(i++, ModItems.vexalIngot, 1, 1, 5 * n * m);
				break;
			case 2:
				addRandomChestItem(i++, ModItems.rawVenison, 1, 3, 10 * n * m);
				break;
		}
		n = 3;
		switch (random.nextInt(n)) {
		case 0:
			addRandomChestItem(i++, ModItems.coldBlazeRod, 1, 2, 8 * n * m);
			break;
		case 1:
			addRandomChestItem(i++, ModItems.sharkTeeth, 1, 2, 9 * n * m);
			break;
		case 2:
			addRandomChestItem(i++, ModItems.golemGyro, 1, 1, 5 * n * m);
			break;
		}

		// In all chests - modArmory
		n = 3;
		switch (random.nextInt(n)) {
			case 0:
				addRandomChestItem(i++, ModArmory.blazeSword, 1, 1, 2 * n * m);
				break;
			case 1:
				addRandomChestItem(i++, ModArmory.iceSword, 1, 1, 3 * n * m);
				break;
			case 2:
				addRandomChestItem(i++, ModArmory.razorSword, 1, 1, 2 * n * m);
				break;
			}
		
		// In all chests - modArmory - titanium tools & weapons
		n = 4;
		switch (random.nextInt(n)) {
			case 0:
				addRandomChestItem(i++, ModArmory.titaniumAxe, 1, 1, 4 * n * m);
				break;
			case 1:
				addRandomChestItem(i++, ModArmory.titaniumPick, 1, 1, 4 * n * m);
				break;
			case 2:
				addRandomChestItem(i++, ModArmory.titaniumShovel, 1, 1, 4 * n * m);
				break;
			case 3:
				addRandomChestItem(i++, ModArmory.titaniumSword, 1, 1, 4 * n * m);
				break;
			}

		// In all chests - modArmory - titanium armor
		n = 2;
		switch (random.nextInt(n)) {
			case 0:
				addRandomChestItem(i++, ModArmory.titaniumBoots, 1, 1, 4 * n * m);
				break;
			case 1:
				addRandomChestItem(i++, ModArmory.titaniumHelm, 1, 1, 4 * n * m);
				break;
		}
		n = 2;
		switch (random.nextInt(n)) {
			case 0:
				addRandomChestItem(i++, ModArmory.titaniumPants, 1, 1, 4 * n * m);
				break;
			case 1:
				addRandomChestItem(i++, ModArmory.titaniumPlate, 1, 1, 4 * n * m);
				break;
			}

		return i;
	}

	// Add 6 items
	protected int addItemsForAllDungeons(int i, int m) {
		Random random = new Random();

		// More ModItems for All Mob Dungeons (6):
		// Since only 1 of n, changed probability to * n
		int n = 3;
		switch (random.nextInt(n)) {
			case 0:
				addRandomChestItem(i++, ModItems.steelIngot, 1, 1, 4 * n * m);
				break;
			case 1:
				addRandomChestItem(i++, ModItems.crystal, 1, 2, 4 * n * m);
				break;
			case 2:
				addRandomChestItem(i++, ModItems.fleroviumShard, 1, 1, 2 * n * m);
				break;
		}
		n = 3;
		switch (random.nextInt(n)) {
			case 0:
				addRandomChestItem(i++, ModItems.crystalShard, 1, 3, 5 * n * m);
				break;
			case 1:
				addRandomChestItem(i++, ModItems.iceGem, 1, 1, 3 * n * m);
				break;
			case 2:
				addRandomChestItem(i++, ModItems.blazeGem, 1, 1, 3 * n * m);
				break;
			}

		// More ModArmory for All Dungeons (13):
		n = 3;
		switch (random.nextInt(n)) {
			case 0:
				addRandomChestItem(i++, ModArmory.steelAxe, 1, 1, 3 * n * m);
				break;
			case 1:
				addRandomChestItem(i++, ModArmory.steelBoots, 1, 1, 3 * n * m);
				break;
			case 2:
				addRandomChestItem(i++, ModArmory.steelHelm, 1, 1, 3 * n * m);
				break;
			}
		n = 3;
		switch (random.nextInt(n)) {
		case 0:
			addRandomChestItem(i++, ModArmory.steelPants, 1, 1, 3 * n * m);
			break;
		case 1:
			addRandomChestItem(i++, ModArmory.steelPick, 1, 1, 3 * n * m);
			break;
		case 2:
			addRandomChestItem(i++, ModArmory.steelPlate, 1, 1, 3 * n * m);
			break;
		}
		n = 3;
		switch (random.nextInt(n)) {
		case 0:
			addRandomChestItem(i++, ModArmory.steelShovel, 1, 1, 3 * n * m);
			break;
		case 1:
			addRandomChestItem(i++, ModArmory.steelSword, 1, 1, 3 * n * m);
			break;
		case 2:
			addRandomChestItem(i++, ModArmory.crystallizedSword, 1, 1, 2 * n * m);
			break;
		}
		n = 4;
		switch (random.nextInt(n)) {
		case 0:
			addRandomChestItem(i++, ModArmory.gyroMace, 1, 1, 1 * n * m);
			break;
		case 1:
			addRandomChestItem(i++, ModArmory.shadowBlade, 1, 1, 1 * n * m);
			break;
		case 2:
			addRandomChestItem(i++, ModArmory.etherealBlade, 1, 1, 1 * n * m);
			break;
		case 3:
			addRandomChestItem(i++, ModArmory.wingedBlade, 1, 1, 1 * n * m);
			break;
		}
		
		return i;
	}

	// Add 1 item
	protected int addItemsForHardDungeons(int i, int m) {
		Random random = new Random();
		int n = 3;
		switch (random.nextInt(n)) {
			case 0:
				addRandomChestItem(i++, ModArmory.divineRapier, 1, 1, 2 * n * m);
				break;
			case 1:
				addRandomChestItem(i++, ModArmory.voidHammer, 1, 1, 2 * n * m);
				break;
			case 2:
				addRandomChestItem(i++, ModArmory.titaniumSword, 1, 1, 10 * n * m);
				break;
			}
	
		return i;
	}

	// Add 1 item
	protected int addItemsForSphinx(int i, int m) {
		// Spawn egg(s)
		addRandomChestItem(i++, ModItems.pharaohEgg, 1, 1, 100);
			
		return i;
	}
}
