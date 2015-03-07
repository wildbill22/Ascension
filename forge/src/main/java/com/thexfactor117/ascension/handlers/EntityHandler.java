package com.thexfactor117.ascension.handlers;

import java.util.Random;

import com.thexfactor117.ascension.Ascension;

import net.minecraft.entity.EntityList;
import cpw.mods.fml.common.registry.EntityRegistry;

public class EntityHandler 
{	
	public static void registerProjectiles(Class entityClass, String name)
	{
		int entityId = EntityRegistry.findGlobalUniqueEntityId();
		
		EntityRegistry.registerModEntity(entityClass, name, entityId, Ascension.instance, 64, 10, true);
	}
}
