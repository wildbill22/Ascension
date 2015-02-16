package com.thexfactor117.ascension.items.weapons;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.thexfactor117.ascension.entities.projectiles.EntityMagicBall;
import com.thexfactor117.ascension.help.LogHelper;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWoodenStaff extends Item
{
	private int fireTick;
	private int fireTickMax;
	
	public ItemWoodenStaff()
	{
		super();
		this.setCreativeTab(ModTabs.tabAscensionTest);
		this.maxStackSize = 1;
		this.setMaxDamage(96);
		this.setNoRepair();
		this.fireTickMax = 2;
		this.fireTick = this.fireTickMax;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
	
	/**
	 * Fire tick stuff is experimental. I may just do a charge up like bows
	 * instead.
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{		
		if(!world.isRemote)
		{
			if (this.fireTick == this.fireTickMax && this.fireTickMax != 0)
			{
				stack.damageItem(1, player);
				world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				
				Vec3 look = player.getLookVec();	
				EntityMagicBall magic = new EntityMagicBall(world, player);	
				magic.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);	
				world.spawnEntityInWorld(magic);
				
				this.fireTick = 0;
			} 
			else
			{
				++this.fireTick;
			}
			
			if (this.fireTickMax == 0)
			{
				stack.damageItem(1, player);
				world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				
				Vec3 look = player.getLookVec();	
				EntityMagicBall magic = new EntityMagicBall(world, player);	
				magic.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);	
				world.spawnEntityInWorld(magic);
			}
		} 	
		return stack;
	}
}
