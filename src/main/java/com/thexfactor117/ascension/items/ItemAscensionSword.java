package com.thexfactor117.ascension.items;

import net.minecraft.item.ItemSword;

import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ItemAscensionSword extends ItemSword
{
	public final ToolMaterial toolMaterial;
	
	public ItemAscensionSword(ToolMaterial EnumToolMaterial)
	{
		super(EnumToolMaterial);
		toolMaterial = EnumToolMaterial;
		setCreativeTab(ModTabs.tabAscension);
	}
}
