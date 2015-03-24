package com.thexfactor117.ascension.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.help.RegisterHelper;
import com.thexfactor117.ascension.items.structures.SpawnAbandonedTower;
import com.thexfactor117.ascension.items.structures.SpawnCamp;
import com.thexfactor117.ascension.items.structures.SpawnEasyMobDungeon1;
import com.thexfactor117.ascension.items.structures.SpawnLandWatchtower;
import com.thexfactor117.ascension.items.structures.SpawnMazeDungeon1;
import com.thexfactor117.ascension.items.structures.SpawnMediumAbandonedHouse;
import com.thexfactor117.ascension.items.structures.SpawnSmallAbandonedHouse;
import com.thexfactor117.ascension.items.structures.SpawnSphinx;

/**
 * 
 * @author WILLIAM
 *
 */

public class ModStructureItems {

	public static Item spawn_small_abandoned_house = new SpawnSmallAbandonedHouse().setUnlocalizedName("spawn_small_abandoned_house");
	public static Item spawn_medium_abandoned_house = new SpawnMediumAbandonedHouse().setUnlocalizedName("spawn_medium_abandoned_house");
	public static Item spawn_land_watchtower = new SpawnLandWatchtower().setUnlocalizedName("spawn_land_watchtower");
	public static Item spawn_easy_mob_dungeon_1 = new SpawnEasyMobDungeon1().setUnlocalizedName("spawn_easy_mob_dungeon_1");
	public static Item spawn_camp = new SpawnCamp().setUnlocalizedName("spawn_camp");
	public static Item spawn_sphinx = new SpawnSphinx().setUnlocalizedName("spawn_sphinx");
	public static Item spawn_abandoned_tower = new SpawnAbandonedTower().setUnlocalizedName("spawn_abandoned_tower");
	public static Item spawn_maze_dungeon_1 = new SpawnMazeDungeon1().setUnlocalizedName("spawn_maze_dungeon_1");

	public static void registerItems()
	{
		RegisterHelper.registerItem(spawn_small_abandoned_house);
		RegisterHelper.registerItem(spawn_medium_abandoned_house);
		RegisterHelper.registerItem(spawn_land_watchtower);
		RegisterHelper.registerItem(spawn_easy_mob_dungeon_1);
		RegisterHelper.registerItem(spawn_camp);
		RegisterHelper.registerItem(spawn_sphinx);
		RegisterHelper.registerItem(spawn_abandoned_tower);
		RegisterHelper.registerItem(spawn_maze_dungeon_1);
	}
	
	public static void registerRenders()
	{
		registerRender(spawn_small_abandoned_house);
		registerRender(spawn_medium_abandoned_house);
		registerRender(spawn_land_watchtower);
		registerRender(spawn_easy_mob_dungeon_1);
		registerRender(spawn_camp);
		registerRender(spawn_sphinx);
		registerRender(spawn_abandoned_tower);
		registerRender(spawn_maze_dungeon_1);
	}
	
	public static void registerRender(Item item)
	{	
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
