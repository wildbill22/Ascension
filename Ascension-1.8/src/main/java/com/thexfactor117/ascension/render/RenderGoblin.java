package com.thexfactor117.ascension.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.thexfactor117.ascension.entities.hostile.EntityGoblin;
import com.thexfactor117.ascension.help.Reference;

public class RenderGoblin extends RenderLiving
{
	private static final ResourceLocation goblinTexture = new ResourceLocation(Reference.MODID + ":textures/models/Goblin.png"); 
	
	public RenderGoblin(RenderManager manager, ModelBase base, float f) 
	{
		super(manager, base, f);
	}

	protected ResourceLocation getEntityTexture(EntityGoblin entity) 
	{
		return goblinTexture;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityGoblin) entity);
	}
}
