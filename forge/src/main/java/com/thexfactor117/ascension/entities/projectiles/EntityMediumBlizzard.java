package com.thexfactor117.ascension.entities.projectiles;

import com.thexfactor117.ascension.help.LogHelper;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityMediumBlizzard extends EntityThrowable
{
	public EntityMediumBlizzard(World world)
    {
        super(world);
    }
    
    public EntityMediumBlizzard(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }
   
    public EntityMediumBlizzard(World world, double par2, double par4, double par6)
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
    					moveObjPos.entityHit.attackEntityFrom(DamageSource.magic, 8.0F);
    					enemy.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 20*10, 1));
    				}
    			}
    		}	
    		this.setDead();
    	}
    }
}
