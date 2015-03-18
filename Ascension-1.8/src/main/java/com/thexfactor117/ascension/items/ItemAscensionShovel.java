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
	private final String name = this.getUnlocalizedName();
	public final ToolMaterial toolMaterial;
	
	public ItemAscensionShovel(ToolMaterial EnumToolMaterial)
	{
		super(EnumToolMaterial);
		toolMaterial = EnumToolMaterial;
		setCreativeTab(ModTabs.tabAscension);
	}
	
	public String getName()
	{
		return name;
	}
}
