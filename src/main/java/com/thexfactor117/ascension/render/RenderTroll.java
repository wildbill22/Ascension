package com.thexfactor117.ascension.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.thexfactor117.ascension.entities.hostile.EntityTroll;
import com.thexfactor117.ascension.help.Reference;

public class RenderTroll extends RenderLiving
{
	private static final ResourceLocation trollTexture = new ResourceLocation(Reference.MODID + ":textures/models/Troll.png");
	
	public RenderTroll(ModelBase par1ModelBase, float par2) 
	{
		super(par1ModelBase, par2);
	}

	protected ResourceLocation getEntityTexture(EntityTroll entity) 
	{
		return trollTexture;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityTroll) entity);
	}
}
