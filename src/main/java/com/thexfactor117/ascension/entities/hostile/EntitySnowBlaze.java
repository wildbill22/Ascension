package com.thexfactor117.ascension.entities.hostile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

import com.thexfactor117.ascension.entities.projectiles.EntitySmallBlizzard;
import com.thexfactor117.ascension.handlers.ConfigHandler;

/**
 * 
 * @author TheXFactor117
 *
 */

public class EntitySnowBlaze extends EntityMob
{	
	private static final String name = "Snow Blaze";
	
	public float heightOffset = 0.5F;
	public int heightOffsetUpdateTime;
	
	public EntitySnowBlaze(World world)
	{
		super(world);
		this.experienceValue = 30;
		this.tasks.addTask(4, new EntitySnowBlaze.AIBlizzardAttack());
        this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ConfigHandler.bansheeHealth);
	}
	
	/**
	 * Updates the entity motions and particle effects
	 */
	@Override
	public void onLivingUpdate()
	{
		if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }

        if (this.worldObj.isRemote)
        {
            if (this.rand.nextInt(24) == 0 && !this.isSilent())
            {
                this.worldObj.playSound(this.posX + 0.5D, this.posY + 0.5D, this.posZ + 0.5D, "fire.fire", 1.0F + this.rand.nextFloat(), this.rand.nextFloat() * 0.7F + 0.3F, false);
            }

            for (int i = 0; i < 2; ++i)
            {
                this.worldObj.spawnParticle(EnumParticleTypes.SNOWBALL, this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D, new int[0]);
            }
        }
        super.onLivingUpdate();
	}
	
	/**
	 * Updates the AI tasks to add height movement and attacks
	 */
	@Override
	protected void updateAITasks()
    {
        --this.heightOffsetUpdateTime;

        if (this.heightOffsetUpdateTime <= 0)
        {
            this.heightOffsetUpdateTime = 100;
            this.heightOffset = 0.5F + (float)this.rand.nextGaussian() * 3.0F;
        }

        EntityLivingBase entity = this.getAttackTarget();

        if (entity != null && entity.posY + (double)entity.getEyeHeight() > this.posY + (double)this.getEyeHeight() + (double)this.heightOffset)
        {
            this.motionY += (0.30000001192092896D - this.motionY) * 0.30000001192092896D;
            this.isAirBorne = true;
        }
        super.updateAITasks();
    }
	
	@Override
	protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, new Byte((byte)0));
    }
	
	public boolean func_70845_n()
    {
        return (this.dataWatcher.getWatchableObjectByte(16) & 1) != 0;
    }
	
	public void func_70844_e(boolean i)
    {
        byte b0 = this.dataWatcher.getWatchableObjectByte(16);

        if (i)
        {
            b0 = (byte)(b0 | 1);
        }
        else
        {
            b0 &= -2;
        }

        this.dataWatcher.updateObject(16, Byte.valueOf(b0));
    }
	
	@Override
    protected String getLivingSound()
    {
        return "mob.blaze.breathe";
    }

	@Override
    protected String getHurtSound()
    {
        return "mob.blaze.hit";
    }

	@Override
    protected String getDeathSound()
    {
        return "mob.blaze.death";
    }
	
	public String getName()
    {
    	return name;
    }
	
	/**
	 * Adds an AI attack based on the Blaze's AI attack.
	 * 
	 * @author TheXFactor117
	 *
	 */
	class AIBlizzardAttack extends EntityAIBase
	{
		public EntitySnowBlaze i = EntitySnowBlaze.this;
		public int j;
		public int attackTime;
		
		public AIBlizzardAttack()
		{
			this.setMutexBits(3);
		}
		
		@Override
		public boolean shouldExecute() 
		{
			EntityLivingBase entity = this.i.getAttackTarget();
            return entity != null && entity.isEntityAlive();
		}
		
		@Override
		public void startExecuting()
		{
			this.j = 0;
		}
		
		@Override
		public void resetTask()
		{
			this.i.func_70844_e(false);
		}
		
		@Override
		public void updateTask()
		{
			--this.attackTime;
            EntityLivingBase entity = this.i.getAttackTarget();
            double d0 = this.i.getDistanceSqToEntity(entity);

            if (d0 < 4.0D)
            {
                if (this.attackTime <= 0)
                {
                    this.attackTime = 20;
                    this.i.attackEntityAsMob(entity);
                }
                this.i.getMoveHelper().setMoveTo(entity.posX, entity.posY, entity.posZ, 1.0D);
            }
            else if (d0 < 256.0D)
            {	
            	double d1 = entity.posX - this.i.posX;
                double d2 = entity.posZ - this.i.posZ;
            	
            	if (this.attackTime <= 0)
                {
                    ++this.j;

                    if (this.j == 1)
                    {
                        this.attackTime = 60;
                        this.i.func_70844_e(true);
                    }
                    else if (this.j <= 4)
                    {
                        this.attackTime = 6;
                    }
                    else
                    {
                        this.attackTime = 100;
                        this.j = 0;
                        this.i.func_70844_e(false);
                    }

                    if (this.j > 1)
                    {
                    	this.i.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, new BlockPos((int)this.i.posX, (int)this.i.posY, (int)this.i.posZ), 0);

                        for (int i = 0; i < 1; ++i)
                        {
                        	EntitySmallBlizzard blizzard = new EntitySmallBlizzard(this.i.worldObj, this.i);
                            blizzard.posY = this.i.posY + (double)(this.i.height / 2.0F) + 0.5D;
                            this.i.worldObj.spawnEntityInWorld(blizzard);
                        }
                        
                        this.i.rotationYaw = (float)(Math.atan2(d2, d1) * 180.0D / Math.PI) - 90.0F;
                    }
                }
                this.i.getLookHelper().setLookPositionWithEntity(entity, 10.0F, 10.0F);
            }
            else
            {
                this.i.getNavigator().clearPathEntity();
                this.i.getMoveHelper().setMoveTo(entity.posX, entity.posY, entity.posZ, 1.0D);
            }
            super.updateTask();
        }
    }
}