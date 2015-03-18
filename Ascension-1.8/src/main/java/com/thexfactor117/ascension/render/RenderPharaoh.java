package com.thexfactor117.ascension.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.BossStatus;
import net.minecraft.util.ResourceLocation;

import com.thexfactor117.ascension.entities.boss.EntityPharaoh;
import com.thexfactor117.ascension.help.Reference;

public class RenderPharaoh extends RenderLiving
{
	private static final ResourceLocation pharaohTexture = new ResourceLocation(Reference.MODID + ":textures/models/Pharaoh.png");

	public RenderPharaoh(RenderManager manager, ModelBase base, float f) 
	{
		super(manager, base, f);
	}
	
	public void renderPharaoh(EntityPharaoh entity, double par2, double par4, double par6, float par8, float par9)
	{
		BossStatus.setBossStatus(entity, true);
		
		super.doRender(entity, par2, par4, par6, par8, par9);
	}
	
	public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) 
	{
		renderPharaoh((EntityPharaoh) par1Entity, par2, par4, par6, par8, par9);
	}
	
	protected ResourceLocation getEntityTexture(EntityPharaoh entity) 
	{
		return pharaohTexture;
	}
	
	protected ResourceLocation getEntityTexture(Entity entity)
	{
		return this.getEntityTexture((EntityPharaoh) entity);
	}
}
