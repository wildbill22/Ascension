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
		GameRegistry.addSmelting(ModBlocks.titaniumOre, new ItemStack(ModItems.ingotTitanium), 0.8F);
		GameRegistry.addSmelting(ModItems.rawVenison, new ItemStack(ModItems.cookedVenison), 0.3F);
		GameRegistry.addSmelting(ModBlocks.fleroviumOre, new ItemStack(ModItems.ingotFlerovium), 0.8F);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.gemIceGem), new Object[] {"ABA", "BCB", "ABA", 'A', ModItems.coldBlazeRod, 'B', Items.snowball, 'C', Items.diamond});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.gemBlazeGem), new Object[] {"ABA", "BCB", "ABA", 'A', Items.blaze_rod, 'B', Items.flint, 'C', Items.diamond});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.coldBlazeRod), new Object[] {"AAA", "ABA", "AAA", 'A', Items.snowball, 'B', Items.blaze_rod});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.gemCrystal), new Object[] {"AAA", "AAA", "AAA", 'A', ModItems.gemCrystalShard});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.ingotFlerovium), new Object[] {"AAA", "AAA", "AAA", 'A', ModItems.gemFleroviumShard});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.soulGem), new Object[] {"AAA", "AAA", "AAA", 'A', ModItems.soulFragment});
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.limestoneBricks), new Object[] {"AA", "AA", 'A', ModBlocks.limestone});
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotSteel), new Object[] {new ItemStack(ModItems.ingotTitanium), Items.iron_ingot, ModItems.gemCrystalShard});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.gemCrystal), new Object[] {new ItemStack(ModItems.ingotVexal), Items.diamond});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.ingotInfusedVexal), new Object[] {new ItemStack(ModItems.ingotVexal), Items.diamond, ModItems.gemFleroviumShard});
	}
}
