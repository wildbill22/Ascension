package com.thexfactor117.ascension.structures;

import java.util.Random;

import com.thexfactor117.ascension.help.LogHelper;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

/**
 * 
 * @author WILLIAM
 *
 */
public class SmallAbandonedHouse extends AbandonedStructure {
	// Variables for configuration
	public static int missingBlockChance = 15;    // 1/n chance of setting block, set not less than 1, to 1 to set all blocks
	public static int spawnHeightTolerance = 3;   // Set larger for bigger structures
	public static int spawnChance = 10;           // chance n/1000

	public SmallAbandonedHouse() 
	{
		structureMissingBlockChance = missingBlockChance;
		structureSpawnHeightTolerance = spawnHeightTolerance;
		structureSpawnChance = spawnChance;
		validSpawnBlocks = getValidSpawnBlocks();
		mobsToSpawn = getMobsToSpawn();

		// Add these in order of low to high probability:
		// Rareness - 3
		addRandomChestItem(0, ModArmory.divineRapier, 1, 1, 2);
		addRandomChestItem(1, ModArmory.voidHammer, 1, 1, 2);

		// Rareness - 2
		addRandomChestItem(2, ModArmory.crystallizedSword, 1, 1, 5);
		addRandomChestItem(3, ModArmory.gyroMace, 1, 1, 5);
		addRandomChestItem(4, ModArmory.shadowBlade, 1, 1, 5);
		addRandomChestItem(5, ModArmory.etherealBlade, 1, 1, 5);

		// Rareness - 1 (least)
		addRandomChestItem(6, ModItems.strawberry, 1, 3, 40);
		addRandomChestItem(7, ModArmory.titaniumSword, 1, 1, 10);
		addRandomChestItem(8, ModArmory.steelSword, 1, 1, 10);
		addRandomChestItem(9, ModArmory.blazeSword, 1, 1, 10);
		addRandomChestItem(10, ModArmory.iceSword, 1, 1, 10);
		addRandomChestItem(11, ModArmory.razorSword, 1, 1, 10);
	}

	protected String[] getMobsToSpawn() {
		return new String[] { "Ghost" };
	}
	
	protected Block[] getValidSpawnBlocks() 
	{
		return new Block[] { Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.cobblestone };
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) 
	{
		//check that each corner is one of the valid spawn blocks
		if(!locationIsValidSpawn(world, x, y, z) 
				|| !locationIsValidSpawn(world, x + 4, y, z) 
				|| !locationIsValidSpawn(world, x + 4, y, z + 6) 
				|| !locationIsValidSpawn(world, x, y, z + 6))
		{
			return false;
		}
		generateStructure(world, random, x, y, z);
		generateStructureBase(world, random, x, z, 4, 6, Blocks.cobblestone);
		generatedCenterAt(x + 5, y, z + 5);
		
		return true;
	}

	@Override
	// Lower level, from part1 of schematic
	// 5 wide (x) x 7 length (z)
	public void generateStructure(World world, Random random, int x, int y,	int z) {
		floorLevel = y;

		LogHelper.info("Generating a Small Abandoned House at " + x + "," + y + "," + z + "!");
		setBlock(world, random, x + 0, y + 0, z + 0, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 0, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 0, Blocks.planks, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 0, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 0, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 0, z + 1, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 1, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 1, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 1, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 1, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 0, z + 2, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 2, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 2, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 2, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 2, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 0, z + 5, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 5, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 5, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 5, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 5, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 0, z + 6, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 6, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 6, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 6, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 6, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 0, Blocks.log, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 0, Blocks.cobblestone, 0, 3);
//		setBlock(world, random, x + 2, y + 1, z + 0, Blocks.wooden_door, 5, 3);
		setBlock(world, random, x + 3, y + 1, z + 0, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 0, Blocks.log, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 1, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 1, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 1, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 2, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 1, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 2, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 1, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 4, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 1, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 4, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 5, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 5, Blocks.air, 0, 3);
//		setBlock(world, random, x + 3, y + 1, z + 5, Blocks.chest, 4, 3);
		setBlock(world, random, x + 4, y + 1, z + 5, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 6, Blocks.log, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 6, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 6, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 3, y + 1, z + 6, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 6, Blocks.log, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 0, Blocks.log, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 0, Blocks.planks, 0, 3);
//		setBlock(world, random, x + 2, y + 2, z + 0, Blocks.wooden_door, 8, 3);
		setBlock(world, random, x + 3, y + 2, z + 0, Blocks.planks, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 0, Blocks.log, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 1, Blocks.planks, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 1, Blocks.planks, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 2, Blocks.glass_pane, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 2, Blocks.glass_pane, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 3, Blocks.glass_pane, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 3, Blocks.glass_pane, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 4, Blocks.glass_pane, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 4, Blocks.glass_pane, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 5, Blocks.planks, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 5, Blocks.planks, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 6, Blocks.log, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 6, Blocks.planks, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 6, Blocks.glass_pane, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 6, Blocks.planks, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 6, Blocks.log, 0, 3);

		generateStructure1(world, random, x - 1, y + 3, z - 2);

		//adding a chest with random stuff
		// If just one chest, set last two parameters to 1 and false
		generateChest(world, random, x + 3, y + 1, z + 5, 0, 1, false);	
		
		// Mob spawner
		generateMobSpawner(world, random, x + 1, y + 1, z + 5, 0);
		
		// Door
		setBlock(world, random, x + 2, y + 1, z + 0, Blocks.wooden_door, 3, 3);
		setBlock(world, random, x + 2, y + 2, z + 0, Blocks.wooden_door, 8, 3);
	}

	// Upper level, from part2 of schematic
	// 7 wide (x) x 11 length (z)
	public void generateStructure1(World world, Random random, int x, int y, int z) {
		setBlock(world, random, x + 0, y + 0, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 0, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 0, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 0, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 0, z + 2, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 2, Blocks.log, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 2, Blocks.planks, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 2, Blocks.planks, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 2, Blocks.planks, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 2, Blocks.log, 0, 3);
		setBlock(world, random, x + 6, y + 0, z + 2, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 0, y + 0, z + 3, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 3, Blocks.planks, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 3, Blocks.planks, 0, 3);
		setBlock(world, random, x + 6, y + 0, z + 3, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 0, y + 0, z + 4, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 4, Blocks.planks, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 4, Blocks.planks, 0, 3);
		setBlock(world, random, x + 6, y + 0, z + 4, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 0, y + 0, z + 5, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 5, Blocks.planks, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 5, Blocks.planks, 0, 3);
		setBlock(world, random, x + 6, y + 0, z + 5, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 0, y + 0, z + 6, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 6, Blocks.planks, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 6, Blocks.planks, 0, 3);
		setBlock(world, random, x + 6, y + 0, z + 6, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 0, y + 0, z + 7, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 7, Blocks.planks, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 7, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 7, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 7, Blocks.planks, 0, 3);
		setBlock(world, random, x + 6, y + 0, z + 7, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 0, y + 0, z + 8, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 8, Blocks.log, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 8, Blocks.planks, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 8, Blocks.planks, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 8, Blocks.planks, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 8, Blocks.log, 0, 3);
		setBlock(world, random, x + 6, y + 0, z + 8, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 0, y + 0, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 0, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 0, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 0, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 1, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 1, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 1, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 1, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 1, Blocks.wooden_slab, 8, 3);
		setBlock(world, random, x + 3, y + 1, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 1, Blocks.wooden_slab, 8, 3);
		setBlock(world, random, x + 5, y + 1, z + 1, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 6, y + 1, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 2, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 2, Blocks.log, 0, 3);
		setBlock(world, random, x + 3, y + 1, z + 2, Blocks.planks, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 2, Blocks.log, 0, 3);
		setBlock(world, random, x + 5, y + 1, z + 2, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 6, y + 1, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 3, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 3, Blocks.oak_stairs, 5, 3);
		setBlock(world, random, x + 3, y + 1, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 3, Blocks.oak_stairs, 4, 3);
		setBlock(world, random, x + 5, y + 1, z + 3, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 6, y + 1, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 4, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 4, Blocks.oak_stairs, 5, 3);
		setBlock(world, random, x + 3, y + 1, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 4, Blocks.oak_stairs, 4, 3);
		setBlock(world, random, x + 5, y + 1, z + 4, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 6, y + 1, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 5, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 5, Blocks.oak_stairs, 5, 3);
		setBlock(world, random, x + 3, y + 1, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 5, Blocks.oak_stairs, 4, 3);
		setBlock(world, random, x + 5, y + 1, z + 5, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 6, y + 1, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 6, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 6, Blocks.oak_stairs, 5, 3);
		setBlock(world, random, x + 3, y + 1, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 6, Blocks.oak_stairs, 4, 3);
		setBlock(world, random, x + 5, y + 1, z + 6, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 6, y + 1, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 7, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 7, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 7, Blocks.oak_stairs, 5, 3);
		setBlock(world, random, x + 3, y + 1, z + 7, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 7, Blocks.oak_stairs, 4, 3);
		setBlock(world, random, x + 5, y + 1, z + 7, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 6, y + 1, z + 7, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 8, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 8, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 8, Blocks.log, 0, 3);
		setBlock(world, random, x + 3, y + 1, z + 8, Blocks.planks, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 8, Blocks.log, 0, 3);
		setBlock(world, random, x + 5, y + 1, z + 8, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 6, y + 1, z + 8, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 9, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 9, Blocks.wooden_slab, 8, 3);
		setBlock(world, random, x + 3, y + 1, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 9, Blocks.wooden_slab, 8, 3);
		setBlock(world, random, x + 5, y + 1, z + 9, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 6, y + 1, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 1, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 1, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 1, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 2, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 1, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 1, Blocks.oak_stairs, 6, 3);
		setBlock(world, random, x + 4, y + 2, z + 1, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 5, y + 2, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 2, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 2, Blocks.log, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 2, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 5, y + 2, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 3, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 3, Blocks.wooden_slab, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 3, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 5, y + 2, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 4, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 4, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 5, y + 2, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 5, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 5, Blocks.wooden_slab, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 5, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 5, y + 2, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 6, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 6, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 5, y + 2, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 7, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 7, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 7, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 7, Blocks.wooden_slab, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 7, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 5, y + 2, z + 7, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 7, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 8, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 8, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 8, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 8, Blocks.log, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 8, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 5, y + 2, z + 8, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 8, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 9, Blocks.oak_stairs, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 9, Blocks.oak_stairs, 7, 3);
		setBlock(world, random, x + 4, y + 2, z + 9, Blocks.oak_stairs, 1, 3);
		setBlock(world, random, x + 5, y + 2, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 2, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 3, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 3, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 3, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 3, z + 0, Blocks.oak_stairs, 6, 3);
		setBlock(world, random, x + 4, y + 3, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 3, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 3, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 3, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 3, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 3, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 3, z + 1, Blocks.oak_stairs, 3, 3);
		setBlock(world, random, x + 4, y + 3, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 3, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 3, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 3, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 3, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 3, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 3, z + 2, Blocks.wooden_slab, 0, 3);
		setBlock(world, random, x + 4, y + 3, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 3, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 3, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 3, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 3, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 3, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 3, z + 3, Blocks.wooden_slab, 0, 3);
		setBlock(world, random, x + 4, y + 3, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 3, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 3, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 3, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 3, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 3, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 3, z + 4, Blocks.wooden_slab, 0, 3);
		setBlock(world, random, x + 4, y + 3, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 3, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 3, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 3, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 3, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 3, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 3, z + 5, Blocks.wooden_slab, 0, 3);
		setBlock(world, random, x + 4, y + 3, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 3, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 3, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 3, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 3, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 3, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 3, z + 6, Blocks.wooden_slab, 0, 3);
		setBlock(world, random, x + 4, y + 3, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 3, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 3, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 3, z + 7, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 3, z + 7, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 3, z + 7, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 3, z + 7, Blocks.wooden_slab, 0, 3);
		setBlock(world, random, x + 4, y + 3, z + 7, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 3, z + 7, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 3, z + 7, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 3, z + 8, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 3, z + 8, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 3, z + 8, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 3, z + 8, Blocks.wooden_slab, 0, 3);
		setBlock(world, random, x + 4, y + 3, z + 8, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 3, z + 8, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 3, z + 8, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 3, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 3, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 3, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 3, z + 9, Blocks.oak_stairs, 2, 3);
		setBlock(world, random, x + 4, y + 3, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 3, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 3, z + 9, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 3, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 3, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 3, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 3, z + 10, Blocks.oak_stairs, 7, 3);
		setBlock(world, random, x + 4, y + 3, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 3, z + 10, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 3, z + 10, Blocks.air, 0, 3);

		generate_r02_last(world, random, x, y, z);
	}
	
	public void generate_r02_last(World world, Random random, int x, int y, int z)
	{	
		setBlock(world, random, x + 3, y + 0, z + 1, Blocks.torch, 4, 3);
		setBlock(world, random, x + 3, y + 0, z + 7, Blocks.torch, 4, 3);
	}
}
