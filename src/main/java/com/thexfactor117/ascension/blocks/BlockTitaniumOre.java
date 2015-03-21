package com.thexfactor117.ascension.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class BlockTitaniumOre extends Block
{
	private static final String name = "titaniumOre";
	
	public BlockTitaniumOre()
	{
		super(Material.iron);
		setUnlocalizedName(name);
		setCreativeTab(ModTabs.tabAscension);
		setStepSound(soundTypeStone);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
	}
	
	public String getName()
	{
		return name;
	}
}
