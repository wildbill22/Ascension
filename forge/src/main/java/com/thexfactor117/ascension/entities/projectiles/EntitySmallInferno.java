package com.thexfactor117.ascension.entities.projectiles;

import com.thexfactor117.ascension.help.LogHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySmallInferno extends EntityThrowable
{	
	public EntitySmallInferno(World world)
    {
        super(world);
    }
    
    public EntitySmallInferno(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }
   
    public EntitySmallInferno(World world, double par2, double par4, double par6)
    {
        super(world, par2, par4, par6);
    }
    
    @Override
    protected void onImpact(MovingObjectPosition moveObjPos)
    {	
    	if (moveObjPos.entityHit != null)
    	{
   			moveObjPos.entityHit.attackEntityFrom(DamageSource.generic, 5.0F);
   			moveObjPos.entityHit.setFire(3);
   		}
    	
    	for (int i = 0; i < 8; ++i)
    	{
    		this.worldObj.spawnParticle("smoke", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
    		LogHelper.info("Particles have spawned!");
    	}
    	
    	if (!this.worldObj.isRemote)
    	{
    		this.setDead();
    	}
    }
}
