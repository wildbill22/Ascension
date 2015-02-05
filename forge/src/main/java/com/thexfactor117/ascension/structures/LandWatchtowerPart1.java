package com.thexfactor117.ascension.structures;

import java.util.Random;

import com.thexfactor117.ascension.help.LogHelper;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.structures.StructureCoordinates.Structures;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
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
	public static int spawnChance = Reference.spawnChanceLandWatchtowerPart1; // chance n/100
	private static int doorX = 3;
	private static int doorZ = 0;
	private static int xMax = 6;
	private static int zMax = 6;

	public LandWatchtowerPart1() 
	{
		super(missingBlockChance, spawnHeightTolerance, spawnChance, Structures.OTHER, 
				getValidSpawnBlocks(), getMobsToSpawn(), doorX, doorZ, xMax, zMax);

		int i = 0;
		i = addItemsForAllChests(i, 1);		
	}

	protected static String[] getMobsToSpawn() {
		return new String[] { "Ghost", "Barbarian", "Valkyrie" };
	}

	protected static Block[] getValidSpawnBlocks() 
	{
		return new Block[] { Blocks.grass, Blocks.dirt, Blocks.sand, Blocks.cobblestone };
	}

	@Override
	// Lower level, from part1 of schematic
	// 7 wide (x) x 7 length (z)
	public boolean generate(World world, Random random, int x, int y, int z) {
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
		
		return true;
	}
}
