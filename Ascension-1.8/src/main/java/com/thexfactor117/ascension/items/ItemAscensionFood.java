package com.thexfactor117.ascension.items;

import net.minecraft.item.ItemFood;

import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ItemAscensionFood extends ItemFood
{
	private final String name = this.getUnlocalizedName();
	
	public ItemAscensionFood(int heal, float saturation, boolean wolfmeat) 
	{
		super(heal, saturation, wolfmeat);
		setCreativeTab(ModTabs.tabAscension);
	}
	
	public String getName()
	{
		return name;
	}
}
