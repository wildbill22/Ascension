package com.thexfactor117.ascension.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.thexfactor117.ascension.entities.passive.EntityDoe;
import com.thexfactor117.ascension.help.Reference;

public class RenderDoe extends RenderLiving
{
	private static final ResourceLocation doeTexture = new ResourceLocation(Reference.MODID + ":textures/models/Doe.png");

	public RenderDoe(RenderManager manager, ModelBase base, float f) 
	{
		super(manager, base, f);
	}
	
	protected ResourceLocation getEntityTexture(EntityDoe entity) 
	{
		return doeTexture;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityDoe) entity);
	}
}
