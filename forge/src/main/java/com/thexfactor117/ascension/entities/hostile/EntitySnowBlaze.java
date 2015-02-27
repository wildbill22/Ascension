package com.thexfactor117.ascension.entities.hostile;

import com.thexfactor117.ascension.handlers.ConfigHandler;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.world.World;

public class EntitySnowBlaze extends EntityBlaze
{
	public EntitySnowBlaze(World world)
	{
		super(world);
		this.experienceValue = 30;
	}
	
	@Override
	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		//this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(ConfigHandler.bansheeDamage);
		//this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(ConfigHandler.bansheeHealth);
	}
	
	/**
	 * Calls Blaze#onLivingUpdate to change particle effects to snowballs instead of smoke
	 */
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
		
		for (int i = 0; i < 2; ++i)
		{
            this.worldObj.spawnParticle("snowballpoof", this.posX + (this.rand.nextDouble() - 0.5D) * (double)this.width, this.posY + this.rand.nextDouble() * (double)this.height, this.posZ + (this.rand.nextDouble() - 0.5D) * (double)this.width, 0.0D, 0.0D, 0.0D);
		}
	}
}
