package com.thexfactor117.ascension.entities;

import java.util.Random;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
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
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, true)); // attacks player once collided
		this.tasks.addTask(2, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
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
		int var1 = this.rand.nextInt(3);
		if (var1 == 0)
		{
			this.dropItem(ModItems.smallRock, 1);
		}
		if (var1 == 1)
		{
			this.dropItem(ModItems.smallRock, 3);
		}
		
		int var2 = this.rand.nextInt(5);
		if (var2 == 0)
		{
			this.dropItem(Items.iron_ingot, 1);
		}
		
		int var3 = this.rand.nextInt(7);
		if (var3 == 0)
		{
			this.dropItem(Items.iron_ingot, 2);
		}
		
		int var4 = this.rand.nextInt(7);
		if (var4 == 0)
		{
			this.dropItem(ModItems.titaniumIngot, 1);
		}
		
		int var5 = this.rand.nextInt(10);
		if (var5 == 0)
		{
			this.dropItem(ModItems.titaniumIngot, 2);
		}
		
		int var6 = this.rand.nextInt(10);
		if (var6 == 0)
		{
			this.dropItem(ModItems.steelIngot, 1);
		}
		
		int var7 = this.rand.nextInt(10);
		if (var7 == 0)
		{
			this.dropItem(Items.diamond, 1);
		}
	}
}
