package com.thexfactor117.ascension.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.world.World;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockFieryNetherrack extends Block
{
	public BlockFieryNetherrack()
	{
		super(Material.grass);
		setBlockName("fieryNetherrack");
		setBlockTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(ModTabs.tabAscension);
		setStepSound(soundTypeGlass);
		setHardness(4.0F);
		setResistance(6.0F);
		setHarvestLevel("shovel", 1);
	}
	
	/**
	 * Sets the player on fire when walked upon.
	 */
	@Override
    public void onEntityWalking(World world, int x, int y, int z, Entity entity)
    {
		if (!world.isRemote)
		{
			if (!(entity instanceof EntityItem)) entity.setFire(5);
		}
    }
}
