package k2b6s9j.BoatCraft

import cpw.mods.fml.common.Mod.{Instance, EventHandler}
import cpw.mods.fml.common.event.FMLInitializationEvent
import cpw.mods.fml.common.event.FMLPostInitializationEvent
import cpw.mods.fml.common.event.FMLPreInitializationEvent

import k2b6s9j.BoatCraft.utilities.log.ModLogger
import cpw.mods.fml.common.{SidedProxy, Mod}
import cpw.mods.fml.common.network.NetworkMod
import k2b6s9j.BoatCraft.Proxy.CommonProxy
import k2b6s9j.BoatCraft.registry._

@Mod(modid = "BoatCraft", name = "BoatCraft", version = "2.0", modLanguage = "scala",dependencies="after:Forestry;")
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
class BoatCraft
{
	  @Instance("BoatCraft")
    val instance: k2b6s9j.BoatCraft.BoatCraft = instance

	  @SidedProxy(clientSide="k2b6s9j.BoatCraft.Proxy.ClientProxy", serverSide="k2b6s9j.BoatCraft.Proxy.CommonProxy")
	  def proxy: k2b6s9j.BoatCraft.Proxy.CommonProxy = proxy

    @EventHandler
	  def PreInit (event:FMLPreInitializationEvent)
	  {
        ModLogger.info("BoatCraft")
        ModLogger.info("Copyright Kepler Sticka-Jones 2013")
        ModLogger.info("http://k2b6s9j.com/projects/minecraft/BoatCraft")

        //Configuration Registration
        ConfigRegistry.CreateConfig(event)

        //Item Registration
        ItemRegistry.InitItems()

        RecipeRegistration.RegisterRecipes()

        //Entity Registration
        proxy.registerRenderers()
        EntityRegistry.RegisterEntities()

        //Statistics Registration
        StatisticsRegistration.RegisterMCStats()
	  }

	  @EventHandler
	  def Init (event:FMLInitializationEvent)
	  {
      LanguageRegistry.RegisterName()
    }

	  @EventHandler
	  def PostInit (event:FMLPostInitializationEvent)
	  {

	  }
}
