package com.thexfactor117.ascension.items;

import net.minecraft.item.ItemPickaxe;

import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ItemAscensionPickaxe extends ItemPickaxe
{
	private final String name = this.getUnlocalizedName();
	public final ToolMaterial toolMaterial;
	
	public ItemAscensionPickaxe(ToolMaterial EnumToolMaterial)
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
