package com.thexfactor117.ascension.items.structures;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.thexfactor117.ascension.items.ItemAscension;
import com.thexfactor117.ascension.structures.SkyrimStyleHouse0;
import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author WILLIAM
 *
 */
public class SpawnSkyrimStyleHouse extends ItemAscension {
	public SpawnSkyrimStyleHouse() 
	{
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
		SkyrimStyleHouse0 house = new SkyrimStyleHouse0();

		// These two don't use a thread
		house.generateStructure(world, random, x, y, z);
		house.generateStructureBase(world, random, x + 3, z + 3, 12, 12, Blocks.cobblestone);
		
		return true;
	}
}
