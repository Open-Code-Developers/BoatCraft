package k2b6s9j.BoatCraft.compatibility.forestry.render.boat.wood.sequoia;

import k2b6s9j.BoatCraft.compatibility.forestry.entity.boat.forestry.wood.sequoia.EntityBoatSequoia;
import k2b6s9j.BoatCraft.entity.boat.EntityCustomBoat;
import k2b6s9j.BoatCraft.render.RenderBoat;
import net.minecraft.util.ResourceLocation;

public class RenderSequoiaWoodBoat extends RenderBoat {
	
	@Override
	public ResourceLocation getTexture() {
		return new ResourceLocation("boatcraft:textures/boats/forestry/sequoia.png");
    }
	
	@Override
	public EntityCustomBoat getEntity() {
		EntityBoatSequoia entity =  null;
		return entity;
	}
}