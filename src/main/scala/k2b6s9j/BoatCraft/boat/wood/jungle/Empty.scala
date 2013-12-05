package k2b6s9j.BoatCraft.boat.wood.jungle

import k2b6s9j.BoatCraft.boat.Boat.{ItemCustomBoat, RenderBoat, EntityCustomBoat}
import k2b6s9j.BoatCraft.boat.Materials
import cpw.mods.fml.common.registry.GameRegistry
import net.minecraftforge.oredict.OreDictionary
import net.minecraft.item.ItemStack
import net.minecraft.world.World

object Empty {

  class Entity(world: World) extends EntityCustomBoat(world) with Materials.Entity.Wood.Jungle {

    override def useItemID(): Boolean = {
      true
    }

    override def customBoatItemID(): Int = {
      Item.shiftedID
    }

  }

  object Item {

    var ID: Int = 0
    var shiftedID: Int = 0

  }

  class Item(id: Int) extends ItemCustomBoat(id) {

    setUnlocalizedName("boat.wood.jungle.empty")
    func_111206_d("boatcraft:boat.wood.jungle.empty")
    GameRegistry.registerItem(this, "Jungle Wood Boat")
    Item.shiftedID = this.itemID
    OreDictionary.registerOre("boatJungleWoodEmpty", new ItemStack(this))

    override def getEntity(world: World, x: Int, y: Int, z: Int): EntityCustomBoat = {
      new Entity(world)
    }

  }

  class Render extends RenderBoat with Materials.Render.Wood.Jungle {

    override def getEntity(): EntityCustomBoat = {
      val entity: Entity =  null
      return entity
    }

  }

}