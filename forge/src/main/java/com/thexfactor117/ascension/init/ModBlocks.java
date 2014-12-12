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
import com.thexfactor117.ascension.blocks.BlockVeconiteOre;
import com.thexfactor117.ascension.blocks.BlockVexalOre;
import com.thexfactor117.ascension.help.RegisterHelper;

public class ModBlocks 
{
	public static Block titaniumOre = new BlockTitaniumOre();
	public static Block vexalOre = new BlockVexalOre();
	public static Block limestone = new BlockLimestone();
	public static Block limestoneBricks = new BlockLimestoneBricks();
	
	public static Block veconiteOre = new BlockVeconiteOre();
	public static Block fieryNetherrack = new BlockFieryNetherrack();
	
	public static Block endStoneBricks = new BlockEndStoneBricks();
	
	public static Block abyssStone = new BlockAbyssStone();
	public static Block abyssCobblestone = new BlockAbyssCobblestone();
	public static Block abyssStoneBricks = new BlockAbyssStoneBricks();
	public static Block ash = new BlockAsh();
	
	public static void init()
	{
		RegisterHelper.registerBlock(titaniumOre);
		RegisterHelper.registerBlock(vexalOre);
		RegisterHelper.registerBlock(limestone);
		RegisterHelper.registerBlock(limestoneBricks);
		
		RegisterHelper.registerBlock(veconiteOre);
		RegisterHelper.registerBlock(fieryNetherrack);
		
		RegisterHelper.registerBlock(endStoneBricks);
		
		RegisterHelper.registerBlock(abyssStone);
		RegisterHelper.registerBlock(abyssCobblestone);
		RegisterHelper.registerBlock(abyssStoneBricks);
		RegisterHelper.registerBlock(ash);
	}
}
