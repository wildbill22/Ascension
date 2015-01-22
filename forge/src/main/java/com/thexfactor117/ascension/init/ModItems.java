package com.thexfactor117.ascension.init;

import net.minecraft.item.Item;

import com.thexfactor117.ascension.help.RegisterHelper;
import com.thexfactor117.ascension.items.ItemAscension;
import com.thexfactor117.ascension.items.ItemAscensionFood;
import com.thexfactor117.ascension.items.artifacts.ItemOmega;
import com.thexfactor117.ascension.items.miscellaneous.ItemBottleOfFlerovium;

public class ModItems 
{
	//Artifacts
	public static Item omega = new ItemOmega().setUnlocalizedName("omega");

	//Valuables
	public static Item titaniumIngot = new ItemAscension().setUnlocalizedName("titaniumIngot");
	public static Item steelIngot = new ItemAscension().setUnlocalizedName("steelIngot");
	public static Item vexalIngot = new ItemAscension().setUnlocalizedName("vexalIngot");
	public static Item infusedVexalIngot = new ItemAscension().setUnlocalizedName("infusedVexalIngot");
	public static Item iceGem = new ItemAscension().setUnlocalizedName("iceGem");
	public static Item blazeGem = new ItemAscension().setUnlocalizedName("blazeGem");
	public static Item crystal = new ItemAscension().setUnlocalizedName("crystal");
	public static Item fleroviumIngot = new ItemAscension().setUnlocalizedName("fleroviumIngot");
	
	//Food
	public static Item rawVenison = new ItemAscensionFood(3, 0.5F, true).setUnlocalizedName("rawVenison");
	public static Item cookedVenison = new ItemAscensionFood(8, 3.0F, true).setUnlocalizedName("cookedVenison");
	public static Item strawberry = new ItemAscensionFood(2, 1.0F, false).setUnlocalizedName("strawberry");
	public static Item raspberry = new ItemAscensionFood(1, 0.75F, false).setUnlocalizedName("raspberry");
	public static Item blueberry = new ItemAscensionFood(1, 0.75F, false).setUnlocalizedName("blueberry");
	
	//Mob Drops
	public static Item antlers = new ItemAscension().setUnlocalizedName("antlers");
	public static Item sharkTeeth = new ItemAscension().setUnlocalizedName("sharkTeeth");
	public static Item smallRock = new ItemAscension().setUnlocalizedName("smallRock");
	public static Item coldBlazeRod = new ItemAscension().setUnlocalizedName("coldBlazeRod");
	public static Item golemGyro = new ItemAscension().setUnlocalizedName("golemGyro");
	
	//Miscellaneous
	public static Item bottleOfFlerovium = new ItemBottleOfFlerovium().setUnlocalizedName("bottleOfFlerovium");
	public static Item meltedVexalIngot = new ItemAscension().setUnlocalizedName("meltedVexalIngot");
		
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
		RegisterHelper.registerItem(fleroviumIngot);
	
		RegisterHelper.registerItem(rawVenison);
		RegisterHelper.registerItem(cookedVenison);
		RegisterHelper.registerItem(strawberry);
		RegisterHelper.registerItem(raspberry);
		RegisterHelper.registerItem(blueberry);
	
		RegisterHelper.registerItem(antlers);
		RegisterHelper.registerItem(sharkTeeth);
		RegisterHelper.registerItem(coldBlazeRod);
		RegisterHelper.registerItem(smallRock);
		RegisterHelper.registerItem(golemGyro);
		
		RegisterHelper.registerItem(bottleOfFlerovium);
	}
}
