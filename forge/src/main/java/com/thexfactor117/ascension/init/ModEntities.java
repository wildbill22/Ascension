package com.thexfactor117.ascension.init;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.thexfactor117.ascension.entities.hostile.EntityBanshee;
import com.thexfactor117.ascension.entities.hostile.EntityBarbarian;
import com.thexfactor117.ascension.entities.hostile.EntityGhost;
import com.thexfactor117.ascension.entities.hostile.EntityGolem;
import com.thexfactor117.ascension.entities.hostile.EntityMummy;
import com.thexfactor117.ascension.entities.hostile.EntityValkyrie;
import com.thexfactor117.ascension.entities.passive.EntityDoe;
import com.thexfactor117.ascension.handlers.EntityHandler;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities 
{
	public static void init()
	{
		//Overworld
		EntityHandler.registerMonsters(EntityMummy.class, "Mummy");
		EntityHandler.registerMonsters(EntityValkyrie.class, "Valkyrie");
		EntityHandler.registerMonsters(EntityGolem.class, "Golem");
		EntityHandler.registerMonsters(EntityBarbarian.class, "Barbarian");
		EntityHandler.registerMonsters(EntityGhost.class, "Ghost");
		EntityHandler.registerMonsters(EntityBanshee.class, "Banshee");
		
		EntityHandler.registerAnimals(EntityDoe.class, "Doe");
		
		addMobSpawns();
	}
	
	public static void addMobSpawns()
	{
		//Overworld
		EntityRegistry.addSpawn(EntityMummy.class, 20, 1, 3, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.desertHills);
		EntityRegistry.addSpawn(EntityValkyrie.class, 100, 2, 6, EnumCreatureType.creature, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.roofedForest);
		EntityRegistry.addSpawn(EntityGolem.class, 35, 1, 2, EnumCreatureType.monster, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus);
		EntityRegistry.addSpawn(EntityBarbarian.class, 100, 2, 6, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.roofedForest);
		EntityRegistry.addSpawn(EntityGhost.class, 50, 1, 2, EnumCreatureType.monster, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.roofedForest);
		EntityRegistry.addSpawn(EntityBanshee.class, 25, 1, 2, EnumCreatureType.monster, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.roofedForest);
		
		EntityRegistry.addSpawn(EntityDoe.class, 75, 2, 4, EnumCreatureType.creature, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.roofedForest);
	}
}
