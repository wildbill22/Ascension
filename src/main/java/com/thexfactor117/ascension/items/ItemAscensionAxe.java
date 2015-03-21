package com.thexfactor117.ascension.items;

import net.minecraft.item.ItemAxe;

import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ItemAscensionAxe extends ItemAxe
{
	private final String name = this.getUnlocalizedName();
	public final ToolMaterial toolMaterial;
	
	public ItemAscensionAxe(ToolMaterial EnumToolMaterial)
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
