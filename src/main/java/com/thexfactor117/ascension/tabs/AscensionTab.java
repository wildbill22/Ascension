package com.thexfactor117.ascension.tabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;

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
			return ModArmory.lightning_staff;
		}
		return null;
	}
}
