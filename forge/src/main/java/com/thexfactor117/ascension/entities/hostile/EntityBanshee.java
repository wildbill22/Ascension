package com.thexfactor117.ascension.entities.hostile;

import java.util.Calendar;

import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;

import net.minecraft.entity.Entity;
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
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityBanshee extends EntityMob
{
	public EntityBanshee(World world) 
	{
		super(world);
		this.getNavigator().setCanSwim(true);
		this.getNavigator().setAvoidsWater(true);
		this.getNavigator().setAvoidSun(true);
		this.experienceValue = 20;
		this.setSize(0.8F, 2.0F);
		this.clearAITasks();
		this.tasks.addTask(0, new EntityAIAttackOnCollide(this, EntityPlayer.class, 1.0D, true));
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAILookIdle(this));
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget(this, EntityPlayer.class, 0, true));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(8.0D);
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
    
    /**
     * Spawns them only under a certain Y value.
     */
    @Override
    public boolean getCanSpawnHere()
    {
    	return super.getCanSpawnHere() && entitySpawnUnderground();
    }
    
    /**
     * Sets a certain Y-value in which mobs can spawn. In this case,
     * the Banshee can spawn anywhere under Y-50.
     */
    public boolean entitySpawnUnderground()
    {
        int i = MathHelper.floor_double(this.boundingBox.minY);

        if (i >= 50)
        {
            return false;
        }
        else
        {
        	return true;
        }
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
			this.dropItem(ModItems.steelIngot, 1);
		}
		
		int var2 = this.rand.nextInt(10);
		if (var2 == 0)
		{
			this.dropItem(ModItems.crystalShard, 1);
		}
		
		int var3 = this.rand.nextInt(10);
		if (var3 == 0)
		{
			this.dropItem(ModItems.soulFragment, 1);
		}
		
		int var4 = this.rand.nextInt(19);
		if (var4 == 0)
		{
			this.dropItem(ModItems.crystalShard, 2);
		}
		
		int var5 = this.rand.nextInt(19);
		if (var5 == 0)
		{
			this.dropItem(ModItems.fleroviumShard, 1);
		}
		
		int var6 = this.rand.nextInt(100);
		if (var6 == 0)
		{
			this.dropItem(ModItems.soulGem, 1);
		}
		
		int var7 = this.rand.nextInt(100);
		if (var7 == 0)
		{
			this.dropItem(ModArmory.shadowBlade, 1);
		}
		
		int var8 = this.rand.nextInt(100);
		if (var8 == 0)
		{
			this.dropItem(ModArmory.voidHammer, 1);
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
