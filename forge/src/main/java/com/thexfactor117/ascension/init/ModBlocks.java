package com.thexfactor117.ascension.init;

import net.minecraft.block.Block;

import com.thexfactor117.ascension.blocks.BlockFleroviumOre;
import com.thexfactor117.ascension.blocks.BlockLimestone;
import com.thexfactor117.ascension.blocks.BlockLimestoneBricks;
import com.thexfactor117.ascension.blocks.BlockTitaniumOre;
import com.thexfactor117.ascension.blocks.BlockVexalOre;
import com.thexfactor117.ascension.help.RegisterHelper;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ModBlocks 
{
	public static Block titaniumOre = new BlockTitaniumOre();
	public static Block vexalOre = new BlockVexalOre();
	public static Block fleroviumOre = new BlockFleroviumOre();
	public static Block limestone = new BlockLimestone();
	public static Block limestoneBricks = new BlockLimestoneBricks();
	
	public static void init()
	{
		RegisterHelper.registerBlock(titaniumOre);
		RegisterHelper.registerBlock(vexalOre);
		RegisterHelper.registerBlock(fleroviumOre);
		RegisterHelper.registerBlock(limestone);
		RegisterHelper.registerBlock(limestoneBricks);
	}
}
