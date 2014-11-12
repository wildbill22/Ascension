package com.thexfactor117.ascension.items;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.tabs.ModTabs;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ItemVeconiteArmor extends ItemArmor
{
	public ItemVeconiteArmor(ArmorMaterial material, int ArmorType, String name) 
	{
		super(material, 0, ArmorType);
		setUnlocalizedName(name);
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(ModTabs.tabAscension);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == ModArmory.veconiteHelm || stack.getItem() == ModArmory.veconitePlate || stack.getItem() == ModArmory.veconiteBoots)
		{
			return Reference.MODID + ":models/armor/veconiteArmor1.png";
		}
		else if (stack.getItem() == ModArmory.veconitePants)
		{
			return Reference.MODID + ":models/armor/veconiteArmor2.png";
		}
		else
		{
			return null;
		}	
	}
}
