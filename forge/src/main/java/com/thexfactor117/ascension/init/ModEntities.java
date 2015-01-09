package com.thexfactor117.ascension.init;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;

import com.thexfactor117.ascension.entities.EntityBarbarian;
import com.thexfactor117.ascension.entities.EntityBear;
import com.thexfactor117.ascension.entities.EntityGhost;
import com.thexfactor117.ascension.entities.EntityGoblin;
import com.thexfactor117.ascension.entities.EntityGolem;
import com.thexfactor117.ascension.entities.EntityMummy;
import com.thexfactor117.ascension.entities.EntitySnowBlaze;
import com.thexfactor117.ascension.entities.EntityValkyrie;
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
		
		addMobSpawns();
	}
	
	public static void addMobSpawns()
	{
		EntityRegistry.addSpawn(EntityMummy.class, 1, 1, 2, EnumCreatureType.monster, BiomeGenBase.desert);
		EntityRegistry.addSpawn(EntityValkyrie.class, 1, 1, 3, EnumCreatureType.monster, BiomeGenBase.forest);
		EntityRegistry.addSpawn(EntityGolem.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.stoneBeach);
		//EntityRegistry.addSpawn(EntityGoblin.class, 1, 1, 3, EnumCreatureType.monster, BiomeGenBase.swampland);
		EntityRegistry.addSpawn(EntityBarbarian.class, 2, 2, 4, EnumCreatureType.monster, BiomeGenBase.plains);
		//EntityRegistry.addSpawn(EntitySnowBlaze.class, 1, 1, 2, EnumCreatureType.monster, BiomeGenBase.coldTaiga);
		EntityRegistry.addSpawn(EntityBear.class, 1, 1, 2, EnumCreatureType.monster, BiomeGenBase.forest);
		//EntityRegistry.addSpawn(EntityShark.class, 1, 1, 2, EnumCreatureType.monster, BiomeGenBase.ocean);
		//EntityRegistry.addSpawn(EntityGhost.class, 1, 1, 1, EnumCreatureType.monster, BiomeGenBase.jungle);
	}
}
