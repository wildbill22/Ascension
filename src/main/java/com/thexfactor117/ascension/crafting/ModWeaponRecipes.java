package com.thexfactor117.ascension.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ModWeaponRecipes 
{
	public static void init()
	{
		// Overworld
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.titanium_sword), new Object[] {" A ", " A ", " B ", 'A', ModItems.titanium_ingot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.titanium_pickaxe), new Object[] {"AAA", " B ", " B ", 'A', ModItems.titanium_ingot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.titanium_shovel), new Object[] {" A ", " B ", " B ", 'A', ModItems.titanium_ingot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.titanium_axe), new Object[] {"AA ", "AB ", " B ", 'A', ModItems.titanium_ingot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.steel_sword), new Object[] {" A ", " A ", " B ", 'A', ModItems.steel_ingot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.steel_pickaxe), new Object[] {"AAA", " B ", " B ", 'A', ModItems.steel_ingot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.steel_shovel), new Object[] {" A ", " B ", " B ", 'A', ModItems.steel_ingot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.steel_axe), new Object[] {"AA ", "AB ", " B ", 'A', ModItems.steel_ingot, 'B', Items.stick});
		
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.vexal_sword), new Object[] {" A ", " A ", " B ", 'A', ModItems.vexal_ingot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.blaze_sword), new Object[] {" A ", " A ", " B ", 'A', ModItems.blaze_gem, 'B', Items.blaze_rod});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.ice_sword), new Object[] {" A ", " A ", " B ", 'A', ModItems.ice_gem, 'B', ModItems.cold_blaze_rod});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.infused_vexal_sword), new Object[] {" A ", " A ", " B ", 'A', ModItems.infused_vexal_ingot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.razor_sword), new Object[] {"AAA", "ABA", "AAA", 'A', ModItems.shark_teeth, 'B', Items.iron_sword});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.crystallized_sword), new Object[] {" A ", " A ", " B ", 'A', ModItems.crystal, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.gyro_mace), new Object[] {" A ", "ABA", " B ", 'A', ModItems.golem_gyro, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.flerovium_sword), new Object[] {" A ", " A ", " B ", 'A', ModItems.flerovium_ingot, 'B', Items.stick});
	}
}
