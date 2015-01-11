package com.thexfactor117.ascension.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModWeaponRecipes 
{
	public static void init()
	{
		// Overworld
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.titaniumSword), new Object[] {" A ", " A ", " B ", 'A', ModItems.titaniumIngot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.titaniumPick), new Object[] {"AAA", " B ", " B ", 'A', ModItems.titaniumIngot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.titaniumShovel), new Object[] {" A ", " B ", " B ", 'A', ModItems.titaniumIngot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.titaniumAxe), new Object[] {"AA ", "AB ", " B ", 'A', ModItems.titaniumIngot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.steelSword), new Object[] {" A ", " A ", " B ", 'A', ModItems.steelIngot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.steelPick), new Object[] {"AAA", " B ", " B ", 'A', ModItems.steelIngot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.steelShovel), new Object[] {" A ", " B ", " B ", 'A', ModItems.steelIngot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.steelAxe), new Object[] {"AA ", "AB ", " B ", 'A', ModItems.steelIngot, 'B', Items.stick});
		
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.vexalSword), new Object[] {" A ", " A ", " B ", 'A', ModItems.vexalIngot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.blazeSword), new Object[] {" A ", " A ", " B ", 'A', ModItems.blazeGem, 'B', Items.blaze_rod});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.iceSword), new Object[] {" A ", " A ", " B ", 'A', ModItems.iceGem, 'B', ModItems.coldBlazeRod});
	}
}
