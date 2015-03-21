package com.thexfactor117.ascension.entities.hostile;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
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
		if (!this.worldObj.isRemote)
        {
            --this.heightOffsetUpdateTime;

            if (this.heightOffsetUpdateTime <= 0)
            {
                this.heightOffsetUpdateTime = 100;
                this.heightOffset = 0.5F + (float)this.rand.nextGaussian() * 3.0F;
            }

            if (this.getEntityToAttack() != null && this.getEntityToAttack().posY + (double)this.getEntityToAttack().getEyeHeight() > this.posY + (double)this.getEyeHeight() + (double)this.heightOffset)
            {
                this.motionY += (0.30000001192092896D - this.motionY) * 0.30000001192092896D;
            }
        }

        if (!this.onGround && this.motionY < 0.0D)
        {
            this.motionY *= 0.6D;
        }
		
		for (int i = 0; i < 2; ++i)
        {
            this.worldObj.spawnParticle("snowballpoof", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
        }
		
		super.onLivingUpdate();
	}
	
	@Override
	protected void attackEntity(Entity entity, float f)
    {
        if (this.attackTime <= 0 && f < 2.0F && entity.boundingBox.maxY > this.boundingBox.minY && entity.boundingBox.minY < this.boundingBox.maxY)
        {
            this.attackTime = 20;
            this.attackEntityAsMob(entity);
        }
        else if (f < 30.0F)
        {
            double d0 = entity.posX - this.posX;
            double d2 = entity.posZ - this.posZ;

            if (this.attackTime == 0)
            {
                ++this.field_70846_g;

                if (this.field_70846_g == 1)
                {
                    this.attackTime = 60;
                    this.func_70844_e(true);
                }
                else if (this.field_70846_g <= 4)
                {
                    this.attackTime = 6;
                }
                else
                {
                    this.attackTime = 100;
                    this.field_70846_g = 0;
                    this.func_70844_e(false);
                }

                if (this.field_70846_g > 1)
                {
                    this.worldObj.playAuxSFXAtEntity((EntityPlayer)null, 1009, (int)this.posX, (int)this.posY, (int)this.posZ, 0);

                    for (int i = 0; i < 1; ++i)
                    {
                    	EntitySmallBlizzard blizzard = new EntitySmallBlizzard(this.worldObj, this);
                    	blizzard.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
                        this.worldObj.spawnEntityInWorld(blizzard);
                    }
                }
            }

            this.rotationYaw = (float)(Math.atan2(d2, d0) * 180.0D / Math.PI) - 90.0F;
            this.hasAttacked = true;
        }
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
}
