package com.thexfactor117.ascension.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.thexfactor117.ascension.entities.hostile.EntityMiniGolem;
import com.thexfactor117.ascension.help.Reference;

public class RenderMiniGolem extends RenderLiving
{
private static final ResourceLocation golemTexture = new ResourceLocation(Reference.MODID + ":textures/models/Golem.png"); 
	
	public RenderMiniGolem(ModelBase par1ModelBase, float par2) 
	{
		super(par1ModelBase, par2);
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
