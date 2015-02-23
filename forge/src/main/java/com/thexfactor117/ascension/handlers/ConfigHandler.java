package com.thexfactor117.ascension.handlers;

import java.io.File;

import com.thexfactor117.ascension.help.LogHelper;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler 
{
	// worldgen
	public static boolean generateTitaniumOre;
	public static boolean generateVexalOre;
	public static boolean generateFleroviumOre;
	public static boolean generateLimestone;
	public static boolean generateStructures;
	
	public static void initProps(File location)
	{
		File mainFile = new File(location + "/Ascension.cfg");
		
		Configuration config = new Configuration(mainFile);
		config.load();
		
		// worldgen
		generateTitaniumOre = config.get("worldgen", "generateTitaniumOre", true, "Set FALSE to disable Titanium Ore generation").getBoolean(true);
		generateVexalOre = config.get("worldgen", "generateVexalOre", true, "Set FALSE to disable Vexal Ore generation").getBoolean(true);
		generateFleroviumOre = config.get("worldgen", "generateFleroviumOre", true, "Set FALSE to disable Flerovium Ore generation").getBoolean(true);
		generateLimestone = config.get("worldgen", "generateLimestone", true, "Set FALSE to disable Limestone generation").getBoolean(true);
		generateStructures = config.get("worldgen", "generateStructures", true, "Set FALSE to disable Structure generation").getBoolean(true);
		
		if (config.hasChanged())
		{
			config.save();
		}
	}
}
