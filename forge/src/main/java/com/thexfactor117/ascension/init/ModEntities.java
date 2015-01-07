package com.thexfactor117.ascension.init;

import com.thexfactor117.ascension.entities.EntityBarbarian;
import com.thexfactor117.ascension.entities.EntityBear;
import com.thexfactor117.ascension.entities.EntityGhost;
import com.thexfactor117.ascension.entities.EntityGoblin;
import com.thexfactor117.ascension.entities.EntityGolem;
import com.thexfactor117.ascension.entities.EntityMummy;
import com.thexfactor117.ascension.entities.EntitySnowBlaze;
import com.thexfactor117.ascension.entities.EntityValkyrie;
import com.thexfactor117.ascension.handlers.EntityHandler;

public class ModEntities 
{
	public static void init()
	{
		//Overworld
		EntityHandler.registerMonsters(EntityMummy.class, "Mummy");
		EntityHandler.registerMonsters(EntityValkyrie.class, "Valkyrie");
		EntityHandler.registerMonsters(EntityGolem.class, "Golem");
		EntityHandler.registerMonsters(EntityGoblin.class, "Goblin");
		EntityHandler.registerMonsters(EntityBarbarian.class, "Barbarian");
		EntityHandler.registerMonsters(EntitySnowBlaze.class, "Snow Blaze");
		EntityHandler.registerMonsters(EntityBear.class, "Bear");
		//EntityHandler.registerMonsters(EntityShark.class, "Shark");
		EntityHandler.registerMonsters(EntityGhost.class, "Ghost");
	}
}
