package com.thexfactor117.ascension.entities.hostile;

import java.util.Random;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.thexfactor117.ascension.init.ModItems;

public class EntityBear extends EntityMob
{
	int itemsDropped = 3;
	
	public EntityBear(World world) 
	{
		super(world);
		this.getNavigator().setCanSwim(true);
		this.experienceValue = 15;
		this.setSize(1.5F, 1.0F); //sets how big the hit box is *** TEST THIS ***
		this.tasks.addTask(0, new EntityAIWander(this, 0.1D)); //speed at which mob wanders
		this.tasks.addTask(1, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, false)); // attacks player once collided
		this.tasks.addTask(2, new EntityAISwimming(this));
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(6.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
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
			dropItem(ModItems.rawVenison, 1);
		}
		if (var1 == 2)
		{
			dropItem(ModItems.rawVenison, 2);
		}
	}
	
	@Override
	protected void dropRareDrop(int par1)
	{
		Random rand = new Random();
		int random = rand.nextInt(2);
		
		if (random == 0)
		{
			dropItem(ModItems.rawVenison, 3);
		}
	}
}
