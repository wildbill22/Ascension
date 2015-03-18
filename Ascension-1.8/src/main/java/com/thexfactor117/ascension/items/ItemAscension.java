package com.thexfactor117.ascension.items;

import net.minecraft.item.Item;

import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ItemAscension extends Item
{
	private final String name = this.getUnlocalizedName();
	
	public ItemAscension()
	{
		super();
		setCreativeTab(ModTabs.tabAscension);
	}
	
	public String getName()
	{
		return name;
	}
}
