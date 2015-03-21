package com.thexfactor117.ascension.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class BlockLimestoneBricks extends Block
{
	private static final String name = "limestoneBricks";
	
	public BlockLimestoneBricks()
	{
		super(Material.iron);
		setUnlocalizedName(name);
		setCreativeTab(ModTabs.tabAscension);
		setStepSound(soundTypeStone);
		setHardness(1.5F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 1);
	}
	
	public String getName()
	{
		return name;
	}
}
