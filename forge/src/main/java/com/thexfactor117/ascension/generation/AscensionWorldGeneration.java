package com.thexfactor117.ascension.generation;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.thexfactor117.ascension.init.ModBlocks;
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

	private void generateSurface(World world, Random random, int x, int z)
	{
		addOreSpawn(ModBlocks.titaniumOre, world, random, x, z, 16, 16, 1 + random.nextInt(3), 7, 0, 25);
		addOreSpawn(ModBlocks.vexalOre, world, random, x, z, 16, 16, 2 + random.nextInt(3), 7, 0, 32);
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
		int chance = random.nextInt(1000);
		boolean generatedStructure = false; // needed when a 2nd structure is added
		int spawnChance = 0;
		
		spawnChance += MediumAbandonedHouse.spawnChance; 
		if (generatedStructure == false && chance < spawnChance)
		{
			// Create abandoned house
			int posX = x + random.nextInt(16);
			int posZ = z + random.nextInt(16);
			// Check where entrance is (look in structure class for location of stairs):
			int posY = world.getHeightValue(posX + 3, posZ + 0); 
			MediumAbandonedHouse house = new MediumAbandonedHouse();
			generatedStructure = house.generate(world, random, posX, posY - 1, posZ);
		}

		spawnChance += SmallAbandonedHouse.spawnChance; 
		if (generatedStructure == false && chance < spawnChance)
		{
			// Create abandoned house
			int posX = x + random.nextInt(16);
			int posZ = z + random.nextInt(16);
			// Check where entrance is (look in structure class for location of stairs):
			int posY = world.getHeightValue(posX + 2, posZ + 0); 
			SmallAbandonedHouse house = new SmallAbandonedHouse();
			generatedStructure = house.generate(world, random, posX, posY - 1, posZ);
		}

		spawnChance += StructureGenAbandonedHouse.spawnChance; 
		if (generatedStructure == false && chance < spawnChance)
		{
			// Create abandoned house
			int posX = x + random.nextInt(16);
			int posZ = z + random.nextInt(16);
			// Check where entrance is (look in structure class for location of stairs):
			int posY = world.getHeightValue(posX + 2, posZ + 6); 
			StructureGenAbandonedHouse house = new StructureGenAbandonedHouse();
			generatedStructure = house.generate(world, random, posX, posY, posZ);
		}

		// Code below for second structure is designed to not place it if first is placed
		// 2nd structure would go here like so:
		spawnChance += SkyrimStyleHouse0.spawnChance; 
		if (generatedStructure == false && chance < spawnChance) {
			int posX = x + random.nextInt(16);
			int posZ = z + random.nextInt(16);
			// Check where entrance is:
			int posY = world.getHeightValue(posX + 9, posZ + 16);
			SkyrimStyleHouse0 house = new SkyrimStyleHouse0();
			generatedStructure = house.generate(world, random, posX, posY, posZ);
		}
	}
}
