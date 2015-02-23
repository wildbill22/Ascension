package com.thexfactor117.ascension.items.weapons.ranged;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.thexfactor117.ascension.entities.projectiles.EntityMediumMagic;
import com.thexfactor117.ascension.entities.projectiles.EntitySmallMagic;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;
import com.thexfactor117.ascension.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWoodenStaff extends Item
{
	@SideOnly(Side.CLIENT)
	private IIcon[] iconArray;
	
	public ItemWoodenStaff()
	{
		super();
		this.setCreativeTab(ModTabs.tabAscensionTest);
		this.maxStackSize = 1;
		this.setMaxDamage(96);
		this.setNoRepair();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		this.itemIcon = iconRegister.registerIcon(Reference.MODID + ":" + "woodenStaff");
		this.iconArray = new IIcon[3];
		this.iconArray[0] = iconRegister.registerIcon(Reference.MODID + ":" + "woodenStaff_charging_1");
		this.iconArray[1] = iconRegister.registerIcon(Reference.MODID + ":" + "woodenStaff_charging_2");
		this.iconArray[2] = iconRegister.registerIcon(Reference.MODID + ":" + "woodenStaff_charging_full");
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(ItemStack stack, int par2, EntityPlayer player, ItemStack item, int usesRemaining)
	{
		if (item == null)
		{
			return itemIcon;
		}
		
		int ticksInUse = stack.getMaxItemUseDuration() - usesRemaining;
		
		if (ticksInUse > 17)
		{
			return iconArray[2];
		}
		else if (ticksInUse > 8)
		{
			return iconArray[1];
		}
		else if (ticksInUse > 0)
		{
			return iconArray[0];
		}
		else
		{
			return itemIcon;
		}
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
					EntityMediumMagic magic = new EntityMediumMagic(world, player);
					magic.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);
					player.inventory.consumeInventoryItem(ModItems.crystalShard);
					world.spawnEntityInWorld(magic);
				}
				else
				{
					Vec3 look = player.getLookVec();
					EntitySmallMagic magic = new EntitySmallMagic(world, player);
					magic.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);
					player.inventory.consumeInventoryItem(ModItems.crystalShard);
					world.spawnEntityInWorld(magic);
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
