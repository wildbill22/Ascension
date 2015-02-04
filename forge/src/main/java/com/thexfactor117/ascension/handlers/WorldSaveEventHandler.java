package com.thexfactor117.ascension.handlers;

import com.thexfactor117.ascension.structures.StructureList;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;

public class WorldSaveEventHandler {
	@SubscribeEvent
	public void onWorldSave(WorldEvent.Unload event) {
		StructureList.writeToFile(event);
	}	
}
