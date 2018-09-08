package com.valentin4311.candycraft.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCandyAddIsland extends GenLayer
{
	private static final String __OBFID = "CL_00000551";

	public GenLayerCandyAddIsland(long p_i2119_1_, GenLayer p_i2119_3_)
	{
		super(p_i2119_1_);
		parent = p_i2119_3_;
	}

	/**
	 * Returns a list of integer values generated by this layer. These may be
	 * interpreted as temperatures, rainfall amounts, or biomeList[] indices
	 * based on the particular GenLayer subclass.
	 */
	@Override
	public int[] getInts(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_)
	{
		int i1 = p_75904_1_ - 1;
		int j1 = p_75904_2_ - 1;
		int k1 = p_75904_3_ + 2;
		int l1 = p_75904_4_ + 2;
		int[] aint = parent.getInts(i1, j1, k1, l1);
		int[] aint1 = IntCache.getIntCache(p_75904_3_ * p_75904_4_);

		for (int i2 = 0; i2 < p_75904_4_; ++i2)
		{
			for (int j2 = 0; j2 < p_75904_3_; ++j2)
			{
				int k2 = aint[j2 + 0 + (i2 + 0) * k1];
				int l2 = aint[j2 + 2 + (i2 + 0) * k1];
				int i3 = aint[j2 + 0 + (i2 + 2) * k1];
				int j3 = aint[j2 + 2 + (i2 + 2) * k1];
				int k3 = aint[j2 + 1 + (i2 + 1) * k1];
				initChunkSeed(j2 + p_75904_1_, i2 + p_75904_2_);

				if (k3 == Biome.getIdForBiome(CCBiomes.candyOcean) && (k2 != Biome.getIdForBiome(CCBiomes.candyOcean) || l2 != Biome.getIdForBiome(CCBiomes.candyOcean) || i3 != Biome.getIdForBiome(CCBiomes.candyOcean) || j3 != Biome.getIdForBiome(CCBiomes.candyOcean)))
				{
					int l3 = 1;
					int i4 = 1;

					if (k2 != Biome.getIdForBiome(CCBiomes.candyOcean) && nextInt(l3++) == 0)
					{
						i4 = k2;
					}

					if (l2 != Biome.getIdForBiome(CCBiomes.candyOcean) && nextInt(l3++) == 0)
					{
						i4 = l2;
					}

					if (i3 != Biome.getIdForBiome(CCBiomes.candyOcean) && nextInt(l3++) == 0)
					{
						i4 = i3;
					}

					if (j3 != Biome.getIdForBiome(CCBiomes.candyOcean) && nextInt(l3++) == 0)
					{
						i4 = j3;
					}

					if (nextInt(3) == 0)
					{
						aint1[j2 + i2 * p_75904_3_] = i4;
					}
					else if (i4 == Biome.getIdForBiome(CCBiomes.candyForest))
					{
						aint1[j2 + i2 * p_75904_3_] = Biome.getIdForBiome(CCBiomes.candyForest);
					}
					else
					{
						aint1[j2 + i2 * p_75904_3_] = Biome.getIdForBiome(CCBiomes.candyOcean);
					}
				}
				else if (k3 != Biome.getIdForBiome(CCBiomes.candyOcean) && (k2 == Biome.getIdForBiome(CCBiomes.candyOcean) || l2 == Biome.getIdForBiome(CCBiomes.candyOcean) || i3 == Biome.getIdForBiome(CCBiomes.candyOcean) || j3 == Biome.getIdForBiome(CCBiomes.candyOcean)))
				{
					if (nextInt(5) == 0)
					{
						if (k3 == Biome.getIdForBiome(CCBiomes.candyForest))
						{
							aint1[j2 + i2 * p_75904_3_] = Biome.getIdForBiome(CCBiomes.candyForest);
						}
						else
						{
							aint1[j2 + i2 * p_75904_3_] = Biome.getIdForBiome(CCBiomes.candyOcean);
						}
					}
					else
					{
						aint1[j2 + i2 * p_75904_3_] = k3;
					}
				}
				else
				{
					aint1[j2 + i2 * p_75904_3_] = k3;
				}
			}
		}

		return aint1;
	}
}
