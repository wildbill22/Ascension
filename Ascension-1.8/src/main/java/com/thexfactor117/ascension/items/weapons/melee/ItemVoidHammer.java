package com.thexfactor117.ascension.items.weapons.melee;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;

import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ItemVoidHammer extends ItemSword
{
	private final String name = this.getUnlocalizedName();
	public final ToolMaterial toolMaterial;
	
	public ItemVoidHammer(ToolMaterial EnumToolMaterial)
	{
		super(EnumToolMaterial);
		toolMaterial = EnumToolMaterial;
		setCreativeTab(ModTabs.tabAscension);
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
	
	public String getName()
	{
		return name;
	}
}
