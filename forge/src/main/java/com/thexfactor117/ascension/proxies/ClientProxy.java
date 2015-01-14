package com.thexfactor117.ascension.proxies;

import com.thexfactor117.ascension.entities.EntityValkyrie;
import com.thexfactor117.ascension.models.ModelValkyrie;
import com.thexfactor117.ascension.render.RenderValkyrie;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public void registerRenderer() 
	{
		//Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityValkyrie.class, new RenderValkyrie(new ModelValkyrie(), 0.3F));
	}
	
	public void registerTileEntitySpecialRenderer() 
	{
		
	}
}
