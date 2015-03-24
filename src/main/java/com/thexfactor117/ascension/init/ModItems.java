package com.thexfactor117.ascension.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.help.RegisterHelper;
import com.thexfactor117.ascension.items.ItemAscension;
import com.thexfactor117.ascension.items.ItemAscensionFood;
import com.thexfactor117.ascension.items.ItemInvisible;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ModItems 
{
	//Artifacts
	public static Item omega = new ItemAscension().setUnlocalizedName("omega");

	//Valuables
	public static Item titanium_ingot = new ItemAscension().setUnlocalizedName("titanium_ingot");
	public static Item steel_ingot = new ItemAscension().setUnlocalizedName("steel_ingot");
	public static Item vexal_ingot = new ItemAscension().setUnlocalizedName("vexal_ingot");
	public static Item infused_vexal_ingot = new ItemAscension().setUnlocalizedName("infused_vexal_ingot");
	public static Item ice_gem = new ItemAscension().setUnlocalizedName("ice_gem");
	public static Item blaze_gem = new ItemAscension().setUnlocalizedName("blaze_gem");
	public static Item crystal = new ItemAscension().setUnlocalizedName("crystal");
	public static Item crystal_shard = new ItemAscension().setUnlocalizedName("crystal_shard");
	public static Item flerovium_ingot = new ItemAscension().setUnlocalizedName("flerovium_ingot");
	public static Item flerovium_shard = new ItemAscension().setUnlocalizedName("flerovium_shard");
	
	//public static Item ingotVeconite = new ItemVeconite().setUnlocalizedName("ingotVeconite");
	//public static Item gemMidgardian = new ItemMidgardian().setUnlocalizedName("gemMidgardian");
	
	//Food
	public static Item raw_venison = new ItemAscensionFood(3, 0.5F, true).setUnlocalizedName("raw_venison");
	public static Item cooked_venison = new ItemAscensionFood(8, 3.0F, true).setUnlocalizedName("cooked_venison");
	
	//Mob Drops
	public static Item antlers = new ItemAscension().setUnlocalizedName("antlers");
	public static Item shark_teeth = new ItemAscension().setUnlocalizedName("shark_teeth");
	public static Item cold_blaze_rod = new ItemAscension().setUnlocalizedName("cold_blaze_rod");
	public static Item golem_gyro = new ItemAscension().setUnlocalizedName("golem_gyro");
	
	//Magical Items
	public static Item soul_fragment = new ItemAscension().setUnlocalizedName("soul_fragment");
	public static Item soul_gem = new ItemAscension().setUnlocalizedName("soul_gem");
	public static Item staffBase = new ItemAscension().setUnlocalizedName("staffBase");
	
	//Entities
	public static Item small_magic = new ItemInvisible().setUnlocalizedName("small_magic");
	public static Item medium_magic = new ItemInvisible().setUnlocalizedName("medium_magic");
	public static Item small_oblivion = new ItemInvisible().setUnlocalizedName("small_oblivion");
	public static Item medium_oblivion = new ItemInvisible().setUnlocalizedName("medium_oblivion");
	public static Item small_blizzard = new ItemInvisible().setUnlocalizedName("small_blizzard");
	public static Item medium_blizzard = new ItemInvisible().setUnlocalizedName("medium_blizzard");
	
	public static void registerItems()
	{
		RegisterHelper.registerItem(omega);
	
		RegisterHelper.registerItem(titanium_ingot);
		RegisterHelper.registerItem(steel_ingot);
		RegisterHelper.registerItem(vexal_ingot);
		RegisterHelper.registerItem(infused_vexal_ingot);
		RegisterHelper.registerItem(ice_gem);
		RegisterHelper.registerItem(blaze_gem);
		RegisterHelper.registerItem(crystal);
		RegisterHelper.registerItem(crystal_shard);
		RegisterHelper.registerItem(flerovium_ingot);
		RegisterHelper.registerItem(flerovium_shard);
		
		//RegisterHelper.registerItem(ingotVeconite);
		//RegisterHelper.registerItem(gemMidgardian);
		
		RegisterHelper.registerItem(raw_venison);
		RegisterHelper.registerItem(cooked_venison);
	
		RegisterHelper.registerItem(antlers);
		RegisterHelper.registerItem(shark_teeth);
		RegisterHelper.registerItem(cold_blaze_rod);
		RegisterHelper.registerItem(golem_gyro);
		
		RegisterHelper.registerItem(soul_fragment);
		RegisterHelper.registerItem(soul_gem);
		//RegisterHelper.registerItem(staffBase);
		
		// comment these out!
		RegisterHelper.registerItem(small_magic);
		RegisterHelper.registerItem(medium_magic);
		RegisterHelper.registerItem(small_oblivion);
		RegisterHelper.registerItem(medium_oblivion);
		RegisterHelper.registerItem(small_blizzard);
		RegisterHelper.registerItem(medium_blizzard);
	}
	
	public static void registerRenders()
	{
		registerRender(omega);
		
		registerRender(titanium_ingot);
		registerRender(vexal_ingot);
		registerRender(steel_ingot);
		registerRender(infused_vexal_ingot);
		registerRender(ice_gem);
		registerRender(blaze_gem);
		registerRender(crystal);
		registerRender(crystal_shard);
		registerRender(flerovium_ingot);
		registerRender(flerovium_shard);
		
		registerRender(raw_venison);
		registerRender(cooked_venison);
		
		registerRender(antlers);
		registerRender(shark_teeth);
		registerRender(cold_blaze_rod);
		registerRender(golem_gyro);
		
		registerRender(soul_fragment);
		registerRender(soul_gem);
		
		registerRender(small_magic);
		registerRender(medium_magic);
		registerRender(small_oblivion);
		registerRender(medium_oblivion);
		registerRender(small_blizzard);
		registerRender(medium_blizzard);
	}
	
	public static void registerRender(Item item)
	{	
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
