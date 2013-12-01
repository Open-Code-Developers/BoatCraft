package k2b6s9j.BoatCraft.item.boat.wood.spruce;

import k2b6s9j.BoatCraft.entity.boat.EntityCustomBoat;
import k2b6s9j.BoatCraft.entity.boat.wood.spruce.EntityBoatSpruceChest;
import k2b6s9j.BoatCraft.item.boat.ItemCustomBoat;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import cpw.mods.fml.common.registry.GameRegistry;

public class BoatSpruceChest extends ItemCustomBoat {
	
	public static int ID;
	public static int shiftedID;
	
	public BoatSpruceChest(int id) {
		super(id);
		setUnlocalizedName("boat.wood.spruce.chest");
        func_111206_d("boatcraft:boat.wood.spruce.chest");
    	GameRegistry.registerItem(this, "Spruce Chest Boat");
    	shiftedID = this.itemID;
    	OreDictionary.registerOre("itemBoat", new ItemStack(this));
    	OreDictionary.registerOre("boat", new ItemStack(this));
    	OreDictionary.registerOre("boatSpruce", new ItemStack(this));
    	OreDictionary.registerOre("boatChest", new ItemStack(this));
    	OreDictionary.registerOre("boatSpruceChest", new ItemStack(this));
	}
	
	@Override
	public EntityCustomBoat getEntity(World world, int x, int y, int z) {
		EntityBoatSpruceChest entity = new EntityBoatSpruceChest(world, (double)((float)x + 0.5F), (double)((float)y + 1.0F), (double)((float)z + 0.5F));
		return entity;
	}
}
