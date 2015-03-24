package com.thexfactor117.ascension.items.armor;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ItemEtherealArmor extends ItemArmor
{
	public ItemEtherealArmor(ArmorMaterial material, int ArmorType, String name) 
	{
		super(material, 0, ArmorType);
		setUnlocalizedName(name);
		setCreativeTab(ModTabs.tabAscension);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == ModArmory.ethereal_helmet || stack.getItem() == ModArmory.ethereal_chestplate || stack.getItem() == ModArmory.ethereal_boots)
		{
			return Reference.MODID + ":models/armor/ethereal_layer1.png";
		}
		else if (stack.getItem() == ModArmory.ethereal_leggings)
		{
			return Reference.MODID + ":models/armor/ethereal_layer2.png";
		}
		else
		{
			return null;
		}
	}
}
