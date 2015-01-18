package com.thexfactor117.ascension.init;

import net.minecraft.item.Item;

import com.thexfactor117.ascension.help.RegisterHelper;
import com.thexfactor117.ascension.items.structures.SpawnAbandonedHouse;
import com.thexfactor117.ascension.items.structures.SpawnLandWatchtower;
import com.thexfactor117.ascension.items.structures.SpawnMediumAbandonedHouse;
import com.thexfactor117.ascension.items.structures.SpawnSkyrimStyleHouse;
import com.thexfactor117.ascension.items.structures.SpawnSmallAbandonedHouse;

/**
 * 
 * @author WILLIAM
 *
 */
public class ModStructureItems {

	public static Item spawnAbandonedHouse = new SpawnAbandonedHouse().setUnlocalizedName("spawnAbandonedHouse");
	public static Item spawnSkyrimStyleHouse = new SpawnSkyrimStyleHouse().setUnlocalizedName("spawnSkyrimStyleHouse");
	public static Item spawnSmallAbandonedHouse = new SpawnSmallAbandonedHouse().setUnlocalizedName("spawnSmallAbandonedHouse");
	public static Item spawnMediumAbandonedHouse = new SpawnMediumAbandonedHouse().setUnlocalizedName("spawnMediumAbandonedHouse");
	public static Item spawnLandWatchtower = new SpawnLandWatchtower().setUnlocalizedName("spawnLandWatchtower");

	public static void init()
	{
		RegisterHelper.registerItem(spawnAbandonedHouse);
		RegisterHelper.registerItem(spawnSkyrimStyleHouse);
		RegisterHelper.registerItem(spawnSmallAbandonedHouse);
		RegisterHelper.registerItem(spawnMediumAbandonedHouse);
		RegisterHelper.registerItem(spawnLandWatchtower);
	}
}
