package com.thexfactor117.ascension.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.thexfactor117.ascension.entities.hostile.EntityMiniGolem;
import com.thexfactor117.ascension.help.Reference;

public class RenderMiniGolem extends RenderLiving
{
	private static final ResourceLocation golemTexture = new ResourceLocation(Reference.MODID + ":textures/models/Golem.png"); 
	
	public RenderMiniGolem(RenderManager manager, ModelBase base, float f) 
	{
		super(manager, base, f);
	}

	protected ResourceLocation getEntityTexture(EntityMiniGolem entity) 
	{
		return golemTexture;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityMiniGolem) entity);
	}
}