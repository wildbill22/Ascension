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
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

import com.thexfactor117.ascension.handlers.ConfigHandler;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;

/**
 * 
 * @author TheXFactor117
 *
 */

public class EntityBanshee extends EntityMob
{
	public EntityBanshee(World world) 
	{
		super(world);
		this.experienceValue = 20;
		this.setSize(0.8F, 2.0F);
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
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(ConfigHandler.bansheeDamage);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(ConfigHandler.bansheeFollowRange);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(ConfigHandler.bansheeSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ConfigHandler.bansheeHealth);
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
        	if (!this.worldObj.isRemote)
        	{
        		addPotionEffect(new PotionEffect(Potion.invisibility.id, 20*10, 1));
        	}
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
        int i = MathHelper.floor_double(this.getBoundingBox().minY);

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
			this.dropItem(ModItems.steel_ingot, 1);
		}
		
		int var2 = this.rand.nextInt(10);
		if (var2 == 0)
		{
			this.dropItem(ModItems.crystal_shard, 1);
		}
		
		int var3 = this.rand.nextInt(10);
		if (var3 == 0)
		{
			this.dropItem(ModItems.soul_fragment, 1);
		}
		
		int var4 = this.rand.nextInt(19);
		if (var4 == 0)
		{
			this.dropItem(ModItems.crystal_shard, 2);
		}
		
		int var5 = this.rand.nextInt(19);
		if (var5 == 0)
		{
			this.dropItem(ModItems.flerovium_shard, 1);
		}
		
		int var6 = this.rand.nextInt(100);
		if (var6 == 0)
		{
			this.dropItem(ModItems.soul_gem, 1);
		}
		
		int var7 = this.rand.nextInt(100);
		if (var7 == 0)
		{
			this.dropItem(ModArmory.shadow_blade, 1);
		}
		
		int var8 = this.rand.nextInt(100);
		if (var8 == 0)
		{
			this.dropItem(ModArmory.void_hammer, 1);
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
