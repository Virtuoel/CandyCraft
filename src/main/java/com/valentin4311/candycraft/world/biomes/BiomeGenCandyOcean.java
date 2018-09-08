package valentin4311.candycraft.world.biomes;

import java.awt.Color;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import valentin4311.candycraft.entity.EntityFish;
import valentin4311.candycraft.entity.EntityNessie;

public class BiomeGenCandyOcean extends BiomeGenCandy
{
	public BiomeGenCandyOcean(Biome.BiomeProperties properties)
	{
		super(properties);
		spawnableCreatureList.clear();
		spawnableWaterCreatureList.clear();
		theBiomeDecorator2.waterlilyPerChunk = 0;
		spawnableWaterCreatureList.add(new SpawnListEntry(EntityFish.class, 75, 4, 4));
		spawnableWaterCreatureList.add(new SpawnListEntry(EntityNessie.class, 25, 1, 3));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getGrassColorAtPos(BlockPos pos)
	{
		return 0xB35EFF;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float par1)
	{
		return new Color(205, 149, 255).getRGB();
	}
}
