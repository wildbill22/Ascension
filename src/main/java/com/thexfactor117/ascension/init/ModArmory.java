package com.thexfactor117.ascension.init;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.thexfactor117.ascension.help.Reference;
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
	
	public static ArmorMaterial AGYROCHESTPLATE = EnumHelper.addArmorMaterial("AGYROCHESTPLATE", "gyro_chestplateArmor", 40, new int[]{3, 7, 5, 3}, 15);
	
	//static ArmorMaterial AVECONITE = EnumHelper.addArmorMaterial("AVECONITE", 28, new int[]{4, 7, 6, 3}, 18);
	//static ArmorMaterial AMIDGARDIAN = EnumHelper.addArmorMaterial("AMIDGARDIAN", 35, new int[]{5, 8, 7, 4}, 25);
	
	
	
	//Tools
	public static Item titanium_sword = new ItemAscensionSword(TITANIUM).setUnlocalizedName("titanium_sword");
	public static Item titanium_pickaxe = new ItemAscensionPickaxe(TITANIUM).setUnlocalizedName("titanium_pickaxe");
	public static Item titanium_shovel = new ItemAscensionShovel(TITANIUM).setUnlocalizedName("titanium_shovel");
	public static Item titanium_axe = new ItemAscensionAxe(TITANIUM).setUnlocalizedName("titanium_axe");
	public static Item steel_sword = new ItemAscensionSword(STEEL).setUnlocalizedName("steel_sword");
	public static Item steel_pickaxe = new ItemAscensionPickaxe(STEEL).setUnlocalizedName("steel_pickaxe");
	public static Item steel_shovel = new ItemAscensionShovel(STEEL).setUnlocalizedName("steel_shovel");
	public static Item steel_axe = new ItemAscensionAxe(STEEL).setUnlocalizedName("steel_axe");
	
	/*public static Item veconiteSword = new ItemAscensionSword(VECONITE).setUnlocalizedName("veconiteSword");
	public static Item veconitePick = new ItemAscensionPickaxe(VECONITE).setUnlocalizedName("veconitePick");
	public static Item veconiteShovel = new ItemAscensionShovel(VECONITE).setUnlocalizedName("veconiteShovel");
	public static Item veconiteAxe = new ItemAscensionAxe(VECONITE).setUnlocalizedName("veconiteAxe");
	public static Item midgardianSword = new ItemAscensionSword(MIDGARDIAN).setUnlocalizedName("midgardianSword");
	public static Item midgardianPick = new ItemAscensionPick(MIDGARDIAN).setUnlocalizedName("midgardianPick");
	public static Item midgardianShovel = new ItemAscensionShovel(MIDGARDIAN).setUnlocalizedName("midgardianShovel");
	public static Item midgardianAxe = new ItemAscensionAxe(MIDGARDIAN).setUnlocalizedName("midgardianAxe");*/
	
	//Weapons
	public static Item vexal_sword = new ItemAscensionSword(VEXAL).setUnlocalizedName("vexal_sword");
	public static Item ice_sword = new ItemIceSword(ICE).setUnlocalizedName("ice_sword");
	public static Item blaze_sword = new ItemBlazeSword(BLAZE).setUnlocalizedName("blaze_sword");
	public static Item infused_vexal_sword = new ItemAscensionSword(INFUSEDVEXAL).setUnlocalizedName("infused_vexal_sword");
	public static Item razor_sword = new ItemAscensionSword(RAZOR).setUnlocalizedName("razor_sword");
	public static Item crystallized_sword = new ItemAscensionSword(CRYSTAL).setUnlocalizedName("crystallized_sword");
	public static Item gyro_mace = new ItemGyroMace(GYRO).setUnlocalizedName("gyro_mace");
	public static Item shadow_blade = new ItemAscensionSword(SHADOW).setUnlocalizedName("shadow_blade");
	public static Item ethereal_blade = new ItemEtherealBlade(ETHEREAL).setUnlocalizedName("ethereal_blade");
	public static Item winged_blade = new ItemAscensionSword(WINGED).setUnlocalizedName("winged_blade");
	public static Item void_hammer = new ItemVoidHammer(VOID).setUnlocalizedName("void_hammer");
	public static Item divine_rapier = new ItemDivineRapier(DIVINERAPIER).setUnlocalizedName("divine_rapier");
	public static Item blade_of_alacrity = new ItemAscensionSword(ALACRITY).setUnlocalizedName("blade_of_alacrity");
	public static Item flerovium_sword = new ItemFleroviumSword(FLEROVIUM).setUnlocalizedName("flerovium_sword");
	
	/*public static Item bladeOfMalice = new ItemMaliceBlade(MALICE).setUnlocalizedName("bladeOfMalice");
	public static Item hammerOfPestilence = new ItemPestilenceHammer(PESTILENCE).setUnlocalizedName("hammerOfPestilence");
	public static Item titansBane = new ItemTitansBane(TITANSBANE).setUnlocalizedName("titansBane");*/
		
	//Armor
	public static Item titanium_helmet = new ItemTitaniumArmor(ATITANIUM, 0, "titanium_helmet");
	public static Item titanium_chestplate = new ItemTitaniumArmor(ATITANIUM, 1, "titanium_chestplate");
	public static Item titanium_leggings = new ItemTitaniumArmor(ATITANIUM, 2, "titanium_leggings");
	public static Item titanium_boots = new ItemTitaniumArmor(ATITANIUM, 3, "titanium_boots");
	public static Item steel_helmet = new ItemSteelArmor(ASTEEL, 0, "steel_helmet");
	public static Item steel_chestplate = new ItemSteelArmor(ASTEEL, 1, "steel_chestplate");
	public static Item steel_leggings = new ItemSteelArmor(ASTEEL, 2, "steel_leggings");
	public static Item steel_boots = new ItemSteelArmor(ASTEEL, 3, "steel_boots");
	public static Item ethereal_helmet = new ItemEtherealArmor(AFLEROVIUM, 0, "ethereal_helmet");
	public static Item ethereal_chestplate = new ItemEtherealArmor(AFLEROVIUM, 1, "ethereal_chestplate");
	public static Item ethereal_leggings = new ItemEtherealArmor(AFLEROVIUM, 2, "ethereal_leggings");
	public static Item ethereal_boots = new ItemEtherealArmor(AFLEROVIUM, 3, "ethereal_boots");
	public static Item flerovium_helmet = new ItemFleroviumArmor(AFLEROVIUM, 0, "flerovium_helmet");
	public static Item flerovium_chestplate = new ItemFleroviumArmor(AFLEROVIUM, 1, "flerovium_chestplate");
	public static Item flerovium_leggings = new ItemFleroviumArmor(AFLEROVIUM, 2, "flerovium_leggings");
	public static Item flerovium_boots = new ItemFleroviumArmor(AFLEROVIUM, 3, "flerovium_boots");
	
	public static Item gyro_chestplate = new ItemGyroPlate(AGYROCHESTPLATE, 1, "gyro_chestplate");
	
	/*public static Item veconiteHelm = new ItemFleroviumArmor(AVECONITE, 0, "veconiteHelm");
	public static Item veconitePlate = new ItemFleroviumArmor(AVECONITE, 1, "veconitePlate");
	public static Item veconitePants = new ItemFleroviumArmor(AVECONITE, 2, "veconitePants");
	public static Item veconiteBoots = new ItemFleroviumArmor(AVECONITE, 3, "veconiteBoots");
	public static Item midgardianHelm = new ItemFleroviumArmor(AMIDGARDIAN, 0, "midgardianHelm");
	public static Item midgardianPlate = new ItemFleroviumArmor(AMIDGARDIAN, 1, "midgardianPlate");
	public static Item midgardianPants = new ItemFleroviumArmor(AMIDGARDIAN, 2, "midgardianPants");
	public static Item midgardianBoots = new ItemFleroviumArmor(AMIDGARDIAN, 3, "midgardianBoots");*/
	
	//Staffs
	public static Item wooden_staff = new ItemWoodenStaff().setUnlocalizedName("wooden_staff");
	public static Item inferno_staff = new ItemInfernoStaff().setUnlocalizedName("inferno_staff");
	public static Item blizzard_staff = new ItemBlizzardStaff().setUnlocalizedName("blizzard_staff");
	public static Item lightning_staff = new ItemLightningStaff().setUnlocalizedName("lightning_staff");
	public static Item oblivion_staff = new ItemOblivionStaff().setUnlocalizedName("oblivion_staff");

	public static void registerItems()
	{
		// Tools
		RegisterHelper.registerItem(titanium_sword);
		RegisterHelper.registerItem(titanium_pickaxe);
		RegisterHelper.registerItem(titanium_shovel);
		RegisterHelper.registerItem(titanium_axe);
		RegisterHelper.registerItem(steel_sword);
		RegisterHelper.registerItem(steel_pickaxe);
		RegisterHelper.registerItem(steel_shovel);
		RegisterHelper.registerItem(steel_axe);
		
		/*RegisterHelper.registerItem(veconiteSword);
		RegisterHelper.registerItem(veconitePick);
		RegisterHelper.registerItem(veconiteShovel);
		RegisterHelper.registerItem(veconiteAxe);
		RegisterHelper.registerItem(midgardianSword);
		RegisterHelper.registerItem(midgardianPick);
		RegisterHelper.registerItem(midgardianShovel);
		RegisterHelper.registerItem(midgardianAxe);*/
		
		// Weapons
		RegisterHelper.registerItem(vexal_sword);
		RegisterHelper.registerItem(ice_sword);
		RegisterHelper.registerItem(blaze_sword);
		RegisterHelper.registerItem(infused_vexal_sword);
		RegisterHelper.registerItem(razor_sword);
		RegisterHelper.registerItem(crystallized_sword);
		RegisterHelper.registerItem(gyro_mace);
		RegisterHelper.registerItem(shadow_blade);
		RegisterHelper.registerItem(ethereal_blade);
		RegisterHelper.registerItem(winged_blade);
		RegisterHelper.registerItem(void_hammer);
		RegisterHelper.registerItem(divine_rapier);
		RegisterHelper.registerItem(blade_of_alacrity);
		RegisterHelper.registerItem(flerovium_sword);
		
		/*RegisterHelper.registerItem(bladeOfMalice);
		RegisterHelper.registerItem(hammerOfPestilence);
		RegisterHelper.registerItem(titansBane);*/
		
		// Armor
		RegisterHelper.registerItem(titanium_helmet);
		RegisterHelper.registerItem(titanium_chestplate);
		RegisterHelper.registerItem(titanium_leggings);
		RegisterHelper.registerItem(titanium_boots);
		RegisterHelper.registerItem(steel_helmet);
		RegisterHelper.registerItem(steel_chestplate);
		RegisterHelper.registerItem(steel_leggings);
		RegisterHelper.registerItem(steel_boots);
		RegisterHelper.registerItem(flerovium_helmet);
		RegisterHelper.registerItem(flerovium_chestplate);
		RegisterHelper.registerItem(flerovium_leggings);
		RegisterHelper.registerItem(flerovium_boots);
		
		RegisterHelper.registerItem(gyro_chestplate);
		
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
		RegisterHelper.registerItem(wooden_staff);
		RegisterHelper.registerItem(inferno_staff);
		RegisterHelper.registerItem(blizzard_staff);
		RegisterHelper.registerItem(lightning_staff);
		RegisterHelper.registerItem(oblivion_staff);
	}
	
	public static void registerRenders()
	{
		registerRender(titanium_sword);
		registerRender(titanium_pickaxe);
		registerRender(titanium_shovel);
		registerRender(titanium_axe);
		registerRender(steel_sword);
		registerRender(steel_pickaxe);
		registerRender(steel_shovel);
		registerRender(steel_axe);
		
		registerRender(vexal_sword);
		registerRender(ice_sword);
		registerRender(blaze_sword);
		registerRender(infused_vexal_sword);
		registerRender(crystallized_sword);
		registerRender(razor_sword);
		registerRender(gyro_mace);
		registerRender(shadow_blade);
		registerRender(ethereal_blade);
		registerRender(winged_blade);
		registerRender(void_hammer);
		registerRender(divine_rapier);
		registerRender(blade_of_alacrity);
		registerRender(flerovium_sword);
		
		registerRender(titanium_helmet);
		registerRender(titanium_chestplate);
		registerRender(titanium_leggings);
		registerRender(titanium_boots);
		registerRender(steel_helmet);
		registerRender(steel_chestplate);
		registerRender(steel_leggings);
		registerRender(steel_boots);
		registerRender(ethereal_helmet);
		registerRender(ethereal_chestplate);
		registerRender(ethereal_leggings);
		registerRender(ethereal_boots);
		registerRender(flerovium_helmet);
		registerRender(flerovium_chestplate);
		registerRender(flerovium_leggings);
		registerRender(flerovium_boots);
		
		registerRender(gyro_chestplate);
	
		registerRender(wooden_staff);
		registerRender(inferno_staff);
		registerRender(blizzard_staff);
		registerRender(lightning_staff);
		registerRender(oblivion_staff);
	}
	
	public static void registerRender(Item item)
	{	
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		
		renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
