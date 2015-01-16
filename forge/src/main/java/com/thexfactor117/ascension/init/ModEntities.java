package com.thexfactor117.ascension.init;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.thexfactor117.ascension.entities.hostile.EntityBarbarian;
import com.thexfactor117.ascension.entities.hostile.EntityBear;
import com.thexfactor117.ascension.entities.hostile.EntityGhost;
import com.thexfactor117.ascension.entities.hostile.EntityGoblin;
import com.thexfactor117.ascension.entities.hostile.EntityGolem;
import com.thexfactor117.ascension.entities.hostile.EntityMummy;
import com.thexfactor117.ascension.entities.hostile.EntitySnowBlaze;
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
		EntityHandler.registerMonsters(EntityGoblin.class, "Goblin");
		EntityHandler.registerMonsters(EntityBarbarian.class, "Barbarian");
		EntityHandler.registerMonsters(EntitySnowBlaze.class, "Snow Blaze");
		EntityHandler.registerMonsters(EntityBear.class, "Bear");
		//EntityHandler.registerMonsters(EntityShark.class, "Shark");
		EntityHandler.registerMonsters(EntityGhost.class, "Ghost");
		
		EntityHandler.registerAnimals(EntityDoe.class, "Doe");
		
		addMobSpawns();
	}
	
	public static void addMobSpawns()
	{
		//Overworld
		EntityRegistry.addSpawn(EntityMummy.class, 10, 1, 3, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.desertHills);
		EntityRegistry.addSpawn(EntityValkyrie.class, 100, 2, 6, EnumCreatureType.monster, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.roofedForest);
		EntityRegistry.addSpawn(EntityGolem.class, 25, 1, 2, EnumCreatureType.monster, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus);
		//EntityRegistry.addSpawn(EntityGoblin.class, 100, 1, 3, EnumCreatureType.monster, BiomeGenBase.swampland);
		EntityRegistry.addSpawn(EntityBarbarian.class, 100, 2, 6, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
		//EntityRegistry.addSpawn(EntitySnowBlaze.class, 1, 1, 2, EnumCreatureType.monster, BiomeGenBase.coldTaiga);
		EntityRegistry.addSpawn(EntityBear.class, 50, 2, 4, EnumCreatureType.monster, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.roofedForest, BiomeGenBase.taiga, BiomeGenBase.taigaHills);
		//EntityRegistry.addSpawn(EntityShark.class, 1, 1, 2, EnumCreatureType.monster, BiomeGenBase.ocean);
		//EntityRegistry.addSpawn(EntityGhost.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.jungle);
		
		EntityRegistry.addSpawn(EntityDoe.class, 75, 2, 4, EnumCreatureType.creature, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.roofedForest);
	}
}
