package com.thexfactor117.ascension.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * 
 * @author TheXFactor117
 *
 */

// Invisible as in it shouldn't appear in creative tabs
public class ItemInvisible extends Item
{
	public ItemInvisible()
	{
		super();
		setCreativeTab(ModTabs.tabAscensionTest);
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void registerIcons(IIconRegister par1IconRegister)
	{
		itemIcon = par1IconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
}
