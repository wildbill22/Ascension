package com.thexfactor117.ascension.items;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.tabs.ModTabs;

public class ItemTitaniumArmor extends ItemArmor
{
	public ItemTitaniumArmor(ArmorMaterial material, int ArmorType, String name) 
	{
		super(material, 0, ArmorType);
		setUnlocalizedName(name);
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(ModTabs.tabAscension);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == ModArmory.titaniumHelm || stack.getItem() == ModArmory.titaniumPlate || stack.getItem() == ModArmory.titaniumBoots)
		{
			return Reference.MODID + ":models/armor/titanium_layer1.png";
		}
		else if (stack.getItem() == ModArmory.titaniumPants)
		{
			return Reference.MODID + ":models/armor/titanium_layer2.png";
		}
		else
		{
			return null;
		}	
	}
}
