package com.thexfactor117.ascension.tabs;

import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;
import com.thexfactor117.ascension.init.ModStructureItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

/**
 * 
 * @author TheXFactor117
 *
 */

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
			return ModItems.omega;
		} 
		else if (this.name == "tabAscensionTest")
		{
			return ModArmory.bladeOfAlacrity;
		}
		return null;
	}
}
