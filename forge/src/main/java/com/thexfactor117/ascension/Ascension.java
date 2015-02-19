/**
 * Copyright 2014-2015 TheXFactor117
 */

package com.thexfactor117.ascension;

import com.thexfactor117.ascension.crafting.ModArmorRecipes;
import com.thexfactor117.ascension.crafting.ModRecipes;
import com.thexfactor117.ascension.crafting.ModWeaponRecipes;
import com.thexfactor117.ascension.generation.AscensionWorldGeneration;
import com.thexfactor117.ascension.generation.VanillaChestLootGen;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModBlocks;
import com.thexfactor117.ascension.init.ModBosses;
import com.thexfactor117.ascension.init.ModEntities;
import com.thexfactor117.ascension.init.ModItems;
import com.thexfactor117.ascension.init.ModStructureItems;
import com.thexfactor117.ascension.proxies.ClientProxy;
import com.thexfactor117.ascension.proxies.CommonProxy;
import com.thexfactor117.ascension.structures.StructureList;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Ascension
{
	@SidedProxy(clientSide = "com.thexfactor117.ascension.proxies.ClientProxy", serverSide = "com.thexfactor117.ascension.proxies.CommonProxy")
	public static CommonProxy ascensionProxy;
	
	@Instance(Reference.MODID)
	public static Ascension instance;
	
	AscensionWorldGeneration eventWorldGen = new AscensionWorldGeneration();
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{		
		ModItems.init();
		ModBlocks.init();
		ModArmory.init();
		ModEntities.init();
		ModBosses.init();
		//ModStructureItems.init(); // Comment out for releases
		StructureList.preInit(event);
		VanillaChestLootGen.init();
		
		GameRegistry.registerWorldGenerator(this.eventWorldGen, 0);
		
		ascensionProxy.registerRenderer();
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		ModRecipes.init();
		ModWeaponRecipes.init();
		ModArmorRecipes.init();
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}	
}
