package com.thexfactor117.ascension.items.weapons.melee;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;

import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ItemDivineRapier extends ItemSword
{
	public final ToolMaterial toolMaterial;
	
	public ItemDivineRapier(ToolMaterial EnumToolMaterial)
	{
		super(EnumToolMaterial);
		toolMaterial = EnumToolMaterial;
		setCreativeTab(ModTabs.tabAscension);
	}
	
	public boolean hitEntity(ItemStack par1ItemStack, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase)
	{
		par1ItemStack.damageItem(1, par3EntityLivingBase);
		
		par2EntityLivingBase.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*5, 1));
		par2EntityLivingBase.setFire(5);
		
		return true;
	}
}
