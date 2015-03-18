package com.thexfactor117.ascension.handlers;

import com.thexfactor117.ascension.structures.StructureList;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;

/**
 * 
 * @author WILLIAM
 *
 */

public class WorldLoadEventHandler {
	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event) {
		StructureList.readFromFile(event);
	}	
}
