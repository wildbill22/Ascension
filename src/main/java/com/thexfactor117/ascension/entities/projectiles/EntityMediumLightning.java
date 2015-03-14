package com.thexfactor117.ascension.entities.projectiles;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

import net.minecraft.entity.EntityLivingBase;
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

public class EntityMediumLightning extends EntityThrowable
{
	public EntityMediumLightning(World world)
    {
        super(world);
    }
    
    public EntityMediumLightning(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }
   
    public EntityMediumLightning(World world, double par2, double par4, double par6)
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
    					moveObjPos.entityHit.attackEntityFrom(DamageSource.magic, 9.0F);
    					
    					int var = this.rand.nextInt(6);
    					if (var == 0)
    					{
    						enemy.addPotionEffect(new PotionEffect(Potion.blindness.id, 20*5, 1));
    						enemy.addPotionEffect(new PotionEffect(Potion.confusion.id, 20*8, 1));
    					}
    					
    					if (var == 1)
    					{
    						enemy.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*10, 1));
    					}
    					
    					if (var == 2)
    					{
    						enemy.addPotionEffect(new PotionEffect(Potion.blindness.id, 20*5, 1));
    						enemy.addPotionEffect(new PotionEffect(Potion.confusion.id, 20*8, 1));
    						enemy.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*10, 1));
    					}
    				}
    			}
    		}	
    		this.setDead();
    	}
    }
}
