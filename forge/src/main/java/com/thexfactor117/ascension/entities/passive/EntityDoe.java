package com.thexfactor117.ascension.entities.passive;

import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.world.World;

import com.thexfactor117.ascension.init.ModItems;

public class EntityDoe extends EntityAnimal
{
	public EntityDoe(World world) 
	{
		super(world);
		this.getNavigator().setAvoidsWater(false);
		this.setSize(2F, 2F);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(4, new EntityAILookIdle(this));
	}

	@Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(10.0D);
        this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.25D);
    }
	
	@Override
	protected void dropFewItems(boolean par1, int par2)
	{
		int var1 = this.rand.nextInt(2);
		if (var1 == 0)
		{
			this.dropItem(ModItems.rawVenison, 1);
		}
		
		int var2 = this.rand.nextInt(3);
		if (var2 == 0)
		{
			this.dropItem(ModItems.rawVenison, 2);
		}
		
		int var3 = this.rand.nextInt(3);
		if (var3 == 0)
		{
			this.dropItem(Items.leather, 1);
		}
	}
	
	public boolean isAIEnabled()
	{
		return true;
	}

	@Override
	public EntityAgeable createChild(EntityAgeable p_90011_1_) 
	{
		return null;
	}
}
