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
	
	// entities
	public static boolean shouldBansheeSpawn;
	public static boolean shouldBarbarianSpawn;
	public static boolean shouldGhostSpawn;
	public static boolean shouldGolemSpawn;
	public static boolean shouldMummySpawn;
	public static boolean shouldValkyrieSpawn;
	
	public static boolean shouldDoeSpawn;
	
	public static double bansheeHealth;
	public static double bansheeDamage;
	public static double bansheeFollowRange;
	public static double bansheeSpeed;
	
	public static void initProps(File location)
	{
		File mainFile = new File(location + "/Ascension.cfg");
		
		Configuration config = new Configuration(mainFile);
		config.load();

		// worldgen
		generateTitaniumOre = config.get("worldgenOres", "generateTitaniumOre", true, "Set FALSE to disable Titanium Ore generation").getBoolean(true);
		generateVexalOre = config.get("worldgenOres", "generateVexalOre", true, "Set FALSE to disable Vexal Ore generation").getBoolean(true);
		generateFleroviumOre = config.get("worldgenOres", "generateFleroviumOre", true, "Set FALSE to disable Flerovium Ore generation").getBoolean(true);
		generateLimestone = config.get("worldgenOres", "generateLimestone", true, "Set FALSE to disable Limestone generation").getBoolean(true);
		generateStructures = config.get("worldgenStructures", "generateStructures", true, "Set FALSE to disable Structure generation").getBoolean(true);
		
		// entities
		shouldBansheeSpawn = config.get("entitySpawn", "shouldBansheeSpawn", true, "Set FALSE to disable Banshee spawning").getBoolean(true);
		shouldBarbarianSpawn = config.get("entitySpawn", "shouldBarbarianSpawn", true, "Set FALSE to disable Barbarian spawning").getBoolean(true);
		shouldGhostSpawn = config.get("entitySpawn", "shouldGhostSpawn", true, "Set FALSE to disable Ghost spawning").getBoolean(true);
		shouldGolemSpawn = config.get("entitySpawn", "shouldGolemSpawn", true, "Set FALSE to disable Golem spawning").getBoolean(true);
		shouldMummySpawn = config.get("entitySpawn", "shouldMummySpawn", true, "Set FALSE to disable Mummy spawning").getBoolean(true);
		shouldValkyrieSpawn = config.get("entitySpawn", "shouldValkyrieSpawn", true, "Set FALSE to disable Valkyrie spawning").getBoolean(true);

		shouldDoeSpawn = config.get("entitySpawn", "shouldDoeSpawn", true, "Set FALSE to disable Doe spawning").getBoolean(true);
		
		bansheeHealth = config.get("entityProperties", "bansheeHealth", 50.0D, "Determines the mobs health (points NOT hearts!)").getDouble(50.0D);
		bansheeDamage = config.get("entityProperties", "bansheeDamage", 8.0D, "Determines the mobs damage (points NOT hearts!)").getDouble(8.0D);
		bansheeFollowRange = config.get("entityProperties", "bansheeFollowRange", 24.0D, "Determines the mobs follow range").getDouble(24.0D);
		bansheeSpeed = config.get("entityProperties", "bansheeSpeed", 0.175D, "Determines the mobs speed (very sensitive)").getDouble(0.175D);
		
		if (config.hasChanged())
		{
			config.save();
		}
	}
}
