package com.thexfactor117.ascension.items.weapons;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

import com.thexfactor117.ascension.entities.projectiles.EntityInferno;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemInfernoStaff extends ItemBow
{	
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
	public void registerIcons(IIconRegister par1IconRegister)
	{
		this.itemIcon = par1IconRegister.registerIcon(Reference.MODID + ":" + getUnlocalizedName().substring(5));
	}
	
	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
	{		
		stack.damageItem(1, player);
		world.playSoundAtEntity(player, "random.bow", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
		
		if (!world.isRemote)
		{
			Vec3 look = player.getLookVec();
			
			EntityInferno inferno = new EntityInferno(world, player);
			
			inferno.setPosition(player.posX + look.xCoord, player.posY + look.yCoord + 1.5, player.posZ + look.zCoord);
			
			world.spawnEntityInWorld(inferno);
		}
		
		return stack;
	}
}
