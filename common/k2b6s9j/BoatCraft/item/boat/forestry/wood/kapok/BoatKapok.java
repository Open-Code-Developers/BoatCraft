package k2b6s9j.BoatCraft.item.boat.forestry.wood.kapok;

import k2b6s9j.BoatCraft.entity.boat.EntityCustomBoat;
import k2b6s9j.BoatCraft.entity.boat.forestry.wood.kapok.EntityBoatKapok;
import k2b6s9j.BoatCraft.item.boat.ItemCustomBoat;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class BoatKapok extends ItemCustomBoat {

	public static int ID;
	public static int shiftedID;
	
	public BoatKapok(int id) {
		super(id);
		setUnlocalizedName("boat.forestry.wood.kapok.empty");
        func_111206_d("boatcraft:boat.forestry.wood.kapok.empty");
    	GameRegistry.registerItem(this, "Kapok Wood Boat");
    	shiftedID = this.itemID;
    	OreDictionary.registerOre("itemBoat", new ItemStack(this));
    	OreDictionary.registerOre("boat", new ItemStack(this));
    	OreDictionary.registerOre("boatKapok", new ItemStack(this));
	}
	
	@Override
	public EntityCustomBoat getEntity(World world, int x, int y, int z) {
		EntityBoatKapok entity = new EntityBoatKapok(world, (double)((float)x + 0.5F), (double)((float)y + 1.0F), (double)((float)z + 0.5F));
		return entity;
	}
}