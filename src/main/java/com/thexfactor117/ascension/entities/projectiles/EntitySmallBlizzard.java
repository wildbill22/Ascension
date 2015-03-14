package com.thexfactor117.ascension.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */

public class EntitySmallBlizzard extends EntityThrowable
{
	public EntityLivingBase shootingEntity;
	public int ticksInAir;
	
	public EntitySmallBlizzard(World world)
    {
        super(world);
    }
    
    public EntitySmallBlizzard(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }
   
    public EntitySmallBlizzard(World world, double par2, double par4, double par6)
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
    			if (moveObjPos.entityHit instanceof EntityLivingBase)
    			{
    				EntityLivingBase enemy = (EntityLivingBase) moveObjPos.entityHit;
    				
    				if (enemy != null)
    				{
    					moveObjPos.entityHit.attackEntityFrom(DamageSource.magic, 5.0F);
    					enemy.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*5, 0));
    				}
    			}
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
    		if (!this.isDead && !this.inGround)
        	{
    			for (int i = 0; i < 4; ++i)
    			{
    				this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
    			}
        	}
    	}
    }
}
