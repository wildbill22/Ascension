package com.thexfactor117.ascension.items.weapons.melee;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ItemGyroMace extends ItemSword
{
	public final ToolMaterial toolMaterial;
	
	public ItemGyroMace(ToolMaterial EnumToolMaterial)
	{
		super(EnumToolMaterial);
		toolMaterial = EnumToolMaterial;
		setCreativeTab(ModTabs.tabAscension);
	}
	
	/**
	 * Adds the Knockback enchantment on creation.
	 */
	@Override
	public void onCreated(ItemStack stack, World world, EntityPlayer player)
	{
		stack.addEnchantment(Enchantment.knockback, 1);
	}
	
	/**
	 * Called each tick the item is in the inventory
	 * 
	 * If the item is NOT enchanted, we will add an enchant.
	 */
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int par4, boolean par5)
	{
		if (!stack.isItemEnchanted())
		{
			stack.addEnchantment(Enchantment.knockback, 1);
		}
	}
}
