package com.thexfactor117.ascension.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import com.thexfactor117.ascension.help.LogHelper;

public class EntitySmallLightning extends EntityThrowable
{
	public EntitySmallLightning(World world)
    {
        super(world);
    }
    
    public EntitySmallLightning(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }
   
    public EntitySmallLightning(World world, double par2, double par4, double par6)
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
    					moveObjPos.entityHit.attackEntityFrom(DamageSource.generic, 5.0F);
    					enemy.addPotionEffect(new PotionEffect(Potion.weakness.id, 20*5, 0));
    				}
    			}
    		}	
    		this.setDead();
    	}
    }
}
