package com.thexfactor117.ascension.items.weapons.ranged;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.thexfactor117.ascension.entities.projectiles.EntityInferno;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModItems;
import com.thexfactor117.ascension.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemInfernoStaff extends Item
{	
	public static final String[] infernoStaffChargeArray = new String[] {"charging_0", "charging_1", "charging_full"};
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	public ItemInfernoStaff()
	{
		super();
		this.setCreativeTab(ModTabs.tabAscensionTest);
		this.maxStackSize = 1;
		this.setMaxDamage(192);
		this.setNoRepair();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		this.iconArray = new IIcon[infernoStaffChargeArray.length];
		
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = iconRegister.registerIcon(this.getIconString() + "_" + infernoStaffChargeArray[i]);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getItemIconForUseDuration(int i)
	{
		return this.iconArray[i];
	}
	
	/**
	 * Once the player releases the right click button, this method is
	 * called, so long as the first couple conditions are met. If they
	 * are not met, nothing returns.
	 */
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int i)
	{
		/**
		 * Determines whether or not the player has fully charged
		 * up the staff. If the staff has not finished charging,
		 * nothing is returned. If the staff has finished
		 * charging, then the specified entity will spawn.
		 */
		int x = getMaxItemUseDuration(stack) - i;
		float y = x / 20.0F;
		y = (y * y + y * 2.0F) / 3.0F;
		
		if (y < 0.1F) return;
		if (y > 1.0F)
		{
			y = 1.0F;
		}
		
		//should the staff consume something?
		if (player.capabilities.isCreativeMode || player.inventory.hasItem(ModItems.crystalShard))
		{
			stack.damageItem(1, player);
			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!world.isRemote)
			{
				/**
				 * Vec3 is used to find the players position, as well as
				 * the direction the player is facing so that the entity
				 * will 'fly' in a straight path.
				 */
				Vec3 look = player.getLookVec();
				EntityInferno inferno = new EntityInferno(world, player);
				inferno.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);
				player.inventory.consumeInventoryItem(ModItems.crystalShard);
				world.spawnEntityInWorld(inferno);
			}
		}
	}
	
	/**
	 * Determines what action the item will have (e.g. eating, drawing a bow)
	 */
	@Override
	public EnumAction getItemUseAction(ItemStack itemstack)
	{
		return EnumAction.none; //test different actions for better looks
	}
	
	/**
	 * Used in finding out whether or not the staff should shoot.
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }
	
	/**
	 * Called when the staff is right-clicked. This determines whether or not
	 * the player has the item required to shoot the staff if applicable.
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{
		if (player.inventory.hasItem(ModItems.crystalShard))
		{
			player.setItemInUse(stack, this.getMaxItemUseDuration(stack));
		}
		
		return stack;
	}
}
