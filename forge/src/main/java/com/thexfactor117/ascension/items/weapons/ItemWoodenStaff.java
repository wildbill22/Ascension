package com.thexfactor117.ascension.items.weapons;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.thexfactor117.ascension.entities.projectiles.EntityMagicBall;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModItems;
import com.thexfactor117.ascension.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemWoodenStaff extends Item
{
	public static final String[] woodenStaffChargeArray = new String[] {"charging_0", "charging_1", "charging_full"};
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
		this.itemIcon = iconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5));
		this.iconArray = new IIcon[woodenStaffChargeArray.length];
		
		for (int i = 0; i < this.iconArray.length; ++i)
		{
			this.iconArray[i] = iconRegister.registerIcon(this.getIconString() + "_" + woodenStaffChargeArray[i]);
		}
	}
	
	@SideOnly(Side.CLIENT)
	public IIcon getItemIconForUseDuration(int i)
	{
		return this.iconArray[i];
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer player, int i)
	{
		int x = getMaxItemUseDuration(stack) - i;
		float y = x / 20.0F;
		y = (y * y + y * 2.0F) / 3.0F;
		
		if (y < 0.1F) return;
		if (y > 1.0F)
		{
			y = 1.0F;
		}
		
		if (player.capabilities.isCreativeMode || player.inventory.hasItem(ModItems.crystalShard))
		{
			stack.damageItem(1, player);
			world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
			
			if (!world.isRemote)
			{
				Vec3 look = player.getLookVec();
				EntityMagicBall magicBall = new EntityMagicBall(world, player);
				magicBall.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);
				player.inventory.consumeInventoryItem(ModItems.crystalShard);
				world.spawnEntityInWorld(magicBall);
			}
		}
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack itemstack)
	{
		return EnumAction.none; //test different actions for better looks
	}
	
	@Override
	public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }
	
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
