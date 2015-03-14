package com.thexfactor117.ascension.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.thexfactor117.ascension.entities.hostile.EntityValkyrie;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.models.ModelValkyrie;

public class RenderValkyrie extends RenderLiving
{
	private static final ResourceLocation valkyrieTexture = new ResourceLocation(Reference.MODID + ":textures/models/Valkyrie.png");
	
	//protected ModelValkyrie modelEntity;
	
	public RenderValkyrie(ModelBase par1ModelBase, float par2) 
	{
		super(par1ModelBase, par2);
		//modelEntity = ((ModelValkyrie) mainModel);
	}
	
	/*
	public void renderValkyrie(EntityValkyrie entity, double x, double y, double z, float u, float v)
	{
		super.doRender(entity, x, y, z, u, v);
	}
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v)
	{
		renderValkyrie((EntityValkyrie) entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v)
	{
		renderValkyrie((EntityValkyrie) entity, x, y, z, u, v);
	}
	*/

	protected ResourceLocation getEntityTexture(EntityValkyrie entity) 
	{
		return valkyrieTexture;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityValkyrie) entity);
	}
}
