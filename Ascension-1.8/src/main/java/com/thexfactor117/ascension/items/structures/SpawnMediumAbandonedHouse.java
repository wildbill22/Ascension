package com.thexfactor117.ascension.items.structures;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.thexfactor117.ascension.items.ItemAscension;
import com.thexfactor117.ascension.structures.MediumAbandonedHouse;
import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author WILLIAM
 *
 */
public class SpawnMediumAbandonedHouse extends ItemAscension {

	public SpawnMediumAbandonedHouse() {
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
		MediumAbandonedHouse house = new MediumAbandonedHouse();
		house.generate(world, random, x, y, z);
		house.generateStructureBase(world, random, x, z, 6, 8, Blocks.cobblestone);
		
		return true;
	}
}
