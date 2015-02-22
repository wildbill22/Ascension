package com.thexfactor117.ascension.entities.hostile;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityGhost extends EntityMob
{
	public EntityGhost(World world) 
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
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(16.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(30.0D);
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
        EntityPlayer entityplayer = this.worldObj.getClosestVulnerablePlayerToEntity(this, 16.0D);
        return entityplayer != null && this.canEntityBeSeen(entityplayer) ? entityplayer : null;
    }

    /**
     * Entity becomes invisible (5 sec) after being damaged.
     */
    public boolean attackEntityFrom(DamageSource source, float par2)
    {
    	if (!super.attackEntityFrom(source, par2))
    	{
    		return false;
    	}
    	else
    	{
        	addPotionEffect(new PotionEffect(Potion.invisibility.id, 20*5, 1));
    	}
    	return true;
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
			this.dropItem(ModItems.crystalShard, 1);
		}
		
		int var2 = this.rand.nextInt(10);
		if (var2 == 0)
		{
			this.dropItem(ModItems.soulFragment, 1);
		}

		int var3 = this.rand.nextInt(100);
		if (var3 == 0)
		{
			this.dropItem(ModItems.fleroviumShard, 1);
		}
		
		int var4 = this.rand.nextInt(100);
		if (var4 == 0)
		{
			this.dropItem(ModItems.soulGem, 1);
		}
		
		int var5 = this.rand.nextInt(100);
		if (var5 == 0)
		{
			this.dropItem(ModArmory.shadowBlade, 1);
		}
    }
    
    @Override
    protected String getLivingSound()
    {
    	return Reference.MODID + ":" + "BansheeScream";
    }
    
    @Override
    protected String getHurtSound()
    {
    	return Reference.MODID + ":" + "BansheeScream";
    }
    
    @Override
    protected String getDeathSound()
    {
    	return Reference.MODID + ":" + "BansheeScream";
    }
}
