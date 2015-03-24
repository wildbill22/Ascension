package com.thexfactor117.ascension.init;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

import com.thexfactor117.ascension.blocks.BlockFleroviumOre;
import com.thexfactor117.ascension.blocks.BlockLimestone;
import com.thexfactor117.ascension.blocks.BlockLimestoneBricks;
import com.thexfactor117.ascension.blocks.BlockTitaniumOre;
import com.thexfactor117.ascension.blocks.BlockVexalOre;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.help.RegisterHelper;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ModBlocks 
{
	public static Block titanium_ore = new BlockTitaniumOre().setUnlocalizedName("titanium_ore");
	public static Block vexal_ore = new BlockVexalOre().setUnlocalizedName("vexal_ore");
	public static Block flerovium_ore = new BlockFleroviumOre().setUnlocalizedName("flerovium_ore");
	public static Block limestone = new BlockLimestone().setUnlocalizedName("limestone");
	public static Block limestone_bricks = new BlockLimestoneBricks().setUnlocalizedName("limestone_bricks");
	
	public static void registerBlocks()
	{		
		RegisterHelper.registerBlock(titanium_ore);
		RegisterHelper.registerBlock(vexal_ore);
		RegisterHelper.registerBlock(flerovium_ore);
		RegisterHelper.registerBlock(limestone);
		RegisterHelper.registerBlock(limestone_bricks);
	}
	
	public static void registerRenders()
	{
		registerRender(titanium_ore);
		registerRender(vexal_ore);
		registerRender(flerovium_ore);
		registerRender(limestone);
		registerRender(limestone_bricks);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
