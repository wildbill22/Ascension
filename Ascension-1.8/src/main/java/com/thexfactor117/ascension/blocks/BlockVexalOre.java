package com.thexfactor117.ascension.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModItems;
import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class BlockVexalOre extends Block
{
	private static final String name = "vexalOre";
	
	public BlockVexalOre()
	{
		super(Material.iron);
		setUnlocalizedName(Reference.MODID + ":" + name);
		setCreativeTab(ModTabs.tabAscension);
		setStepSound(soundTypeStone);
		setHardness(3.0F);
		setResistance(5.0F);
		setHarvestLevel("pickaxe", 2);
	}
	
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune)
	{
		return ModItems.ingotVexal;
	}
	
	public String getName()
	{
		return name;
	}
}
