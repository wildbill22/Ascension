package com.thexfactor117.ascension.entities.boss;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
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
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import com.thexfactor117.ascension.entities.hostile.EntityMummy;
import com.thexfactor117.ascension.help.LogHelper;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;

public class EntityPharaoh extends EntityMob implements IBossDisplayData
{
	//used to cool down the mummy spawning
	int coolDown = 100;
	int count = 0;
	
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
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.23D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(300.0D);
	}
	
	@Override
	public boolean isAIEnabled()
	{
		return true;
	}
	
	@Override
	public boolean canDespawn()
	{
		return false;
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
    
    /**
     * Updates every tick the Pharoah is alive. Once the cool 
     * down has finished, the Pharoah will spawn a mummy at 
     * its coordinates. The cool down then resets, and will 
     * tick down again and repeat.
     */
    @Override
    public void onLivingUpdate()
    {
    	super.onLivingUpdate();
    	
    	if (coolDown > 0)
    	{
    		this.coolDown = coolDown - 1;
    	}
    	
    	if (count > 1)
    	{
    		this.count = count - 1;
    	}
    	
    	if ((coolDown < 2) && (!this.worldObj.isRemote))
    	{
    		this.count = 60;
    		this.coolDown = 200;
    	}

    	if ((count == 1) && (!this.worldObj.isRemote))
    	{
    		EntityMummy mummy = new EntityMummy(this.worldObj);
    		
    		//spawns the Mummy at the Pharaoh's coordinates
    		mummy.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rand.nextFloat() * 360, 0.0F);
    		this.worldObj.spawnEntityInWorld(mummy);
    		LogHelper.info("The Pharaoh has summoned a mummy!");
    		this.count = 0;
    	}
    }
    
    /**
     * Gives the Pharoah a special attack. The
     * Pharoah has a 25% chance to inflict
     * blindness and nausea for the stated
     * amount of time.
     */
    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
    	int attack = this.rand.nextInt(3);
    	
    	if (attack == 0)
    	{
    		if (super.attackEntityAsMob(entity))
           	{
            	if (entity instanceof EntityLivingBase)
            	{
            		EntityLivingBase enemy = (EntityLivingBase) entity;        			
           			
            		if (enemy != null)
           			{
           				enemy.addPotionEffect(new PotionEffect(Potion.confusion.id, 20*10, 0));
           				enemy.addPotionEffect(new PotionEffect(Potion.blindness.id, 20*3, 0));
           				
           				return true;
           			}
           		}
            }
    	} else
    	{
    		return super.attackEntityAsMob(entity);
    	}
    	return false;
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
    
    @Override
    protected String getLivingSound()
    {
    	return Reference.MODID + ":" + "PharoahSay";
    }
}
