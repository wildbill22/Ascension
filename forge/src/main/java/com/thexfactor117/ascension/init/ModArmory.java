package com.thexfactor117.ascension.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.thexfactor117.ascension.help.RegisterHelper;
import com.thexfactor117.ascension.items.ItemAscensionAxe;
import com.thexfactor117.ascension.items.ItemAscensionPickaxe;
import com.thexfactor117.ascension.items.ItemAscensionShovel;
import com.thexfactor117.ascension.items.ItemAscensionSword;
import com.thexfactor117.ascension.items.armor.ItemEtherealArmor;
import com.thexfactor117.ascension.items.armor.ItemFleroviumArmor;
import com.thexfactor117.ascension.items.armor.ItemGyroPlate;
import com.thexfactor117.ascension.items.armor.ItemSteelArmor;
import com.thexfactor117.ascension.items.armor.ItemTitaniumArmor;
import com.thexfactor117.ascension.items.weapons.melee.ItemBladeOfAlacrity;
import com.thexfactor117.ascension.items.weapons.melee.ItemBlazeSword;
import com.thexfactor117.ascension.items.weapons.melee.ItemCrystallizedSword;
import com.thexfactor117.ascension.items.weapons.melee.ItemDivineRapier;
import com.thexfactor117.ascension.items.weapons.melee.ItemEtherealBlade;
import com.thexfactor117.ascension.items.weapons.melee.ItemFleroviumSword;
import com.thexfactor117.ascension.items.weapons.melee.ItemGyroMace;
import com.thexfactor117.ascension.items.weapons.melee.ItemIceSword;
import com.thexfactor117.ascension.items.weapons.melee.ItemInfusedVexalSword;
import com.thexfactor117.ascension.items.weapons.melee.ItemRazorSword;
import com.thexfactor117.ascension.items.weapons.melee.ItemShadowBlade;
import com.thexfactor117.ascension.items.weapons.melee.ItemVexalSword;
import com.thexfactor117.ascension.items.weapons.melee.ItemVoidHammer;
import com.thexfactor117.ascension.items.weapons.melee.ItemWingedBlade;
import com.thexfactor117.ascension.items.weapons.ranged.ItemBlizzardStaff;
import com.thexfactor117.ascension.items.weapons.ranged.ItemInfernoStaff;
import com.thexfactor117.ascension.items.weapons.ranged.ItemLightningStaff;
import com.thexfactor117.ascension.items.weapons.ranged.ItemOblivionStaff;
import com.thexfactor117.ascension.items.weapons.ranged.ItemWoodenStaff;

public class ModArmory 
{
	//Tool Materials
	static Item.ToolMaterial TITANIUM = EnumHelper.addToolMaterial("TITANIUM", 2, 512, 2.0F, 2.0F, 14);
	static Item.ToolMaterial STEEL = EnumHelper.addToolMaterial("STEEL", 3, 728, 3.0F, 2.0F, 5);
	
	//Weapon Materials
	static Item.ToolMaterial VEXAL = EnumHelper.addToolMaterial("VEXAL", 3, 256, 2.0F, 1.0F, 25);
	static Item.ToolMaterial ICE = EnumHelper.addToolMaterial("ICE", 3, 192, 2.0F, 2.0F, 15);
	static Item.ToolMaterial BLAZE = EnumHelper.addToolMaterial("BLAZE", 3, 192, 2.0F, 2.0F, 15);
	static Item.ToolMaterial INFUSEDVEXAL = EnumHelper.addToolMaterial("INFUSEDVEXAL", 3, 728, 2.0F, 6.0F, 20);
	static Item.ToolMaterial RAZOR = EnumHelper.addToolMaterial("RAZOR", 3, 256, 2.0F, 2.0F, 25);
	static Item.ToolMaterial CRYSTAL = EnumHelper.addToolMaterial("CRYSTAL", 3, 512, 2.0F, 3.0F, 20);
	static Item.ToolMaterial GYRO = EnumHelper.addToolMaterial("GYRO", 3, 192, 2.0F, 5.0F, 10);
	static Item.ToolMaterial SHADOW = EnumHelper.addToolMaterial("SHADOW", 3, 256, 2.0F, 4.0F, 30);
	static Item.ToolMaterial ETHEREAL = EnumHelper.addToolMaterial("ETHEREAL", 3, 192, 2.0F, 4.0F, 25);
	static Item.ToolMaterial WINGED = EnumHelper.addToolMaterial("WINGED", 3, 256, 2.0F, 4.0F, 30);
	static Item.ToolMaterial VOID = EnumHelper.addToolMaterial("VOID", 3, 256, 2.0F, 6.0F, 15);
	static Item.ToolMaterial DIVINERAPIER = EnumHelper.addToolMaterial("DIVINERAPIER", 3, 256, 2.0F, 6.0F, 15);
	static Item.ToolMaterial ALACRITY = EnumHelper.addToolMaterial("ALACRITY", 3, 984, 4.0F, 10.0F, 30);
	static Item.ToolMaterial FLEROVIUM = EnumHelper.addToolMaterial("FLEROVIUM", 3, 728, 4.0F, 8.0F, 20);
		
	//Armor Materials
	static ArmorMaterial ATITANIUM = EnumHelper.addArmorMaterial("ATITANIUM", 20, new int[]{3, 7, 5, 2}, 14);
	static ArmorMaterial ASTEEL = EnumHelper.addArmorMaterial("ASTEEL", 30, new int[]{4, 8, 7, 3}, 5);
	static ArmorMaterial AFLEROVIUM = EnumHelper.addArmorMaterial("AFLEROVIUM", 38, new int[]{5, 9, 8, 4}, 20);
	
	static ArmorMaterial AGYROCHESTPLATE = EnumHelper.addArmorMaterial("AGYROCHESTPLATE", 40, new int[]{3, 7, 5, 3}, 15);
	
	
	
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
	public static Item vexalSword = new ItemVexalSword(VEXAL).setUnlocalizedName("vexalSword");
	public static Item iceSword = new ItemIceSword(ICE).setUnlocalizedName("iceSword");
	public static Item blazeSword = new ItemBlazeSword(BLAZE).setUnlocalizedName("blazeSword");
	public static Item infusedVexalSword = new ItemInfusedVexalSword(INFUSEDVEXAL).setUnlocalizedName("infusedVexalSword");
	public static Item razorSword = new ItemRazorSword(RAZOR).setUnlocalizedName("razorSword");
	public static Item crystallizedSword = new ItemCrystallizedSword(CRYSTAL).setUnlocalizedName("crystallizedSword");
	public static Item gyroMace = new ItemGyroMace(GYRO).setUnlocalizedName("gyroMace");
	public static Item shadowBlade = new ItemShadowBlade(SHADOW).setUnlocalizedName("shadowBlade");
	public static Item etherealBlade = new ItemEtherealBlade(ETHEREAL).setUnlocalizedName("etherealBlade");
	public static Item wingedBlade = new ItemWingedBlade(WINGED).setUnlocalizedName("wingedBlade");
	public static Item voidHammer = new ItemVoidHammer(VOID).setUnlocalizedName("voidHammer");
	public static Item divineRapier = new ItemDivineRapier(DIVINERAPIER).setUnlocalizedName("divineRapier");
	public static Item bladeOfAlacrity = new ItemBladeOfAlacrity(ALACRITY).setUnlocalizedName("bladeOfAlacrity");
	public static Item fleroviumSword = new ItemFleroviumSword(FLEROVIUM).setUnlocalizedName("fleroviumSword");
		
	//Armor
	public static Item titaniumHelm = new ItemTitaniumArmor(ATITANIUM, 0, "titaniumHelm");
	public static Item titaniumPlate = new ItemTitaniumArmor(ATITANIUM, 1, "titaniumPlate");
	public static Item titaniumPants = new ItemTitaniumArmor(ATITANIUM, 2, "titaniumPants");
	public static Item titaniumBoots = new ItemTitaniumArmor(ATITANIUM, 3, "titaniumBoots");
	public static Item steelHelm = new ItemSteelArmor(ASTEEL, 0, "steelHelm");
	public static Item steelPlate = new ItemSteelArmor(ASTEEL, 1, "steelPlate");
	public static Item steelPants = new ItemSteelArmor(ASTEEL, 2, "steelPants");
	public static Item steelBoots = new ItemSteelArmor(ASTEEL, 3, "steelBoots");
	public static Item etherealHelm = new ItemEtherealArmor(AFLEROVIUM, 0, "etherealHelm");
	public static Item etherealPlate = new ItemEtherealArmor(AFLEROVIUM, 1, "etherealPlate");
	public static Item etherealPants = new ItemEtherealArmor(AFLEROVIUM, 2, "etherealPants");
	public static Item etherealBoots = new ItemEtherealArmor(AFLEROVIUM, 3, "etherealBoots");
	public static Item fleroviumHelm = new ItemFleroviumArmor(AFLEROVIUM, 0, "fleroviumHelm");
	public static Item fleroviumPlate = new ItemFleroviumArmor(AFLEROVIUM, 1, "fleroviumPlate");
	public static Item fleroviumPants = new ItemFleroviumArmor(AFLEROVIUM, 2, "fleroviumPants");
	public static Item fleroviumBoots = new ItemFleroviumArmor(AFLEROVIUM, 3, "fleroviumBoots");
	
	public static Item gyroPlate = new ItemGyroPlate(AGYROCHESTPLATE, 1, "gyroPlate");
	
	//Staffs
	public static Item woodenStaff = new ItemWoodenStaff().setUnlocalizedName("woodenStaff");
	public static Item infernoStaff = new ItemInfernoStaff().setUnlocalizedName("infernoStaff");
	public static Item blizzardStaff = new ItemBlizzardStaff().setUnlocalizedName("blizzardStaff");
	public static Item lightningStaff = new ItemLightningStaff().setUnlocalizedName("lightningStaff");
	public static Item oblivionStaff = new ItemOblivionStaff().setUnlocalizedName("oblivionStaff");

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
		
		RegisterHelper.registerItem(vexalSword);
		RegisterHelper.registerItem(iceSword);
		RegisterHelper.registerItem(blazeSword);
		RegisterHelper.registerItem(infusedVexalSword);
		RegisterHelper.registerItem(razorSword);
		RegisterHelper.registerItem(crystallizedSword);
		RegisterHelper.registerItem(gyroMace);
		RegisterHelper.registerItem(shadowBlade);
		RegisterHelper.registerItem(etherealBlade);
		RegisterHelper.registerItem(wingedBlade);
		RegisterHelper.registerItem(voidHammer);
		RegisterHelper.registerItem(divineRapier);
		RegisterHelper.registerItem(bladeOfAlacrity);
		RegisterHelper.registerItem(fleroviumSword);
		
		RegisterHelper.registerItem(titaniumHelm);
		RegisterHelper.registerItem(titaniumPlate);
		RegisterHelper.registerItem(titaniumPants);
		RegisterHelper.registerItem(titaniumBoots);
		RegisterHelper.registerItem(steelHelm);
		RegisterHelper.registerItem(steelPlate);
		RegisterHelper.registerItem(steelPants);
		RegisterHelper.registerItem(steelBoots);
		RegisterHelper.registerItem(fleroviumHelm);
		RegisterHelper.registerItem(fleroviumPlate);
		RegisterHelper.registerItem(fleroviumPants);
		RegisterHelper.registerItem(fleroviumBoots);
		
		RegisterHelper.registerItem(gyroPlate);
		
		/*
		 * TEST ITEMS
		 * 
		 * These items are under testing. Certain items below this point
		 * should not be included in certain releases. COMMENT THESE OUT
		 * BEFORE RELEASES!
		 */
		// Beta 2
		RegisterHelper.registerItem(woodenStaff);
		RegisterHelper.registerItem(infernoStaff);
		RegisterHelper.registerItem(blizzardStaff);
		RegisterHelper.registerItem(lightningStaff);
		RegisterHelper.registerItem(oblivionStaff);
	}
}
