package com.thexfactor117.ascension.structures;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;

public class StructureCoordinates extends ChunkCoordinates {
	protected Structures type;
	
	public StructureCoordinates() {	}

	public StructureCoordinates(Structures type, int posX, int posY, int posZ) {	
		super(posX, posY, posZ);
		this.type = type;
	}

	public StructureCoordinates(Structures type, StructureCoordinates coords) {	
		super(coords);
		this.type = type;
	}

	public enum Structures {
		CAMP, EASYMOBDUNGEON, SPHINX, OTHER, UNDERGROUND;
	}

	protected int toInteger(Structures type) {
		switch (type) {
			case CAMP:
				return 0;
			case EASYMOBDUNGEON:
				return 1;
			case SPHINX:
				return 2;
			case UNDERGROUND:
				return 4;
			default:
				return 3;
		}
	}
	
	protected Structures toEnum(int type) {
		switch (type) {
		case 0:
			return Structures.CAMP;
		case 1:
			return Structures.EASYMOBDUNGEON;
		case 2:
			return Structures.SPHINX;
		case 4:
			return Structures.UNDERGROUND;
		default:
			return Structures.OTHER;
		}
	}

	public void readFromNBT(NBTTagCompound nbt, int i) {
		NBTTagCompound nbtTag = nbt.getCompoundTag("coords" + i);
		type = toEnum(nbtTag.getInteger("type"));
		posX = nbtTag.getInteger("x");
		posY = nbtTag.getInteger("y");
		posZ = nbtTag.getInteger("z");
		if (type == Structures.SPHINX)
			StructureList.setSphinxGenerated(true);
	}

	public void writeToNBT(NBTTagCompound nbt, int i) {
		NBTTagCompound nbtTag = new NBTTagCompound();
		nbtTag.setInteger("type", toInteger(type));
		nbtTag.setInteger("x", posX);
		nbtTag.setInteger("y", posY);
		nbtTag.setInteger("z", posZ);
		nbt.setTag("coords" + i, nbtTag);
	}
}
