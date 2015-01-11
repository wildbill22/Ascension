package com.thexfactor117.ascension.init;

import net.minecraft.item.Item;

import com.thexfactor117.ascension.help.RegisterHelper;
import com.thexfactor117.ascension.items.structures.SpawnAbandonedHouse;
import com.thexfactor117.ascension.items.structures.SpawnSkyrimStyleHouse;

public class ModStructureItems {

	public static Item spawnAbandonedHouse = new SpawnAbandonedHouse().setUnlocalizedName("spawnAbandonedHouse");
	public static Item spawnSkyrimStyleHouse = new SpawnSkyrimStyleHouse().setUnlocalizedName("spawnSkyrimStyleHouse");

	public static void init()
	{
		RegisterHelper.registerItem(spawnAbandonedHouse);
		RegisterHelper.registerItem(spawnSkyrimStyleHouse);
	}
}
