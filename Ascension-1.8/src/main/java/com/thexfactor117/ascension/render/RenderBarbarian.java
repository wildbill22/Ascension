package com.thexfactor117.ascension.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.thexfactor117.ascension.entities.hostile.EntityBarbarian;
import com.thexfactor117.ascension.help.Reference;

public class RenderBarbarian extends RenderLiving
{
	private static final ResourceLocation barbarianTexture = new ResourceLocation(Reference.MODID + ":textures/models/Barbarian.png"); 
	
	public RenderBarbarian(RenderManager manager, ModelBase base, float f) 
	{
		super(manager, base, f);
	}

	protected ResourceLocation getEntityTexture(EntityBarbarian entity) 
	{
		return barbarianTexture;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityBarbarian) entity);
	}
}
