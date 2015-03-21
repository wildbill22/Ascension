package com.thexfactor117.ascension.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */

public class EntityMediumOblivion extends EntityThrowable
{
	public EntityMediumOblivion(World world)
    {
        super(world);
    }
    
    public EntityMediumOblivion(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }
   
    public EntityMediumOblivion(World world, double par2, double par4, double par6)
    {
        super(world, par2, par4, par6);
    }
    
    @Override
    protected void onImpact(MovingObjectPosition moveObjPos)
    {	
    	if (!this.worldObj.isRemote)
    	{
    		if (moveObjPos.entityHit != null)
    		{
    			moveObjPos.entityHit.attackEntityFrom(DamageSource.magic, 9.0F);
    		}
    		this.setDead();
    	}
    }
    
    @Override
    public void onUpdate()
    {
    	super.onUpdate();
    	
    	if (this.worldObj.isRemote)
    	{
    		if (!this.inGround && !this.isDead)
    		{
    			for (int i = 0; i < 4; ++i)
    			{
        			this.worldObj.spawnParticle(EnumParticleTypes.SPELL_MOB, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
    			}
    		}
    	}
    }
}
