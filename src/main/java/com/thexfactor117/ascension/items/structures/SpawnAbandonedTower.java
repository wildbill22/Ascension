package com.thexfactor117.ascension.items.structures;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;

import com.thexfactor117.ascension.items.ItemAscension;
import com.thexfactor117.ascension.structures.AbandonedTower;
import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author WILLIAM
 *
 */
public class SpawnAbandonedTower extends ItemAscension {

	public SpawnAbandonedTower() {
		super();
		this.setCreativeTab(ModTabs.tabAscensionTest);
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{	
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		
		if (world.isRemote)
			return false;
		if (world.getBlockState(pos) == Blocks.chest)
			return false;
		
		// TODO: adjust x & z so house doesn't spawn on player
		x += 1;
		z += 1;
		
		Random random = new Random();
		AbandonedTower tower = new AbandonedTower();
		tower.generate(world, random, x, y, z);
		tower.generateStructureBase(world, random, x, z, 11, 8, Blocks.cobblestone);
		
		return true;
	}
}
