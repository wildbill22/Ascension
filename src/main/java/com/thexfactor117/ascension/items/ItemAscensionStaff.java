package com.thexfactor117.ascension.items;

import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.thexfactor117.ascension.help.Reference;

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
	
	@Override
	@SideOnly(Side.CLIENT)
	public ModelResourceLocation getModel(ItemStack stack, EntityPlayer player, int usesRemaining)
	{		
		if (stack.getItem() instanceof ItemAscensionStaff && player.getItemInUse() != null)
		{
			int ticksInUse = stack.getMaxItemUseDuration() - usesRemaining;
			
			if (ticksInUse > 19)
			{
				return new ModelResourceLocation(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_charging_full", "inventory");
			}
			else if (ticksInUse > 11)
			{
				return new ModelResourceLocation(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_charging_2", "inventory");
			}
			else if (ticksInUse > 3)
			{
				return new ModelResourceLocation(Reference.MODID + ":" + getUnlocalizedName().substring(5) + "_charging_1", "inventory");
			}
		}
		return null;
	}
	
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
