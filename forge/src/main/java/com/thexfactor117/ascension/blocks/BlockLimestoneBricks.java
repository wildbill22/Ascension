package com.thexfactor117.ascension.blocks;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class BlockLimestoneBricks extends Block
{
	public BlockLimestoneBricks()
	{
		super(Material.iron);
		setBlockName("limestoneBricks");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(ModTabs.tabAscension);
		setStepSound(soundTypeStone);
		setHardness(1.5F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 1);
	}
}
