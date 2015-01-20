package com.thexfactor117.ascension.items.weapons;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.thexfactor117.ascension.entities.projectile.EntityInferno;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemInfernoStaff extends Item
{
	public ItemInfernoStaff()
	{
		super();
		setCreativeTab(ModTabs.tabAscension);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer)
	{
		if(par3EntityPlayer.capabilities.isCreativeMode) 
		{
			//DEBUG
			System.out.println("RightClick is working");
			
			par2World.playSoundAtEntity(par3EntityPlayer, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			if (!par2World.isRemote)
		    {
		        par2World.spawnEntityInWorld(new EntityInferno(par2World, par3EntityPlayer));
		    }
		}	            
	    return par1ItemStack;
	}
}
