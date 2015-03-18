package com.thexfactor117.ascension.help;

/**
 * 
 * @author TheXFactor117
 * @author WILLIAM
 *
 */

public class Reference 
{
	public static final String MODID = "Ascension";
	public static final String NAME = "Ascension";
	public static final String VERSION = "b1.2.3";
	public static final String CLIENT_PROXY = "com.thexfactor117.ascension.proxies.ClientProxy";
	public static final String COMMON_PROXY = "com.thexfactor117.ascension.proxies.CommonProxy";
	
	// Constants for controlling structure generation
	// spawnChanceXXXX is the chance n/100 that an attempt will be made to generate it
	// Only one of N buildings will generate per chunk, so divide the chance by number of buildings also
	// Some types will only generate if not close to other builds or in special terrain
	public static final int spawnChanceCamp = 100;               // Set high, since it is rare to be able to spawn
	public static final int spawnChanceEasyMobDungeon1 = 6;
	public static final int spawnChanceLandWatchtowerPart1 = 8;
	public static final int spawnChanceMediumAbandonedHouse = 8;
	public static final int spawnChanceSmallAbandonedHouse = 8;
	public static final int spawnChanceSphinx = 100;		
	public static final int spawnChanceMazeDungeon = 10;		
	public static final int spawnChanceAbandonedTower = 8;
	public static final int minSpawnDistSphinx = 400; // TODO: Make this larger for Beta
	public static final int minSpawnDistMazeDungeon = 400; // Too much stuff generates when spawning, this avoids crash
	public static final int sphinxChestItemsMultiplier = 12;   // n times the normal probability for items in Sphinx chests 
}
