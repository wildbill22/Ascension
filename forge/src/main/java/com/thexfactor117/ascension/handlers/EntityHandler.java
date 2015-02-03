package com.thexfactor117.ascension.handlers;

import java.util.Random;

import com.thexfactor117.ascension.Ascension;

import net.minecraft.entity.EntityList;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler 
{
	public static void registerMonsters(Class entityClass, String name)
	{
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = name.hashCode();
		Random random = new Random();
		int primaryColor = random.nextInt() * 627424;
		int secondaryColor = random.nextInt() * 627424;
		
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.registerModEntity(entityClass, name, entityId, Ascension.instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, primaryColor, secondaryColor));
	}
	
	public static void registerAnimals(Class entityClass, String name)
	{
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		long x = name.hashCode();
		Random random = new Random();
		int primaryColor = random.nextInt() * 627424;
		int secondaryColor = random.nextInt() * 627424;
		
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.registerModEntity(entityClass, name, entityId, Ascension.instance, 64, 1, true);
		EntityList.entityEggs.put(Integer.valueOf(entityId), new EntityList.EntityEggInfo(entityId, primaryColor, secondaryColor));
	}
	
	public static void registerBosses(Class entityClass, String name)
	{
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerGlobalEntityID(entityClass, name, entityId);
		EntityRegistry.registerModEntity(entityClass, name, entityId, Ascension.instance, 64, 1, true);
	}
}
