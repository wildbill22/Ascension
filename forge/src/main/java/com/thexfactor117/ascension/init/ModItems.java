package com.thexfactor117.ascension.init;

import net.minecraft.item.Item;

import com.thexfactor117.ascension.help.RegisterHelper;
import com.thexfactor117.ascension.items.ItemAscension;
import com.thexfactor117.ascension.items.ItemAscensionFood;
import com.thexfactor117.ascension.items.artifacts.ItemOmega;
import com.thexfactor117.ascension.items.miscellaneous.ItemFlerovium;
import com.thexfactor117.ascension.items.miscellaneous.ItemSteel;
import com.thexfactor117.ascension.items.miscellaneous.ItemTitanium;

public class ModItems 
{
	//Artifacts
	public static Item omega = new ItemOmega().setUnlocalizedName("omega");

	//Valuables
	public static Item titaniumIngot = new ItemTitanium().setUnlocalizedName("titaniumIngot");
	public static Item steelIngot = new ItemSteel().setUnlocalizedName("steelIngot");
	public static Item vexalIngot = new ItemAscension().setUnlocalizedName("vexalIngot");
	public static Item infusedVexalIngot = new ItemAscension().setUnlocalizedName("infusedVexalIngot");
	public static Item iceGem = new ItemAscension().setUnlocalizedName("iceGem");
	public static Item blazeGem = new ItemAscension().setUnlocalizedName("blazeGem");
	public static Item crystal = new ItemAscension().setUnlocalizedName("crystal");
	public static Item crystalShard = new ItemAscension().setUnlocalizedName("crystalShard");
	public static Item fleroviumIngot = new ItemFlerovium().setUnlocalizedName("fleroviumIngot");
	public static Item fleroviumShard = new ItemFlerovium().setUnlocalizedName("fleroviumShard");
	
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
		
	public static void init()
	{
		RegisterHelper.registerItem(omega);
	
		RegisterHelper.registerItem(titaniumIngot);
		RegisterHelper.registerItem(steelIngot);
		RegisterHelper.registerItem(vexalIngot);
		RegisterHelper.registerItem(infusedVexalIngot);
		RegisterHelper.registerItem(blazeGem);
		RegisterHelper.registerItem(iceGem);
		RegisterHelper.registerItem(crystal);
		RegisterHelper.registerItem(crystalShard);
		RegisterHelper.registerItem(fleroviumIngot);
		RegisterHelper.registerItem(fleroviumShard);
	
		RegisterHelper.registerItem(rawVenison);
		RegisterHelper.registerItem(cookedVenison);
	
		RegisterHelper.registerItem(antlers);
		RegisterHelper.registerItem(sharkTeeth);
		RegisterHelper.registerItem(coldBlazeRod);
		RegisterHelper.registerItem(golemGyro);
		
		RegisterHelper.registerItem(soulFragment);
		RegisterHelper.registerItem(soulGem);
	}
}
