package com.thexfactor117.ascension.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.tabs.ModTabs;

public class BlockFleroviumOre extends Block 
{
	public BlockFleroviumOre() 
	{
		super(Material.iron);
		setBlockName("fleroviumOre");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(ModTabs.tabAscension);
		setStepSound(soundTypeStone);
		setHardness(2.5F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 3);
	}
}
