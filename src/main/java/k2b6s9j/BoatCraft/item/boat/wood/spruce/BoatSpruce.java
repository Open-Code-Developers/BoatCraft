package k2b6s9j.BoatCraft.item.boat.wood.spruce;

import k2b6s9j.BoatCraft.entity.boat.EntityCustomBoat;
import k2b6s9j.BoatCraft.entity.boat.wood.spruce.EntityBoatSpruce;
import k2b6s9j.BoatCraft.item.boat.ItemCustomBoat;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class BoatSpruce extends ItemCustomBoat {

	public static int ID;
	public static int shiftedID ;
	
	public BoatSpruce(int id) {
		super(id);
		setUnlocalizedName("boat.wood.spruce.empty");
        func_111206_d("boatcraft:boat.wood.spruce.empty");
    	GameRegistry.registerItem(this, "Spruce Wood Boat");
    	shiftedID = this.itemID;
    	OreDictionary.registerOre("itemBoat", new ItemStack(this));
    	OreDictionary.registerOre("boat", new ItemStack(this));
    	OreDictionary.registerOre("boatSpruce", new ItemStack(this));
	}
	
	@Override
	public EntityCustomBoat getEntity(World world, int x, int y, int z) {
		EntityBoatSpruce entity = new EntityBoatSpruce(world, (double)((float)x + 0.5F), (double)((float)y + 1.0F), (double)((float)z + 0.5F));
		return entity;
	}
}
