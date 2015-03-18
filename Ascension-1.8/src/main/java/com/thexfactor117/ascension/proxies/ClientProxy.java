package com.thexfactor117.ascension.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.init.Items;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import com.thexfactor117.ascension.entities.boss.EntityPharaoh;
import com.thexfactor117.ascension.entities.hostile.EntityBanshee;
import com.thexfactor117.ascension.entities.hostile.EntityBarbarian;
import com.thexfactor117.ascension.entities.hostile.EntityGhost;
import com.thexfactor117.ascension.entities.hostile.EntityGoblin;
import com.thexfactor117.ascension.entities.hostile.EntityGolem;
import com.thexfactor117.ascension.entities.hostile.EntityMiniGolem;
import com.thexfactor117.ascension.entities.hostile.EntityMummy;
import com.thexfactor117.ascension.entities.hostile.EntitySnowBlaze;
import com.thexfactor117.ascension.entities.hostile.EntityValkyrie;
import com.thexfactor117.ascension.entities.passive.EntityDoe;
import com.thexfactor117.ascension.entities.projectiles.EntityMediumBlizzard;
import com.thexfactor117.ascension.entities.projectiles.EntityMediumInferno;
import com.thexfactor117.ascension.entities.projectiles.EntityMediumMagic;
import com.thexfactor117.ascension.entities.projectiles.EntityMediumOblivion;
import com.thexfactor117.ascension.entities.projectiles.EntitySmallBlizzard;
import com.thexfactor117.ascension.entities.projectiles.EntitySmallInferno;
import com.thexfactor117.ascension.entities.projectiles.EntitySmallMagic;
import com.thexfactor117.ascension.entities.projectiles.EntitySmallOblivion;
import com.thexfactor117.ascension.init.ModItems;
import com.thexfactor117.ascension.models.ModelBanshee;
import com.thexfactor117.ascension.models.ModelBarbarian;
import com.thexfactor117.ascension.models.ModelDoe;
import com.thexfactor117.ascension.models.ModelGhost;
import com.thexfactor117.ascension.models.ModelGoblin;
import com.thexfactor117.ascension.models.ModelGolem;
import com.thexfactor117.ascension.models.ModelMiniGolem;
import com.thexfactor117.ascension.models.ModelMummy;
import com.thexfactor117.ascension.models.ModelPharaoh;
import com.thexfactor117.ascension.models.ModelValkyrie;
import com.thexfactor117.ascension.render.RenderBanshee;
import com.thexfactor117.ascension.render.RenderBarbarian;
import com.thexfactor117.ascension.render.RenderDoe;
import com.thexfactor117.ascension.render.RenderGhost;
import com.thexfactor117.ascension.render.RenderGoblin;
import com.thexfactor117.ascension.render.RenderGolem;
import com.thexfactor117.ascension.render.RenderMiniGolem;
import com.thexfactor117.ascension.render.RenderMummy;
import com.thexfactor117.ascension.render.RenderPharaoh;
import com.thexfactor117.ascension.render.RenderSnowBlaze;
import com.thexfactor117.ascension.render.RenderValkyrie;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ClientProxy extends CommonProxy
{	
	@Override
	public void registerRenderer() 
	{ 	
		// mob entities
		RenderingRegistry.registerEntityRenderingHandler(EntityValkyrie.class, new RenderValkyrie(Minecraft.getMinecraft().getRenderManager(), new ModelValkyrie(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityBarbarian.class, new RenderBarbarian(Minecraft.getMinecraft().getRenderManager(), new ModelBarbarian(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityGolem.class, new RenderGolem(Minecraft.getMinecraft().getRenderManager(), new ModelGolem(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityMummy.class, new RenderMummy(Minecraft.getMinecraft().getRenderManager(), new ModelMummy(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityGhost.class, new RenderGhost(Minecraft.getMinecraft().getRenderManager(), new ModelGhost(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityBanshee.class, new RenderBanshee(Minecraft.getMinecraft().getRenderManager(), new ModelBanshee(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityMiniGolem.class, new RenderMiniGolem(Minecraft.getMinecraft().getRenderManager(), new ModelMiniGolem(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntitySnowBlaze.class, new RenderSnowBlaze(Minecraft.getMinecraft().getRenderManager(), new ModelBlaze(), 0));
		RenderingRegistry.registerEntityRenderingHandler(EntityGoblin.class, new RenderGoblin(Minecraft.getMinecraft().getRenderManager(), new ModelGoblin(), 0));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityDoe.class, new RenderDoe(Minecraft.getMinecraft().getRenderManager(), new ModelDoe(), 0));
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPharaoh.class, new RenderPharaoh(Minecraft.getMinecraft().getRenderManager(), new ModelPharaoh(), 0));
		
		// projectile entities
		RenderingRegistry.registerEntityRenderingHandler(EntitySmallMagic.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ModItems.smallMagic, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMediumMagic.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ModItems.mediumMagic, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntitySmallOblivion.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ModItems.smallOblivion, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMediumOblivion.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ModItems.mediumOblivion, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntitySmallBlizzard.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ModItems.smallBlizzard, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMediumBlizzard.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), ModItems.mediumBlizzard, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntitySmallInferno.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), Items.fire_charge, Minecraft.getMinecraft().getRenderItem()));
		RenderingRegistry.registerEntityRenderingHandler(EntityMediumInferno.class, new RenderSnowball(Minecraft.getMinecraft().getRenderManager(), Items.fire_charge, Minecraft.getMinecraft().getRenderItem()));
	}
	
	public void registerTileEntitySpecialRenderer() 
	{
		
	}
}
