package com.thexfactor117.ascension.items.weapons;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.thexfactor117.ascension.entities.projectiles.EntityMagicBall;
import com.thexfactor117.ascension.help.LogHelper;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;
import com.thexfactor117.ascension.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWoodenStaff extends Item
{
	private int ticks;
	boolean inUse;
	
	public ItemWoodenStaff()
	{
		super();
		this.setCreativeTab(ModTabs.tabAscensionTest);
		this.maxStackSize = 1;
		this.setMaxDamage(96);
		this.setNoRepair();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
	
	/**
	 * Basically creates a rapid fire staff - not necessarily what
	 * is wanted. Experimental.
	 */
	public void chargeStaff(ItemStack stack, World world, EntityPlayer player, int ticksLeft)
	{
		if (player.capabilities.isCreativeMode || player.inventory.hasItem(ModItems.crystalShard))
		{
			//starts at max item use duration and is decremented each tick
			//ticksLeft is assigned in onUpdate
			int durationTotal = this.getMaxItemUseDuration(stack) - ticksLeft;
			//converts ticks to seconds
			float durationInSeconds = (float) durationTotal / 20.0F;
			//
			durationInSeconds = (durationInSeconds * durationInSeconds + durationInSeconds * 2.0F) / 3.0F;

			if (durationInSeconds < 3.0F)
			{	
				LogHelper.info("Duration in seconds is too short!");
				return;
			}
			else if (durationInSeconds >= 5.0F)
			{
				LogHelper.info("Duration in seconds has passed! Firing Entity!");
				
				EntityMagicBall magicBall = new EntityMagicBall(world, player);
	            
	            stack.damageItem(1, player);
	            world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	            player.inventory.consumeInventoryItem(ModItems.crystalShard);
	            
	            if (!world.isRemote)
	            {
	            	world.spawnEntityInWorld(magicBall);
	            }
			}
		}
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int par4)
	{
		inUse = false;
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		inUse = true;
		
		if (player.capabilities.isCreativeMode || player.inventory.hasItem(ModItems.crystalShard))
		{
			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		}
		
		return stack;
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return 80;
    }
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
		EntityPlayer player = (EntityPlayer) entity;
		
		//if (player.inventory.getCurrentItem() != null && player.inventory.hasItem(ModArmory.infernoStaff) && player.isUsingItem())
		//{
		//	  Only needed for registering icons for level of charge
		//}
		
		if (inUse == true)
		{
			chargeStaff(stack, world, player, 20);
		}
	}
}
