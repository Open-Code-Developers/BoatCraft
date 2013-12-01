package k2b6s9j.BoatCraft.entity.boat.wood.spruce;

import k2b6s9j.BoatCraft.entity.boat.EntityCustomBoat;
import k2b6s9j.BoatCraft.item.boat.wood.spruce.BoatSpruceFurnace;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityBoatSpruceFurnace extends EntityCustomBoat {
	
	public BoatSpruceFurnace item;
	
	public EntityBoatSpruceFurnace(World par1World)
    {
        super(par1World);
    }

    public EntityBoatSpruceFurnace(World par1World, double par2, double par4, double par6)
    {
        super(par1World, par2, par4, par6);
    }
    
    @Override
    public boolean doesBoatContainBlock()
    {
    	return true;
    }
    
    @Override
    public ItemStack blockInBoat()
    {
    	return new ItemStack(Block.furnaceIdle, 1, 0);
    }

    public Block getDefaultDisplayTile()
    {
        return Block.furnaceBurning;
    }

    public int getDefaultDisplayTileData()
    {
        return 2;
    }
    
    public boolean func_130002_c(EntityPlayer player)
    {
    	//Do not mount this boat on right click!
        return false;
    }
    
    @Override
	public boolean isCustomBoat()
    {
    	return true;
    }
    
    @Override
	public boolean useItemID()
	{
		return true;
	}
    
	@Override
    public int customBoatItemID()
    {
    	return item.shiftedID;
    }
}
