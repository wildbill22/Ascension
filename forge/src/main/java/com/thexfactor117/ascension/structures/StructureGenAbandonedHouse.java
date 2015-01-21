package com.thexfactor117.ascension.structures;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.world.World;

import com.thexfactor117.ascension.help.LogHelper;

/**
 * 
 * @author WILLIAM
 *
 */
public class StructureGenAbandonedHouse extends AbandonedStructure
{
	// Variables for configuration
	public static int missingBlockChance = 11;    // 1/n chance of setting block, set not less than 1, to 1 to set all blocks
	public static int spawnHeightTolerance = 3;   // Set larger for bigger structures
	public static int spawnChance = 5;           // chance n/1000
	
	public StructureGenAbandonedHouse() 
	{
		structureMissingBlockChance = missingBlockChance;
		structureSpawnHeightTolerance = spawnHeightTolerance;
		structureSpawnChance = spawnChance;
		validSpawnBlocks = getValidSpawnBlocks();
		// Add these in order of low to high probability:
//		addRandomChestItem(Items.arrow, 1, 3, 10);
//		addRandomChestItem(Items.apple, 1, 3, 20);
	}

	protected Block[] getValidSpawnBlocks() 
	{
		return new Block[] {Blocks.grass, Blocks.dirt};
	}

	// This example doesn't use threading, but the abstract super class supports that
	@Override
	public boolean generate(World world, Random random, int x, int y, int z) 
	{
		//check that each corner is one of the valid spawn blocks
		if(!locationIsValidSpawn(world, x, y, z) 
				|| !locationIsValidSpawn(world, x + 4, y, z) 
				|| !locationIsValidSpawn(world, x + 4, y, z + 5) 
				|| !locationIsValidSpawn(world, x, y, z + 5))
		{
			return false;
		}
		generateStructure(world, random, x, y, z);
		generateStructureBase(world, random, x, z, 4, 5, Blocks.cobblestone);
		
		return true;
	}

	// This is the part from Schematic to Java converter. Use search and replace to use the setBlock method
	// Replace and chests from the generated code with the generateChest method
	public void generateStructure(World world, Random random, int x, int y, int z) 
	{
		floorLevel = y;
		
		LogHelper.info("Generating an Abandoned House at " + x + "," + y + "," + z + "!");
		setBlock(world, random, x + 0, y + 0, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 0, y + 0, z + 1, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 0, y + 0, z + 2, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 0, y + 0, z + 3, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 0, y + 0, z + 4, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 0, y + 0, z + 5, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 0, y + 1, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 0, y + 1, z + 1, Blocks.planks, 0, 2);
		setBlock(world, random, x + 0, y + 1, z + 2, Blocks.planks, 0, 2);
		setBlock(world, random, x + 0, y + 1, z + 3, Blocks.planks, 0, 2);
		setBlock(world, random, x + 0, y + 1, z + 4, Blocks.planks, 0, 2);
		setBlock(world, random, x + 0, y + 1, z + 5, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 0, y + 2, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 0, y + 2, z + 1, Blocks.planks, 0, 2);
		setBlock(world, random, x + 0, y + 2, z + 2, Blocks.glass_pane, 0, 2);
		setBlock(world, random, x + 0, y + 2, z + 3, Blocks.glass_pane, 0, 2);
		setBlock(world, random, x + 0, y + 2, z + 4, Blocks.planks, 0, 2);
		setBlock(world, random, x + 0, y + 2, z + 5, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 0, y + 3, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 0, y + 3, z + 1, Blocks.planks, 0, 2);
		setBlock(world, random, x + 0, y + 3, z + 2, Blocks.planks, 0, 2);
		setBlock(world, random, x + 0, y + 3, z + 3, Blocks.planks, 0, 2);
		setBlock(world, random, x + 0, y + 3, z + 4, Blocks.planks, 0, 2);
		setBlock(world, random, x + 0, y + 3, z + 5, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 0, y + 4, z + 0, Blocks.oak_stairs, 2, 2);
		setBlock(world, random, x + 0, y + 4, z + 1, Blocks.log, 0, 2);
		setBlock(world, random, x + 0, y + 4, z + 2, Blocks.log, 0, 2);
		setBlock(world, random, x + 0, y + 4, z + 3, Blocks.log, 0, 2);
		setBlock(world, random, x + 0, y + 4, z + 4, Blocks.log, 0, 2);
		setBlock(world, random, x + 0, y + 4, z + 5, Blocks.oak_stairs, 3, 2);
		setBlock(world, random, x + 0, y + 5, z + 1, Blocks.oak_stairs, 2, 2);
		setBlock(world, random, x + 0, y + 5, z + 2, Blocks.planks, 0, 2);
		setBlock(world, random, x + 0, y + 5, z + 3, Blocks.planks, 0, 2);
		setBlock(world, random, x + 0, y + 5, z + 4, Blocks.oak_stairs, 3, 2);
		setBlock(world, random, x + 0, y + 6, z + 2, Blocks.oak_stairs, 2, 2);
		setBlock(world, random, x + 0, y + 6, z + 3, Blocks.oak_stairs, 3, 2);
		setBlock(world, random, x + 1, y + 0, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 1, y + 0, z + 1, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 1, y + 0, z + 2, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 1, y + 0, z + 3, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 1, y + 0, z + 4, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 1, y + 0, z + 5, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 1, y + 1, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 1, y + 1, z + 1, Blocks.air, 0, 2);
		setBlock(world, random, x + 1, y + 1, z + 2, Blocks.air, 0, 2);
		setBlock(world, random, x + 1, y + 1, z + 3, Blocks.air, 0, 2);
		setBlock(world, random, x + 1, y + 1, z + 4, Blocks.air, 0, 2);
		setBlock(world, random, x + 1, y + 1, z + 5, Blocks.planks, 0, 2);
		setBlock(world, random, x + 1, y + 2, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 1, y + 2, z + 1, Blocks.air, 0, 2);
		setBlock(world, random, x + 1, y + 2, z + 2, Blocks.air, 0, 2);
		setBlock(world, random, x + 1, y + 2, z + 3, Blocks.air, 0, 2);
		setBlock(world, random, x + 1, y + 2, z + 4, Blocks.air, 0, 2);
		setBlock(world, random, x + 1, y + 2, z + 5, Blocks.planks, 0, 2);
		setBlock(world, random, x + 1, y + 3, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 1, y + 3, z + 1, Blocks.air, 0, 2);
		setBlock(world, random, x + 1, y + 3, z + 2, Blocks.air, 0, 2);
		setBlock(world, random, x + 1, y + 3, z + 3, Blocks.air, 0, 2);
		setBlock(world, random, x + 1, y + 3, z + 4, Blocks.air, 0, 2);
		setBlock(world, random, x + 1, y + 3, z + 5, Blocks.planks, 0, 2);
		setBlock(world, random, x + 1, y + 4, z + 0, Blocks.oak_stairs, 2, 2);
		setBlock(world, random, x + 1, y + 4, z + 1, Blocks.planks, 0, 2);
		setBlock(world, random, x + 1, y + 4, z + 2, Blocks.planks, 0, 2);
		setBlock(world, random, x + 1, y + 4, z + 3, Blocks.planks, 0, 2);
		setBlock(world, random, x + 1, y + 4, z + 4, Blocks.planks, 0, 2);
		setBlock(world, random, x + 1, y + 4, z + 5, Blocks.oak_stairs, 3, 2);
		setBlock(world, random, x + 1, y + 5, z + 1, Blocks.oak_stairs, 2, 2);
		setBlock(world, random, x + 1, y + 5, z + 2, Blocks.planks, 0, 2);
		setBlock(world, random, x + 1, y + 5, z + 3, Blocks.planks, 0, 2);
		setBlock(world, random, x + 1, y + 5, z + 4, Blocks.oak_stairs, 3, 2);
		setBlock(world, random, x + 1, y + 6, z + 2, Blocks.oak_stairs, 2, 2);
		setBlock(world, random, x + 1, y + 6, z + 3, Blocks.oak_stairs, 3, 2);
		setBlock(world, random, x + 2, y + 0, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 2, y + 0, z + 1, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 2, y + 0, z + 2, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 2, y + 0, z + 3, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 2, y + 0, z + 4, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 2, y + 0, z + 5, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 2, y + 1, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 2, y + 1, z + 1, Blocks.air, 0, 2);
		setBlock(world, random, x + 2, y + 1, z + 2, Blocks.air, 0, 2);
		setBlock(world, random, x + 2, y + 1, z + 3, Blocks.air, 0, 2);
		setBlock(world, random, x + 2, y + 1, z + 4, Blocks.air, 0, 2);
		setBlock(world, random, x + 2, y + 1, z + 5, Blocks.air, 0, 2);
		setBlock(world, random, x + 2, y + 2, z + 0, Blocks.glass_pane, 0, 2);
		setBlock(world, random, x + 2, y + 2, z + 2, Blocks.air, 0, 2);
		setBlock(world, random, x + 2, y + 2, z + 3, Blocks.air, 0, 2);
		setBlock(world, random, x + 2, y + 2, z + 4, Blocks.air, 0, 2);
		setBlock(world, random, x + 2, y + 2, z + 5, Blocks.air, 0, 2);
		setBlock(world, random, x + 2, y + 3, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 2, y + 3, z + 1, Blocks.air, 0, 2);
		setBlock(world, random, x + 2, y + 3, z + 2, Blocks.air, 0, 2);
		setBlock(world, random, x + 2, y + 3, z + 3, Blocks.air, 0, 2);
		setBlock(world, random, x + 2, y + 3, z + 4, Blocks.air, 0, 2);
		setBlock(world, random, x + 2, y + 3, z + 5, Blocks.planks, 0, 2);
		setBlock(world, random, x + 2, y + 4, z + 0, Blocks.oak_stairs, 2, 2);
		setBlock(world, random, x + 2, y + 4, z + 1, Blocks.planks, 0, 2);
		setBlock(world, random, x + 2, y + 4, z + 2, Blocks.planks, 0, 2);
		setBlock(world, random, x + 2, y + 4, z + 3, Blocks.planks, 0, 2);
		setBlock(world, random, x + 2, y + 4, z + 4, Blocks.planks, 0, 2);
		setBlock(world, random, x + 2, y + 4, z + 5, Blocks.oak_stairs, 3, 2);
		setBlock(world, random, x + 2, y + 5, z + 1, Blocks.oak_stairs, 2, 2);
		setBlock(world, random, x + 2, y + 5, z + 2, Blocks.planks, 0, 2);
		setBlock(world, random, x + 2, y + 5, z + 3, Blocks.planks, 0, 2);
		setBlock(world, random, x + 2, y + 5, z + 4, Blocks.oak_stairs, 3, 2);
		setBlock(world, random, x + 2, y + 6, z + 2, Blocks.oak_stairs, 2, 2);
		setBlock(world, random, x + 2, y + 6, z + 3, Blocks.oak_stairs, 3, 2);
		setBlock(world, random, x + 3, y + 0, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 3, y + 0, z + 1, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 3, y + 0, z + 2, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 3, y + 0, z + 3, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 3, y + 0, z + 4, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 3, y + 0, z + 5, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 3, y + 1, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 3, y + 1, z + 1, Blocks.air, 0, 2);
		setBlock(world, random, x + 3, y + 1, z + 2, Blocks.air, 0, 2);
		setBlock(world, random, x + 3, y + 1, z + 3, Blocks.air, 0, 2);
		setBlock(world, random, x + 3, y + 1, z + 4, Blocks.air, 0, 2);
		setBlock(world, random, x + 3, y + 1, z + 5, Blocks.planks, 0, 2);
		setBlock(world, random, x + 3, y + 2, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 3, y + 2, z + 1, Blocks.air, 0, 2);
		setBlock(world, random, x + 3, y + 2, z + 2, Blocks.air, 0, 2);
		setBlock(world, random, x + 3, y + 2, z + 3, Blocks.air, 0, 2);
		setBlock(world, random, x + 3, y + 2, z + 4, Blocks.air, 0, 2);
		setBlock(world, random, x + 3, y + 2, z + 5, Blocks.planks, 0, 2);
		setBlock(world, random, x + 3, y + 3, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 3, y + 3, z + 1, Blocks.air, 0, 2);
		setBlock(world, random, x + 3, y + 3, z + 2, Blocks.air, 0, 2);
		setBlock(world, random, x + 3, y + 3, z + 3, Blocks.air, 0, 2);
		setBlock(world, random, x + 3, y + 3, z + 4, Blocks.air, 0, 2);
		setBlock(world, random, x + 3, y + 3, z + 5, Blocks.planks, 0, 2);
		setBlock(world, random, x + 3, y + 4, z + 0, Blocks.oak_stairs, 2, 2);
		setBlock(world, random, x + 3, y + 4, z + 1, Blocks.planks, 0, 2);
		setBlock(world, random, x + 3, y + 4, z + 2, Blocks.planks, 0, 2);
		setBlock(world, random, x + 3, y + 4, z + 3, Blocks.planks, 0, 2);
		setBlock(world, random, x + 3, y + 4, z + 4, Blocks.planks, 0, 2);
		setBlock(world, random, x + 3, y + 4, z + 5, Blocks.oak_stairs, 3, 2);
		setBlock(world, random, x + 3, y + 5, z + 1, Blocks.oak_stairs, 2, 2);
		setBlock(world, random, x + 3, y + 5, z + 2, Blocks.planks, 0, 2);
		setBlock(world, random, x + 3, y + 5, z + 3, Blocks.planks, 0, 2);
		setBlock(world, random, x + 3, y + 5, z + 4, Blocks.oak_stairs, 3, 2);
		setBlock(world, random, x + 3, y + 6, z + 2, Blocks.oak_stairs, 2, 2);
		setBlock(world, random, x + 3, y + 6, z + 3, Blocks.oak_stairs, 3, 2);
		setBlock(world, random, x + 4, y + 0, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 4, y + 0, z + 1, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 4, y + 0, z + 2, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 4, y + 0, z + 3, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 4, y + 0, z + 4, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 4, y + 0, z + 5, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 4, y + 1, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 4, y + 1, z + 1, Blocks.planks, 0, 2);
		setBlock(world, random, x + 4, y + 1, z + 2, Blocks.planks, 0, 2);
		setBlock(world, random, x + 4, y + 1, z + 3, Blocks.planks, 0, 2);
		setBlock(world, random, x + 4, y + 1, z + 4, Blocks.planks, 0, 2);
		setBlock(world, random, x + 4, y + 1, z + 5, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 4, y + 2, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 4, y + 2, z + 1, Blocks.planks, 0, 2);
		setBlock(world, random, x + 4, y + 2, z + 2, Blocks.glass_pane, 0, 2);
		setBlock(world, random, x + 4, y + 2, z + 3, Blocks.glass_pane, 0, 2);
		setBlock(world, random, x + 4, y + 2, z + 4, Blocks.planks, 0, 2);
		setBlock(world, random, x + 4, y + 2, z + 5, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 4, y + 3, z + 0, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 4, y + 3, z + 1, Blocks.planks, 0, 2);
		setBlock(world, random, x + 4, y + 3, z + 2, Blocks.planks, 0, 2);
		setBlock(world, random, x + 4, y + 3, z + 3, Blocks.planks, 0, 2);
		setBlock(world, random, x + 4, y + 3, z + 4, Blocks.planks, 0, 2);
		setBlock(world, random, x + 4, y + 3, z + 5, Blocks.cobblestone, 0, 2);
		setBlock(world, random, x + 4, y + 4, z + 0, Blocks.oak_stairs, 2, 2);
		setBlock(world, random, x + 4, y + 4, z + 1, Blocks.log, 0, 2);
		setBlock(world, random, x + 4, y + 4, z + 2, Blocks.log, 0, 2);
		setBlock(world, random, x + 4, y + 4, z + 3, Blocks.log, 0, 2);
		setBlock(world, random, x + 4, y + 4, z + 4, Blocks.log, 0, 2);
		setBlock(world, random, x + 4, y + 4, z + 5, Blocks.oak_stairs, 3, 2);
		setBlock(world, random, x + 4, y + 5, z + 1, Blocks.oak_stairs, 2, 2);
		setBlock(world, random, x + 4, y + 5, z + 2, Blocks.planks, 0, 2);
		setBlock(world, random, x + 4, y + 5, z + 3, Blocks.planks, 0, 2);
		setBlock(world, random, x + 4, y + 5, z + 4, Blocks.oak_stairs, 3, 2);
		setBlock(world, random, x + 4, y + 6, z + 2, Blocks.oak_stairs, 2, 2);
		setBlock(world, random, x + 4, y + 6, z + 3, Blocks.oak_stairs, 3, 2);
		
		//adding some extra stuff
		setBlock(world, random, x + 2, y + 3, z + 4, Blocks.torch, 0, 2);
		setBlock(world, random, x + 2, y + 0, z + 6, Blocks.stone_stairs, 3, 2);
		
		//adding a chest with random stuff
		// If just one chest, set last two parameters to 1 and false
		generateChest(world, random, x + 1, y + 1, z + 1, 0, 1, false);
	}
}
