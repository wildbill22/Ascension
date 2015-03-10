package com.thexfactor117.ascension.items.structures;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.thexfactor117.ascension.items.ItemAscension;
import com.thexfactor117.ascension.structures.Camp_000;
import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author WILLIAM
 *
 */
public class SpawnCamp extends ItemAscension {

	public SpawnCamp() {
		super();
		this.setCreativeTab(ModTabs.tabAscensionTest);
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{	
		if (world.isRemote)
			return false;
		if (world.getBlock(x, y, z) == Blocks.chest)
			return false;
		
		// TODO: adjust x & z so house doesn't spawn on player
		x += 1;
		z += 1;
		
		Random random = new Random();
		Camp_000 camp = new Camp_000();
		camp.generate(world, random, x, y, z);
		camp.generateStructureBase(world, random, x, z, 31, 31, Blocks.dirt);
		
		return true;
	}
}
