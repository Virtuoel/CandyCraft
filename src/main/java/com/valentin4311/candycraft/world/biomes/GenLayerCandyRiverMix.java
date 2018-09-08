package com.valentin4311.candycraft.world.biomes;

import net.minecraft.init.Biomes;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCandyRiverMix extends GenLayer
{
	private GenLayer biomePatternGeneratorChain;
	private GenLayer riverPatternGeneratorChain;

	public GenLayerCandyRiverMix(long p_i2129_1_, GenLayer p_i2129_3_, GenLayer p_i2129_4_)
	{
		super(p_i2129_1_);
		biomePatternGeneratorChain = p_i2129_3_;
		riverPatternGeneratorChain = p_i2129_4_;
	}

	/**
	 * Initialize layer's local worldGenSeed based on its own baseSeed and the
	 * world's global seed (passed in as an argument).
	 */
	@Override
	public void initWorldGenSeed(long p_75905_1_)
	{
		biomePatternGeneratorChain.initWorldGenSeed(p_75905_1_);
		riverPatternGeneratorChain.initWorldGenSeed(p_75905_1_);
		super.initWorldGenSeed(p_75905_1_);
	}

	/**
	 * Returns a list of integer values generated by this layer. These may be
	 * interpreted as temperatures, rainfall amounts, or biomeList[] indices
	 * based on the particular GenLayer subclass.
	 */
	@Override
	public int[] getInts(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_)
	{
		int[] aint = biomePatternGeneratorChain.getInts(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
		int[] aint1 = riverPatternGeneratorChain.getInts(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
		int[] aint2 = IntCache.getIntCache(p_75904_3_ * p_75904_4_);

		for (int i1 = 0; i1 < p_75904_3_ * p_75904_4_; ++i1)
		{
			if (aint[i1] != Biome.getIdForBiome(CCBiomes.candyOcean) && aint[i1] != Biome.getIdForBiome(CCBiomes.candyHellForest))
			{
				if (aint1[i1] == Biome.getIdForBiome(CCBiomes.candyRiver))
				{
					if (aint[i1] == Biome.getIdForBiome(Biomes.ICE_PLAINS))
					{
						aint2[i1] = Biome.getIdForBiome(Biomes.FROZEN_RIVER);
					}
					else if (aint[i1] != Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND) && aint[i1] != Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND_SHORE))
					{
						aint2[i1] = aint1[i1] & 255;
					}
					else
					{
						aint2[i1] = Biome.getIdForBiome(Biomes.MUSHROOM_ISLAND_SHORE);
					}
				}
				else
				{
					aint2[i1] = aint[i1];
				}
			}
			else
			{
				aint2[i1] = aint[i1];
			}
		}

		return aint2;
	}
}
