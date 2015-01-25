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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityBanshee extends EntityMob
{
	public EntityBanshee(World world) 
	{
		super(world);
		this.getNavigator().setCanSwim(true);
		this.experienceValue = 20;
		this.setSize(0.8F, 2.0F);
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
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(7.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(24.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.175D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(50.0D);
	}
	
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
     * Entity becomes invisible (10 sec) after being damaged.
     */
    public boolean attackEntityFrom(DamageSource source, float par2)
    {
    	if (!super.attackEntityFrom(source, par2))
    	{
    		return false;
    	}
    	else
    	{
        	addPotionEffect(new PotionEffect(Potion.invisibility.id, 20*10, 1));
    	}
    	return true;
    }
}
