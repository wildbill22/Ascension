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
import net.minecraft.world.World;

import com.thexfactor117.ascension.handlers.ConfigHandler;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;

/**
 * 
 * @author TheXFactor117
 *
 */

public class EntityValkyrie extends EntityMob
{
	public EntityValkyrie(World world) 
	{
		super(world);
		this.experienceValue = 20;
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
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(ConfigHandler.valkyrieDamage);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(ConfigHandler.valkyrieFollowRange);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(ConfigHandler.valkyrieSpeed);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ConfigHandler.valkyrieHealth);
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
			this.dropItem(ModItems.soul_fragment, 1);
		}
		
		int var2 = this.rand.nextInt(19);
		if (var2 == 0)
		{
			this.dropItem(ModItems.steel_ingot, 1);
		}
		
		int var3 = this.rand.nextInt(19);
		if (var3 == 0)
		{
			this.dropItem(ModItems.crystal_shard, 1);
		}
		
		int var4 = this.rand.nextInt(19);
		if (var4 == 0)
		{
			this.dropItem(ModArmory.razor_sword, 1);
		}
		
		int var5 = this.rand.nextInt(100);
		if (var5 == 0)
		{
			this.dropItem(ModItems.flerovium_shard, 1);
		}
		
		int var6 = this.rand.nextInt(100);
		if (var6 == 0)
		{
			this.dropItem(ModArmory.winged_blade, 1);
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
