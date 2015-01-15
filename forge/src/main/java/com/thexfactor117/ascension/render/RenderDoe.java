package com.thexfactor117.ascension.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.thexfactor117.ascension.entities.EntityDoe;
import com.thexfactor117.ascension.help.Reference;

public class RenderDoe extends RenderLiving
{
	private static final ResourceLocation doeTexture = new ResourceLocation(Reference.MODID + ":textures/models/Doe.png");

	public RenderDoe(ModelBase par1ModelBase, float par2) 
	{
		super(par1ModelBase, par2);
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
