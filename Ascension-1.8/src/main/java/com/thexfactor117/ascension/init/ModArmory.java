package com.thexfactor117.ascension.init;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.relauncher.Side;

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
import com.thexfactor117.ascension.items.weapons.melee.ItemBlazeSword;
import com.thexfactor117.ascension.items.weapons.melee.ItemDivineRapier;
import com.thexfactor117.ascension.items.weapons.melee.ItemEtherealBlade;
import com.thexfactor117.ascension.items.weapons.melee.ItemFleroviumSword;
import com.thexfactor117.ascension.items.weapons.melee.ItemGyroMace;
import com.thexfactor117.ascension.items.weapons.melee.ItemIceSword;
import com.thexfactor117.ascension.items.weapons.melee.ItemVoidHammer;
import com.thexfactor117.ascension.items.weapons.ranged.ItemBlizzardStaff;
import com.thexfactor117.ascension.items.weapons.ranged.ItemInfernoStaff;
import com.thexfactor117.ascension.items.weapons.ranged.ItemLightningStaff;
import com.thexfactor117.ascension.items.weapons.ranged.ItemOblivionStaff;
import com.thexfactor117.ascension.items.weapons.ranged.ItemWoodenStaff;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ModArmory 
{
	//Tool Materials
	public static Item.ToolMaterial TITANIUM = EnumHelper.addToolMaterial("TITANIUM", 2, 512, 2.0F, 2.0F, 14);
	public static Item.ToolMaterial STEEL = EnumHelper.addToolMaterial("STEEL", 3, 728, 3.0F, 2.0F, 5);
	
	//public static Item.ToolMaterial VECONITE = EnumHelper.addToolMaterial("VECONITE", 2, 512, 2.5F, 2.5F, 14);
	//public static Item.ToolMaterial MIDGARDIAN = EnumHelper.addToolMaterial("MIDGARDIAN", 3, 1028, 3.5F, 3.0F, 20);
	
	//Weapon Materials
	public static Item.ToolMaterial VEXAL = EnumHelper.addToolMaterial("VEXAL", 3, 256, 2.0F, 1.0F, 25);
	public static Item.ToolMaterial ICE = EnumHelper.addToolMaterial("ICE", 3, 192, 2.0F, 2.0F, 15);
	public static Item.ToolMaterial BLAZE = EnumHelper.addToolMaterial("BLAZE", 3, 192, 2.0F, 2.0F, 15);
	public static Item.ToolMaterial INFUSEDVEXAL = EnumHelper.addToolMaterial("INFUSEDVEXAL", 3, 728, 2.0F, 6.0F, 20);
	public static Item.ToolMaterial RAZOR = EnumHelper.addToolMaterial("RAZOR", 3, 256, 2.0F, 2.0F, 25);
	public static Item.ToolMaterial CRYSTAL = EnumHelper.addToolMaterial("CRYSTAL", 3, 512, 2.0F, 3.0F, 20);
	public static Item.ToolMaterial GYRO = EnumHelper.addToolMaterial("GYRO", 3, 192, 2.0F, 5.0F, 10);
	public static Item.ToolMaterial SHADOW = EnumHelper.addToolMaterial("SHADOW", 3, 256, 2.0F, 4.0F, 30);
	public static Item.ToolMaterial ETHEREAL = EnumHelper.addToolMaterial("ETHEREAL", 3, 192, 2.0F, 4.0F, 25);
	public static Item.ToolMaterial WINGED = EnumHelper.addToolMaterial("WINGED", 3, 256, 2.0F, 4.0F, 30);
	public static Item.ToolMaterial VOID = EnumHelper.addToolMaterial("VOID", 3, 256, 2.0F, 6.0F, 15);
	public static Item.ToolMaterial DIVINERAPIER = EnumHelper.addToolMaterial("DIVINERAPIER", 3, 256, 2.0F, 6.0F, 15);
	public static Item.ToolMaterial ALACRITY = EnumHelper.addToolMaterial("ALACRITY", 3, 984, 4.0F, 10.0F, 30);
	public static Item.ToolMaterial FLEROVIUM = EnumHelper.addToolMaterial("FLEROVIUM", 3, 728, 4.0F, 8.0F, 20);
	
	//public static Item.ToolMaterial MALICE = EnumHelper.addToolMaterial("MALICE", 3, 512, 4.0F, 5.0F, 20);
	//public static Item.ToolMaterial PESTILENCE = EnumHelper.addToolMaterial("PESTILENCE", 3, 728, 4.0F, 6.0F, 15);
	//public static Item.ToolMaterial TITANBANE = EnumHelper.addToolMaterial("TITANBANE", 3, 728, 4.0F, 8.0F, 5);
		
	//Armor Materials
	
	//TODO: Add a new param here. Supposedly texture name, which I haven't gotten to yet.
	public static ArmorMaterial ATITANIUM = EnumHelper.addArmorMaterial("ATITANIUM", "titaniumArmor", 20, new int[]{3, 7, 5, 2}, 14);
	public static ArmorMaterial ASTEEL = EnumHelper.addArmorMaterial("ASTEEL", "steelArmor", 30, new int[]{4, 8, 7, 3}, 5);
	public static ArmorMaterial AFLEROVIUM = EnumHelper.addArmorMaterial("AFLEROVIUM", "fleroviumArmor", 40, new int[]{5, 9, 8, 4}, 20);
	
	public static ArmorMaterial AGYROCHESTPLATE = EnumHelper.addArmorMaterial("AGYROCHESTPLATE", "gyroPlateArmor", 40, new int[]{3, 7, 5, 3}, 15);
	
	//static ArmorMaterial AVECONITE = EnumHelper.addArmorMaterial("AVECONITE", 28, new int[]{4, 7, 6, 3}, 18);
	//static ArmorMaterial AMIDGARDIAN = EnumHelper.addArmorMaterial("AMIDGARDIAN", 35, new int[]{5, 8, 7, 4}, 25);
	
	
	
	//Tools
	public static Item titaniumSword = new ItemAscensionSword(TITANIUM).setUnlocalizedName("titaniumSword");
	public static Item titaniumPick = new ItemAscensionPickaxe(TITANIUM).setUnlocalizedName("titaniumPick");
	public static Item titaniumShovel = new ItemAscensionShovel(TITANIUM).setUnlocalizedName("titaniumShovel");
	public static Item titaniumAxe = new ItemAscensionAxe(TITANIUM).setUnlocalizedName("titaniumAxe");
	public static Item steelSword = new ItemAscensionSword(STEEL).setUnlocalizedName("steelSword");
	public static Item steelPick = new ItemAscensionPickaxe(STEEL).setUnlocalizedName("steelPick");
	public static Item steelShovel = new ItemAscensionShovel(STEEL).setUnlocalizedName("steelShovel");
	public static Item steelAxe = new ItemAscensionAxe(STEEL).setUnlocalizedName("steelAxe");
	
	/*public static Item veconiteSword = new ItemAscensionSword(VECONITE).setUnlocalizedName("veconiteSword");
	public static Item veconitePick = new ItemAscensionPickaxe(VECONITE).setUnlocalizedName("veconitePick");
	public static Item veconiteShovel = new ItemAscensionShovel(VECONITE).setUnlocalizedName("veconiteShovel");
	public static Item veconiteAxe = new ItemAscensionAxe(VECONITE).setUnlocalizedName("veconiteAxe");
	public static Item midgardianSword = new ItemAscensionSword(MIDGARDIAN).setUnlocalizedName("midgardianSword");
	public static Item midgardianPick = new ItemAscensionPick(MIDGARDIAN).setUnlocalizedName("midgardianPick");
	public static Item midgardianShovel = new ItemAscensionShovel(MIDGARDIAN).setUnlocalizedName("midgardianShovel");
	public static Item midgardianAxe = new ItemAscensionAxe(MIDGARDIAN).setUnlocalizedName("midgardianAxe");*/
	
	//Weapons
	public static Item vexalSword = new ItemAscensionSword(VEXAL).setUnlocalizedName("vexalSword");
	public static Item iceSword = new ItemIceSword(ICE).setUnlocalizedName("iceSword");
	public static Item blazeSword = new ItemBlazeSword(BLAZE).setUnlocalizedName("blazeSword");
	public static Item infusedVexalSword = new ItemAscensionSword(INFUSEDVEXAL).setUnlocalizedName("infusedVexalSword");
	public static Item razorSword = new ItemAscensionSword(RAZOR).setUnlocalizedName("razorSword");
	public static Item crystallizedSword = new ItemAscensionSword(CRYSTAL).setUnlocalizedName("crystallizedSword");
	public static Item gyroMace = new ItemGyroMace(GYRO).setUnlocalizedName("gyroMace");
	public static Item shadowBlade = new ItemAscensionSword(SHADOW).setUnlocalizedName("shadowBlade");
	public static Item etherealBlade = new ItemEtherealBlade(ETHEREAL).setUnlocalizedName("etherealBlade");
	public static Item wingedBlade = new ItemAscensionSword(WINGED).setUnlocalizedName("wingedBlade");
	public static Item voidHammer = new ItemVoidHammer(VOID).setUnlocalizedName("voidHammer");
	public static Item divineRapier = new ItemDivineRapier(DIVINERAPIER).setUnlocalizedName("divineRapier");
	public static Item bladeOfAlacrity = new ItemAscensionSword(ALACRITY).setUnlocalizedName("bladeOfAlacrity");
	public static Item fleroviumSword = new ItemFleroviumSword(FLEROVIUM).setUnlocalizedName("fleroviumSword");
	
	/*public static Item bladeOfMalice = new ItemMaliceBlade(MALICE).setUnlocalizedName("bladeOfMalice");
	public static Item hammerOfPestilence = new ItemPestilenceHammer(PESTILENCE).setUnlocalizedName("hammerOfPestilence");
	public static Item titansBane = new ItemTitansBane(TITANSBANE).setUnlocalizedName("titansBane");*/
		
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
	
	/*public static Item veconiteHelm = new ItemFleroviumArmor(AVECONITE, 0, "veconiteHelm");
	public static Item veconitePlate = new ItemFleroviumArmor(AVECONITE, 1, "veconitePlate");
	public static Item veconitePants = new ItemFleroviumArmor(AVECONITE, 2, "veconitePants");
	public static Item veconiteBoots = new ItemFleroviumArmor(AVECONITE, 3, "veconiteBoots");
	public static Item midgardianHelm = new ItemFleroviumArmor(AMIDGARDIAN, 0, "midgardianHelm");
	public static Item midgardianPlate = new ItemFleroviumArmor(AMIDGARDIAN, 1, "midgardianPlate");
	public static Item midgardianPants = new ItemFleroviumArmor(AMIDGARDIAN, 2, "midgardianPants");
	public static Item midgardianBoots = new ItemFleroviumArmor(AMIDGARDIAN, 3, "midgardianBoots");*/
	
	//Staffs
	public static Item woodenStaff = new ItemWoodenStaff().setUnlocalizedName("woodenStaff");
	public static Item infernoStaff = new ItemInfernoStaff().setUnlocalizedName("infernoStaff");
	public static Item blizzardStaff = new ItemBlizzardStaff().setUnlocalizedName("blizzardStaff");
	public static Item lightningStaff = new ItemLightningStaff().setUnlocalizedName("lightningStaff");
	public static Item oblivionStaff = new ItemOblivionStaff().setUnlocalizedName("oblivionStaff");

	public static void registerItems()
	{
		// Tools
		RegisterHelper.registerItem(titaniumSword);
		RegisterHelper.registerItem(titaniumPick);
		RegisterHelper.registerItem(titaniumShovel);
		RegisterHelper.registerItem(titaniumAxe);
		RegisterHelper.registerItem(steelSword);
		RegisterHelper.registerItem(steelPick);
		RegisterHelper.registerItem(steelShovel);
		RegisterHelper.registerItem(steelAxe);
		
		/*RegisterHelper.registerItem(veconiteSword);
		RegisterHelper.registerItem(veconitePick);
		RegisterHelper.registerItem(veconiteShovel);
		RegisterHelper.registerItem(veconiteAxe);
		RegisterHelper.registerItem(midgardianSword);
		RegisterHelper.registerItem(midgardianPick);
		RegisterHelper.registerItem(midgardianShovel);
		RegisterHelper.registerItem(midgardianAxe);*/
		
		// Weapons
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
		
		/*RegisterHelper.registerItem(bladeOfMalice);
		RegisterHelper.registerItem(hammerOfPestilence);
		RegisterHelper.registerItem(titansBane);*/
		
		// Armor
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
		
		/*RegisterHelper.registerItem(veconiteHelm);
		RegisterHelper.registerItem(veconitePlate);
		RegisterHelper.registerItem(veconitePants);
		RegisterHelper.registerItem(veconiteBoots);
		RegisterHelper.registerItem(midgardianHelm);
		RegisterHelper.registerItem(midgardianPlate);
		RegisterHelper.registerItem(midgardianPants);
		RegisterHelper.registerItem(midgardianBoots);*/
		
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
	
	public static void renderItems(FMLInitializationEvent event)
	{
		if (event.getSide() == Side.CLIENT)
		{
			// Tools
			RegisterHelper.itemRenderer(titaniumSword);
			RegisterHelper.itemRenderer(titaniumPick);
			RegisterHelper.itemRenderer(titaniumShovel);
			RegisterHelper.itemRenderer(titaniumAxe);
			RegisterHelper.itemRenderer(steelSword);
			RegisterHelper.itemRenderer(steelPick);
			RegisterHelper.itemRenderer(steelShovel);
			RegisterHelper.itemRenderer(steelAxe);
			
			/*RegisterHelper.itemRenderer(veconiteSword);
			RegisterHelper.itemRenderer(veconitePick);
			RegisterHelper.itemRenderer(veconiteShovel);
			RegisterHelper.itemRenderer(veconiteAxe);
			RegisterHelper.itemRenderer(midgardianSword);
			RegisterHelper.itemRenderer(midgardianPick);
			RegisterHelper.itemRenderer(midgardianShovel);
			RegisterHelper.itemRenderer(midgardianAxe);*/
			
			// Weapons
			RegisterHelper.itemRenderer(vexalSword);
			RegisterHelper.itemRenderer(iceSword);
			RegisterHelper.itemRenderer(blazeSword);
			RegisterHelper.itemRenderer(infusedVexalSword);
			RegisterHelper.itemRenderer(razorSword);
			RegisterHelper.itemRenderer(crystallizedSword);
			RegisterHelper.itemRenderer(gyroMace);
			RegisterHelper.itemRenderer(shadowBlade);
			RegisterHelper.itemRenderer(etherealBlade);
			RegisterHelper.itemRenderer(wingedBlade);
			RegisterHelper.itemRenderer(voidHammer);
			RegisterHelper.itemRenderer(divineRapier);
			RegisterHelper.itemRenderer(bladeOfAlacrity);
			RegisterHelper.itemRenderer(fleroviumSword);
			
			// Armor
			RegisterHelper.itemRenderer(titaniumHelm);
			RegisterHelper.itemRenderer(titaniumPlate);
			RegisterHelper.itemRenderer(titaniumPants);
			RegisterHelper.itemRenderer(titaniumBoots);
			RegisterHelper.itemRenderer(steelHelm);
			RegisterHelper.itemRenderer(steelPlate);
			RegisterHelper.itemRenderer(steelPants);
			RegisterHelper.itemRenderer(steelBoots);
			RegisterHelper.itemRenderer(etherealHelm);
			RegisterHelper.itemRenderer(etherealPlate);
			RegisterHelper.itemRenderer(etherealPants);
			RegisterHelper.itemRenderer(etherealBoots);
			RegisterHelper.itemRenderer(fleroviumHelm);
			RegisterHelper.itemRenderer(fleroviumPlate);
			RegisterHelper.itemRenderer(fleroviumPants);
			RegisterHelper.itemRenderer(fleroviumBoots);
			
			RegisterHelper.itemRenderer(gyroPlate);
			
			// Staffs
			RegisterHelper.itemRenderer(woodenStaff);
			RegisterHelper.itemRenderer(infernoStaff);
			RegisterHelper.itemRenderer(blizzardStaff);
			RegisterHelper.itemRenderer(lightningStaff);
			RegisterHelper.itemRenderer(oblivionStaff);
		}
	}
}
