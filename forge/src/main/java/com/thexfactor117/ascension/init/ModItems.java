package com.thexfactor117.ascension.init;

import net.minecraft.item.Item;

import com.thexfactor117.ascension.help.RegisterHelper;
import com.thexfactor117.ascension.items.ItemAscension;
import com.thexfactor117.ascension.items.ItemAscensionFood;

public class ModItems 
{
	//Artifacts
	public static Item omega = new ItemAscension().setUnlocalizedName("omega");

	//Valuables
	public static Item titaniumIngot = new ItemAscension().setUnlocalizedName("titaniumIngot");
	public static Item steelIngot = new ItemAscension().setUnlocalizedName("steelIngot");
	public static Item vexalIngot = new ItemAscension().setUnlocalizedName("vexalIngot");
	public static Item iceGem = new ItemAscension().setUnlocalizedName("iceGem");
	public static Item blazeGem = new ItemAscension().setUnlocalizedName("blazeGem");
	
	//Food
	public static Item rawVenison = new ItemAscensionFood(3, 0.5F, true).setUnlocalizedName("rawVenison");
	public static Item cookedVenison = new ItemAscensionFood(8, 3.0F, true).setUnlocalizedName("cookedVenison");
	
	//Miscellaneous
	public static Item antlers = new ItemAscension().setUnlocalizedName("antlers");
	public static Item sharkTeeth = new ItemAscension().setUnlocalizedName("sharkTeeth");
	public static Item smallRock = new ItemAscension().setUnlocalizedName("smallRock");
	public static Item coldBlazeRod = new ItemAscension().setUnlocalizedName("coldBlazeRod");
		
	public static void init()
	{
		RegisterHelper.registerItem(omega);
	
		RegisterHelper.registerItem(titaniumIngot);
		RegisterHelper.registerItem(steelIngot);
		RegisterHelper.registerItem(vexalIngot);
		RegisterHelper.registerItem(blazeGem);
		RegisterHelper.registerItem(iceGem);
	
		RegisterHelper.registerItem(rawVenison);
		RegisterHelper.registerItem(cookedVenison);
	
<<<<<<< HEAD
		RegisterHelper.registerItem(antlers);
		RegisterHelper.registerItem(sharkTeeth);
		RegisterHelper.registerItem(coldBlazeRod);
		RegisterHelper.registerItem(smallRock);
	
		RegisterHelper.registerItem(spawnAbandonedHouse);
=======
	RegisterHelper.registerItem(antlers);
	RegisterHelper.registerItem(sharkTeeth);
	RegisterHelper.registerItem(coldBlazeRod);
	RegisterHelper.registerItem(smallRock);
>>>>>>> wildbill22-master
	}
}
