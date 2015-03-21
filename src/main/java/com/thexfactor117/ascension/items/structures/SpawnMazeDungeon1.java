package com.thexfactor117.ascension.items.structures;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.thexfactor117.ascension.items.ItemAscensionTooltip;
import com.thexfactor117.ascension.structures.MazeDungeon_000;
import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author WILLIAM
 *
 */
public class SpawnMazeDungeon1 extends ItemAscensionTooltip {

	public SpawnMazeDungeon1() {
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
		MazeDungeon_000 mazeDungeon = new MazeDungeon_000();
		mazeDungeon.generate(world, random, x, y, z);
		mazeDungeon.generateStructureBase(world, random, x, z, 24, 24, Blocks.dirt);
		
		return true;
	}
}
