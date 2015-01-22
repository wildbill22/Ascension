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
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.infusedVexalSword), new Object[] {" A ", " A ", " B ", 'A', ModItems.infusedVexalIngot, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.razorSword), new Object[] {"AAA", "ABA", "AAA", 'A', ModItems.sharkTeeth, 'B', Items.iron_sword});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.crystallizedSword), new Object[] {" A ", " A ", " B ", 'A', ModItems.crystal, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.gyroMace), new Object[] {" A ", "ABA", " B ", 'A', ModItems.golemGyro, 'B', Items.stick});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.fleroviumSword), new Object[] {" A ", " A ", " B ", 'A', ModItems.fleroviumIngot, 'B', Items.stick});
	}
}
