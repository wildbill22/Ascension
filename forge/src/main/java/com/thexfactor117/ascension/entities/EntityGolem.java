package com.thexfactor117.ascension.entities;

import java.util.Random;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

import com.thexfactor117.ascension.init.ModItems;

public class EntityGolem extends EntityMob
{
	public EntityGolem(World world) 
	{
		super(world);
		this.getNavigator().setCanSwim(true);
		this.experienceValue = 30;
		this.setSize(1.5F, 1.0F); //sets how big the hit box is *** TEST THIS ***
		this.tasks.addTask(0, new EntityAIWander(this, 1.0D)); //speed at which mob wanders
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false)); // attacks player once collided
		this.tasks.addTask(2, new EntityAISwimming(this));
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.5D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.1D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(75.0D);
	}
	
	public boolean isAIEnabled()
	{
		return true;
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		int var1 = this.rand.nextInt(4);
		
		if (var1 == 0)
		{
			dropItem(ModItems.smallRock, 2);
		}
		if (var1 == 2)
		{
			dropItem(ModItems.smallRock, 4);
		}
		if (var1 == 3)
		{
			dropItem(Items.iron_ingot, 1);
		}
	}
	
	@Override
	protected void dropRareDrop(int par1)
	{
		Random rand = new Random();
		int random = rand.nextInt(3);
		
		if(random == 0)
		{
			dropItem(ModItems.titaniumIngot, 1);
		}
		if (random == 2)
		{
			dropItem(Items.iron_ingot, 2);
		}
	}
}
