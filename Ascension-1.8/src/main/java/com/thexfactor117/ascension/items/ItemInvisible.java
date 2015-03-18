package com.thexfactor117.ascension.items;

import net.minecraft.item.Item;

import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

// Invisible as in it shouldn't appear in creative tabs
public class ItemInvisible extends Item
{
	private final String name = this.getUnlocalizedName();
	
	public ItemInvisible()
	{
		super();
		setCreativeTab(ModTabs.tabAscensionTest);
	}
	
	public String getName()
	{
		return name;
	}
}
