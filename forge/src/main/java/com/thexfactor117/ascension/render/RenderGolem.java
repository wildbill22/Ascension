package com.thexfactor117.ascension.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.thexfactor117.ascension.entities.hostile.EntityGolem;
import com.thexfactor117.ascension.help.Reference;

public class RenderGolem extends RenderLiving
{
	private static final ResourceLocation golemTexture = new ResourceLocation(Reference.MODID + ":textures/models/Golem.png"); 
	
	public RenderGolem(ModelBase par1ModelBase, float par2) 
	{
		super(par1ModelBase, par2);
	}

	protected ResourceLocation getEntityTexture(EntityGolem entity) 
	{
		return golemTexture;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityGolem) entity);
	}
}
