package boatcraft.compatibility.vanilla.blocks

import boatcraft.api.boat.EntityCustomBoat
import boatcraft.core.utilities.NBTHelper
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.tileentity.TileEntityChest
import boatcraft.api.traits.Block

object Chest extends Block
{
	override def getBlock = Blocks.chest
	
	override def getInventory(boat: EntityCustomBoat): IInventory =
		new Chest.Inventory(boat)
	
	override def getName = "Chest"
	
	override def getContent = new ItemStack(Blocks.chest)
	
	override def interact(player: EntityPlayer, boat: EntityCustomBoat) =
		//player openGui(Vanilla, 0, player.worldObj, 0, 0, 0)
		player displayGUIChest boat.asInstanceOf[IInventory]
	
	override def writeStateToNBT(boat: EntityCustomBoat, tag: NBTTagCompound) =
		NBTHelper writeChestToNBT (boat.asInstanceOf[IInventory], tag)
	
	override def readStateFromNBT(boat: EntityCustomBoat, tag: NBTTagCompound) =
		NBTHelper readChestFromNBT (boat.asInstanceOf[IInventory], tag)
	
	private class Inventory(boat: EntityCustomBoat) extends TileEntityChest
	{
		worldObj = boat.worldObj
		
		override def getInventoryName = "Chest Boat"
		
		override def hasCustomInventoryName = false
		
		override def isUseableByPlayer(player: EntityPlayer) =
			(player getDistanceSqToEntity boat) <= 64
		
		//TODO make it render it on the boat
		override def openInventory {}
		
		override def closeInventory {}
	}
}