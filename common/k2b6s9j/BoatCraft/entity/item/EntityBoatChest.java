package k2b6s9j.BoatCraft.entity.item;

import k2b6s9j.BoatCraft.item.boat.BoatChest;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityBoatChest extends EntityBoatContainer {

	public BoatChest item;
	
	public EntityBoatChest(World par1World)
    {
        super(par1World);
    }

    public EntityBoatChest(World par1World, double par2, double par4, double par6)
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
    	return new ItemStack(Block.chest, 1, 0);
    }
    
    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return 27;
    }

    public Block getDefaultDisplayTile()
    {
        return Block.chest;
    }

    public int getDefaultDisplayTileOffset()
    {
        return 8;
    }

	@Override
	public boolean isInvNameLocalized() {
		return false;
	}
	
	@Override
	public String getInvName() {
		return "Boat";
	}
	
	@Override
	public boolean isCustomBoat()
    {
    	return true;
    }
    
	@Override
    public ItemStack customBoatItem()
    {
    	return new ItemStack(item, 1, 0);
    }
}
