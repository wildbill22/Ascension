/**
 * Copyright 2014-2015 TheXFactor117
 */

package com.thexfactor117.ascension;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLInterModComms;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import com.thexfactor117.ascension.crafting.ModArmorRecipes;
import com.thexfactor117.ascension.crafting.ModRecipes;
import com.thexfactor117.ascension.crafting.ModWeaponRecipes;
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

/**
 * 
 * @author TheXFactor117
 * @author WILLIAM
 *
 */

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class Ascension
{
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.COMMON_PROXY)
	public static CommonProxy proxy;
	
	@Instance(Reference.MODID)
	public static Ascension instance;
	
	//AscensionWorldGeneration eventWorldGen = new AscensionWorldGeneration();
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{		
		LogHelper.info("Beginning initialization phase 1...");
		ConfigHandler.registerConfig(event.getModConfigurationDirectory());

		ModItems.registerItems();
		ModBlocks.registerBlocks();
		ModArmory.registerItems(); // comment test items out!
		ModEntities.init();
		ModStructureItems.registerItems(); // Keep this commented out when pushing.
		//StructureList.preInit(event);
		VanillaChestLootGen.init();
		
		//GameRegistry.registerWorldGenerator(this.eventWorldGen, 100); // experiment with other world gen mods for balancing
		
		MinecraftForge.EVENT_BUS.register(new DropHandler());
		LogHelper.info("Finished initialization phase 1.");
	}
	
	@Mod.EventHandler
	public void Init(FMLInitializationEvent event)
	{
		LogHelper.info("Beginning initialization phase 2..."); 
		
		proxy.registerRenders();
		
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
		LogHelper.info("Finished initialization phase 3.");
		LogHelper.info("Are you up for the challenge that awaits you?");
	}	
}
