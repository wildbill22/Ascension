package com.thexfactor117.ascension.init;

import com.thexfactor117.ascension.Ascension;
import com.thexfactor117.ascension.entities.boss.EntityPharaoh;
import com.thexfactor117.ascension.help.LogHelper;
import com.thexfactor117.ascension.items.AscensionMonsterPlacer;

import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBosses
{
    static int startEntityId = 300;
    
    public static Item itemSpawnEgg = new AscensionMonsterPlacer("Pharaoh", 0xC9C9BB, 0x182ED6).setUnlocalizedName("spawn_egg_" + "Pharaoh".toLowerCase()).setTextureName("thexfactor117_ascension:spawn_egg");
    
    public static void init()
    {
    	registerModEntityWithEgg(EntityPharaoh.class, "Pharaoh", 0xC9C9BB, 0x182ED6);
    }
    
    public static void registerModEntity(Class parEntityClass, String parEntityName)
    {
    	int id = getUniqueEntityId();
        EntityRegistry.registerModEntity(parEntityClass, parEntityName, id, Ascension.instance, 64, 1, false);
      	// DEBUG
      	LogHelper.info("Registering mod entity " + parEntityName + " with ID = " + id);
    }

    public static void registerModEntityWithEgg(Class parEntityClass, String parEntityName, int parEggColor, int parEggSpotsColor)
    {
        registerModEntity(parEntityClass, parEntityName);
        registerSpawnEgg(parEntityName, parEggColor, parEggSpotsColor);
    }

    public static void registerSpawnEgg(String parSpawnName, int parEggColor, int parEggSpotsColor)
    {
    	//Item itemSpawnEgg = new AscensionMonsterPlacer(parSpawnName, parEggColor, parEggSpotsColor).setUnlocalizedName("spawn_egg_" + parSpawnName.toLowerCase()).setTextureName("thexfactor117_ascension:spawn_egg");
    	GameRegistry.registerItem(itemSpawnEgg, "spawnEgg" + parSpawnName);
    }
    
    public static int getUniqueEntityId()
    {
    	do
    	{
    		startEntityId++;
    	}
    	while (EntityList.getStringFromID(startEntityId) != null);

    	return startEntityId;
    }
}
