package com.thexfactor117.ascension.handlers;

import java.util.Random;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCaveSpider;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.thexfactor117.ascension.init.ModItems;

/**
 * 
 * @author TheXFactor117
 *
 */

public class DropHandler 
{	
	/**
	 * Adds Ascension drops to vanilla mobs on death.
	 */
	@SubscribeEvent
	public void entityDropItems(LivingDropsEvent event)
	{
		Random rand = new Random();
		
		if (event.entity instanceof EntityZombie)
		{
			int var = rand.nextInt(9);
			if (var == 0)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 1);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
			
			if (var == 1)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 2);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
		}
		
		if (event.entity instanceof EntitySkeleton)
		{
			int var = rand.nextInt(9);
			if (var == 0)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 1);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
			
			if (var == 1)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 2);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
		}
		
		if (event.entity instanceof EntitySpider)
		{
			int var = rand.nextInt(9);
			if (var == 0)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 1);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
			
			if (var == 1)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 2);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
		}
		
		if (event.entity instanceof EntityCreeper)
		{
			int var = rand.nextInt(9);
			if (var == 0)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 1);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
			
			if (var == 1)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 2);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
		}
		
		if (event.entity instanceof EntityEnderman)
		{
			int var = rand.nextInt(6);
			if (var == 0)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 1);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
			
			if (var == 1)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 2);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
		}
		
		if (event.entity instanceof EntityCaveSpider)
		{
			int var = rand.nextInt(8);
			if (var == 0)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 1);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
			
			if (var == 1)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 2);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
		}
		
		if (event.entity instanceof EntityBlaze)
		{
			int var = rand.nextInt(8);
			if (var == 0)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 1);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
			
			if (var == 1)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 2);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
		}
		
		if (event.entity instanceof EntityGhast)
		{
			int var = rand.nextInt(4);
			if (var == 0)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 1);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
			
			if (var == 1)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 2);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
		}
		
		if (event.entity instanceof EntityMagmaCube)
		{
			int var = rand.nextInt(5);
			if (var == 0)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 1);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
			
			if (var == 1)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 2);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
		}
		
		if (event.entity instanceof EntityPigZombie)
		{
			int var = rand.nextInt(9);
			if (var == 0)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 1);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
			
			if (var == 1)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 2);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
		}
		
		if (event.entity instanceof EntitySilverfish)
		{
			int var = rand.nextInt(8);
			if (var == 0)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 1);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
			
			if (var == 1)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 2);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
		}
		
		if (event.entity instanceof EntitySlime)
		{
			int var = rand.nextInt(7);
			if (var == 0)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 1);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
			
			if (var == 1)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 2);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
		}
		
		if (event.entity instanceof EntityWitch)
		{
			int var = rand.nextInt(8);
			if (var == 0)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 1);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
			
			if (var == 1)
			{
				ItemStack stack = new ItemStack(ModItems.soulFragment, 2);
				event.drops.add(new EntityItem(event.entity.worldObj, event.entity.posX, event.entity.posY, 
						event.entity.posZ, stack));
			}
		}
	}
}
