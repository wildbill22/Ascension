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
		// Overworld
		GameRegistry.addSmelting(ModBlocks.titaniumOre, new ItemStack(ModItems.titaniumIngot), 0.8F);
		GameRegistry.addSmelting(ModItems.rawVenison, new ItemStack(ModItems.cookedVenison), 0.3F);
		GameRegistry.addSmelting(ModBlocks.fleroviumOre, new ItemStack(ModItems.fleroviumIngot), 0.8F);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.iceGem), new Object[] {"ABA", "BCB", "ABA", 'A', ModItems.coldBlazeRod, 'B', Items.snowball, 'C', Items.diamond});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.blazeGem), new Object[] {"ABA", "BCB", "ABA", 'A', Items.blaze_rod, 'B', Items.flint, 'C', Items.diamond});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.coldBlazeRod), new Object[] {"AAA", "ABA", "AAA", 'A', Items.snowball, 'B', Items.blaze_rod});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.crystal), new Object[] {"AAA", "AAA", "AAA", 'A', ModItems.crystalShard});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.fleroviumIngot), new Object[] {"AAA", "AAA", "AAA", 'A', ModItems.fleroviumShard});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.soulGem), new Object[] {"AAA", "AAA", "AAA", 'A', ModItems.soulFragment});
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.limestoneBricks), new Object[] {"AA", "AA", 'A', ModBlocks.limestone});
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.steelIngot), new Object[] {new ItemStack(ModItems.titaniumIngot), Items.iron_ingot, ModItems.crystalShard});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.crystal), new Object[] {new ItemStack(ModItems.vexalIngot), Items.diamond});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.infusedVexalIngot), new Object[] {new ItemStack(ModItems.vexalIngot), Items.diamond, ModItems.fleroviumShard});
	}
}
