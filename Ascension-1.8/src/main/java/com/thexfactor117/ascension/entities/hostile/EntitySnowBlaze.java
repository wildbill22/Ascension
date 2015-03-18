package com.thexfactor117.ascension.entities.hostile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

import com.thexfactor117.ascension.handlers.ConfigHandler;

/**
 * 
 * @author TheXFactor117
 *
 */

public class EntitySnowBlaze extends EntityMob
{
	private float heightOffset = 0.5F;
    private int heightOffsetUpdateTime;
	// wish I knew what this did :/
    private int field_70846_g;
	
	public EntitySnowBlaze(World world)
	{
		super(world);
		this.experienceValue = 30;
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ConfigHandler.bansheeHealth);
	}
	
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
	
	class AIBlizzardAttack extends EntityAIBase
	{
		public EntitySnowBlaze i = EntitySnowBlaze.this;
		public int j;
		public int k;
		
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
			
		}
	}
}
