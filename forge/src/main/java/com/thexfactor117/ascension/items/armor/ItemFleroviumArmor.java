package com.thexfactor117.ascension.items.armor;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemFleroviumArmor extends ItemArmor
{
	public ItemFleroviumArmor(ArmorMaterial material, int ArmorType, String name) 
	{
		super(material, 0, ArmorType);
		setUnlocalizedName(name);
		setTextureName(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		setCreativeTab(ModTabs.tabAscension);
	}
	
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (stack.getItem() == ModArmory.fleroviumHelm || stack.getItem() == ModArmory.fleroviumPlate || stack.getItem() == ModArmory.fleroviumBoots)
		{
			return Reference.MODID + ":models/armor/flerovium_layer1.png";
		}
		else if (stack.getItem() == ModArmory.fleroviumPants)
		{
			return Reference.MODID + ":models/armor/flerovium_layer2.png";
		}
		else
		{
			return null;
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		list.add("An extremely powerful armor.");
		list.add(stack.getMaxDamage() - stack.getItemDamage() + " Hits Remaining");
		list.add("Full Set Bonus: Strength");
	}
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack stack)
	{
		if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(ModArmory.fleroviumBoots) 
				&& player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(ModArmory.fleroviumPants) 
				&& player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(ModArmory.fleroviumPlate) 
				&& player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(ModArmory.fleroviumHelm))
		{
			player.addPotionEffect(new PotionEffect(Potion.damageBoost.id, 20*1));
		}
	}
}
