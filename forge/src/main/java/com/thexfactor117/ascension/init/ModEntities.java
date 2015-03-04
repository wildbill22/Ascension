package com.thexfactor117.ascension.init;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.thexfactor117.ascension.entities.hostile.EntityBanshee;
import com.thexfactor117.ascension.entities.hostile.EntityBarbarian;
import com.thexfactor117.ascension.entities.hostile.EntityGhost;
import com.thexfactor117.ascension.entities.hostile.EntityGoblin;
import com.thexfactor117.ascension.entities.hostile.EntityGolem;
import com.thexfactor117.ascension.entities.hostile.EntityMiniGolem;
import com.thexfactor117.ascension.entities.hostile.EntityMummy;
import com.thexfactor117.ascension.entities.hostile.EntitySnowBlaze;
import com.thexfactor117.ascension.entities.hostile.EntityValkyrie;
import com.thexfactor117.ascension.entities.passive.EntityDoe;
import com.thexfactor117.ascension.entities.projectiles.EntityMediumMagic;
import com.thexfactor117.ascension.entities.projectiles.EntityMediumOblivion;
import com.thexfactor117.ascension.entities.projectiles.EntitySmallMagic;
import com.thexfactor117.ascension.entities.projectiles.EntitySmallOblivion;
import com.thexfactor117.ascension.handlers.ConfigHandler;
import com.thexfactor117.ascension.handlers.EntityHandler;

import cpw.mods.fml.common.registry.EntityRegistry;

public class ModEntities 
{
	public static void init()
	{
		//Overworld Mobs
		EntityHandler.registerMonsters(EntityMummy.class, "Mummy");
		EntityHandler.registerMonsters(EntityValkyrie.class, "Valkyrie");
		EntityHandler.registerMonsters(EntityGolem.class, "Golem");
		EntityHandler.registerMonsters(EntityBarbarian.class, "Barbarian");
		EntityHandler.registerMonsters(EntityGhost.class, "Ghost");
		EntityHandler.registerMonsters(EntityBanshee.class, "Banshee");
		// comment these out!
		EntityHandler.registerMonsters(EntitySnowBlaze.class, "Snow Blaze");
		EntityHandler.registerMonsters(EntityGoblin.class, "Goblin");
		EntityHandler.registerMonsters(EntityMiniGolem.class, "Mini-Golem");
		
		EntityHandler.registerAnimals(EntityDoe.class, "Doe");
		
		// Projectiles
		EntityHandler.registerProjectiles(EntitySmallMagic.class, "Small Magic");
		EntityHandler.registerProjectiles(EntityMediumMagic.class, "Medium Magic");
		EntityHandler.registerProjectiles(EntitySmallOblivion.class, "Small Oblivion");
		EntityHandler.registerProjectiles(EntityMediumOblivion.class, "Medium Oblivion");

		addMobSpawns();
	}
	
	public static void addMobSpawns()
	{
		//Overworld
		/*
		 * Weigthed Probability info:
		 * 
		 * CREATURE (day): Cows (8), Pigs (10), Chickens (10), Sheep (12)
		 * MONSTER (night): All 100 except Endermen (10), and Witches (5)
		 * AMBIENT (ambient creatures): Bats (10)
		 * WATER (water, duh): Squids (10)
		 * 
		 * Make sure these balance out; if not balanced, it could cause excess spawning/not spawning
		 * at all, plus crashes.
		 */
		
		// HOSTILE
		if (ConfigHandler.shouldBansheeSpawn)
		{
			EntityRegistry.addSpawn(EntityBanshee.class, 200, 1, 2, EnumCreatureType.monster, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.roofedForest);
		}
		
		if (ConfigHandler.shouldBarbarianSpawn)
		{
			EntityRegistry.addSpawn(EntityBarbarian.class, 20, 1, 3, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.roofedForest);
		}
		
		if (ConfigHandler.shouldGhostSpawn)
		{
			EntityRegistry.addSpawn(EntityGhost.class, 65, 1, 2, EnumCreatureType.monster, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.roofedForest);
		}
		
		if (ConfigHandler.shouldGolemSpawn)
		{
			EntityRegistry.addSpawn(EntityGolem.class, 40, 1, 2, EnumCreatureType.monster, BiomeGenBase.stoneBeach, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F);
		}
		
		if (ConfigHandler.shouldMummySpawn)
		{
			EntityRegistry.addSpawn(EntityMummy.class, 50, 1, 3, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.desertHills);
		}
		
		if (ConfigHandler.shouldValkyrieSpawn)
		{
			EntityRegistry.addSpawn(EntityValkyrie.class, 20, 1, 3, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.desert, BiomeGenBase.extremeHills, BiomeGenBase.extremeHillsEdge, BiomeGenBase.extremeHillsPlus, BiomeGenBase.desert, BiomeGenBase.desertHills, BiomeGenBase.iceMountains, BiomeGenBase.icePlains, BiomeGenBase.mesa, BiomeGenBase.mesaPlateau, BiomeGenBase.mesaPlateau_F, BiomeGenBase.mushroomIsland, BiomeGenBase.mushroomIslandShore, BiomeGenBase.savanna, BiomeGenBase.savannaPlateau, BiomeGenBase.swampland, BiomeGenBase.taiga, BiomeGenBase.taigaHills, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.roofedForest);
		}
		
		// PASSIVE
		if (ConfigHandler.shouldValkyrieSpawn)
		{
			EntityRegistry.addSpawn(EntityDoe.class, 8, 2, 4, EnumCreatureType.creature, BiomeGenBase.plains, BiomeGenBase.forest, BiomeGenBase.birchForest, BiomeGenBase.birchForestHills, BiomeGenBase.forestHills, BiomeGenBase.jungle, BiomeGenBase.jungleEdge, BiomeGenBase.jungleHills, BiomeGenBase.roofedForest);
		}
	}
}
