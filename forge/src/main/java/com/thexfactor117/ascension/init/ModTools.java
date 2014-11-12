package com.thexfactor117.ascension.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.thexfactor117.ascension.help.RegisterHelper;
import com.thexfactor117.ascension.items.ItemOmegaAxe;
import com.thexfactor117.ascension.items.ItemOmegaPickaxe;
import com.thexfactor117.ascension.items.ItemOmegaShovel;
import com.thexfactor117.ascension.items.ItemOmegaSword;

public class ModTools 
{
	//Tool Materials
	static Item.ToolMaterial TITANIUM = EnumHelper.addToolMaterial("TITANIUM", 3, 1957, 10.0F, 4.0F, 7);
	static Item.ToolMaterial STEEL = EnumHelper.addToolMaterial("STEEL", 3, 2256, 11.0F, 4.5F, 5);
	static Item.ToolMaterial VECONITE = EnumHelper.addToolMaterial("VECONITE", 3, 768, 12.0F, 5, 13);
	
	//Weapon Materials
	static Item.ToolMaterial ICE = EnumHelper.addToolMaterial("ICE", 3, 1561, 8.0F, 3.0F, 10);
	static Item.ToolMaterial BLAZE = EnumHelper.addToolMaterial("BLAZE", 3, 1561, 8.0F, 3.0F, 10);
	static Item.ToolMaterial VEXAL = EnumHelper.addToolMaterial("VEXAL", 3, 2073, 8.0F, 2.5F, 15);
	static Item.ToolMaterial INFUSEDVECONITE = EnumHelper.addToolMaterial("INFUSEDVECONITE", 0, 1028, 10.0F, 6F, 10);
	
	//Armor Materials
	static ArmorMaterial ATITANIUM = EnumHelper.addArmorMaterial("ATITANIUM", 38, new int[]{4, 9, 7, 3}, 7);
	static ArmorMaterial ASTEEL = EnumHelper.addArmorMaterial("ASTEEL", 42, new int[]{5, 10, 8, 4}, 5);
	static ArmorMaterial AVECONITE = EnumHelper.addArmorMaterial("AVECONITE", 42, new int[]{5,  10, 8, 4}, 5);
	
	
	
	//Tools
	public static Item titaniumSword = new ItemOmegaSword(TITANIUM).setUnlocalizedName("titaniumSword");
	public static Item titaniumPick = new ItemOmegaPickaxe(TITANIUM).setUnlocalizedName("titaniumPick");
	public static Item titaniumShovel = new ItemOmegaShovel(TITANIUM).setUnlocalizedName("titaniumShovel");
	public static Item titaniumAxe = new ItemOmegaAxe(TITANIUM).setUnlocalizedName("titaniumAxe");
	public static Item steelSword = new ItemOmegaSword(STEEL).setUnlocalizedName("steelSword");
	public static Item steelPick = new ItemOmegaPickaxe(STEEL).setUnlocalizedName("steelPick");
	public static Item steelShovel = new ItemOmegaShovel(STEEL).setUnlocalizedName("steelShovel");
	public static Item steelAxe = new ItemOmegaAxe(STEEL).setUnlocalizedName("steelAxe");
	public static Item veconiteSword = new ItemOmegaSword(VECONITE).setUnlocalizedName("veconiteSword");
	public static Item veconitePick = new ItemOmegaPickaxe(VECONITE).setUnlocalizedName("veconitePick");
	public static Item veconiteShovel = new ItemOmegaShovel(VECONITE).setUnlocalizedName("veconiteShovel");
	public static Item veconiteAxe = new ItemOmegaAxe(VECONITE).setUnlocalizedName("veconiteAxe");
	
	//Weapons
	public static Item iceSword = new ItemOmegaSword(ICE).setUnlocalizedName("iceSword");
	public static Item blazeSword = new ItemOmegaSword(BLAZE).setUnlocalizedName("blazeSword");
	public static Item vexalSword = new ItemOmegaSword(VEXAL).setUnlocalizedName("vexalSword");
	public static Item infusedVeconiteSword = new ItemOmegaSword(INFUSEDVECONITE).setUnlocalizedName("infusedVeconiteSword");
	
	
	
	//Armor
	/*public static Item titaniumHelm = new ItemTitaniumArmor(ATITANIUM, 0, "titaniumHelm");
	public static Item titaniumPlate = new ItemTitaniumArmor(ATITANIUM, 1, "titaniumPlate");
	public static Item titaniumPants = new ItemTitaniumArmor(ATITANIUM, 2, "titaniumPants");
	public static Item titaniumBoots = new ItemTitaniumArmor(ATITANIUM, 3, "titaniumBoots");
	public static Item steelHelm = new ItemSteelArmor(ASTEEL, 0, "steelHelm");
	public static Item steelPlate = new ItemSteelArmor(ASTEEL, 1, "steelPlate");
	public static Item steelPants = new ItemSteelArmor(ASTEEL, 2, "steelPants");
	public static Item steelBoots = new ItemSteelArmor(ASTEEL, 3, "steelBoots");*/
	
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
		RegisterHelper.registerItem(veconiteSword);
		RegisterHelper.registerItem(veconitePick);
		RegisterHelper.registerItem(veconiteShovel);
		RegisterHelper.registerItem(veconiteAxe);
		
		RegisterHelper.registerItem(iceSword);
		RegisterHelper.registerItem(blazeSword);
		RegisterHelper.registerItem(vexalSword);
		RegisterHelper.registerItem(infusedVeconiteSword);
		
		/*RegisterHelper.registerItem(titaniumHelm);
		RegisterHelper.registerItem(titaniumPlate);
		RegisterHelper.registerItem(titaniumPants);
		RegisterHelper.registerItem(titaniumBoots);
		RegisterHelper.registerItem(steelHelm);
		RegisterHelper.registerItem(steelPlate);
		RegisterHelper.registerItem(steelPants);
		RegisterHelper.registerItem(steelBoots);*/
	}
}
