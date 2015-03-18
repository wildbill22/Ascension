package com.thexfactor117.ascension.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.thexfactor117.ascension.entities.hostile.EntityGhost;
import com.thexfactor117.ascension.help.Reference;

public class RenderGhost extends RenderLiving
{
	private static final ResourceLocation ghostTexture = new ResourceLocation(Reference.MODID + ":textures/models/Ghost.png"); 
	
	public RenderGhost(ModelBase par1ModelBase, float par2) 
	{
		super(par1ModelBase, par2);
	}

	protected ResourceLocation getEntityTexture(EntityGhost entity) 
	{
		return ghostTexture;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityGhost) entity);
	}
}
