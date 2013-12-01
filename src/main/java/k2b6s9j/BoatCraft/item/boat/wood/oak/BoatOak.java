package k2b6s9j.BoatCraft.item.boat.wood.oak;

import k2b6s9j.BoatCraft.entity.boat.EntityCustomBoat;
import k2b6s9j.BoatCraft.entity.boat.wood.oak.EntityBoatOak;
import k2b6s9j.BoatCraft.item.boat.ItemCustomBoat;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class BoatOak extends ItemCustomBoat {

	public static int ID;
	public static int shiftedID;
	
	public BoatOak(int id) {
		super(id);
		setUnlocalizedName("boat.wood.oak.empty");
        func_111206_d("boatcraft:boat.wood.oak.empty");
    	GameRegistry.registerItem(this, "Oak Wood Boat");
    	shiftedID = this.itemID;
    	OreDictionary.registerOre("itemBoat", new ItemStack(this));
    	OreDictionary.registerOre("boat", new ItemStack(this));
    	OreDictionary.registerOre("boatOak", new ItemStack(this));
	}
	
	@Override
	public EntityCustomBoat getEntity(World world, int x, int y, int z) {
		EntityBoatOak entity = new EntityBoatOak(world, (double)((float)x + 0.5F), (double)((float)y + 1.0F), (double)((float)z + 0.5F));
		return entity;
	}
}
