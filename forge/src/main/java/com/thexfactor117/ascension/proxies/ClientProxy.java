package com.thexfactor117.ascension.proxies;

import com.thexfactor117.ascension.entities.boss.EntityPharaoh;
import com.thexfactor117.ascension.entities.hostile.EntityBanshee;
import com.thexfactor117.ascension.entities.hostile.EntityBarbarian;
import com.thexfactor117.ascension.entities.hostile.EntityGhost;
import com.thexfactor117.ascension.entities.hostile.EntityGolem;
import com.thexfactor117.ascension.entities.hostile.EntityMummy;
import com.thexfactor117.ascension.entities.hostile.EntityValkyrie;
import com.thexfactor117.ascension.entities.passive.EntityDoe;
import com.thexfactor117.ascension.models.ModelBanshee;
import com.thexfactor117.ascension.models.ModelBarbarian;
import com.thexfactor117.ascension.models.ModelDoe;
import com.thexfactor117.ascension.models.ModelGhost;
import com.thexfactor117.ascension.models.ModelGolem;
import com.thexfactor117.ascension.models.ModelMummy;
import com.thexfactor117.ascension.models.ModelPharaoh;
import com.thexfactor117.ascension.models.ModelValkyrie;
import com.thexfactor117.ascension.render.RenderBanshee;
import com.thexfactor117.ascension.render.RenderBarbarian;
import com.thexfactor117.ascension.render.RenderDoe;
import com.thexfactor117.ascension.render.RenderGhost;
import com.thexfactor117.ascension.render.RenderGolem;
import com.thexfactor117.ascension.render.RenderMummy;
import com.thexfactor117.ascension.render.RenderPharaoh;
import com.thexfactor117.ascension.render.RenderValkyrie;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public void registerRenderer() 
	{
		//Entities
		RenderingRegistry.registerEntityRenderingHandler(EntityValkyrie.class, new RenderValkyrie(new ModelValkyrie(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityBarbarian.class, new RenderBarbarian(new ModelBarbarian(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityGolem.class, new RenderGolem(new ModelGolem(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new RenderMummy(new ModelMummy(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, new RenderGhost(new ModelGhost(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityBanshee.class, new RenderBanshee(new ModelBanshee(), 0));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDoe.class, new RenderDoe(new ModelDoe(), 0));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPharaoh.class, new RenderPharaoh(new ModelPharaoh(), 0));
	}
	
	public void registerTileEntitySpecialRenderer() 
	{
		
	}
}
