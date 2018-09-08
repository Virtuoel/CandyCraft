package valentin4311.candycraft.world.biomes;

import java.awt.Color;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import valentin4311.candycraft.entity.EntityBunny;
import valentin4311.candycraft.entity.EntityCandyPig;
import valentin4311.candycraft.entity.EntityCandyWolf;
import valentin4311.candycraft.entity.EntitySuguard;
import valentin4311.candycraft.entity.EntityWaffleSheep;

public class BiomeGenMountains extends BiomeGenCandy
{
	public BiomeGenMountains(Biome.BiomeProperties properties)
	{
		super(properties);
		spawnableCreatureList.add(new SpawnListEntry(EntityCandyWolf.class, 12, 4, 4));
		spawnableMonsterList.add(new SpawnListEntry(EntitySuguard.class, 4, 4, 4));
		spawnableCreatureList.add(new SpawnListEntry(EntityCandyPig.class, 8, 4, 6));
		spawnableCreatureList.add(new SpawnListEntry(EntityBunny.class, 8, 4, 6));
		spawnableCreatureList.add(new SpawnListEntry(EntityWaffleSheep.class, 24, 4, 4));
		theBiomeDecorator2.treesPerChunk = 2;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getSkyColorByTemp(float par1)
	{
		return new Color(245, 220, 220).getRGB();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int getGrassColorAtPos(BlockPos pos)
	{
		return 0xEEBBCC;
	}
}
