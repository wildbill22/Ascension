/**
 * Copyright 2014-2015 TheXFactor117
 */

package com.thexfactor117.ascension;

import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.MinecraftForge;

import com.thexfactor117.ascension.crafting.ModArmorRecipes;
import com.thexfactor117.ascension.crafting.ModRecipes;
import com.thexfactor117.ascension.crafting.ModWeaponRecipes;
import com.thexfactor117.ascension.generation.AscensionWorldGeneration;
import com.thexfactor117.ascension.generation.VanillaChestLootGen;
import com.thexfactor117.ascension.handlers.ConfigHandler;
import com.thexfactor117.ascension.handlers.DropHandler;
import com.thexfactor117.ascension.help.LogHelper;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModBlocks;
import com.thexfactor117.ascension.init.ModEntities;
import com.thexfactor117.ascension.init.ModItems;
import com.thexfactor117.ascension.init.ModStructureItems;
import com.thexfactor117.ascension.proxies.CommonProxy;
import com.thexfactor117.ascension.structures.StructureList;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLInterModComms;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * @author TheXFactor117
 * @author WILLIAM
 *
 */

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
		LogHelper.info("Beginning initialization phase 1...");
		ConfigHandler.initProps(event.getModConfigurationDirectory());

		ModItems.init();
		ModBlocks.init();
		ModArmory.init(); // Comment out all test items!
		ModEntities.init();
		ModStructureItems.init(); // Keep this commented out when pushing.
		StructureList.preInit(event);
		VanillaChestLootGen.init();
		
		GameRegistry.registerWorldGenerator(this.eventWorldGen, 100); // experiment with other world gen mods for balancing
		
		ascensionProxy.registerRenderer();
		
		MinecraftForge.EVENT_BUS.register(new DropHandler());
		LogHelper.info("Finished initialization phase 1.");
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		LogHelper.info("Beginning initialization phase 2...");
		ModRecipes.init();
		ModWeaponRecipes.init();
		ModArmorRecipes.init();
		
		
		//Version Checker -- Be sure to update the file!
		String link = "https://raw.githubusercontent.com/TheXFactor117/Ascension/master/versionchecker.json";
		FMLInterModComms.sendRuntimeMessage(Reference.MODID, "VersionChecker", "addVersionCheck", link);
		LogHelper.info("Finished initialization phase 2.");
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		LogHelper.info("Beginning initialization phase 3...");
		
		BiomeDictionary.registerAllBiomes();
		
		LogHelper.info("Finished initialization phase 3.");
		LogHelper.info("Are you up for the challenge that awaits you?");
	}	
}
