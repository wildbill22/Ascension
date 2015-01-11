package com.thexfactor117.ascension.structures;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import com.thexfactor117.ascension.help.LogHelper;

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
*/ 
public abstract class AbandonedStructure extends WorldGenerator implements Runnable
{
	protected int structureMissingBlockChance = 10;  // Set this to about 1/10 number of blocks
	protected int structureSpawnHeightTolerance = 3;
	protected int structureSpawnChance = 10; // chance n/1000
	protected Block[] validSpawnBlocks;
	protected Block[] validBaseBlocks = { Blocks.bedrock, Blocks.clay, Blocks.coal_ore, Blocks.cobblestone,
			Blocks.diamond_ore, Blocks.dirt, Blocks.emerald_ore, Blocks.end_stone, Blocks.glass,
			Blocks.glowstone, Blocks.gold_ore, Blocks.gravel, Blocks.hardened_clay, Blocks.ice, Blocks.iron_ore,
			Blocks.lapis_ore, Blocks.mossy_cobblestone, Blocks.netherrack, Blocks.obsidian, 
			Blocks.quartz_ore, Blocks.redstone_ore, Blocks.sandstone, Blocks.soul_sand, Blocks.stone,
			Blocks.wool, Blocks.sand };
	protected int floorLevel;
	protected ArrayList<RandomChestItems> randomChestItems;

	// Variables used when using a separate thread to generate structure
	World threadWorld = null;
	Random threadRandom;
	int threadX;
	int threadY;
	int threadZ;
	static boolean running = false;

	// Used when generateStructureInThread is used instead of generateStructure
	@Override
	public void run() 
	{
		if (threadWorld == null)
			LogHelper.error("Call generateStructureInThread first!");
		generateStructure(threadWorld, threadRandom, threadX, threadY, threadZ);	
	}

	// Instantiate in class that implements this abstract class
	public abstract void generateStructure(World world, Random random, int x, int y, int z);	

	// Put blocks under structure so it isn't floating in air
	protected void generateStructureBase(World world, Random random, int x,	int y, int z, Block block) {
		for (int baseX = 0; baseX <= x; baseX++) {
			for (int baseZ = 0; baseZ <= z; baseZ++) {
				for (int baseY = y - 1; baseY >= y - structureSpawnHeightTolerance; baseY--) {
					if (!isValidBaseBlock(world, baseX, baseY, baseZ)) {
						world.setBlock(x, y, z, block);
					}
					else
						break; // Just the top one needs to be valid
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

	// To use this:
	// 1) Add "if (running) return false;" in generate, to avoid too many threads
	// 2) Call generateStructureInThread(...); instead of: generateStructure(...);
	// 3) Put preventLag() in generateStructure function every 100 lines
	// 4) Set "running" to false at end of last generateStructureX() call 
	public void generateStructureInThread(World world, Random random, int x, int y, int z) 
	{
		threadWorld = world;
		threadRandom = random;
		threadX = x;
		threadY = y;
		threadZ = z;
		running = true;
		Thread thread = new Thread(this);
		thread.start();
	}

	protected void preventLag()
	{
		try           
		{              
			Thread.sleep(300);            
		}          
		catch (InterruptedException interruptedException)          
		{              
			LogHelper.error("generateStructure interrupted while sleeping! " + interruptedException);
		}  
	}

	// Generates some random loot in the chest
	public void setRandomSlots(TileEntityChest chestEntity, Item item, int min, int max, int chance) 
	{
		Random rand = new Random();
		// Normally 27 slots
		for (int slot = 0; slot < chestEntity.getSizeInventory(); slot++) 
		{
			int randomChance = rand.nextInt(100);
			if (chestEntity.getStackInSlot(slot) == null && chance > randomChance)
			{
				int randomQty = rand.nextInt(max - min + 1) + min;
				ItemStack items = new ItemStack(item, randomQty);
				chestEntity.setInventorySlotContents(slot, items);
			}
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
			// item, min to add, max to add, chance N/100
			// Add items with lowest chance first
			for (int i = 0; i < randomChestItems.size(); i++) {
				setRandomSlots(chestEntity, randomChestItems.get(i).item, randomChestItems.get(i).min,
						randomChestItems.get(i).max, randomChestItems.get(i).probability);				
			}
			return true;
		}		
		return generated;
	}
	
	protected void addRandomChestItem(Item item, int min, int max, int probability) {
		if (randomChestItems == null)
			randomChestItems = new ArrayList<RandomChestItems>();
		randomChestItems.add(new RandomChestItems(item, min, max, probability));
	}
	
	protected class RandomChestItems {
		Item item;
		int min;
		int max;
		int probability;
		
		protected RandomChestItems(Item item, int min, int max, int probability) {
			this.item = item;
			this.min = min;
			this.max = max;
			this.probability = probability;
		}
	}
	
	// Checks that chunk has been created and meets the spawn requirements
	private boolean spawnedAtLocation(World world, int x, int y, int z, int xMax, int zMax)
	{
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
	protected boolean isValidSpawnCorners(World world, int x, int y, int z, int xMax, int zMax)
	{
		if (spawnedAtLocation(world, x, y, z, xMax, zMax))
			return true;
		// try the North
		else if (spawnedAtLocation(world, x, y, z - zMax, xMax, zMax))
			return true;
		// try to the West
		else if (spawnedAtLocation(world, x - xMax, y, z, xMax, zMax))
			return true;
		// try to the South
		else if (spawnedAtLocation(world, x, y, z + zMax, xMax, zMax))
			return true;
		// try to the East
		else if (spawnedAtLocation(world, x + xMax, y, z, xMax, zMax))
			return true;

		return false;
	}
	
	// Works fairly well to place the building where the stairs are on ground level
	// Could be improved to rotate structure so none of it is in the air
	protected boolean locationIsValidSpawn(World world, int x, int y, int z)
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
		// Don't place some blocks that are above floor level
		if(block == Blocks.air || block == Blocks.chest || y == floorLevel || random.nextInt(structureMissingBlockChance) < 1)
			world.setBlock(x, y, z, block, metadata, flag);
	}
}
