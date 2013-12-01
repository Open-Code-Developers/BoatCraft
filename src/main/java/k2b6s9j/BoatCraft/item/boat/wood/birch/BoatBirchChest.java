package k2b6s9j.BoatCraft.item.boat.wood.birch;

import k2b6s9j.BoatCraft.entity.boat.EntityCustomBoat;
import k2b6s9j.BoatCraft.entity.boat.wood.birch.EntityBoatBirchChest;
import k2b6s9j.BoatCraft.item.boat.ItemCustomBoat;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class BoatBirchChest extends ItemCustomBoat {
	
	public static int ID;
	public static int shiftedID;
	
	public BoatBirchChest(int id) {
		super(id);
		setUnlocalizedName("boat.wood.birch.chest");
        func_111206_d("boatcraft:boat.wood.birch.chest");
    	GameRegistry.registerItem(this, "Birch Chest Boat");
    	shiftedID = this.itemID;
    	OreDictionary.registerOre("itemBoat", new ItemStack(this));
    	OreDictionary.registerOre("boat", new ItemStack(this));
    	OreDictionary.registerOre("boatBirch", new ItemStack(this));
    	OreDictionary.registerOre("boatChest", new ItemStack(this));
    	OreDictionary.registerOre("boatBirchChest", new ItemStack(this));
	}
	
	@Override
	public EntityCustomBoat getEntity(World world, int x, int y, int z) {
		EntityBoatBirchChest entity = new EntityBoatBirchChest(world, (double)((float)x + 0.5F), (double)((float)y + 1.0F), (double)((float)z + 0.5F));
		return entity;
	}
}
