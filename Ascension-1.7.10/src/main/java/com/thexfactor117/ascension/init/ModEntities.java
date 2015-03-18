package com.thexfactor117.ascension.init;

import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.item.Item;
import net.minecraft.world.biome.BiomeGenBase;

import com.thexfactor117.ascension.Ascension;
import com.thexfactor117.ascension.entities.boss.EntityPharaoh;
import com.thexfactor117.ascension.entities.hostile.EntityBanshee;
import com.thexfactor117.ascension.entities.hostile.EntityBarbarian;
import com.thexfactor117.ascension.entities.hostile.EntityGhost;
import com.thexfactor117.ascension.entities.hostile.EntityGoblin;
import com.thexfactor117.ascension.entities.hostile.EntityGolem;
import com.thexfactor117.ascension.entities.hostile.EntityMiniGolem;
import com.thexfactor117.ascension.entities.hostile.EntityMummy;
import com.thexfactor117.ascension.entities.hostile.EntitySnowBlaze;
import com.thexfactor117.ascension.entities.hostile.EntityTroll;
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
import com.thexfactor117.ascension.handlers.ConfigHandler;
import com.thexfactor117.ascension.help.LogHelper;
import com.thexfactor117.ascension.items.ItemAscensionMonsterPlacer;

import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

/**
 * 
 * @author TheXFactor117
 * @author WILLIAM
 *
 */

public class ModEntities 
{
	public static int i;
	public static int startEntityID;
	
	// Egg Items
	public static Item pharaohEgg = new ItemAscensionMonsterPlacer("Pharaoh", 0xC9C9BB, 0x182ED6).setUnlocalizedName("spawn_egg_" + "Pharaoh".toLowerCase()).setTextureName("thexfactor117_ascension:spawn_egg");
	
	public static Item bansheeEgg = new ItemAscensionMonsterPlacer("Banshee", 0x342D4A, 0xFCD80A).setUnlocalizedName("spawn_egg_" + "Banshee".toLowerCase()).setTextureName("thexfactor117_ascension:spawn_egg");
	public static Item barbarianEgg = new ItemAscensionMonsterPlacer("Barbarian", 0xE32209, 0xE38F09).setUnlocalizedName("spawn_egg_" + "Barbarian".toLowerCase()).setTextureName("thexfactor117_ascension:spawn_egg");
	public static Item ghostEgg = new ItemAscensionMonsterPlacer("Ghost", 0x807D79, 0xF22E18).setUnlocalizedName("spawn_egg_" + "Ghost".toLowerCase()).setTextureName("thexfactor117_ascension:spawn_egg");
	public static Item goblinEgg = new ItemAscensionMonsterPlacer("Goblin", 0x342D4A, 0xFCD80A).setUnlocalizedName("spawn_egg_" + "Goblin".toLowerCase()).setTextureName("thexfactor117_ascension:spawn_egg");
	public static Item golemEgg = new ItemAscensionMonsterPlacer("Golem", 0xF2961D, 0x45341E).setUnlocalizedName("spawn_egg_" + "Golem".toLowerCase()).setTextureName("thexfactor117_ascension:spawn_egg");
	public static Item miniGolemEgg = new ItemAscensionMonsterPlacer("Mini-Golem", 0xF2961D, 0x45341E).setUnlocalizedName("spawn_egg_" + "Mini-Golem".toLowerCase()).setTextureName("thexfactor117_ascension:spawn_egg");
	public static Item mummyEgg = new ItemAscensionMonsterPlacer("Mummy", 0x436E59, 0x7FAD94).setUnlocalizedName("spawn_egg_" + "Mummy".toLowerCase()).setTextureName("thexfactor117_ascension:spawn_egg");
	public static Item snowBlazeEgg = new ItemAscensionMonsterPlacer("Snow Blaze", 0x9EF4FF, 0xE8FCFF).setUnlocalizedName("spawn_egg_" + "Snow Blaze".toLowerCase()).setTextureName("thexfactor117_ascension:spawn_egg");
	public static Item trollEgg = new ItemAscensionMonsterPlacer("Troll", 0x9EF4FF, 0x9EF4FF).setUnlocalizedName("spawn_egg_" + "Troll".toLowerCase()).setTextureName("thexfactor117_ascension:spawn_egg");
	public static Item valkyrieEgg = new ItemAscensionMonsterPlacer("Valkyrie", 0xFFFDE8, 0xF0E335).setUnlocalizedName("spawn_egg_" + "Valkyrie".toLowerCase()).setTextureName("thexfactor117_ascension:spawn_egg");

	public static Item doeEgg = new ItemAscensionMonsterPlacer("Doe", 0x634F35, 0xF7F7F7).setUnlocalizedName("spawn_egg_" + "Doe".toLowerCase()).setTextureName("thexfactor117_ascension:spawn_egg");

	public static void init()
	{
    	registerModEntityEgg(EntityPharaoh.class, "Pharaoh", 0xC9C9BB, 0x182ED6);
    	
    	registerModEntityEgg(EntityBanshee.class, "Banshee", 0x342D4A, 0xFCD80A);
    	registerModEntityEgg(EntityBarbarian.class, "Barbarian", 0xE32209, 0xE38F09);
    	registerModEntityEgg(EntityGhost.class, "Ghost", 0x807D79, 0xF22E18);
    	registerModEntityEgg(EntityGoblin.class, "Goblin", 0x342D4A, 0xFCD80A);
    	registerModEntityEgg(EntityGolem.class, "Golem", 0xF2961D, 0x45341E);
    	registerModEntityEgg(EntityMiniGolem.class, "Mini-Golem", 0xF2961D, 0x45341E);
    	registerModEntityEgg(EntityMummy.class, "Mummy", 0x436E59, 0x7FAD94);
    	registerModEntityEgg(EntitySnowBlaze.class, "Snow Blaze", 0x9EF4FF, 0xE8FCFF);
    	registerModEntityEgg(EntityTroll.class, "Troll", 0x9EF4FF, 0x9EF4FF);
    	registerModEntityEgg(EntityValkyrie.class, "Valkyrie", 0xFFFDE8, 0xF0E335);
    	
    	registerModEntityEgg(EntityDoe.class, "Doe", 0x634F35, 0xF7F7F7);
    	
    	registerModProjectile(EntitySmallMagic.class, "Small Magic");
    	registerModProjectile(EntityMediumMagic.class, "Medium Magic");
    	registerModProjectile(EntitySmallOblivion.class, "Small Oblivion");
    	registerModProjectile(EntityMediumOblivion.class, "Medium Oblivion");
    	registerModProjectile(EntitySmallBlizzard.class, "Small Blizzard");
    	registerModProjectile(EntityMediumBlizzard.class, "Medium Blizzard");
    	registerModProjectile(EntitySmallInferno.class, "Small Inferno");
    	registerModProjectile(EntityMediumInferno.class, "Medium Inferno");
    	        
        mobSpawns();
	}

	/**
	 * Registers an entity projectile using #registerModEntity (e.g. a spell/arrow)
	 */
	public static void registerModProjectile(Class entityClass, String name)
	{
		EntityRegistry.registerModEntity(entityClass, name, ++startEntityID, Ascension.instance, 64, 10, true);
		LogHelper.info("Registering mod projectile " + name + " with ID = " + startEntityID);
	}
	
	/**
	 * Registers an entity using #registerModEntity (e.g. a mob without an egg)
	 */
	public static void registerModEntity(Class entityClass, String name)
	{
        EntityRegistry.registerModEntity(entityClass, name, ++startEntityID, Ascension.instance, 80, 3, false);
      	LogHelper.info("Registering mod entity " + name + " with ID = " + startEntityID);
	}
	
	/**
	 * Registers an entity with a spawn egg (e.g. a mob with an egg)
	 */
	public static void registerModEntityEgg(Class entityClass, String name, int primary, int secondary)
	{	
		registerModEntity(entityClass, name);
		
		if (i == 0)
		{
			registerSpawnEgg(name, primary, secondary);
			++i;
		}
	}
	
	/**
	 * Registers the egg items with Forge
	 */
	public static void registerSpawnEgg(String name, int primary, int secondary)
	{
		GameRegistry.registerItem(pharaohEgg, "spawnEggPharaoh");
		
		GameRegistry.registerItem(bansheeEgg, "spawnEggBanshee");
		GameRegistry.registerItem(barbarianEgg, "spawnEggBarbarian");
		GameRegistry.registerItem(ghostEgg, "spawnEggGhost");
		GameRegistry.registerItem(goblinEgg, "spawnEggGoblin");
		GameRegistry.registerItem(golemEgg, "spawnEggGolem");
		GameRegistry.registerItem(miniGolemEgg, "spawnEggMiniGolem");
		GameRegistry.registerItem(mummyEgg, "spawnEggMummy");
		GameRegistry.registerItem(snowBlazeEgg, "spawnEggSnowBlaze");
		GameRegistry.registerItem(trollEgg, "spawnEggTroll");
		GameRegistry.registerItem(valkyrieEgg, "spawnEggValkyrie");
		
		GameRegistry.registerItem(doeEgg, "spawnEggDoe");
	}
	
	/**
	 * Generates a unique ID for every entity to reduce ID mismatches.
	 */
	public static int getUniqueEntityId()
    {
    	do
    	{
    		startEntityID++;
    	}
    	while (EntityList.getStringFromID(startEntityID) != null);

    	return startEntityID;
    }
	
	/**
	 * Assigns spawn variables for mob entities
	 */
	public static void mobSpawns()
	{
		if (ConfigHandler.shouldBansheeSpawn)
	    {
	        EntityRegistry.addSpawn(EntityBanshee.class, 200, 1, 2, EnumCreatureType.monster,
	        		new BiomeGenBase[] 
	        	        	{
	        	        		BiomeGenBase.beach, 
	        	        		BiomeGenBase.birchForest, 
	        	        		BiomeGenBase.birchForestHills, 
	        	        		BiomeGenBase.coldBeach, 
	        	        		BiomeGenBase.coldTaiga, 
	        	        		BiomeGenBase.coldTaigaHills, 
	        	        		BiomeGenBase.desert, 
	        	        		BiomeGenBase.desertHills, 
	        	        		BiomeGenBase.extremeHills, 
	        	        		BiomeGenBase.extremeHillsEdge, 
	        	        		BiomeGenBase.extremeHillsPlus, 
	        	        		BiomeGenBase.forest, 
	        	        		BiomeGenBase.forestHills, 
	        	        		BiomeGenBase.iceMountains, 
	        	        		BiomeGenBase.icePlains, 
	        	        		BiomeGenBase.jungle, 
	        	        		BiomeGenBase.jungleHills, 
	        	        		BiomeGenBase.jungleEdge, 
	        	        		BiomeGenBase.megaTaiga, 
	        	        		BiomeGenBase.megaTaigaHills, 
	        	        		BiomeGenBase.mesa, 
	        	        		BiomeGenBase.mesaPlateau, 
	                			BiomeGenBase.mesaPlateau_F, 
	                			BiomeGenBase.mushroomIsland, 
	                			BiomeGenBase.mushroomIslandShore, 
	                			BiomeGenBase.plains, 
	                			BiomeGenBase.roofedForest,
	                			BiomeGenBase.savanna,
	                			BiomeGenBase.savannaPlateau,
	                			BiomeGenBase.stoneBeach,
	                			BiomeGenBase.swampland,
	                			BiomeGenBase.taiga,
	                			BiomeGenBase.taigaHills});
	    }

	    if (ConfigHandler.shouldBarbarianSpawn)
	    {
	        EntityRegistry.addSpawn(EntityBarbarian.class, 20, 1, 3, EnumCreatureType.creature,
	        		new BiomeGenBase[] 
	        	        	{
	        	        		BiomeGenBase.beach, 
	        	        		BiomeGenBase.birchForest, 
	        	        		BiomeGenBase.birchForestHills, 
	        	        		BiomeGenBase.coldBeach, 
	        	        		BiomeGenBase.coldTaiga, 
	        	        		BiomeGenBase.coldTaigaHills, 
	        	        		BiomeGenBase.desert, 
	        	        		BiomeGenBase.desertHills, 
	        	        		BiomeGenBase.extremeHills, 
	        	        		BiomeGenBase.extremeHillsEdge, 
	        	        		BiomeGenBase.extremeHillsPlus, 
	        	        		BiomeGenBase.forest, 
	        	        		BiomeGenBase.forestHills, 
	        	        		BiomeGenBase.iceMountains, 
	        	        		BiomeGenBase.icePlains, 
	        	        		BiomeGenBase.jungle, 
	        	        		BiomeGenBase.jungleHills, 
	        	        		BiomeGenBase.jungleEdge, 
	        	        		BiomeGenBase.megaTaiga, 
	        	        		BiomeGenBase.megaTaigaHills, 
	        	        		BiomeGenBase.mesa, 
	        	        		BiomeGenBase.mesaPlateau, 
	                			BiomeGenBase.mesaPlateau_F, 
	                			BiomeGenBase.mushroomIsland, 
	                			BiomeGenBase.mushroomIslandShore, 
	                			BiomeGenBase.plains, 
	                			BiomeGenBase.roofedForest,
	                			BiomeGenBase.savanna,
	                			BiomeGenBase.savannaPlateau,
	                			BiomeGenBase.stoneBeach,
	                			BiomeGenBase.swampland,
	                			BiomeGenBase.taiga,
	                			BiomeGenBase.taigaHills});
	    }
	        	
	    if (ConfigHandler.shouldGhostSpawn)
	    {
	        EntityRegistry.addSpawn(EntityGhost.class, 65, 1, 2, EnumCreatureType.monster,
	        		new BiomeGenBase[] 
	        	        	{
	        	        		BiomeGenBase.beach, 
	        	        		BiomeGenBase.coldBeach,  
	        	        		BiomeGenBase.desert, 
	        	        		BiomeGenBase.desertHills, 
	        	        		BiomeGenBase.extremeHills, 
	        	        		BiomeGenBase.extremeHillsEdge, 
	        	        		BiomeGenBase.extremeHillsPlus, 
	        	        		BiomeGenBase.iceMountains, 
	        	        		BiomeGenBase.icePlains, 
	        	        		BiomeGenBase.mesa, 
	        	        		BiomeGenBase.mesaPlateau, 
	                			BiomeGenBase.mesaPlateau_F, 
	                			BiomeGenBase.mushroomIsland, 
	                			BiomeGenBase.mushroomIslandShore, 
	                			BiomeGenBase.plains,
	                			BiomeGenBase.savanna,
	                			BiomeGenBase.savannaPlateau,
	                			BiomeGenBase.stoneBeach,
	                			BiomeGenBase.swampland,});	
	    }

	    if (ConfigHandler.shouldGolemSpawn)
	    {
	        EntityRegistry.addSpawn(EntityGolem.class, 40, 1, 2, EnumCreatureType.monster,
	        		new BiomeGenBase[] 
	        	        	{
	        	        		BiomeGenBase.beach,  
	        	        		BiomeGenBase.coldBeach,  
	        	        		BiomeGenBase.desert, 
	        	        		BiomeGenBase.desertHills, 
	        	        		BiomeGenBase.extremeHills, 
	        	        		BiomeGenBase.extremeHillsEdge, 
	        	        		BiomeGenBase.extremeHillsPlus, 
	        	        		BiomeGenBase.iceMountains, 
	        	        		BiomeGenBase.icePlains,  
	        	        		BiomeGenBase.mesa, 
	        	        		BiomeGenBase.mesaPlateau, 
	                			BiomeGenBase.mesaPlateau_F,  
	                			BiomeGenBase.stoneBeach,
	                			BiomeGenBase.swampland});
	    
	    }

	    if (ConfigHandler.shouldMummySpawn)
	    {
	        EntityRegistry.addSpawn(EntityMummy.class, 50, 1, 3, EnumCreatureType.monster,
	        		new BiomeGenBase[] 
	        	        	{
	        	        		BiomeGenBase.desert, 
	        	        		BiomeGenBase.desertHills});
	    }

	    if (ConfigHandler.shouldValkyrieSpawn)
	    {
	        EntityRegistry.addSpawn(EntityValkyrie.class, 20, 1, 3, EnumCreatureType.creature,
	        		new BiomeGenBase[] 
	        	        	{
	        	        		BiomeGenBase.beach, 
	        	        		BiomeGenBase.birchForest, 
	        	        		BiomeGenBase.birchForestHills, 
	        	        		BiomeGenBase.coldBeach, 
	        	        		BiomeGenBase.coldTaiga, 
	        	        		BiomeGenBase.coldTaigaHills, 
	        	        		BiomeGenBase.desert, 
	        	        		BiomeGenBase.desertHills, 
	        	        		BiomeGenBase.extremeHills, 
	        	        		BiomeGenBase.extremeHillsEdge, 
	        	        		BiomeGenBase.extremeHillsPlus, 
	        	        		BiomeGenBase.forest, 
	        	        		BiomeGenBase.forestHills, 
	        	        		BiomeGenBase.iceMountains, 
	        	        		BiomeGenBase.icePlains, 
	        	        		BiomeGenBase.jungle, 
	        	        		BiomeGenBase.jungleHills, 
	        	        		BiomeGenBase.jungleEdge, 
	        	        		BiomeGenBase.megaTaiga, 
	        	        		BiomeGenBase.megaTaigaHills, 
	        	        		BiomeGenBase.mesa, 
	        	        		BiomeGenBase.mesaPlateau, 
	                			BiomeGenBase.mesaPlateau_F, 
	                			BiomeGenBase.mushroomIsland, 
	                			BiomeGenBase.mushroomIslandShore, 
	                			BiomeGenBase.plains, 
	                			BiomeGenBase.roofedForest,
	                			BiomeGenBase.savanna,
	                			BiomeGenBase.savannaPlateau,
	                			BiomeGenBase.stoneBeach,
	                			BiomeGenBase.swampland,
	                			BiomeGenBase.taiga,
	                			BiomeGenBase.taigaHills});
	    }
	}
}