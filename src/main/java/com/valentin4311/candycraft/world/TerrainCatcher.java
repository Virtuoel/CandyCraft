package valentin4311.candycraft.world;

import net.minecraftforge.event.terraingen.WorldTypeEvent.InitBiomeGens;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import valentin4311.candycraft.world.biomes.GenLayerCandyBiomes;

public class TerrainCatcher
{
	@SubscribeEvent
	public void setBiomes(InitBiomeGens event)
	{
		if (event.getWorldType() instanceof WorldTypeCandy)
		{
			event.setNewBiomeGens(GenLayerCandyBiomes.initBiomes(event.getSeed(), event.getWorldType()));
		}
	}
}
