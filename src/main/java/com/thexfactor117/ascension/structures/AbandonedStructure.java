package com.thexfactor117.ascension.structures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import com.thexfactor117.ascension.structures.RandomChest;

import com.thexfactor117.ascension.help.LogHelper;
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
		
		randomChest = new RandomChest();
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
	public RandomChest randomChest;

	// For underground structures:
	public int minY;
	public int maxY;

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
			Thread.sleep(500);            
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
				setEntity = true;
			}				
		}
		if (setEntity == false) {
			int i = random.nextInt(mobsToSpawn.length);
			spawner.func_145881_a().setEntityName(mobsToSpawn[i]);			
			LogHelper.info("Generating a mob spawner with " + mobsToSpawn[i]);
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
		if (y != 0 && (world.blockExists(x, y, z) && world.blockExists(x + xMax, y, z) &&
				 world.blockExists(x, y, z + zMax) && world.blockExists(x + xMax, y, z + zMax))) {
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

	// Checks that chunk has been created and meets the spawn requirements
	private boolean spawnedUndergroundAt(World world, int x, int y, int z, int xMax, int zMax)
	{
		if (world.blockExists(x, y, z) && world.blockExists(x + xMax, y, z) &&
			 world.blockExists(x, y, z + zMax) && world.blockExists(x + xMax, y, z + zMax)) {
			return true;
		}
		return false;
	}
	
	// Tries 4 locations around selected spawn point to avoid placing in a chunk not yet created
	public boolean isValidUndergroundSpawnCorners(World world, StructureCoordinates coords)
	{
		int x = coords.posX;
		int z = coords.posZ;
		int y = coords.posY;
		
		// Don't place if another structures is nearby
		if (y == 0 || StructureList.findNearestStructure(x, y, z) < 64)
			return false;
		
		if (spawnedUndergroundAt(world, x, y, z, xMax, zMax)) {
			return true;			
		}
		// try the North
		if (spawnedUndergroundAt(world, x, y, z - zMax, xMax, zMax)) {
			coords.posZ = z - zMax;
			return true;			
		}
		// try to the West
		if (spawnedUndergroundAt(world, x - xMax, y, z, xMax, zMax)){
			coords.posX = x - xMax;
			return true;			
		}
		// try to the South
		if (spawnedUndergroundAt(world, x, y, z + zMax, xMax, zMax)) {
			coords.posZ = z + zMax;
			return true;			
		}
		// try to the East
		if (spawnedUndergroundAt(world, x + xMax, y, z, xMax, zMax)) {
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
}
