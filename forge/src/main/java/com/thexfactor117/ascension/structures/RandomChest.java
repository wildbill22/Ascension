package com.thexfactor117.ascension.structures;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.world.World;

import com.thexfactor117.ascension.help.LogHelper;
import com.thexfactor117.ascension.init.ModArmory;
import com.thexfactor117.ascension.init.ModItems;

public class RandomChest {
	public ArrayList<RandomChestItem> randomChestItems;
	// For generating chests (if more than one)
	protected int numGenerated = 0;
	
	protected class RandomChestItem {
		Item item;
		int min;
		int max;
		int probability;
		Enchantment enchantment;
		int enchantmentLevel;
		
		protected RandomChestItem(Item item, int min, int max, int probability) {
			this.item = item;
			this.min = min;
			this.max = max;
			this.probability = probability;
			enchantment = null;
		}
		protected RandomChestItem(Item item, int min, int max, int probability, Enchantment enchantment, int enchantmentLevel) {
			this.item = item;
			this.min = min;
			this.max = max;
			this.probability = probability;
			this.enchantment = enchantment;
		}
	}

	/**
	 *  Adds loot to chestEntity based on chance given
	 * @param chestEntity
	 * @param slot to add loot to
	 * @param item to add
	 * @param min to add
	 * @param max to add
	 * @param chance that it will be added
	 * @return slot + 1 if added, slot if not added
	 */
	private int setRandomSlots(TileEntityChest chestEntity, int slot, RandomChestItem chestItem) 
	{
		Random rand = new Random();
		int randomChance = rand.nextInt(100);
		if (chestEntity.getStackInSlot(slot) == null && chestItem.probability > randomChance)
		{
			int randomQty = rand.nextInt(chestItem.max - chestItem.min + 1) + chestItem.min;
			ItemStack stack = new ItemStack(chestItem.item, randomQty);
			if (chestItem.enchantment != null) {
				stack.addEnchantment(chestItem.enchantment, 1);
			}
			chestEntity.setInventorySlotContents(slot, stack);
			return slot + 1;
		}
		return slot;
	}

	/**
	 * Replace a setBlock for a chest with this function with all the parameters, and a few extra 
	 * @param world 
	 * @param random
	 * @param x
	 * @param y
	 * @param z
	 * @param metaData
	 * @param chance 1/n chance that the chest will be created at the x, y, z location (set to 1 generate chest)
	 * @param generated set to true to not generate a chest
	 * @return true if chest is generated
	 */
	protected boolean generateChest(World world, Random random, int x, int y, int z, int metaData, int chance, boolean generated){
		if (!generated && random.nextInt(chance) == 0)
		{			
			//adding a chest with random stuff
			world.setBlock(x, y, z, Blocks.chest, metaData, 3); // 3 for block update
			TileEntityChest chestEntity = (TileEntityChest) world.getTileEntity(x, y, z);
			if (chestEntity == null){
				LogHelper.warn("Can't get chestEntity at: " + x + "," + y + "," + z);				
			}
//			TileEntityChest chestEntity = new TileEntityChest();
//			world.setTileEntity(x, y, z, chestEntity);
			if (randomChestItems != null) {
				int listSize = randomChestItems.size();
				int addItemChance = (int) (27.0 / listSize * 0.8 * listSize);
				int slot = 0;
				for (int i = 0; i < listSize; i++) {
					if (random.nextInt(27) < addItemChance) {
						// item, min to add, max to add, chance N/100
						slot = setRandomSlots(chestEntity, slot, randomChestItems.get(i));
					}
					if (slot == 27) {
						LogHelper.error("Too many items assigned to spawn in chest!");
						break;
					}
				}
				LogHelper.info("Generated chest with " + slot + " items at: " + x + "," + y + "," + z);				
			}
			return true;
		}		
		return generated;
	}
	
	/**
	 * Replace a setBlock for a chest with this function with all the parameters, and a few extra 
	 * @param world 
	 * @param random
	 * @param x1 First Chest x, y, z
	 * @param y1
	 * @param z1
	 * @param x2 2nd Chest x, y, z
	 * @param y2
	 * @param z2
	 * @param metaData
	 * @param generated set to true to generate the 2nd chest
	 * @return true if chest is generated
	 */
	protected boolean generateDoubleChest(World world, Random random, int x1, int y1, int z1, int x2, int y2, int z2, int metaData, int chance, boolean generated){
		if (!generated && random.nextInt(chance) == 0)
		{			
			//adding a chest with random stuff
			world.setBlock(x1, y1, z1, Blocks.chest, metaData, 3); // changed flag to 3 to cause block update, was 2
			world.setBlock(x2, y2, z2, Blocks.chest, metaData, 3);
			TileEntityChest chestEntity = (TileEntityChest) world.getTileEntity(x1, y1, z1);
			if (chestEntity == null){
				LogHelper.warn("Can't get chestEntity at: " + x1 + "," + y1 + "," + z1);				
			}
			if (randomChestItems != null) {
				int listSize = randomChestItems.size();
				int addItemChance = (int) (54.0 / listSize * 0.8 * listSize);
				int slot = 0;
				for (int i = 0; i < listSize; i++) {
					if (random.nextInt(54) < addItemChance) {
						// item, min to add, max to add, chance N/100
						slot = setRandomSlots(chestEntity, slot, randomChestItems.get(i));
					}
					if (slot == 54) {
						LogHelper.error("Too many items assigned to spawn in chest!");
						break;
					}
				}
				LogHelper.info("Generated chest with " + slot + " items at: " + x1 + "," + y1 + "," + z1);				
			}
			return true;
		}		
		return generated;
	}
	
	/**
	 * Replace a setBlock for a chest with this function with all the parameters, and a few extra 
	 * @param world 
	 * @param random
	 * @param x
	 * @param y
	 * @param z
	 * @param metaData
	 * @param chance 1/n chance that the chest will be created at the x, y, z location (set to 1 generate chest)
	 * @param numToGenerate set to the number of chests to generate
	 * @return true if chest is generated
	 */
	protected boolean generateChest(World world, Random random, int x, int y, int z, int metaData, int chance, int numToGenerate){
		if (this.numGenerated < numToGenerate && random.nextInt(chance) == 0)
		{			
			//adding a chest with random stuff
			world.setBlock(x, y, z, Blocks.chest, metaData, 3);
			TileEntityChest chestEntity = (TileEntityChest) world.getTileEntity(x, y, z);
			if (chestEntity == null){
				LogHelper.warn("Can't get chestEntity at: " + x + "," + y + "," + z);				
			}
			if (randomChestItems != null) {
				int listSize = randomChestItems.size();
				int addItemChance = (int) (27.0 / listSize * 0.8 * listSize);
				int slot = 0;
				for (int i = 0; i < listSize; i++) {
					if (random.nextInt(27) < addItemChance) {
						// item, min to add, max to add, chance N/100
						slot = setRandomSlots(chestEntity, slot, randomChestItems.get(i));
					}
					if (slot == 27) {
						LogHelper.error("Too many items assigned to spawn in chest!");
						break;
					}
				}
				LogHelper.info("Generated chest with " + slot + " items at: " + x + "," + y + "," + z);				
			}
			return true;
		}		
		return false;
	}

	/**
	 * Adds item(s) to a the random chest items list with a designated slot and probability 
	 * @param slot slot where the item will randomly appear
	 * @param item item to add randomly to chest 
	 * @param min minimum to add to a slot (0 - 64)
	 * @param max maximum to add to a slot (1 - 64)
	 * @param probability n/100 chance of any one slot having this item
	 */
	protected void addRandomChestItem(Item item, int min, int max, int probability) {
		if (randomChestItems == null)
			randomChestItems = new ArrayList<RandomChestItem>();
		if (probability > 100)
			probability = 100;
		if (min <= max && max <= 64 && probability >= 0)
			randomChestItems.add(new RandomChestItem(item, min, max, probability));
		else
			LogHelper.error("One of the parameters for adding " + item.getUnlocalizedName() + " to chest is wrong!");
	}
	
	/**
	 * Adds item(s) to a the random chest items list with a designated slot and probability 
	 * @param slot slot where the item will randomly appear
	 * @param item item to add randomly to chest 
	 * @param min minimum to add to a slot (0 - 64)
	 * @param max maximum to add to a slot (1 - 64)
	 * @param probability n/100 chance of any one slot having this item
	 * @param enchantment property to add to item
	 */
	protected void addRandomChestItem(Item item, int min, int max, int probability, Enchantment enchantment, int enchantmentLevel) {
		if (randomChestItems == null)
			randomChestItems = new ArrayList<RandomChestItem>();
		if (probability > 100)
			probability = 100;
		if (min <= max && max <= 64 && probability >= 0)
			randomChestItems.add(new RandomChestItem(item, min, max, probability, enchantment, enchantmentLevel));
		else
			LogHelper.error("One of the parameters for adding " + item.getUnlocalizedName() + " to chest is wrong!");
	}
	
	// Chest stuff
	protected void addItemsForAllChests(int m) {	
		// In all chests - minecraft vanilla
		addRandomChestItem(Items.iron_ingot, 1, 3, 7 * m);
		addRandomChestItem(Items.gold_ingot, 1, 2, 7 * m);
		addRandomChestItem(Items.diamond, 1, 2, 3 * m);
		addRandomChestItem(Items.emerald, 1, 1, 2 * m);
		addRandomChestItem(Items.rotten_flesh, 1, 4, 10 * m);
		addRandomChestItem(Items.bone, 1, 3, 8 * m);
		addRandomChestItem(Items.wheat, 1, 4, 10 * m);
		
		// In all chests - modItems
		addRandomChestItem(ModItems.titaniumIngot, 1, 2, 6 * m);
		addRandomChestItem(ModItems.vexalIngot, 1, 1, 5 * m);
		addRandomChestItem(ModItems.rawVenison, 1, 3, 10 * m);
		addRandomChestItem(ModItems.coldBlazeRod, 1, 2, 8 * m);
		addRandomChestItem(ModItems.sharkTeeth, 1, 2, 9 * m);
		addRandomChestItem(ModItems.golemGyro, 1, 1, 5 * m);

		// In all chests - modArmory
		addRandomChestItem(ModArmory.blazeSword, 1, 1, 2 * m);
		addRandomChestItem(ModArmory.iceSword, 1, 1, 3 * m);
		addRandomChestItem(ModArmory.razorSword, 1, 1, 2 * m);
		
		// In all chests - modArmory - titanium tools & weapons
		addRandomChestItem(ModArmory.titaniumAxe, 1, 1, 4 * m);
		addRandomChestItem(ModArmory.titaniumPick, 1, 1, 4 * m);
		addRandomChestItem(ModArmory.titaniumShovel, 1, 1, 4 * m);
		addRandomChestItem(ModArmory.titaniumSword, 1, 1, 4 * m);

		// In all chests - modArmory - titanium armor
		addRandomChestItem(ModArmory.titaniumBoots, 1, 1, 4 * m);
		addRandomChestItem(ModArmory.titaniumHelm, 1, 1, 4 * m);
		addRandomChestItem(ModArmory.titaniumPants, 1, 1, 4 * m);
		addRandomChestItem(ModArmory.titaniumPlate, 1, 1, 4 * m);
	}

	protected void addItemsForAllDungeons(int m) {

		// More ModItems for All Mob Dungeons (6):
		addRandomChestItem(ModItems.steelIngot, 1, 1, 4 * m);
		addRandomChestItem(ModItems.crystal, 1, 2, 4 * m);
		addRandomChestItem(ModItems.fleroviumShard, 1, 1, 2 * m);
		addRandomChestItem(ModItems.crystalShard, 1, 3, 5 * m);
		addRandomChestItem(ModItems.iceGem, 1, 1, 3 * m);
		addRandomChestItem(ModItems.blazeGem, 1, 1, 3 * m);

		// More ModArmory for All Dungeons (13):
		addRandomChestItem(ModArmory.steelAxe, 1, 1, 3 * m);
		addRandomChestItem(ModArmory.steelBoots, 1, 1, 3 * m);
		addRandomChestItem(ModArmory.steelHelm, 1, 1, 3 * m);
		addRandomChestItem(ModArmory.steelPants, 1, 1, 3 * m);
		addRandomChestItem(ModArmory.steelPick, 1, 1, 3 * m);
		addRandomChestItem(ModArmory.steelPlate, 1, 1, 3 * m);
		addRandomChestItem(ModArmory.steelShovel, 1, 1, 3 * m);
		addRandomChestItem(ModArmory.steelSword, 1, 1, 3 * m);
		addRandomChestItem(ModArmory.crystallizedSword, 1, 1, 2 * m);
		addRandomChestItem(ModArmory.gyroMace, 1, 1, 1 * m, Enchantment.knockback, 1);
		addRandomChestItem(ModArmory.shadowBlade, 1, 1, 1 * m);
		addRandomChestItem(ModArmory.etherealBlade, 1, 1, 1 * m);
		addRandomChestItem(ModArmory.wingedBlade, 1, 1, 1 * m);
	}

	protected void addItemsForHardDungeons(int m) {
		addRandomChestItem(ModArmory.divineRapier, 1, 1, 2 * m);
		addRandomChestItem(ModArmory.voidHammer, 1, 1, 2 * m, Enchantment.knockback, 2);
		addRandomChestItem(ModArmory.titaniumSword, 1, 1, 10 * m);
	}

	// Add 1 item
	protected void addItemsForSphinx(int m) {
		// Spawn egg(s)
		addRandomChestItem(ModItems.pharaohEgg, 1, 1, 100);
	}
}
