package com.thexfactor117.ascension.items.armor;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.tabs.ModTabs;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;

public class ItemGyroPlate extends ItemArmor
{
	public ItemGyroPlate(ArmorMaterial material, int ArmorType, String name) 
	{
		super(material, 0, ArmorType);
		setUnlocalizedName(name);
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(ModTabs.tabAscension);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == ModArmory.steelPlate)
		{
			return Reference.MODID + ":models/armor/steel_layer1.png";
		}
		else
		{
			return null;
		}	
	}
}
