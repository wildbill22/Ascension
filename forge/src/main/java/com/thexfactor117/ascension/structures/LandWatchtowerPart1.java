package com.thexfactor117.ascension.structures;

import java.util.Random;

import com.thexfactor117.ascension.help.LogHelper;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.world.World;

/**
 * 
 * @author WILLIAM
 *
 */
public class LandWatchtowerPart1 extends AbandonedStructure {
	// Variables for configuration
	public static int missingBlockChance = 1;     // 1/n chance of setting block, set not less than 1, to 1 to set all blocks
	public static int spawnHeightTolerance = 3;   // Set larger for bigger structures
	public static int spawnChance = 30;           // chance n/1000

	public LandWatchtowerPart1() 
	{
		structureMissingBlockChance = missingBlockChance;
		structureSpawnHeightTolerance = spawnHeightTolerance;
		structureSpawnChance = spawnChance;
		validSpawnBlocks = getValidSpawnBlocks();

		// Add these in order of low to high probability:
		// Rareness - 3
		addRandomChestItem(ModArmory.divineRapier, 1, 1, 2);
		addRandomChestItem(ModArmory.voidHammer, 1, 1, 2);

		// Rareness - 2
		addRandomChestItem(ModArmory.crystallizedSword, 1, 1, 5);
		addRandomChestItem(ModArmory.gyroMace, 1, 1, 5);
		addRandomChestItem(ModArmory.shadowBlade, 1, 1, 5);
		addRandomChestItem(ModArmory.etherealBlade, 1, 1, 5);

		// Rareness - 1 (least)
		addRandomChestItem(ModItems.strawberry, 1, 3, 40);
		addRandomChestItem(ModArmory.titaniumSword, 1, 1, 10);
		addRandomChestItem(ModArmory.steelSword, 1, 1, 10);
		addRandomChestItem(ModArmory.blazeSword, 1, 1, 10);
		addRandomChestItem(ModArmory.iceSword, 1, 1, 10);
		addRandomChestItem(ModArmory.razorSword, 1, 1, 10);
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
				|| !locationIsValidSpawn(world, x + 6, y, z) 
				|| !locationIsValidSpawn(world, x + 6, y, z + 6) 
				|| !locationIsValidSpawn(world, x, y, z + 6))
		{
			return false;
		}
		generateStructure(world, random, x, y, z);
		generateStructureBase(world, random, x, z, 6, 6, Blocks.cobblestone);
		
		return true;
	}

	@Override
	// Lower level, from part1 of schematic
	// 7 wide (x) x 7 length (z)
	public void generateStructure(World world, Random random, int x, int y,	int z) {
		floorLevel = y;
		
		LogHelper.info("Generating a Land Watchtower at " + x + "," + y + "," + z + "!");
		// corners don't need air, commenting those out
//		setBlock(world, random, x + 0, y + 0, z + 0, Blocks.air, 0, 3);
//		setBlock(world, random, x + 1, y + 0, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 0, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 0, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 0, Blocks.cobblestone, 0, 3);
//		setBlock(world, random, x + 5, y + 0, z + 0, Blocks.air, 0, 3);
//		setBlock(world, random, x + 6, y + 0, z + 0, Blocks.air, 0, 3);
//		setBlock(world, random, x + 0, y + 0, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 1, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 1, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 1, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 1, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 1, Blocks.cobblestone, 0, 3);
//		setBlock(world, random, x + 6, y + 0, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 0, z + 2, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 2, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 2, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 2, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 2, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 2, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 6, y + 0, z + 2, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 6, y + 0, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 4, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 6, y + 0, z + 4, Blocks.cobblestone, 0, 3);
//		setBlock(world, random, x + 0, y + 0, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 0, z + 5, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 5, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 5, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 5, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 5, y + 0, z + 5, Blocks.cobblestone, 0, 3);
//		setBlock(world, random, x + 6, y + 0, z + 5, Blocks.air, 0, 3);
//		setBlock(world, random, x + 0, y + 0, z + 6, Blocks.air, 0, 3);
//		setBlock(world, random, x + 1, y + 0, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 0, z + 6, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 3, y + 0, z + 6, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 4, y + 0, z + 6, Blocks.cobblestone, 0, 3);
//		setBlock(world, random, x + 5, y + 0, z + 6, Blocks.air, 0, 3);
//		setBlock(world, random, x + 6, y + 0, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 0, Blocks.log, 0, 3);
//		setBlock(world, random, x + 3, y + 1, z + 0, Blocks.wooden_door, 1, 3);
		setBlock(world, random, x + 4, y + 1, z + 0, Blocks.log, 0, 3);
		setBlock(world, random, x + 5, y + 1, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 1, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 1, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 1, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 1, z + 1, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 6, y + 1, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 2, Blocks.log, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 1, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 2, Blocks.air, 0, 3);
//		setBlock(world, random, x + 5, y + 1, z + 2, Blocks.chest, 4, 3);
		setBlock(world, random, x + 6, y + 1, z + 2, Blocks.log, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 1, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 1, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 1, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 4, Blocks.log, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 1, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 1, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 1, z + 4, Blocks.log, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 5, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 1, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 1, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 1, z + 5, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 6, y + 1, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 1, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 1, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 1, z + 6, Blocks.log, 0, 3);
//		setBlock(world, random, x + 3, y + 1, z + 6, Blocks.wooden_door, 3, 3);
		setBlock(world, random, x + 4, y + 1, z + 6, Blocks.log, 0, 3);
		setBlock(world, random, x + 5, y + 1, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 1, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 0, Blocks.log, 0, 3);
//		setBlock(world, random, x + 3, y + 2, z + 0, Blocks.wooden_door, 8, 3);
		setBlock(world, random, x + 4, y + 2, z + 0, Blocks.log, 0, 3);
		setBlock(world, random, x + 5, y + 2, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 0, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 1, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 2, z + 1, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 1, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 2, Blocks.log, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 2, z + 2, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 2, Blocks.log, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 2, z + 3, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 3, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 4, Blocks.log, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 2, z + 4, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 4, Blocks.log, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 5, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 3, y + 2, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 4, y + 2, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 5, y + 2, z + 5, Blocks.cobblestone, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 5, Blocks.air, 0, 3);
		setBlock(world, random, x + 0, y + 2, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 1, y + 2, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 2, y + 2, z + 6, Blocks.log, 0, 3);
//		setBlock(world, random, x + 3, y + 2, z + 6, Blocks.wooden_door, 8, 3);
		setBlock(world, random, x + 4, y + 2, z + 6, Blocks.log, 0, 3);
		setBlock(world, random, x + 5, y + 2, z + 6, Blocks.air, 0, 3);
		setBlock(world, random, x + 6, y + 2, z + 6, Blocks.air, 0, 3);

		new LandWatchtowerPart2().generate_r01(world, random, x - 1 , y + 3, z - 1);

		// doors
		setBlock(world, random, x + 3, y + 1, z + 0, Blocks.wooden_door, 1, 3);
		setBlock(world, random, x + 3, y + 2, z + 0, Blocks.wooden_door, 8, 3);
		setBlock(world, random, x + 3, y + 1, z + 6, Blocks.wooden_door, 3, 3);
		setBlock(world, random, x + 3, y + 2, z + 6, Blocks.wooden_door, 8, 3);

		//adding a chest with random stuff
		// If just one chest, set last two parameters to 1 and false
		generateChest(world, random, x + 5, y + 1, z + 2, 0, 1, false);	
		generateChest(world, random, x + 6, y + 11, z + 2, 0, 1, false);	
	}
}
