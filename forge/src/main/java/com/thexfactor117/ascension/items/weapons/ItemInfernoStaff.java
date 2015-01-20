package com.thexfactor117.ascension.items.weapons;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemInfernoStaff extends ItemBow
{
	public ItemInfernoStaff()
	{
		super();
		this.setCreativeTab(ModTabs.tabAscension);
		this.maxStackSize = 1;
		this.setMaxDamage(64);
		this.setNoRepair();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
	
	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
	{
		itemstack.damageItem(1, entityplayer);
		if (!world.isRemote) 
		{
			Vec3 look = entityplayer.getLookVec();
			EntitySmallFireball fireball2 = new EntitySmallFireball(world, entityplayer, 1, 1, 1);
			fireball2.setPosition(entityplayer.posX + look.xCoord * 5, entityplayer.posY + look.yCoord * 5, entityplayer.posZ + look.zCoord * 5);
			fireball2.accelerationX = look.xCoord * 0.1;
			fireball2.accelerationY = look.yCoord * 0.1;
			fireball2.accelerationZ = look.zCoord * 0.1;
			world.spawnEntityInWorld(fireball2);
		}
		return itemstack;
	}
}
