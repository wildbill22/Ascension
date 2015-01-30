package com.thexfactor117.ascension.handlers;

import com.thexfactor117.ascension.structures.AbandonedStructure;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;

public class WorldLoadEventHandler {
	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event) {
		AbandonedStructure.readFromFile(event);
	}	
}
