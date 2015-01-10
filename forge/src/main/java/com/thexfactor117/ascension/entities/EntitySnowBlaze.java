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

public class EntitySnowBlaze extends EntityMob
{
	/**
	 * !!!Come back later to add blaze properties!!!
	 */
	public EntitySnowBlaze(World world) 
	{
		super(world);
		this.getNavigator().setCanSwim(true);
		this.experienceValue = 20;
		this.setSize(1.5F, 1.0F); //sets how big the hit box is *** TEST THIS ***
		this.tasks.addTask(0, new EntityAIWander(this, 1.25D)); //speed at which mob wanders
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false)); // attacks player once collided
		this.tasks.addTask(2, new EntityAISwimming(this));
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.5D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(35.0D);
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
			dropItem(ModItems.coldBlazeRod, 1);
		}
		if (var1 == 2)
		{
			dropItem(Items.snowball, 1);
		}
		if (var1 == 3)
		{
			dropItem(Items.snowball, 3);
		}
	}
	
	@Override
	protected void dropRareDrop(int par1)
	{
		Random rand = new Random();
		int random = rand.nextInt(2);
		
		if (random == 0)
		{
			dropItem(ModItems.iceGem, 1);
		}
	}
}
