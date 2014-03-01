package k2b6s9j.boatcraft.compatibility.vanilla

import cpw.mods.fml.common.network.IGuiHandler
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.world.World
import net.minecraft.client.gui.inventory.GuiChest
import k2b6s9j.boatcraft.compatibility.vanilla.modifiers.Workbench

//TODO: Fill Documentation
/**
 *
 */
object VanillaGuiHandler extends IGuiHandler
{
  //TODO: Fill Documentation
  /**
   *
   * @param id
   * @param player
   * @param world
   * @param x
   * @param y
   * @param z
   * @return
   */
  override def getClientGuiElement(id: Int, player: EntityPlayer, world: World,
		x: Int, y: Int, z: Int): AnyRef =
	{
		id match
		{
			case 0 => new Workbench.Gui(player.inventory, world, x, y, z)
			case _ => null
		}
	}

  //TODO: Fill Documentation
  /**
   *
   * @param id
   * @param player
   * @param world
   * @param x
   * @param y
   * @param z
   * @return
   */
	override def getServerGuiElement(id: Int, player: EntityPlayer, world: World,
		x: Int, y: Int, z: Int): AnyRef =
	{
		id match
		{
			case 0 => new Workbench.Container(player.inventory, world, x, y, z)
			case _ => null
		}
	}
}