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

public class ItemTitaniumArmor extends ItemArmor
{
	public ItemTitaniumArmor(ArmorMaterial material, int ArmorType, String name) 
	{
		super(material, 0, ArmorType);
		setUnlocalizedName(name);
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add("An alternative to iron.");
		list.add(stack.getMaxDamage() - stack.getItemDamage() + " Hits Remaining");
		list.add("Full Set Bonus: None");
	}
}
