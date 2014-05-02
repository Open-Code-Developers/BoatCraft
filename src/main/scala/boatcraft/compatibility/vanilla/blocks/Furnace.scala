package boatcraft.compatibility.vanilla.blocks

import boatcraft.api.boat.EntityCustomBoat
import boatcraft.api.traits.Block
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.inventory.IInventory
import net.minecraft.item.ItemStack
import net.minecraft.item.crafting.FurnaceRecipes
import net.minecraft.nbt.{NBTTagCompound, NBTTagList}
import net.minecraft.tileentity.TileEntityFurnace

object Furnace extends Block
{
	override def getBlock = Blocks.furnace
	override def getMeta = 3
	
	override def getName = "Furnace"
	
	override def getContent = new ItemStack(Blocks.furnace)
	
	override def getInventory(boat: EntityCustomBoat): IInventory =
		new Furnace.Inventory(boat)
	
	override def interact(player: EntityPlayer, boat: EntityCustomBoat) =
		player func_146101_a(boat.asInstanceOf[EntityCustomBoat]
							.getInventory.asInstanceOf[Inventory])
	
	override def update(boat: EntityCustomBoat) =
		(boat.asInstanceOf[EntityCustomBoat].getInventory.asInstanceOf[Furnace.Inventory]
			updateEntity)
	
	override def readStateFromNBT(boat: EntityCustomBoat, tag: NBTTagCompound) =
	{
		var inventory = boat.asInstanceOf[EntityCustomBoat]
						.getInventory.asInstanceOf[Furnace.Inventory]
		
		val nbttaglist = tag getTagList("Items", 10)

		for (i <- 0 until nbttaglist.tagCount)
		{
			val _tag = nbttaglist getCompoundTagAt i
			val b0 = _tag getByte "Slot"

			if (b0 >= 0 && b0 < inventory.getSizeInventory)
			{
				inventory setInventorySlotContents(b0,
						ItemStack loadItemStackFromNBT _tag)
			}
		}
		
		inventory.furnaceBurnTime = tag.getShort("BurnTime");
		inventory.furnaceCookTime = tag.getShort("CookTime");
		inventory.currentItemBurnTime = TileEntityFurnace getItemBurnTime
				(inventory getStackInSlot 1)
		
		if (tag hasKey("CustomName", 8))
		{
			//inventory.field_145958_o = p_145839_1_.getString("CustomName");
		}
	}
	
	override def writeStateToNBT(boat: EntityCustomBoat, tag: NBTTagCompound) =
	{
		var inventory = boat.asInstanceOf[EntityCustomBoat]
						.getInventory.asInstanceOf[Furnace.Inventory]
		
		tag setShort("BurnTime", inventory.furnaceBurnTime toShort)
		tag setShort("CookTime", inventory.furnaceCookTime toShort)
		val list = new NBTTagList

		for (i <- 0 until inventory.getSizeInventory)
		{
			if ((inventory getStackInSlot i) != null)
			{
				var _tag = new NBTTagCompound
				_tag setByte("Slot", i toByte)
				(inventory getStackInSlot i) writeToNBT _tag
				list appendTag _tag
			}
		}

		tag setTag("Items", list);

		if (inventory hasCustomInventoryName)
		{
			//tag setString("CustomName", inventory.field_145958_o);
		}
	}

	private class Inventory(boat: EntityCustomBoat) extends TileEntityFurnace
	{
		worldObj = boat.worldObj
		
		override def getInventoryName: String = "Furnace Boat"
		
		override def isUseableByPlayer(player: EntityPlayer): Boolean =
				(player getDistanceSqToEntity boat) <= 64
		
		override def updateEntity
		{
			var flag = furnaceBurnTime > 0

			if (furnaceBurnTime > 0)
				furnaceBurnTime = furnaceBurnTime - 1

			if (!worldObj.isRemote)
			{
				if (furnaceBurnTime == 0 && canSmelt)
				{
					currentItemBurnTime = TileEntityFurnace getItemBurnTime getStackInSlot(1)
					furnaceBurnTime = TileEntityFurnace getItemBurnTime getStackInSlot(1)

					if (furnaceBurnTime > 0)
					{
						if (getStackInSlot(1) != null)
						{
							getStackInSlot(1).stackSize = getStackInSlot(1).stackSize - 1

							if (getStackInSlot(1).stackSize == 0)
							{
								setInventorySlotContents(1,
									getStackInSlot(1).getItem getContainerItem getStackInSlot(1))
							}
						}
					}
				}

				if (isBurning && canSmelt)
				{
					furnaceCookTime = furnaceCookTime + 1

					if (furnaceCookTime == 200)
					{
						furnaceCookTime = 0
						smeltItem
					}
				}
				else furnaceCookTime = 0
			}
		}

		private def canSmelt: Boolean =
		{
			if (getStackInSlot(0) == null) false
			else
			{
				val itemstack = FurnaceRecipes.smelting.getSmeltingResult(getStackInSlot(0))
				if (itemstack == null) return false
				if (getStackInSlot(2) == null) return true
				if (!getStackInSlot(2).isItemEqual(itemstack)) return false
				val result = getStackInSlot(2).stackSize + itemstack.stackSize
				
				result <= getInventoryStackLimit &&
					result <= getStackInSlot(2).getMaxStackSize
			}
		}
	}
}