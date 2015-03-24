package com.thexfactor117.ascension.crafting;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ModArmorRecipes 
{
	public static void init()
	{
		// Overworld
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.titanium_helmet), new Object[] {"AAA", "A A", 'A', ModItems.titanium_ingot});
    	GameRegistry.addShapedRecipe(new ItemStack(ModArmory.titanium_chestplate), new Object[] {"A A", "AAA", "AAA", 'A', ModItems.titanium_ingot});
    	GameRegistry.addShapedRecipe(new ItemStack(ModArmory.titanium_leggings), new Object[] {"AAA", "A A", "A A", 'A', ModItems.titanium_ingot});
    	GameRegistry.addShapedRecipe(new ItemStack(ModArmory.titanium_boots), new Object[] {"A A", "A A", 'A', ModItems.titanium_ingot});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.steel_helmet), new Object[] {"AAA", "A A", 'A', ModItems.steel_ingot});
    	GameRegistry.addShapedRecipe(new ItemStack(ModArmory.steel_chestplate), new Object[] {"A A", "AAA", "AAA", 'A', ModItems.steel_ingot});
    	GameRegistry.addShapedRecipe(new ItemStack(ModArmory.steel_leggings), new Object[] {"AAA", "A A", "A A", 'A', ModItems.steel_ingot});
    	GameRegistry.addShapedRecipe(new ItemStack(ModArmory.steel_boots), new Object[] {"A A", "A A", 'A', ModItems.steel_ingot});
		GameRegistry.addShapedRecipe(new ItemStack(ModArmory.flerovium_helmet), new Object[] {"AAA", "A A", 'A', ModItems.flerovium_ingot});
    	GameRegistry.addShapedRecipe(new ItemStack(ModArmory.flerovium_chestplate), new Object[] {"A A", "AAA", "AAA", 'A', ModItems.flerovium_ingot});
    	GameRegistry.addShapedRecipe(new ItemStack(ModArmory.flerovium_leggings), new Object[] {"AAA", "A A", "A A", 'A', ModItems.flerovium_ingot});
    	GameRegistry.addShapedRecipe(new ItemStack(ModArmory.flerovium_boots), new Object[] {"A A", "A A", 'A', ModItems.flerovium_ingot});
	
    	GameRegistry.addShapedRecipe(new ItemStack(ModArmory.gyro_chestplate), new Object[] {"A A", "AAA", "AAA", 'A', ModItems.golem_gyro});
	}
}
