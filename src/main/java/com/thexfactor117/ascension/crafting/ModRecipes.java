package com.thexfactor117.ascension.crafting;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.thexfactor117.ascension.init.ModBlocks;
import com.thexfactor117.ascension.init.ModItems;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ModRecipes 
{
	public static void init()
	{		
		// Overworld
		GameRegistry.addSmelting(ModBlocks.titanium_ore, new ItemStack(ModItems.titanium_ingot), 0.8F);
		GameRegistry.addSmelting(ModItems.raw_venison, new ItemStack(ModItems.cooked_venison), 0.3F);
		GameRegistry.addSmelting(ModBlocks.flerovium_ore, new ItemStack(ModItems.flerovium_ingot), 0.8F);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ice_gem), new Object[] {"ABA", "BCB", "ABA", 'A', ModItems.cold_blaze_rod, 'B', Items.snowball, 'C', Items.diamond});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.blaze_gem), new Object[] {"ABA", "BCB", "ABA", 'A', Items.blaze_rod, 'B', Items.flint, 'C', Items.diamond});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.cold_blaze_rod), new Object[] {"AAA", "ABA", "AAA", 'A', Items.snowball, 'B', Items.blaze_rod});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.crystal), new Object[] {"AAA", "AAA", "AAA", 'A', ModItems.crystal_shard});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.flerovium_ingot), new Object[] {"AAA", "AAA", "AAA", 'A', ModItems.flerovium_shard});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.soul_gem), new Object[] {"AAA", "AAA", "AAA", 'A', ModItems.soul_fragment});
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.limestone_bricks), new Object[] {"AA", "AA", 'A', ModBlocks.limestone});
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.steel_ingot), new Object[] {new ItemStack(ModItems.titanium_ingot), Items.iron_ingot, ModItems.crystal_shard});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.crystal), new Object[] {new ItemStack(ModItems.vexal_ingot), Items.diamond});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.infused_vexal_ingot), new Object[] {new ItemStack(ModItems.vexal_ingot), Items.diamond, ModItems.flerovium_shard});
	}
}
