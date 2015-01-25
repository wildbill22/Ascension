package com.thexfactor117.ascension.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModItems;
import com.thexfactor117.ascension.tabs.ModTabs;

public class BlockVexalOre extends Block
{
	public BlockVexalOre()
	{
		super(Material.iron);
		setBlockName("vexalOre");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(ModTabs.tabAscension);
		setStepSound(soundTypeStone);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
	}
	
	@Override
	public Item getItemDropped(int metadata, Random random, int fortune)
	{
		return ModItems.vexalIngot;
	}
}
