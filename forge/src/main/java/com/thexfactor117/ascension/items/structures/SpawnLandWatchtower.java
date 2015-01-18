package com.thexfactor117.ascension.items.structures;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.thexfactor117.ascension.items.ItemAscension;
import com.thexfactor117.ascension.structures.LandWatchtowerPart1;
import com.thexfactor117.ascension.tabs.ModTabs;

public class SpawnLandWatchtower extends ItemAscension {
	public SpawnLandWatchtower() {
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
		LandWatchtowerPart1 tower = new LandWatchtowerPart1();
		tower.generateStructure(world, random, x, y, z);
		tower.generateStructureBase(world, random, x, z, 6, 6, Blocks.cobblestone);
		
		return true;
	}

}
