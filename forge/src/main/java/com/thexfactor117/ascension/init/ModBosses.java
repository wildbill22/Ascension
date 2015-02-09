package com.thexfactor117.ascension.init;

import com.thexfactor117.ascension.Ascension;
import com.thexfactor117.ascension.entities.boss.EntityPharaoh;
import com.thexfactor117.ascension.help.LogHelper;
import com.thexfactor117.ascension.items.AscensionMonsterPlacer;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModBosses
{
    static int entityId = -1;
    
    public static Item itemSpawnEgg = new AscensionMonsterPlacer("Pharaoh", 0xC9C9BB, 0x182ED6).setUnlocalizedName("spawn_egg_" + "Pharaoh".toLowerCase()).setTextureName("thexfactor117_ascension:spawn_egg");
    
    public static void init()
    {
    	registerModEntityWithEgg(EntityPharaoh.class, "Pharaoh", 0xC9C9BB, 0x182ED6);
    }
    
    public static void registerModEntity(Class parEntityClass, String parEntityName)
    {
        EntityRegistry.registerModEntity(parEntityClass, parEntityName, ++entityId, Ascension.instance, 64, 1, false);
      	// DEBUG
      	LogHelper.info("Registering mod entity " + parEntityName + " with ID = " + entityId);
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
}
