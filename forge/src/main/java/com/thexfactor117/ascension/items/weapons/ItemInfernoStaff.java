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
	
	public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int i, int j, int k, int l)
	{
		EntityInferno inferno = new EntityInferno(par3World, par2EntityPlayer, i, j, k);
		par3World.spawnEntityInWorld(inferno);

		return true;
	}
}
