package com.thexfactor117.ascension.crafting;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.thexfactor117.ascension.init.ModBlocks;
import com.thexfactor117.ascension.init.ModItems;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipes 
{
	public static void init()
	{
		ItemStack smallRockItemStack = new ItemStack(ModItems.smallRock);
		
		// Overworld
		GameRegistry.addSmelting(ModBlocks.titaniumOre, new ItemStack(ModItems.titaniumIngot), 0.8F);
		GameRegistry.addSmelting(ModBlocks.vexalOre, new ItemStack(ModItems.vexalIngot), 1.0F);
		GameRegistry.addSmelting(ModItems.rawVenison, new ItemStack(ModItems.cookedVenison), 0.3F);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.iceGem), new Object[] {"ABA", "BCB", "ABA", 'A', ModItems.coldBlazeRod, 'B', Items.snowball, 'C', Items.diamond});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.blazeGem), new Object[] {"ABA", "BCB", "ABA", 'A', Items.blaze_rod, 'B', Items.flint, 'C', Items.diamond});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 4), new Object[] {new ItemStack(ModItems.smallRock), ModItems.smallRock, ModItems.smallRock, ModItems.smallRock});
	}
}
