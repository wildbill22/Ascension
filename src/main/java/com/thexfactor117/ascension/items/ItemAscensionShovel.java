package com.thexfactor117.ascension.items;

import net.minecraft.item.ItemSpade;

import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ItemAscensionShovel extends ItemSpade
{
	public final ToolMaterial toolMaterial;
	
	public ItemAscensionShovel(ToolMaterial EnumToolMaterial)
	{
		super(EnumToolMaterial);
		toolMaterial = EnumToolMaterial;
		setCreativeTab(ModTabs.tabAscension);
	}
}
