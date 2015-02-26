package com.thexfactor117.ascension.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMediumInferno extends EntityThrowable
{
	public EntityMediumInferno(World world)
    {
        super(world);
    }
    
    public EntityMediumInferno(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }
   
    public EntityMediumInferno(World world, double par2, double par4, double par6)
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
    			moveObjPos.entityHit.attackEntityFrom(DamageSource.generic, 7.0F);
    			moveObjPos.entityHit.setFire(5);
    		}
    		
    		this.setDead();
    	}
    }
}
