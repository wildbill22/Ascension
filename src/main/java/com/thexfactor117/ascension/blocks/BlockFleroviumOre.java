package com.thexfactor117.ascension.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class BlockFleroviumOre extends Block
{
	public BlockFleroviumOre() 
	{
		super(Material.iron);
		setCreativeTab(ModTabs.tabAscension);
		setStepSound(soundTypeStone);
		setHardness(2.5F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 3);
		setLightLevel(0.4F);
	}
}
