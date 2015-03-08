package com.thexfactor117.ascension.init;

import net.minecraft.item.Item;

import com.thexfactor117.ascension.help.RegisterHelper;
import com.thexfactor117.ascension.items.ItemAscension;
import com.thexfactor117.ascension.items.ItemAscensionFood;
import com.thexfactor117.ascension.items.ItemInvisible;
import com.thexfactor117.ascension.items.artifacts.ItemOmega;
import com.thexfactor117.ascension.items.miscellaneous.ItemBlazeGem;
import com.thexfactor117.ascension.items.miscellaneous.ItemCrystal;
import com.thexfactor117.ascension.items.miscellaneous.ItemFlerovium;
import com.thexfactor117.ascension.items.miscellaneous.ItemIceGem;
import com.thexfactor117.ascension.items.miscellaneous.ItemInfusedVexal;
import com.thexfactor117.ascension.items.miscellaneous.ItemSoulGem;
import com.thexfactor117.ascension.items.miscellaneous.ItemSteel;
import com.thexfactor117.ascension.items.miscellaneous.ItemTitanium;
import com.thexfactor117.ascension.items.miscellaneous.ItemVexal;

public class ModItems 
{
	//Artifacts
	public static Item omega = new ItemOmega().setUnlocalizedName("omega");

	//Valuables
	public static Item ingotTitanium = new ItemTitanium().setUnlocalizedName("ingotTitanium");
	public static Item ingotSteel = new ItemSteel().setUnlocalizedName("ingotSteel");
	public static Item ingotVexal = new ItemVexal().setUnlocalizedName("ingotVexal");
	public static Item ingotInfusedVexal = new ItemInfusedVexal().setUnlocalizedName("ingotInfusedVexal");
	public static Item gemIceGem = new ItemIceGem().setUnlocalizedName("gemIceGem");
	public static Item gemBlazeGem = new ItemBlazeGem().setUnlocalizedName("gemBlazeGem");
	public static Item gemCrystal = new ItemCrystal().setUnlocalizedName("gemCrystal");
	public static Item gemCrystalShard = new ItemCrystal().setUnlocalizedName("gemCrystalShard");
	public static Item ingotFlerovium = new ItemFlerovium().setUnlocalizedName("ingotFlerovium");
	public static Item gemFleroviumShard = new ItemFlerovium().setUnlocalizedName("gemFleroviumShard");
	
	//Food
	public static Item rawVenison = new ItemAscensionFood(3, 0.5F, true).setUnlocalizedName("rawVenison");
	public static Item cookedVenison = new ItemAscensionFood(8, 3.0F, true).setUnlocalizedName("cookedVenison");
	
	//Mob Drops
	public static Item antlers = new ItemAscension().setUnlocalizedName("antlers");
	public static Item sharkTeeth = new ItemAscension().setUnlocalizedName("sharkTeeth");
	public static Item coldBlazeRod = new ItemAscension().setUnlocalizedName("coldBlazeRod");
	public static Item golemGyro = new ItemAscension().setUnlocalizedName("golemGyro");
	
	//Magical Items
	public static Item soulFragment = new ItemSoulGem().setUnlocalizedName("soulFragment");
	public static Item soulGem = new ItemSoulGem().setUnlocalizedName("soulGem");
	public static Item staffBase = new ItemAscension().setUnlocalizedName("staffBase");
	
	//Entities
	public static Item smallMagic = new ItemInvisible().setUnlocalizedName("smallMagic");
	public static Item mediumMagic = new ItemInvisible().setUnlocalizedName("mediumMagic");
	public static Item smallOblivion = new ItemInvisible().setUnlocalizedName("smallOblivion");
	public static Item mediumOblivion = new ItemInvisible().setUnlocalizedName("mediumOblivion");
	public static Item smallBlizzard = new ItemInvisible().setUnlocalizedName("smallBlizzard");
	public static Item mediumBlizzard = new ItemInvisible().setUnlocalizedName("mediumBlizzard");
	
	public static void init()
	{
		RegisterHelper.registerItem(omega);
	
		RegisterHelper.registerItem(ingotTitanium);
		RegisterHelper.registerItem(ingotSteel);
		RegisterHelper.registerItem(ingotVexal);
		RegisterHelper.registerItem(ingotInfusedVexal);
		RegisterHelper.registerItem(gemIceGem);
		RegisterHelper.registerItem(gemBlazeGem);
		RegisterHelper.registerItem(gemCrystal);
		RegisterHelper.registerItem(gemCrystalShard);
		RegisterHelper.registerItem(ingotFlerovium);
		RegisterHelper.registerItem(gemFleroviumShard);
		
		RegisterHelper.registerItem(rawVenison);
		RegisterHelper.registerItem(cookedVenison);
	
		RegisterHelper.registerItem(antlers);
		RegisterHelper.registerItem(sharkTeeth);
		RegisterHelper.registerItem(coldBlazeRod);
		RegisterHelper.registerItem(golemGyro);
		
		RegisterHelper.registerItem(soulFragment);
		RegisterHelper.registerItem(soulGem);
		
		// comment these out!
		RegisterHelper.registerItem(smallMagic);
		RegisterHelper.registerItem(mediumMagic);
		RegisterHelper.registerItem(smallOblivion);
		RegisterHelper.registerItem(mediumOblivion);
		RegisterHelper.registerItem(smallBlizzard);
		RegisterHelper.registerItem(mediumBlizzard);
	}
}
