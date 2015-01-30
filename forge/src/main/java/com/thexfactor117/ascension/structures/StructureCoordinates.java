package com.thexfactor117.ascension.structures;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;

public class StructureCoordinates extends ChunkCoordinates {
	
	public StructureCoordinates() {	}

	public StructureCoordinates(int posX, int posY, int posZ) {	
		super(posX, posY, posZ);
	}

	public void readFromNBT(NBTTagCompound nbt, int i) {
		posX = nbt.getInteger("x" + i);
		posY = nbt.getInteger("y" + i);
		posZ = nbt.getInteger("z" + i);
	}

	public void writeToNBT(NBTTagCompound nbt, int i) {
		nbt.setInteger("x" + i, posX);
		nbt.setInteger("y" + i, posY);
		nbt.setInteger("z" + i, posZ);
	}
}
