package com.thexfactor117.ascension.items;

import java.util.List;

import net.minecraft.block.BlockFence;
import net.minecraft.block.BlockLiquid;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.thexfactor117.ascension.help.LogHelper;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.tabs.ModTabs;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ItemAscensionMonsterPlacer extends ItemMonsterPlacer
{
	@SideOnly(Side.CLIENT)
    protected int colorPrimary;
    protected int colorSecondary;
    protected String entityToSpawnName = "";
    protected String entityToSpawnNameFull = "";
    protected EntityLiving entityToSpawn = null;
    
    public ItemAscensionMonsterPlacer()
    {
        super();
    }
    
    public ItemAscensionMonsterPlacer(String name, int primary, int secondary)
    {
        setHasSubtypes(false);
        maxStackSize = 64;
        setCreativeTab(ModTabs.tabAscensionTest);
        setEntityToSpawnName(name);
        colorPrimary = primary;
        colorSecondary = secondary;
        // DEBUG
        LogHelper.info("Added spawn egg constructor for " + entityToSpawnName);
    }
    
    @Override
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, BlockPos pos, EnumFacing face, float hitX, float hitY, float hitZ)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            IBlockState block = world.getBlockState(pos);
            
            pos = pos.offset(face);
            double d0 = 0.0D;

            if (face == EnumFacing.UP && block instanceof BlockFence)
            {
                d0 = 0.5D;
            }

            Entity entity = spawnEntity(world, stack.getMetadata(), (double)pos.getX() + 0.5D, (double)pos.getY() + d0, (double)pos.getZ() + 0.5D);

            if (entity != null)
            {
                if (entity instanceof EntityLivingBase && stack.hasDisplayName())
                {
                    entity.setCustomNameTag(stack.getDisplayName());
                }

                if (!player.capabilities.isCreativeMode)
                {
                    --stack.stackSize;
                }
            }
            return true;
        }
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player)
    {
        if (world.isRemote)
        {
            return stack;
        }
        else
        {
            MovingObjectPosition moveObjPos = getMovingObjectPositionFromPlayer(world, player, true);

            if (moveObjPos == null)
            {
                return stack;
            }
            else
            {
                if (moveObjPos.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
                {
                    BlockPos pos = moveObjPos.getBlockPos();

                    if (!world.canMineBlockBody(player, pos))
                    {
                        return stack;
                    }

                    if (!player.canPlayerEdit(pos, moveObjPos.sideHit, stack))
                    {
                        return stack;
                    }

                    if (world.getBlockState(pos) instanceof BlockLiquid)
                    {
                        Entity entity = spawnEntity(world, stack.getMetadata(), (double)pos.getX() + 0.5D, (double)pos.getY() + 0.5D, (double)pos.getZ() + 0.5D);

                        if (entity != null)
                        {
                            if (entity instanceof EntityLivingBase && stack.hasDisplayName())
                            {
                                ((EntityLiving)entity).setCustomNameTag(stack.getDisplayName());
                            }

                            if (!player.capabilities.isCreativeMode)
                            {
                                --stack.stackSize;
                            }
                        }
                    }
                }
                return stack;
            }
        }
    }
    
    public Entity spawnEntity(World world, int entityID, double x, double y, double z)
    {   
       if (!world.isRemote)
       {
            entityToSpawnNameFull = Reference.MODID + "." + entityToSpawnName;
            if (EntityList.stringToClassMapping.containsKey(entityToSpawnNameFull))
            {
                entityToSpawn = (EntityLiving) EntityList.createEntityByName(entityToSpawnNameFull, world);
                entityToSpawn.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
                world.spawnEntityInWorld(entityToSpawn);
                entityToSpawn.func_180482_a(world.getDifficultyForLocation(new BlockPos(entityToSpawn)), (IEntityLivingData)null);
                entityToSpawn.playLivingSound();
            } else
            {
                LogHelper.error("Entity (" + entityToSpawnName + ") not found!");
            }
        }  
        return entityToSpawn;
    }
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List list)
    {
        list.add(new ItemStack(item, 1, 0));  
    }

    @Override
    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack stack, int type)
    {
        return (type == 0) ? colorPrimary : colorSecondary;
    }
    
    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {
        return "Spawn " + entityToSpawnName;
    } 
    
    public void setColors(int primary, int secondary)
    {
    	colorPrimary = primary;
    	colorSecondary = secondary;
    }
    
    public int getColorPrimary()
    {
    	return colorPrimary;
    }
    
    public int getColorSecondary()
    {
    	return colorSecondary;
    }
    
    public void setEntityToSpawnName(String name)
    {
        entityToSpawnName = name;
        entityToSpawnNameFull = Reference.MODID + "." + entityToSpawnName; 
    }
}
