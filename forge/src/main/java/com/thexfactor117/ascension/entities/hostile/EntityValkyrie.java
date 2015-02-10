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
import net.minecraft.util.MathHelper;
import net.minecraft.world.EnumSkyBlock;
import net.minecraft.world.World;

import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;

public class EntityValkyrie extends EntityMob
{
	public EntityValkyrie(World world) 
	{
		super(world);
		this.getNavigator().setCanSwim(true);
		this.experienceValue = 20;
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
	
	@Override
	public boolean isValidLightLevel()
	{
		return true;
	}
	
	@Override
	public boolean canDespawn()
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
		int var = this.rand.nextInt(5);
		if (var == 0)
		{
			this.dropItem(Items.iron_ingot, 1);
		}
		
		int var1 = this.rand.nextInt(10);
		if (var1 == 0)
		{
			this.dropItem(ModItems.soulFragment, 1);
		}
		
		int var2 = this.rand.nextInt(19);
		if (var2 == 0)
		{
			this.dropItem(ModItems.steelIngot, 1);
		}
		
		int var3 = this.rand.nextInt(19);
		if (var3 == 0)
		{
			this.dropItem(ModItems.crystalShard, 1);
		}
		
		int var4 = this.rand.nextInt(19);
		if (var4 == 0)
		{
			this.dropItem(ModArmory.razorSword, 1);
		}
		
		int var5 = this.rand.nextInt(100);
		if (var5 == 0)
		{
			this.dropItem(ModItems.fleroviumShard, 1);
		}
		
		int var6 = this.rand.nextInt(100);
		if (var6 == 0)
		{
			this.dropItem(ModArmory.wingedBlade, 1);
		}
	}
	
    @Override
    protected String getLivingSound()
    {
    	return "mob.villager.idle";
    }
    
    @Override
    protected String getHurtSound()
    {
    	return "mob.villager.hit";
    }
    
    @Override
    protected String getDeathSound()
    {
    	return "mob.villager.death";
    }
}
