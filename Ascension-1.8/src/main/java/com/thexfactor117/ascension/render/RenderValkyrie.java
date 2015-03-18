package com.thexfactor117.ascension.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import com.thexfactor117.ascension.entities.hostile.EntityValkyrie;
import com.thexfactor117.ascension.help.Reference;

public class RenderValkyrie extends RenderLiving
{
	private static final ResourceLocation valkyrieTexture = new ResourceLocation(Reference.MODID + ":textures/models/Valkyrie.png");
		
	public RenderValkyrie(RenderManager manager, ModelBase base, float f) 
	{
		super(manager, base, f);
	}
	
	protected ResourceLocation getEntityTexture(EntityValkyrie entity) 
	{
		return valkyrieTexture;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityValkyrie) entity);
	}
}
