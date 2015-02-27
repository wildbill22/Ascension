package com.thexfactor117.ascension.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntitySmallMagic extends EntityThrowable
{
	public EntitySmallMagic(World world)
    {
        super(world);
    }
    
    public EntitySmallMagic(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }
   
    public EntitySmallMagic(World world, double par2, double par4, double par6)
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
    			moveObjPos.entityHit.attackEntityFrom(DamageSource.magic, 5.0F);
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
        			this.worldObj.spawnParticle("mobSpell", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
    			}
    		}
    	}
    }
}
