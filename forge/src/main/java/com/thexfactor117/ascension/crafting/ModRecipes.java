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
		GameRegistry.addSmelting(ModItems.vexalIngot, new ItemStack(ModItems.meltedVexalIngot), 0.1F);
		
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.iceGem), new Object[] {"ABA", "BCB", "ABA", 'A', ModItems.coldBlazeRod, 'B', Items.snowball, 'C', Items.diamond});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.blazeGem), new Object[] {"ABA", "BCB", "ABA", 'A', Items.blaze_rod, 'B', Items.flint, 'C', Items.diamond});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.coldBlazeRod), new Object[] {"AAA", "ABA", "AAA", 'A', Items.snowball, 'B', Items.blaze_rod});
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.fleroviumIngot), new Object[] {" A ", "ABA", " A ", 'A', ModItems.bottleOfFlerovium, 'B', ModItems.titaniumIngot});
		
		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.cobblestone, 4), new Object[] {new ItemStack(ModItems.smallRock), ModItems.smallRock, ModItems.smallRock, ModItems.smallRock});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.steelIngot), new Object[] {new ItemStack(ModItems.titaniumIngot), Items.iron_ingot});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.infusedVexalIngot), new Object[] {new ItemStack(ModItems.vexalIngot), ModItems.crystal, ModItems.bottleOfFlerovium});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.crystal), new Object[] {new ItemStack(ModItems.meltedVexalIngot), Items.diamond});
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.bottleOfFlerovium), new Object[] {new ItemStack(ModItems.crystal), ModItems.vexalIngot, Items.water_bucket, Items.glass_bottle, Items.redstone});
	}
}
