package com.thexfactor117.ascension.entities.hostile;

import java.util.Random;

import com.thexfactor117.ascension.init.ModItems;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityValkyrie extends EntityMob
{
	public EntityValkyrie(World world) 
	{
		super(world);
		this.setSize(1F, 2F);
		this.getNavigator().setCanSwim(true);
		this.experienceValue = 20;
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
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.3D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
	}

	public boolean isAIEnabled()
	{
		return true;
	}
	
	@Override
	protected void dropFewItems(boolean par1, int par2)
	{	
		int var1 = this.rand.nextInt(5);
		if (var1 == 0)
		{
			this.dropItem(Items.iron_ingot, 1);
		}
		
		int var2 = this.rand.nextInt(5);
		if (var2 == 0)
		{
			this.dropItem(Items.iron_ingot, 3);
		}
		
		int var3 = this.rand.nextInt(5);
		if (var3 == 0)
		{
			this.dropItem(ModItems.titaniumIngot, 1);
		}
		
		int var4 = this.rand.nextInt(10);
		if (var4 == 0)
		{
			this.dropItem(ModItems.steelIngot, 1);
		}
	}
}
