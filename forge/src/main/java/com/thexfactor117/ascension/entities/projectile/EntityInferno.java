package com.thexfactor117.ascension.entities.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityInferno extends EntityThrowable
{
	private double explosionRadius = 1.0F;
	
	public EntityInferno(World par1World) 
	{
		super(par1World);
	}

    public EntityInferno(World par1World, EntityLivingBase par2EntityLivingBase, double par3, double par5, double par7)
    {
        super(par1World, par2EntityLivingBase);
    }

	public EntityInferno(World par1World, EntityLivingBase par2EntityLivingBase) 
	{
		super(par1World);
	}
    
    @Override
	protected void onImpact(MovingObjectPosition par1MovingObjectPosition) 
	{
    	this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, (float)this.explosionRadius, true);
		this.setDead();
	}
}
