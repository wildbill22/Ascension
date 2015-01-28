package com.thexfactor117.ascension.generation;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.thexfactor117.ascension.init.ModBlocks;
import com.thexfactor117.ascension.structures.AbandonedStructure;
import com.thexfactor117.ascension.structures.Camp_000;
import com.thexfactor117.ascension.structures.EasyMobDungeon1;
import com.thexfactor117.ascension.structures.LandWatchtowerPart1;
import com.thexfactor117.ascension.structures.MediumAbandonedHouse;
import com.thexfactor117.ascension.structures.SkyrimStyleHouse0;
import com.thexfactor117.ascension.structures.SmallAbandonedHouse;
import com.thexfactor117.ascension.structures.StructureGenAbandonedHouse;

import cpw.mods.fml.common.IWorldGenerator;

/**
 * 
 * @author WILLIAM
 *
 */
public class AscensionWorldGeneration implements IWorldGenerator
{
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		switch (world.provider.dimensionId)
		{
    		case 0:
    			generateSurface(world, random, chunkX * 16, chunkZ * 16);
    		case -1:
    			generateNether(world, random, chunkX * 16, chunkZ * 16);
    		case 1:
    			generateEnd(world, random, chunkX * 16, chunkZ * 16);
		}
	}
	
	/**
	 * addOreSpawn(block, world, random, x, z, 16, 16, amount per vein, spawn chance, minY, maxY)
	 */
	private void generateSurface(World world, Random random, int x, int z)
	{
		addOreSpawn(ModBlocks.titaniumOre, world, random, x, z, 16, 16, 1 + random.nextInt(3), 7, 0, 25);
		addOreSpawn(ModBlocks.vexalOre, world, random, x, z, 16, 16, 2 + random.nextInt(3), 7, 0, 32);
		addOreSpawn(ModBlocks.fleroviumOre, world, random, x, z, 16, 16, 1, 1, 0, 10);
		addOreSpawn(ModBlocks.limestone, world, random, x, z, 16, 16, 20 + random.nextInt(20), 15, 32, 128);
		addStructures(world, random, x, z);
	}

	private void generateNether(World world, Random random, int x, int z)
	{
	
	}

	private void generateEnd(World world, Random random, int x, int z)
	{
	
	}

	private void addOreSpawn(Block block, World world, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chanceToSpawn, int minY, int maxY)
	{
		for (int i = 0; i < chanceToSpawn; i++)
		{
			int posX = blockXPos + random.nextInt(maxX);
			int posY = minY + random.nextInt(maxY - minY);
			int posZ = blockZPos + random.nextInt(maxZ);
			new WorldGenMinable(block, maxVeinSize).generate(world, random, posX, posY, posZ);
		}
	}
	
	private void addStructures(World world, Random random, int x, int z){
		// Flat?
		if (world.provider.getAverageGroundLevel() < 10)
			return;

		final int numStructures = 6;
		int which = random.nextInt(numStructures);
		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);
		
		switch (which) {
		case 0:
		case 1:
			Camp_000 camp = new Camp_000();
			// Use center of camp as entrance for now
			generateStructure(camp, world, random, x, z, 16, 16, -1);
			break;
		case 2:
			LandWatchtowerPart1 tower = new LandWatchtowerPart1();
			generateStructure(tower, world, random, x, z, 3, 0, -1);
			break;
		case 3:
			MediumAbandonedHouse mediumHouse = new MediumAbandonedHouse();
			generateStructure(mediumHouse, world, random, x, z, 3, 0, -1);
			break;
		case 4:
			SmallAbandonedHouse smallHouse = new SmallAbandonedHouse();
			generateStructure(smallHouse, world, random, x, z, 2, 0, -1);
			break;
		case 5:
			if (biome != BiomeGenBase.birchForest && biome != BiomeGenBase.birchForestHills &&
			biome != BiomeGenBase.forest && biome != BiomeGenBase.forestHills &&
			biome != BiomeGenBase.jungle && biome != BiomeGenBase.jungleHills &&
			biome != BiomeGenBase.taiga && biome != BiomeGenBase.taigaHills &&
			biome != BiomeGenBase.roofedForest) {
				EasyMobDungeon1 dungeon = new EasyMobDungeon1();
				generateStructure(dungeon, world, random, x, z, 5, 0, -1);
			}
			break;
		}
	}

	/**
	 * Create structure at x, z, check height at entrance at x + doorX, z + doorZ, set y = y + yOffset 
	 * @param world 
	 * @param random
	 * @param x X coordinate in world
	 * @param z Z coordinate in world
	 * @param doorX Offset from x where entrance is
	 * @param doorZ Offset from z where entrance is
	 * @param yOffset Normally 0, but -1 if structure has floor
	 * @return true if generated
	 */
	private boolean generateStructure(AbandonedStructure structure, World world, Random random, int x, int z, int doorX, int doorZ, int offsetY) {
		int chance = random.nextInt(100);
		if (chance < structure.structureSpawnChance) {
			int posX = x + random.nextInt(16);
			int posZ = z + random.nextInt(16);
			int posY = world.getHeightValue(posX + doorX, posZ + doorZ); 
			return structure.generate(world, random, posX, posY - offsetY, posZ);
		}
		return false;
	}
}
