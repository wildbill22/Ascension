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
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityMummy extends EntityMob
{
	public EntityMummy(World world) 
	{
		super(world);
		this.getNavigator().setCanSwim(true);
		this.experienceValue = 25;
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
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.15D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(40.0D);
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
			this.dropItem(Items.rotten_flesh, 1);
		}
		if (var1 == 1)
		{
			this.dropItem(Items.paper, 1);
		}
		
		int var2 = this.rand.nextInt(3);
		if (var2 == 0)
		{
			this.dropItem(Items.gold_nugget, 2);
		}
		
		int var3 = this.rand.nextInt(5);
		if (var3 == 0)
		{
			this.dropItem(Items.gold_ingot, 1);
		}
		
		int var4 = this.rand.nextInt(7);
		if (var4 == 0)
		{
			this.dropItem(Items.emerald, 1);
		}
		
		int var5 = this.rand.nextInt(10);
		if (var5 == 0)
		{
			this.dropItem(Items.diamond, 1);
		}
	}
}
