package com.thexfactor117.ascension.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBlizzard extends EntityThrowable
{
	public EntityBlizzard(World world)
    {
        super(world);
    }
    
    public EntityBlizzard(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }
   
    public EntityBlizzard(World world, double par2, double par4, double par6)
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
    					enemy.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*50, 0));
    				}
    			}
    		}	
    		this.setDead();
    	}
    }
}
