package com.thexfactor117.ascension.init;

import net.minecraft.block.Block;

import com.thexfactor117.ascension.blocks.BlockAbyssCobblestone;
import com.thexfactor117.ascension.blocks.BlockAbyssStone;
import com.thexfactor117.ascension.blocks.BlockAbyssStoneBricks;
import com.thexfactor117.ascension.blocks.BlockAsh;
import com.thexfactor117.ascension.blocks.BlockEndStoneBricks;
import com.thexfactor117.ascension.blocks.BlockFieryNetherrack;
import com.thexfactor117.ascension.blocks.BlockLimestone;
import com.thexfactor117.ascension.blocks.BlockLimestoneBricks;
import com.thexfactor117.ascension.blocks.BlockTitaniumOre;
import com.thexfactor117.ascension.blocks.BlockVexalOre;
import com.thexfactor117.ascension.help.RegisterHelper;

public class ModBlocks 
{
	public static Block titaniumOre = new BlockTitaniumOre().setBlockName("titaniumOre");
	public static Block vexalOre = new BlockVexalOre().setBlockName("vexalOre");
	public static Block limestone = new BlockLimestone().setBlockName("limestone");
	public static Block limestoneBricks = new BlockLimestoneBricks().setBlockName("limestoneBricks");
	
	public static Block fieryNetherrack = new BlockFieryNetherrack().setBlockName("fieryNetherrack");
	
	public static Block endStoneBricks = new BlockEndStoneBricks().setBlockName("endStoneBricks");
	
	public static Block abyssStone = new BlockAbyssStone().setBlockName("abyssStone");
	public static Block abyssCobblestone = new BlockAbyssCobblestone().setBlockName("abyssCobblestone");
	public static Block abyssStoneBricks = new BlockAbyssStoneBricks().setBlockName("abyssStoneBricks");
	public static Block ash = new BlockAsh().setBlockName("ash");
	
	public static void init()
	{
		RegisterHelper.registerBlock(titaniumOre);
		RegisterHelper.registerBlock(vexalOre);
		RegisterHelper.registerBlock(limestone);
		RegisterHelper.registerBlock(limestoneBricks);
		
		RegisterHelper.registerBlock(fieryNetherrack);
		
		RegisterHelper.registerBlock(endStoneBricks);
		
		RegisterHelper.registerBlock(abyssStone);
		RegisterHelper.registerBlock(abyssCobblestone);
		RegisterHelper.registerBlock(abyssStoneBricks);
		RegisterHelper.registerBlock(ash);
	}
}
