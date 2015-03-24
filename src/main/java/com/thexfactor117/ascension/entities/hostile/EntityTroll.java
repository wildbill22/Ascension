package com.thexfactor117.ascension.entities.hostile;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.thexfactor117.ascension.handlers.ConfigHandler;

/**
 * 
 * @author TheXFactor117
 *
 */

public class EntityTroll extends EntityMob
{
	private static final String name = "Troll";
	
	public EntityTroll(World world) 
	{
		super(world);
		this.experienceValue = 25;
		this.setSize(1.0F, 2.0F);
		this.clearAITasks();
		this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, true));
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(ConfigHandler.mummyDamage);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(ConfigHandler.mummyFollowRange);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(ConfigHandler.mummySpeed);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ConfigHandler.mummyHealth);
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
	
	public String getName()
    {
    	return name;
    }
}
