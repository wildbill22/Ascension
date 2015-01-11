package com.thexfactor117.ascension.items.structures;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.thexfactor117.ascension.items.ItemAscension;
import com.thexfactor117.ascension.structures.StructureGenAbandonedHouse;

public class SpawnAbandonedHouse extends ItemAscension 
{
	public SpawnAbandonedHouse() 
	{
		super();
	}
	@Override
	public boolean onItemUse(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
	{	
		// TODO: adjust x & z so house doesn't spawn on player
		x += 1;
		y += 1;
		z += 1;
		
		Random random = new Random();
		new StructureGenAbandonedHouse().generateStructure(world, random, x, y, z);
		
		return true;
	}
}
