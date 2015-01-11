package com.thexfactor117.ascension.items.structures;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.thexfactor117.ascension.items.ItemAscension;
import com.thexfactor117.ascension.structures.SkyrimStyleHouse0;
import com.thexfactor117.ascension.tabs.ModTabs;

public class SpawnSkyrimStyleHouse extends ItemAscension {
	public SpawnSkyrimStyleHouse() 
	{
		super();
		this.setCreativeTab(ModTabs.tabAscensionTest);
	}
	
	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{	
		// TODO: adjust x & z so house doesn't spawn on player
		x += 1;
		y += 1;
		z += 1;
		
		Random random = new Random();
		new SkyrimStyleHouse0().generateStructure(world, random, x, y, z);
		
		return true;
	}
}
