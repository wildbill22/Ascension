package com.thexfactor117.ascension.handlers;

import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import com.thexfactor117.ascension.structures.StructureList;

/**
 * 
 * @author WILLIAM
 *
 */

public class WorldSaveEventHandler {
	@SubscribeEvent
	public void onWorldSave(WorldEvent.Unload event) {
		StructureList.writeToFile(event);
	}	
}
