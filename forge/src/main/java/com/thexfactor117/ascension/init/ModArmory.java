package com.thexfactor117.ascension.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.thexfactor117.ascension.help.RegisterHelper;
import com.thexfactor117.ascension.items.ItemAscensionAxe;
import com.thexfactor117.ascension.items.ItemAscensionPickaxe;
import com.thexfactor117.ascension.items.ItemAscensionShovel;
import com.thexfactor117.ascension.items.ItemAscensionSword;
import com.thexfactor117.ascension.items.armor.ItemSteelArmor;
import com.thexfactor117.ascension.items.armor.ItemTitaniumArmor;
import com.thexfactor117.ascension.items.weapons.ItemBlazeSword;
import com.thexfactor117.ascension.items.weapons.ItemIceSword;

public class ModArmory 
{
	/**
	 * Overworld
	 */
	//Tool Materials
	static Item.ToolMaterial TITANIUM = EnumHelper.addToolMaterial("TITANIUM", 2, 512, 6.0F, 2.5F, 10);
	static Item.ToolMaterial STEEL = EnumHelper.addToolMaterial("STEEL", 3, 728, 7.0F, 3.0F, 5);
	
	//Weapon Materials
	static Item.ToolMaterial VEXAL = EnumHelper.addToolMaterial("VEXAL", 3, 256, 5.0F, 2.0F, 20);
	static Item.ToolMaterial ICE = EnumHelper.addToolMaterial("ICE", 3, 192, 6.0F, 2.5F, 15);
	static Item.ToolMaterial BLAZE = EnumHelper.addToolMaterial("BLAZE", 3, 192, 6.0F, 2.5F, 15);
	static Item.ToolMaterial INFUSEDVEXAL = EnumHelper.addToolMaterial("INFUSEDVEXAL", 3, 728, 8.0F, 2.0F, 20);
	static Item.ToolMaterial RAZOR = EnumHelper.addToolMaterial("RAZOR", 3, 256, 5.0F, 2.0F, 25);
	static Item.ToolMaterial CRYSTAL = EnumHelper.addToolMaterial("CRYSTAL", 3, 512, 6.0F, 2.0F, 15);
	static Item.ToolMaterial GYRO = EnumHelper.addToolMaterial("GYRO", 3, 192, 8.0F, 2.0F, 10);
	static Item.ToolMaterial SHADOW = EnumHelper.addToolMaterial("SHADOW", 3, 256, 7.0F, 2.0F, 25);
	static Item.ToolMaterial ETHEREAL = EnumHelper.addToolMaterial("ETHEREAL", 3, 192, 7.0F, 2.0F, 25);
	static Item.ToolMaterial VOID = EnumHelper.addToolMaterial("VOID", 3, 256, 8.0F, 2.0F, 15);
	static Item.ToolMaterial DIVINERAPIER = EnumHelper.addToolMaterial("DIVINERAPIER", 3, 256, 8.0F, 2.0F, 15);
	static Item.ToolMaterial ALACRITY = EnumHelper.addToolMaterial("ALACRITY", 3, 512, 10.0F, 2.0F, 30);
	static Item.ToolMaterial FLEROVIUM = EnumHelper.addToolMaterial("FLEROVIUM", 3, 256, 9.0F, 2.0F, 20);
	
	//Armor Materials
	static ArmorMaterial ATITANIUM = EnumHelper.addArmorMaterial("ATITANIUM", 20, new int[]{2, 7, 5, 3}, 10);
	static ArmorMaterial ASTEEL = EnumHelper.addArmorMaterial("ASTEEL", 30, new int[]{4, 8, 7, 3}, 2);
	static ArmorMaterial AFLEROVIUM = EnumHelper.addArmorMaterial("AFLEROVIUM", 35, new int[]{4, 9, 8, 4}, 20);
	
	
	
	//Tools
	public static Item titaniumSword = new ItemAscensionSword(TITANIUM).setUnlocalizedName("titaniumSword");
	public static Item titaniumPick = new ItemAscensionPickaxe(TITANIUM).setUnlocalizedName("titaniumPick");
	public static Item titaniumShovel = new ItemAscensionShovel(TITANIUM).setUnlocalizedName("titaniumShovel");
	public static Item titaniumAxe = new ItemAscensionAxe(TITANIUM).setUnlocalizedName("titaniumAxe");
	public static Item steelSword = new ItemAscensionSword(STEEL).setUnlocalizedName("steelSword");
	public static Item steelPick = new ItemAscensionPickaxe(STEEL).setUnlocalizedName("steelPick");
	public static Item steelShovel = new ItemAscensionShovel(STEEL).setUnlocalizedName("steelShovel");
	public static Item steelAxe = new ItemAscensionAxe(STEEL).setUnlocalizedName("steelAxe");
	
	//Weapons
	public static Item iceSword = new ItemIceSword(ICE).setUnlocalizedName("iceSword");
	public static Item blazeSword = new ItemBlazeSword(BLAZE).setUnlocalizedName("blazeSword");
	public static Item vexalSword = new ItemAscensionSword(VEXAL).setUnlocalizedName("vexalSword");
	
	
	
	//Armor
	public static Item titaniumHelm = new ItemTitaniumArmor(ATITANIUM, 0, "titaniumHelm");
	public static Item titaniumPlate = new ItemTitaniumArmor(ATITANIUM, 1, "titaniumPlate");
	public static Item titaniumPants = new ItemTitaniumArmor(ATITANIUM, 2, "titaniumPants");
	public static Item titaniumBoots = new ItemTitaniumArmor(ATITANIUM, 3, "titaniumBoots");
	public static Item steelHelm = new ItemSteelArmor(ASTEEL, 0, "steelHelm");
	public static Item steelPlate = new ItemSteelArmor(ASTEEL, 1, "steelPlate");
	public static Item steelPants = new ItemSteelArmor(ASTEEL, 2, "steelPants");
	public static Item steelBoots = new ItemSteelArmor(ASTEEL, 3, "steelBoots");

	public static void init()
	{
		RegisterHelper.registerItem(titaniumSword);
		RegisterHelper.registerItem(titaniumPick);
		RegisterHelper.registerItem(titaniumShovel);
		RegisterHelper.registerItem(titaniumAxe);
		RegisterHelper.registerItem(steelSword);
		RegisterHelper.registerItem(steelPick);
		RegisterHelper.registerItem(steelShovel);
		RegisterHelper.registerItem(steelAxe);
		
		RegisterHelper.registerItem(iceSword);
		RegisterHelper.registerItem(blazeSword);
		RegisterHelper.registerItem(vexalSword);
		
		RegisterHelper.registerItem(titaniumHelm);
		RegisterHelper.registerItem(titaniumPlate);
		RegisterHelper.registerItem(titaniumPants);
		RegisterHelper.registerItem(titaniumBoots);
		RegisterHelper.registerItem(steelHelm);
		RegisterHelper.registerItem(steelPlate);
		RegisterHelper.registerItem(steelPants);
		RegisterHelper.registerItem(steelBoots);
	}
}
