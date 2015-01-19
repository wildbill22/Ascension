package com.thexfactor117.ascension.entities.hostile;

import net.minecraft.entity.Entity;
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

public class EntityValkyrie extends EntityMob
{
	public EntityValkyrie(World world) 
	{
		super(world);
		this.setSize(1F, 2F);
		this.getNavigator().setCanSwim(true);
		this.experienceValue = 20;
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

	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	
	protected void clearAITasks()
	{
		tasks.taskEntries.clear();
		targetTasks.taskEntries.clear();
	}
	
	/**
	 * Testing purposes. Entities are having trouble attacking
	 * players; hopefully this will help out.
	 */
    @Override
	protected Entity findPlayerToAttack()
    {
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 32.0D);
        return entityplayer != null && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
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
