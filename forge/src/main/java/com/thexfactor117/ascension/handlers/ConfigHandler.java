package com.thexfactor117.ascension.handlers;

import java.io.File;

import com.thexfactor117.ascension.help.LogHelper;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler 
{	
	// worldgenores
	public static boolean generateTitaniumOre;
	public static boolean generateVexalOre;
	public static boolean generateFleroviumOre;
	public static boolean generateLimestone;
	public static int titaniumSpawnProbability;
	public static int titaniumMinY;
	public static int titaniumMaxY;
	public static int vexalSpawnProbability;
	public static int vexalMinY;
	public static int vexalMaxY;
	public static int fleroviumSpawnProbability;
	public static int fleroviumMinY;
	public static int fleroviumMaxY;
	public static int limestoneSpawnProbability;
	public static int limestoneMinY;
	public static int limestoneMaxY;
	
	// worldgenstructures
	public static boolean generateStructures;
	
	// entityspawn
	public static boolean shouldBansheeSpawn;
	public static boolean shouldBarbarianSpawn;
	public static boolean shouldGhostSpawn;
	public static boolean shouldGolemSpawn;
	public static boolean shouldMummySpawn;
	public static boolean shouldValkyrieSpawn;
	
	public static boolean shouldDoeSpawn;
	
	// entityproperties
	public static double bansheeHealth;
	public static double bansheeDamage;
	public static double bansheeFollowRange;
	public static double bansheeSpeed;
	public static double barbarianHealth;
	public static double barbarianDamage;
	public static double barbarianFollowRange;
	public static double barbarianSpeed;
	public static double ghostHealth;
	public static double ghostDamage;
	public static double ghostFollowRange;
	public static double ghostSpeed;
	public static double golemHealth;
	public static double golemDamage;
	public static double golemFollowRange;
	public static double golemSpeed;
	public static double golemKnockbackResistance;
	public static double mummyHealth;
	public static double mummyDamage;
	public static double mummyFollowRange;
	public static double mummySpeed;
	public static double valkyrieHealth;
	public static double valkyrieDamage;
	public static double valkyrieFollowRange;
	public static double valkyrieSpeed;
	
	public static void initProps(File location)
	{
		File mainFile = new File(location + "/Ascension.cfg");
		
		Configuration config = new Configuration(mainFile);
		config.load();

		// worldgenores
		generateTitaniumOre = config.get("worldgenOres", "generateTitaniumOre", true).getBoolean(true);
		generateVexalOre = config.get("worldgenOres", "generateVexalOre", true).getBoolean(true);
		generateFleroviumOre = config.get("worldgenOres", "generateFleroviumOre", true).getBoolean(true);
		generateLimestone = config.get("worldgenOres", "generateLimestone", true).getBoolean(true);
		titaniumSpawnProbability = config.get("worldgenOres", "titaniumSpawnProbability", 9).getInt(9);
		titaniumMinY = config.get("worldgenOres", "titaniumMinY", 0).getInt(0);
		titaniumMaxY = config.get("worldgenOres", "titaniumMaxY", 48).getInt(48);
		vexalSpawnProbability = config.get("worldgenOres", "vexalSpawnProbability", 7).getInt(7);
		vexalMinY = config.get("worldgenOres", "vexalMinY", 0).getInt(0);
		vexalMaxY = config.get("worldgenOres", "vexalMaxY", 32).getInt(32);
		fleroviumSpawnProbability = config.get("worldgenOres", "fleroviumSpawnProbability", 1).getInt(1);
		fleroviumMinY = config.get("worldgenOres", "fleroviumMinY", 0).getInt(0);
		fleroviumMaxY = config.get("worldgenOres", "fleroviumMaxY", 80).getInt(80);
		limestoneSpawnProbability = config.get("worldgenOres", "limestoneSpawnProbability", 13).getInt(13);
		limestoneMinY = config.get("worldgenOres", "limestoneMinY", 42).getInt(42);
		limestoneMaxY = config.get("worldgenOres", "limestoneMaxY", 128).getInt(128);
		
		// worldgenstructures
		generateStructures = config.get("worldgenStructures", "generateStructures", true).getBoolean(true);
		
		// entityspawn
		shouldBansheeSpawn = config.get("entitySpawn", "shouldBansheeSpawn", true).getBoolean(true);
		shouldBarbarianSpawn = config.get("entitySpawn", "shouldBarbarianSpawn", true).getBoolean(true);
		shouldGhostSpawn = config.get("entitySpawn", "shouldGhostSpawn", true).getBoolean(true);
		shouldGolemSpawn = config.get("entitySpawn", "shouldGolemSpawn", true).getBoolean(true);
		shouldMummySpawn = config.get("entitySpawn", "shouldMummySpawn", true).getBoolean(true);
		shouldValkyrieSpawn = config.get("entitySpawn", "shouldValkyrieSpawn", true).getBoolean(true);

		shouldDoeSpawn = config.get("entitySpawn", "shouldDoeSpawn", true).getBoolean(true);
		
		// entityproperties
		bansheeHealth = config.get("entityProperties", "bansheeHealth", 50.0D).getDouble(50.0D);
		bansheeDamage = config.get("entityProperties", "bansheeDamage", 8.0D).getDouble(8.0D);
		bansheeFollowRange = config.get("entityProperties", "bansheeFollowRange", 24.0D).getDouble(24.0D);
		bansheeSpeed = config.get("entityProperties", "bansheeSpeed", 0.175D).getDouble(0.175D);
		barbarianHealth = config.get("entityProperties", "barbarianHealth", 30.0D).getDouble(30.0D);
		barbarianDamage = config.get("entityProperties", "barbarianDamage", 5.0D).getDouble(5.0D);
		barbarianFollowRange = config.get("entityProperties", "barbarianFollowRange", 32.0D).getDouble(32.0D);
		barbarianSpeed = config.get("entityProperties", "barbarianSpeed", 0.3D).getDouble(0.3D);
		ghostHealth = config.get("entityProperties", "ghostHealth", 30.0D).getDouble(30.0D);
		ghostDamage = config.get("entityProperties", "ghostDamage", 5.0D).getDouble(5.0D);
		ghostFollowRange = config.get("entityProperties", "ghostFollowRange", 16.0D).getDouble(16.0D);
		ghostSpeed = config.get("entityProperties", "ghostSpeed", 0.2D).getDouble(0.2D);
		golemHealth = config.get("entityProperties", "golemHealth", 100.0D).getDouble(100.0D);
		golemDamage = config.get("entityProperties", "golemDamage", 15.0D).getDouble(15.0D);
		golemFollowRange = config.get("entityProperties", "golemFollowRange", 16.0D).getDouble(16.0D);
		golemSpeed = config.get("entityProperties", "golemSpeed", 0.175D).getDouble(0.175D);
		golemKnockbackResistance = config.get("entityproperties", "golemKnockbackResistance", 0.8D).getDouble(0.8D);
		mummyHealth = config.get("entityProperties", "mummyHealth", 60.0D).getDouble(60.0D);
		mummyDamage = config.get("entityProperties", "mummyDamage", 10.0D).getDouble(10.0D);
		mummyFollowRange = config.get("entityProperties", "mummyFollowRange", 24.0D).getDouble(24.0D);
		mummySpeed = config.get("entityProperties", "mummySpeed", 0.2D).getDouble(0.2D);
		valkyrieHealth = config.get("entityProperties", "valkyrieHealth", 30.0D).getDouble(30.0D);
		valkyrieDamage = config.get("entityProperties", "valkyrieDamage", 5.0D).getDouble(5.0D);
		valkyrieFollowRange = config.get("entityProperties", "valkyrieFollowRange", 32.0D).getDouble(32.0D);
		valkyrieSpeed = config.get("entityProperties", "valkyrieSpeed", 0.3D).getDouble(0.3D);
		
		if (config.hasChanged())
		{
			config.save();
		}
	}
}
