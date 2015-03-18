package com.thexfactor117.ascension.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ItemAscensionStaff extends Item
{
	public ItemAscensionStaff()
	{
		super();
	}
	
	/*@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int par2, EntityPlayer player, ItemStack item, int usesRemaining)
	{
		if (item == null)
		{
			return itemIcon;
		}
		
		int ticksInUse = stack.getMaxItemUseDuration() - usesRemaining;
		
		if (ticksInUse > 19)
		{
			return iconArray[2];
		}
		else if (ticksInUse > 11)
		{
			return iconArray[1];
		}
		else if (ticksInUse > 3)
		{
			return iconArray[0];
		}
		else
		{
			return itemIcon;
		}
	}*/
	
	/**
	 * Once the player releases the right click button, this method is
	 * called, so long as the first couple conditions are met. If they
	 * are not met, nothing returns.
	 * 
	 * Count = itemInUseCount (how many ticks the item has been in use)
	 */
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int count)
	{
		
	}
	
	/**
	 * Determines what action the item will have (e.g. eating, drawing a bow)
	 */
	/*@Override
	public EnumAction getItemUseAction(ItemStack itemstack)
	{
		return EnumAction.none;
	}*/
	
	/**
	 * Used in finding out whether or not the staff should shoot.
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return 300;
    }
	
	/**
	 * Called when the staff is right-clicked. This determines whether or not
	 * the player has the item required to shoot the staff if applicable.
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		return stack;
	}
}
