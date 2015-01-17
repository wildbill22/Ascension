package com.thexfactor117.ascension.items.structures;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.thexfactor117.ascension.items.ItemAscension;
import com.thexfactor117.ascension.structures.SmallAbandonedHouse;
import com.thexfactor117.ascension.tabs.ModTabs;

public class SpawnSmallAbandonedHouse extends ItemAscension {

	public SpawnSmallAbandonedHouse() {
		super();
		this.setCreativeTab(ModTabs.tabAscensionTest);
	}

	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{	
		if (world.getBlock(x, y, z) == Blocks.chest)
			return false;
		
		// TODO: adjust x & z so house doesn't spawn on player
		x += 1;
		z += 1;
		
		Random random = new Random();
		SmallAbandonedHouse house = new SmallAbandonedHouse();
		house.generateStructure(world, random, x, y, z);
		house.generateStructureBase(world, random, x, z, 4, 5, Blocks.cobblestone);
		
		return true;
	}
}
