package com.thexfactor117.ascension.tabs;

import com.thexfactor117.ascension.init.ModBlocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class AscensionTab extends CreativeTabs 
{
	String name;
	
	public AscensionTab(int par1, String par2Str)
	{
		super(par1, par2Str);
		this.name = par2Str;
	}
	
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		if (this.name == "tabAscension") 
		{
			return Items.apple;
		}
		System.out.println("Mariah, I love you, but why crash?");
		return null;
	}
}
