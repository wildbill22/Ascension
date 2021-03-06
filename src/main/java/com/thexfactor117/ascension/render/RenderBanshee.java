package com.thexfactor117.ascension.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.thexfactor117.ascension.entities.hostile.EntityBanshee;
import com.thexfactor117.ascension.help.Reference;

public class RenderBanshee extends RenderLiving
{
	private static final ResourceLocation bansheeTexture = new ResourceLocation(Reference.MODID + ":textures/models/Banshee.png"); 
	
	public RenderBanshee(ModelBase par1ModelBase, float par2) 
	{
		super(par1ModelBase, par2);
	}

	protected ResourceLocation getEntityTexture(EntityBanshee entity) 
	{
		return bansheeTexture;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityBanshee) entity);
	}
}
