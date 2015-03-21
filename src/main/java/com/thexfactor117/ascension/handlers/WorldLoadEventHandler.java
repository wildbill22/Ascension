package com.thexfactor117.ascension.handlers;

import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.thexfactor117.ascension.structures.StructureList;

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
