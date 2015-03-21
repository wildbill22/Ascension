package com.thexfactor117.ascension.init;

import net.minecraft.item.Item;

import com.thexfactor117.ascension.help.RegisterHelper;
import com.thexfactor117.ascension.items.ItemAscension;
import com.thexfactor117.ascension.items.ItemAscensionFood;
import com.thexfactor117.ascension.items.ItemAscensionTooltip;
import com.thexfactor117.ascension.items.ItemInvisible;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ModItems 
{
	//Artifacts
	public static Item omega = new ItemAscensionTooltip().setUnlocalizedName("omega");

	//Valuables
	public static Item ingotTitanium = new ItemAscensionTooltip().setUnlocalizedName("ingotTitanium");
	public static Item ingotSteel = new ItemAscensionTooltip().setUnlocalizedName("ingotSteel");
	public static Item ingotVexal = new ItemAscensionTooltip().setUnlocalizedName("ingotVexal");
	public static Item ingotInfusedVexal = new ItemAscensionTooltip().setUnlocalizedName("ingotInfusedVexal");
	public static Item gemIceGem = new ItemAscensionTooltip().setUnlocalizedName("gemIceGem");
	public static Item gemBlazeGem = new ItemAscensionTooltip().setUnlocalizedName("gemBlazeGem");
	public static Item gemCrystal = new ItemAscensionTooltip().setUnlocalizedName("gemCrystal");
	public static Item gemCrystalShard = new ItemAscensionTooltip().setUnlocalizedName("gemCrystalShard");
	public static Item ingotFlerovium = new ItemAscensionTooltip().setUnlocalizedName("ingotFlerovium");
	public static Item gemFleroviumShard = new ItemAscensionTooltip().setUnlocalizedName("gemFleroviumShard");
	
	//public static Item ingotVeconite = new ItemVeconite().setUnlocalizedName("ingotVeconite");
	//public static Item gemMidgardian = new ItemMidgardian().setUnlocalizedName("gemMidgardian");
	
	//Food
	public static Item rawVenison = new ItemAscensionFood(3, 0.5F, true).setUnlocalizedName("rawVenison");
	public static Item cookedVenison = new ItemAscensionFood(8, 3.0F, true).setUnlocalizedName("cookedVenison");
	
	//Mob Drops
	public static Item antlers = new ItemAscension().setUnlocalizedName("antlers");
	public static Item sharkTeeth = new ItemAscension().setUnlocalizedName("sharkTeeth");
	public static Item coldBlazeRod = new ItemAscension().setUnlocalizedName("coldBlazeRod");
	public static Item golemGyro = new ItemAscension().setUnlocalizedName("golemGyro");
	
	//Magical Items
	public static Item soulFragment = new ItemAscension().setUnlocalizedName("soulFragment");
	public static Item soulGem = new ItemAscension().setUnlocalizedName("soulGem");
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
		
		//RegisterHelper.registerItem(ingotVeconite);
		//RegisterHelper.registerItem(gemMidgardian);
		
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
