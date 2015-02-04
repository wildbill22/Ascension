package com.thexfactor117.ascension.structures;

import java.util.Random;

import com.thexfactor117.ascension.help.LogHelper;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;

/**
 * 
 * @author WILLIAM
 *
 */
public class SphinxStairs extends Sphinx_000 {

	public void generate_r00(World world, Random random, int x, int y, int z) {
		LogHelper.info("Generating stairs for Sphinx at " + x + "," + y + "," + z + "!");
//		world.setBlock(x + 0, y + 2, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 2, z + 0, Blocks.sandstone, 2, 3);
		world.setBlock(x + 2, y + 2, z + 0, Blocks.sandstone, 2, 3);
		world.setBlock(x + 3, y + 2, z + 0, Blocks.sandstone, 2, 3);
		world.setBlock(x + 4, y + 2, z + 0, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 2, z + 1, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 1, y + 2, z + 1, Blocks.sandstone, 2, 3);
		world.setBlock(x + 2, y + 2, z + 1, Blocks.sandstone, 2, 3);
		world.setBlock(x + 3, y + 2, z + 1, Blocks.sandstone, 2, 3);
		world.setBlock(x + 4, y + 2, z + 1, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 0, y + 2, z + 2, Blocks.stonebrick, 2, 3);
		world.setBlock(x + 1, y + 2, z + 2, Blocks.stone_brick_stairs, 3, 3);
		world.setBlock(x + 2, y + 2, z + 2, Blocks.stone_brick_stairs, 3, 3);
		world.setBlock(x + 3, y + 2, z + 2, Blocks.stone_brick_stairs, 3, 3);
		world.setBlock(x + 4, y + 2, z + 2, Blocks.stonebrick, 1, 3);
		world.setBlock(x + 0, y + 2, z + 3, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 1, y + 2, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 2, y + 2, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 3, y + 2, z + 3, Blocks.air, 0, 3);
		world.setBlock(x + 4, y + 2, z + 3, Blocks.stonebrick, 0, 3);	
//		world.setBlock(x + 0, y + 1, z + 0, Blocks.air, 0, 3);
//		world.setBlock(x + 1, y + 1, z + 0, Blocks.air, 0, 3);
//		world.setBlock(x + 2, y + 1, z + 0, Blocks.air, 0, 3);
//		world.setBlock(x + 3, y + 1, z + 0, Blocks.air, 0, 3);
//		world.setBlock(x + 4, y + 1, z + 0, Blocks.air, 0, 3);
//		world.setBlock(x + 0, y + 1, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 1, z + 1, Blocks.sandstone, 2, 3);
		world.setBlock(x + 2, y + 1, z + 1, Blocks.sandstone, 2, 3);
		world.setBlock(x + 3, y + 1, z + 1, Blocks.sandstone, 2, 3);
		world.setBlock(x + 4, y + 1, z + 1, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 1, z + 2, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 1, y + 1, z + 2, Blocks.sandstone, 2, 3);
		world.setBlock(x + 2, y + 1, z + 2, Blocks.sandstone, 2, 3);
		world.setBlock(x + 3, y + 1, z + 2, Blocks.sandstone, 2, 3);
		world.setBlock(x + 4, y + 1, z + 2, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 0, y + 1, z + 3, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 1, y + 1, z + 3, Blocks.stone_brick_stairs, 3, 3);
		world.setBlock(x + 2, y + 1, z + 3, Blocks.stone_brick_stairs, 3, 3);
		world.setBlock(x + 3, y + 1, z + 3, Blocks.stone_brick_stairs, 3, 3);
		world.setBlock(x + 4, y + 1, z + 3, Blocks.stonebrick, 2, 3);
//		world.setBlock(x + 0, y + 0, z + 0, Blocks.air, 0, 3);
//		world.setBlock(x + 1, y + 0, z + 0, Blocks.air, 0, 3);
//		world.setBlock(x + 2, y + 0, z + 0, Blocks.air, 0, 3);
//		world.setBlock(x + 3, y + 0, z + 0, Blocks.air, 0, 3);
//		world.setBlock(x + 4, y + 0, z + 0, Blocks.air, 0, 3);
//		world.setBlock(x + 0, y + 0, z + 1, Blocks.air, 0, 3);
//		world.setBlock(x + 1, y + 0, z + 1, Blocks.air, 0, 3);
//		world.setBlock(x + 2, y + 0, z + 1, Blocks.air, 0, 3);
//		world.setBlock(x + 3, y + 0, z + 1, Blocks.air, 0, 3);
//		world.setBlock(x + 4, y + 0, z + 1, Blocks.air, 0, 3);
//		world.setBlock(x + 0, y + 0, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 1, y + 0, z + 2, Blocks.sandstone, 2, 3);
		world.setBlock(x + 2, y + 0, z + 2, Blocks.sandstone, 2, 3);
		world.setBlock(x + 3, y + 0, z + 2, Blocks.sandstone, 2, 3);
		world.setBlock(x + 4, y + 0, z + 2, Blocks.air, 0, 3);
		world.setBlock(x + 0, y + 0, z + 3, Blocks.stonebrick, 0, 3);
		world.setBlock(x + 1, y + 0, z + 3, Blocks.sandstone, 2, 3);
		world.setBlock(x + 2, y + 0, z + 3, Blocks.sandstone, 2, 3);
		world.setBlock(x + 3, y + 0, z + 3, Blocks.sandstone, 2, 3);
		world.setBlock(x + 4, y + 0, z + 3, Blocks.stonebrick, 0, 3);
	}
}
