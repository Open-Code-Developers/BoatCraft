package k2b6s9j.BoatCraft.item.boat.forestry.wood.cherry;

import k2b6s9j.BoatCraft.entity.boat.EntityCustomBoat;
import k2b6s9j.BoatCraft.entity.boat.forestry.wood.cherry.EntityBoatCherry;
import k2b6s9j.BoatCraft.item.boat.ItemCustomBoat;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class BoatCherry extends ItemCustomBoat {

	public static int ID;
	public static int shiftedID;
	
	public BoatCherry(int id) {
		super(id);
		setUnlocalizedName("boat.forestry.wood.cherry.empty");
        func_111206_d("boatcraft:boat.forestry.wood.cherry.empty");
    	GameRegistry.registerItem(this, "Cherry Wood Boat");
    	shiftedID = this.itemID;
    	OreDictionary.registerOre("itemBoat", new ItemStack(this));
    	OreDictionary.registerOre("boat", new ItemStack(this));
    	OreDictionary.registerOre("boatCherry", new ItemStack(this));
	}
	
	@Override
	public EntityCustomBoat getEntity(World world, int x, int y, int z) {
		EntityBoatCherry entity = new EntityBoatCherry(world, (double)((float)x + 0.5F), (double)((float)y + 1.0F), (double)((float)z + 0.5F));
		return entity;
	}
}