package com.thexfactor117.ascension.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.thexfactor117.ascension.entities.hostile.EntitySnowBlaze;
import com.thexfactor117.ascension.help.Reference;

public class RenderSnowBlaze extends RenderLiving
{
	private static final ResourceLocation snowBlazeTexture = new ResourceLocation(Reference.MODID + ":textures/models/SnowBlaze.png"); 

	public RenderSnowBlaze(RenderManager manager, ModelBase base, float f) 
	{
		super(manager, base, f);
	}
	
	protected ResourceLocation getEntityTexture(EntitySnowBlaze entity) 
	{
		return snowBlazeTexture;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntitySnowBlaze) entity);
	}
}
