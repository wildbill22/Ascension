package com.thexfactor117.ascension.entities.boss;

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
import net.minecraft.entity.boss.IBossDisplayData;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.world.World;

public class EntityPharaoh extends EntityMob implements IBossDisplayData
{
	public EntityPharaoh(World world)
	{
		super(world);
		this.getNavigator().setCanSwim(true);
		this.experienceValue = 100;
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
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(32.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.2D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(200.0D);
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
	 * Hopefully will help entities attack better...
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
    	int var = this.rand.nextInt(3);
    	if (var == 0)
    	{
    		this.dropItem(ModItems.crystal, 1);
    	}
    	
    	int var1 = this.rand.nextInt(3);
    	if (var == 0)
    	{
    		this.dropItem(ModItems.soulGem, 1);
    	}
    	
    	int var2 = this.rand.nextInt(9);
    	if (var2 == 0)
    	{
    		this.dropItem(Items.gold_ingot, 9);
    	}
    	if (var2 == 9)
    	{
    		this.dropItem(Items.iron_ingot, 9);
    	}
    	
    	int var3 = this.rand.nextInt(19);
    	if (var3 == 0)
    	{
    		this.dropItem(ModItems.fleroviumIngot, 1);
    	}
    	
    	int var4 = this.rand.nextInt(19);
    	if (var4 == 0)
    	{
    		this.dropItem(ModArmory.etherealBlade, 1);
    	}
    	
    	int var5 = this.rand.nextInt(19);
    	if (var5 == 0)
    	{
    		this.dropItem(ModArmory.shadowBlade, 1);
    	}
    	
    	int var6 = this.rand.nextInt(19);
    	if (var6 == 0)
    	{
    		this.dropItem(ModArmory.wingedBlade, 1);
    	}
    	
    	int var7 = this.rand.nextInt(9);
    	if (var7 == 0)
    	{
    		this.dropItem(Items.diamond, 3);
    	}
    	if (var7 == 0)
    	{
    		this.dropItem(Items.emerald, 3);
    	}
    	
    	int var8 = this.rand.nextInt(1);
    	if (var8 == 0)
    	{
    		this.dropItem(ModItems.omega, 1);
    	}
    }
}
