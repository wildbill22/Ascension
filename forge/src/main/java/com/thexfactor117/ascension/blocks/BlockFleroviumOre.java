package com.thexfactor117.ascension.blocks;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.tabs.ModTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFleroviumOre extends Block 
{
	public BlockFleroviumOre() 
	{
		super(Material.iron);
		setBlockName("fleroviumOre");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(ModTabs.tabAscension);
		setStepSound(soundTypeStone);
		setHardness(1.5F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 3);
	}

}
