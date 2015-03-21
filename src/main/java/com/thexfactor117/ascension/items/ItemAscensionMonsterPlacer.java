package com.thexfactor117.ascension.items;

import java.util.List;

import com.thexfactor117.ascension.help.LogHelper;
import com.thexfactor117.ascension.help.Reference;
import com.thexfactor117.ascension.tabs.ModTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLiquid;
import net.minecraft.client.renderer.texture.IIconRegister;
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
import net.minecraft.util.Facing;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

/**
 * 
 * @author TheXFactor117
 *
 */

public class ItemAscensionMonsterPlacer extends ItemMonsterPlacer
{
	@SideOnly(Side.CLIENT)
    private IIcon theIcon;
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
    public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
        if (world.isRemote)
        {
            return true;
        }
        else
        {
            Block block = world.getBlock(par4, par5, par6);
            par4 += Facing.offsetsXForSide[par7];
            par5 += Facing.offsetsYForSide[par7];
            par6 += Facing.offsetsZForSide[par7];
            double d0 = 0.0D;

            if (par7 == 1 && block.getRenderType() == 11)
            {
                d0 = 0.5D;
            }

            Entity entity = spawnEntity(world, par4 + 0.5D, par5 + d0, par6 + 0.5D);

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
            MovingObjectPosition movingobjectposition = getMovingObjectPositionFromPlayer(world, player, true);

            if (movingobjectposition == null)
            {
                return stack;
            }
            else
            {
                if (movingobjectposition.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK)
                {
                    int i = movingobjectposition.blockX;
                    int j = movingobjectposition.blockY;
                    int k = movingobjectposition.blockZ;

                    if (!world.canMineBlock(player, i, j, k))
                    {
                        return stack;
                    }

                    if (!player.canPlayerEdit(i, j, k, movingobjectposition.sideHit, stack))
                    {
                        return stack;
                    }

                    if (world.getBlock(i, j, k) instanceof BlockLiquid)
                    {
                        Entity entity = spawnEntity(world, i, j, k);

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
    
    public Entity spawnEntity(World world, double x, double y, double z)
    {   
       if (!world.isRemote)
       {
            entityToSpawnNameFull = Reference.MODID + "." + entityToSpawnName;
            if (EntityList.stringToClassMapping.containsKey(entityToSpawnNameFull))
            {
                entityToSpawn = (EntityLiving) EntityList.createEntityByName(entityToSpawnNameFull, world);
                entityToSpawn.setLocationAndAngles(x, y, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
                world.spawnEntityInWorld(entityToSpawn);
                entityToSpawn.onSpawnWithEgg((IEntityLivingData)null);
                entityToSpawn.playLivingSound();
            }
            else
            {
                //DEBUG
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
    @SideOnly(Side.CLIENT)
    public boolean requiresMultipleRenderPasses()
    {
        return true;
    }
    
    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {
        return "Spawn " + entityToSpawnName;
    } 
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister par1IconRegister)
    {
        super.registerIcons(par1IconRegister);
        theIcon = par1IconRegister.registerIcon(getIconString() + "_overlay");
    }
    
    /**
     * Gets an icon index based on an item's damage value and the given render pass
     */
    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamageForRenderPass(int damageValue, int renderPass)
    {
        return renderPass > 0 ? theIcon : super.getIconFromDamageForRenderPass(damageValue, renderPass);
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
