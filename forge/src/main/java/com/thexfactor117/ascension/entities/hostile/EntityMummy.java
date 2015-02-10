package com.thexfactor117.ascension.entities.hostile;

import java.util.Random;

import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;

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
		this.setSize(1.0F, 2.0F);
		this.clearAITasks();
		this.tasks.addTask(2, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, true));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(5, new EntityAISwimming(this));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(60.0D);
	}
	
	/**
	 * Overrides to make sure the AI is enabled
	 */
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	
	@Override
	public boolean canDespawn()
	{
		return true;
	}
	
	/**
	 * Clears previous AI Tasks, so the ones defined above will
	 * actually perform.
	 */
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
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 24.0D);
        return entityplayer != null && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
    }
	
    /**
     * Drops a select amount of items.
     * 
     * this.rand.nextInt(x) -- x is basically the chance of spawning.
     */
	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		int var = this.rand.nextInt(3);
		if (var == 0)
		{
			this.dropItem(Items.rotten_flesh, 1);
		}
		if (var == 1)
		{
			this.dropItem(Items.paper, 1);
		}
		
		int var1 = this.rand.nextInt(5);
		if (var1 == 0)
		{
			this.dropItem(Items.gold_nugget, 2);
		}
		
		int var2 = this.rand.nextInt(10);
		if (var2 == 0)
		{
			this.dropItem(Items.gold_ingot, 1);
		}
		
		int var3 = this.rand.nextInt(10);
		if (var3 == 0)
		{
			this.dropItem(ModItems.soulFragment, 1);
		}
		
		int var4 = this.rand.nextInt(10);
		if (var4 == 0)
		{
			this.dropItem(ModItems.crystalShard, 1);
		}
		
		int var5 = this.rand.nextInt(19);
		if (var5 == 0)
		{
			this.dropItem(Items.emerald, 1);
		}
		
		int var6 = this.rand.nextInt(19);
		if (var6 == 0)
		{
			this.dropItem(Items.diamond, 1);
		}
		
		int var7 = this.rand.nextInt(100);
		if (var7 == 0)
		{
			this.dropItem(ModItems.fleroviumShard, 1);
		}
		
		int var8 = this.rand.nextInt(100);
		if (var8 == 0)
		{
			this.dropItem(ModArmory.etherealBlade, 1);
		}
	}
	
    @Override
    protected String getLivingSound()
    {
    	return "mob.zombie.say";
    }
    
    @Override
    protected String getHurtSound()
    {
    	return "mob.zombie.hurt";
    }
    
    @Override
    protected String getDeathSound()
    {
    	return "mob.zombie.death";
    }
}
