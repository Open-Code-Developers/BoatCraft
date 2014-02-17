package k2b6s9j.boatcraft.compatibility.ironchest.modifiers

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest._
import k2b6s9j.boatcraft.api.traits.Modifier
import cpw.mods.ironchest.{IronChestType, IronChest}

@RunWith(classOf[JUnitRunner])
class Gold_ChestTest extends FlatSpec with Matchers with BeforeAndAfter {

  var modifier: Modifier = null

  before {
    modifier = Gold_Chest
  }

  "The Gold Chest Modifier" should "be a modifier." in {
    modifier shouldBe a [Modifier]
  }

  it should "not be rideable." in {
    modifier.isRideable shouldBe false
  }

  it should "contain the Iron Chest block." in {
    modifier.getBlock shouldBe IronChest.ironChestBlock
  }

  it should "have the metadata of a Gold Chest" in {
    modifier.getMeta shouldBe IronChestType.GOLD.ordinal
  }

  it should "be called \"Gold Chest\"." in {
    modifier.getName shouldBe "Gold Chest"
  }

  /*
  it should "contain a Chest." in {
    modifier.getContent shouldBe new ItemStack(Blocks.chest)
  }
  */

}