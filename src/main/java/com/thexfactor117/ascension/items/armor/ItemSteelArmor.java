package com.thexfactor117.ascension.items.armor;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ItemSteelArmor extends ItemArmor
{
	public ItemSteelArmor(ArmorMaterial material, int ArmorType, String name) 
	{
		super(material, 0, ArmorType);
		setUnlocalizedName(name);
		setCreativeTab(ModTabs.tabAscension);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == ModArmory.steelHelm || stack.getItem() == ModArmory.steelPlate || stack.getItem() == ModArmory.steelBoots)
		{
			return Reference.MODID + ":models/armor/steel_layer1.png";
		}
		else if (stack.getItem() == ModArmory.steelPants)
		{
			return Reference.MODID + ":models/armor/steel_layer2.png";
		}
		else
		{
			return null;
		}	
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add("A combination of Titanium and Iron.");
		list.add(stack.getMaxDamage() - stack.getItemDamage() + " Hits Remaining");
		list.add("Full Set Bonus: None");
	}
}
