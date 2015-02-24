package com.thexfactor117.ascension.items.weapons.ranged;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.thexfactor117.ascension.entities.projectiles.EntityMediumBlizzard;
import com.thexfactor117.ascension.entities.projectiles.EntitySmallBlizzard;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;
import com.thexfactor117.ascension.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBlizzardStaff extends Item
{
	public static final String[] blizzardStaffChargeArray = new String[] {"charging_0", "charging_1", "charging_full"};
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	public ItemBlizzardStaff()
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
		this.iconArray = new IIcon[blizzardStaffChargeArray.length];
		
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = iconRegister.registerIcon(this.getIconString() + "_" + blizzardStaffChargeArray[i]);
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
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int count)
	{
		/**
		 * Determines whether or not the player has fully charged
		 * up the staff. If the staff has not finished charging,
		 * nothing is returned. If the staff has finished
		 * charging, then the specified entity will spawn.
		 * 
		 * Explanation:
		 * We set x to the maxDuration minus the count. Count is how long the item has been
		 * used in ticks (e.g. maxDuration [300] - count [20] = 280). Y is then x transformed
		 * into seconds (280/20), and is run through some numbers to make sure it is over 1 
		 * second.
		 * 
		 * If count is less than 20, nothing will return. If it is greater than 20, the entity
		 * fires.
		 */
		int x = getMaxItemUseDuration(stack) - count;
		float y = x / 20.0F;
		y = (y * y + y * 2.0F) / 3.0F;
		
		if (y < 1.0F) return;
		if (y >= 1.0F)
		{
			y = 1.0F;
		}
		
		//should the staff consume something?
		if (player.capabilities.isCreativeMode || player.inventory.hasItem(ModItems.crystalShard))
		{
			stack.damageItem(1, player);
			world.playSoundAtEntity(player, "", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!world.isRemote)
			{
				/**
				 * Retrieves the players armor.
				 * 
				 * If the player is wearing a full set of Ethereal, the
				 * magic used will be bigger. If not, it will default
				 * to the smaller magic.
				 */
				if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(ModArmory.etherealBoots) 
						&& player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(ModArmory.etherealPants) 
						&& player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(ModArmory.etherealPlate) 
						&& player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(ModArmory.etherealHelm))
				{
					/**
					 * Vec3 is used to find the players position, as well as
					 * the direction the player is facing so that the entity
					 * will 'fly' in a straight path.
					 */
					Vec3 look = player.getLookVec();
					EntityMediumBlizzard blizzard = new EntityMediumBlizzard(world, player);
					blizzard.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);
					player.inventory.consumeInventoryItem(ModItems.crystalShard);
					world.spawnEntityInWorld(blizzard);
				}
				else
				{
					Vec3 look = player.getLookVec();
					EntitySmallBlizzard blizzard = new EntitySmallBlizzard(world, player);
					blizzard.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);
					player.inventory.consumeInventoryItem(ModItems.crystalShard);
					world.spawnEntityInWorld(blizzard);
				}
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
        return 300;
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
