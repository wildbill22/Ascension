package com.thexfactor117.ascension.generation;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.util.ChunkCoordinates;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;

import com.thexfactor117.ascension.handlers.ConfigHandler;
import com.thexfactor117.ascension.help.LogHelper;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModBlocks;
import com.thexfactor117.ascension.structures.AbandonedStructure;
import com.thexfactor117.ascension.structures.AbandonedTower;
import com.thexfactor117.ascension.structures.Camp_000;
import com.thexfactor117.ascension.structures.EasyMobDungeon1;
import com.thexfactor117.ascension.structures.LandWatchtowerPart1;
import com.thexfactor117.ascension.structures.MazeDungeon_000;
import com.thexfactor117.ascension.structures.MediumAbandonedHouse;
import com.thexfactor117.ascension.structures.SmallAbandonedHouse;
import com.thexfactor117.ascension.structures.Sphinx_000;
import com.thexfactor117.ascension.structures.StructureCoordinates;
import com.thexfactor117.ascension.structures.StructureList;

import cpw.mods.fml.common.IWorldGenerator;

/**
 * 
 * @author WILLIAM
 * @author TheXFactor117
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
		if (ConfigHandler.generateTitaniumOre)
		{
			addOreSpawn(ModBlocks.titaniumOre, world, random, x, z, 16, 16, 2 + random.nextInt(3), ConfigHandler.titaniumSpawnProbability, ConfigHandler.titaniumMinY, ConfigHandler.titaniumMaxY);
		}
		
		if (ConfigHandler.generateVexalOre)
		{
			addOreSpawn(ModBlocks.vexalOre, world, random, x, z, 16, 16, 2 + random.nextInt(3), ConfigHandler.vexalSpawnProbability, ConfigHandler.vexalMinY, ConfigHandler.vexalMaxY);
		}
		
		if (ConfigHandler.generateFleroviumOre)
		{
			addOreSpawn(ModBlocks.fleroviumOre, world, random, x, z, 16, 16, 1, ConfigHandler.fleroviumSpawnProbability, ConfigHandler.fleroviumMinY, ConfigHandler.fleroviumMaxY);
		}
		
		if (ConfigHandler.generateLimestone)
		{
			addOreSpawn(ModBlocks.limestone, world, random, x, z, 16, 16, 20 + random.nextInt(20), ConfigHandler.limestoneSpawnProbability, ConfigHandler.limestoneMinY, ConfigHandler.limestoneMaxY);
		}
		
		if (ConfigHandler.generateStructures)
		{
			addStructures(world, random, x, z);
		}
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

		BiomeGenBase biome = world.getWorldChunkManager().getBiomeGenAt(x, z);

		// This one gets special consideration, as it is so hard to spawn
		if (biome == BiomeGenBase.desert && StructureList.isSphinxGenerated() == false) {
			ChunkCoordinates spawn = world.getSpawnPoint();
			double distanceFromSpawn = Math.sqrt(spawn.getDistanceSquared(x, 64, z));
			if (distanceFromSpawn > Reference.minSpawnDistSphinx) {
				LogHelper.info("Attempting to generate Sphinx at " + distanceFromSpawn + " meters from spawn"); 
				Sphinx_000 sphinx = new Sphinx_000();
				if (generateFlatStructure(sphinx, world, random, x, z, -1, false) == true) {
					StructureList.setSphinxGenerated(true);
					return;
				}
			}
		}
		
		final int numStructures = 8; // Set to the number case statements below
		int which = random.nextInt(numStructures);
		switch (which) {
		case 0:
		case 1:
			Camp_000 camp = new Camp_000();
			// Use center of camp as entrance for now
			generateFlatStructure(camp, world, random, x, z, -1, true);
			break;
		case 2:
			if (biome != BiomeGenBase.desert) {				
				LandWatchtowerPart1 tower = new LandWatchtowerPart1();
				generateSmallStructure(tower, world, random, x, z, -1, Blocks.cobblestone);
			}
			break;
		case 3:
			if (biome != BiomeGenBase.desert) {				
				MediumAbandonedHouse mediumHouse = new MediumAbandonedHouse();
				generateSmallStructure(mediumHouse, world, random, x, z, -1, Blocks.cobblestone);
			}
			break;
		case 4:
			if (biome != BiomeGenBase.desert) {				
				SmallAbandonedHouse smallHouse = new SmallAbandonedHouse();
				generateSmallStructure(smallHouse, world, random, x, z, -1, Blocks.cobblestone);
			}
			break;
		case 5:
			if (biome != BiomeGenBase.birchForest && biome != BiomeGenBase.birchForestHills &&
			biome != BiomeGenBase.forest && biome != BiomeGenBase.forestHills &&
			biome != BiomeGenBase.jungle && biome != BiomeGenBase.jungleHills &&
			biome != BiomeGenBase.taiga && biome != BiomeGenBase.taigaHills &&
			biome != BiomeGenBase.roofedForest) {
				EasyMobDungeon1 dungeon = new EasyMobDungeon1();
				generateLargeStructure(dungeon, world, random, x, z, -1);
			}
			break;
		case 6:
			AbandonedTower abandonedTower = new AbandonedTower();
			generateSmallStructure(abandonedTower, world, random, x, z, -1, Blocks.cobblestone);
			break;
		case 7:
			ChunkCoordinates spawn = world.getSpawnPoint();
			double distanceFromSpawn = Math.sqrt(spawn.getDistanceSquared(x, 64, z));
			if (distanceFromSpawn > Reference.minSpawnDistMazeDungeon) {
				MazeDungeon_000 mazeDungeon = new MazeDungeon_000();
				generateUndergroundStructure(mazeDungeon, world, random, x, z);
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
	private boolean generateSmallStructure(AbandonedStructure structure, World world, Random random, int x, int z, int offsetY, Block block) {
		int chance = random.nextInt(100);
		if (chance < structure.structureSpawnChance) {
			int posX = x + random.nextInt(16);
			int posZ = z + random.nextInt(16);
			int posY = world.getHeightValue(posX + structure.doorX, posZ + structure.doorZ); 

			// Don't place if another structures is nearby
			if (StructureList.findNearestStructure(posX + 5, posY, posZ + 4) < 64)
				return false;

			//check that each corner is one of the valid spawn blocks
			if(!structure.locationIsValidSpawn(world, posX, posY, posZ) 
					|| !structure.locationIsValidSpawn(world, posX + structure.xMax, posY, posZ) 
					|| !structure.locationIsValidSpawn(world, posX + structure.xMax, posY, posZ + structure.zMax) 
					|| !structure.locationIsValidSpawn(world, posX, posY, posZ + structure.zMax))
			{
				return false;
			}
			StructureList.generatedCenterAt(structure.structureType, posX + structure.xMax / 2, posY, posZ + structure.zMax / 2);
			
			structure.generate(world, random, posX, posY + offsetY, posZ);
			structure.generateStructureBase(world, random, posX, posZ, structure.xMax, structure.zMax, block);
		}
		return false;
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
	private boolean generateLargeStructure(AbandonedStructure structure, World world, Random random, int x, int z, int offsetY) {
		// Add this line to prevent more than one being built at a time
		if (AbandonedStructure.running) return false; 

		int chance = random.nextInt(100);
		if (chance < structure.structureSpawnChance) {
			int posX = x + random.nextInt(16);
			int posZ = z + random.nextInt(16);
			int posY = world.getHeightValue(posX, posZ);
			StructureCoordinates coords = new StructureCoordinates(structure.structureType, posX, posY, posZ);
			if (!structure.isValidSpawnCorners(world, coords)){
				return false;
			}
			coords.posY = coords.posY + offsetY;
			StructureList.generatedAt(structure.structureType, coords);			
			return structure.generateStructureInThread(world, random, coords, true);		
		}
		return false;
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
	 * @param generateBase true to generate the base (below the structure
	 * @return true if generated
	 */
	private boolean generateFlatStructure(AbandonedStructure structure, World world, Random random, int x, int z, int offsetY, boolean generateBase) {
		// Add this line to prevent more than one being built at a time
		if (AbandonedStructure.running) return false; 

		int chance = random.nextInt(100);
		if (chance < structure.structureSpawnChance) {
			int posX = x + random.nextInt(16);
			int posZ = z + random.nextInt(16);
			int posY = world.getHeightValue(posX, posZ);
			StructureCoordinates coords = new StructureCoordinates(structure.structureType, posX, posY, posZ);
			// TODO: can set spawn location after returning from this
			// Also check for close structures just from the posX, posY, posZ, not the center
			if (!structure.isValidSpawnEdges(world, coords)){
				return false;
			}
//			StructureList.setSphinxGenerated(true);
			coords.posY = coords.posY + offsetY;
			StructureList.generatedAt(structure.structureType, coords);			
			return structure.generateStructureInThread(world, random, coords, generateBase);		
		}
		return false;
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
	private boolean generateUndergroundStructure(AbandonedStructure structure, World world, Random random, int x, int z) {
		// Add this line to prevent more than one being built at a time
		if (AbandonedStructure.running) return false; 

		int chance = random.nextInt(100);
		if (chance < structure.structureSpawnChance) {
			int posX = x + random.nextInt(16);
			int posZ = z + random.nextInt(16);
			int posY = structure.minY + random.nextInt(structure.maxY - structure.minY);
			
			StructureCoordinates coords = new StructureCoordinates(structure.structureType, posX, posY, posZ);
			if (!structure.isValidUndergroundSpawnCorners(world, coords)){
				return false;
			}

			StructureList.generatedAt(structure.structureType, coords);			
			return structure.generateStructureInThread(world, random, coords, false);		
		}
		return false;
	}
}	
