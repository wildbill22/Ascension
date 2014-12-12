package com.thexfactor117.ascension.blocks;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.tabs.ModTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockVeconiteOre extends Block 
{
	public BlockVeconiteOre()
	{
		super(Material.iron);
		setBlockName("veconiteOre");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(ModTabs.tabAscension);
		setStepSound(soundTypeStone);
		setHardness(4.0F);
		setResistance(6.0F);
		setHarvestLevel("pickaxe", 3);
	}
}
