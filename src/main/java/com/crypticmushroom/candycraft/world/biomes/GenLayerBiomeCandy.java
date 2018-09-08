package com.crypticmushroom.candycraft.world.biomes;

import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerBiomeCandy extends GenLayer
{
	private Biome[] field_151623_c;
	private Biome[] field_151621_d;
	private Biome[] field_151622_e;
	private Biome[] field_151620_f;
	private static final String __OBFID = "CL_00000555";

	public GenLayerBiomeCandy(long par1, GenLayer par3GenLayer, WorldType par4WorldType)
	{
		super(par1);
		field_151623_c = new Biome[] { CCBiomes.candyEnchantedForest, CCBiomes.candyHellForest };
		field_151621_d = new Biome[] { CCBiomes.candyForest, CCBiomes.candyPlains, CCBiomes.candyOcean };
		field_151622_e = new Biome[] { CCBiomes.candyColdForest, CCBiomes.candyMountains, CCBiomes.candyFrostPlains, CCBiomes.candyOcean };
		field_151620_f = new Biome[] { CCBiomes.candyHellMountains };
		parent = par3GenLayer;
	}

	/**
	 * Returns a list of integer values generated by this layer. These may be
	 * interpreted as temperatures, rainfall amounts, or biomeList[] indices
	 * based on the particular GenLayer subclass.
	 */
	@Override
	public int[] getInts(int par1, int par2, int par3, int par4)
	{
		int[] aint = parent.getInts(par1, par2, par3, par4);
		int[] aint1 = IntCache.getIntCache(par3 * par4);

		for (int i1 = 0; i1 < par4; ++i1)
		{
			for (int j1 = 0; j1 < par3; ++j1)
			{
				initChunkSeed(j1 + par1, i1 + par2);
				int k1 = aint[j1 + i1 * par3];
				int l1 = (k1 & 3840) >> 8;
				k1 &= -3841;
				if (k1 == Biome.getIdForBiome(CCBiomes.candyOcean))
				{
					aint1[j1 + i1 * par3] = k1;
				}
				else if (k1 == Biome.getIdForBiome(CCBiomes.candyMountains))
				{
					aint1[j1 + i1 * par3] = k1;
				}
				else if (k1 == 1)
				{
					if (l1 > 0)
					{
						if (nextInt(3) == 0)
						{
							aint1[j1 + i1 * par3] = Biome.getIdForBiome(CCBiomes.candyPlains);
						}
						else
						{
							aint1[j1 + i1 * par3] = Biome.getIdForBiome(CCBiomes.candyEnchantedForest);
						}
					}
					else
					{
						aint1[j1 + i1 * par3] = Biome.getIdForBiome(field_151623_c[nextInt(field_151623_c.length)]);
					}
				}
				else if (k1 == 2)
				{
					if (l1 > 0)
					{
						aint1[j1 + i1 * par3] = Biome.getIdForBiome(CCBiomes.candyForest);
					}
					else
					{
						aint1[j1 + i1 * par3] = Biome.getIdForBiome(field_151621_d[nextInt(field_151621_d.length)]);
					}
				}
				else if (k1 == 3)
				{
					if (l1 > 0)
					{
						aint1[j1 + i1 * par3] = Biome.getIdForBiome(CCBiomes.candyMountains);
					}
					else
					{
						if (nextInt(12) == 0)
						{
							aint1[j1 + i1 * par3] = Biome.getIdForBiome(CCBiomes.candyHellMountains);
						}
						else
						{
							aint1[j1 + i1 * par3] = Biome.getIdForBiome(field_151622_e[nextInt(field_151622_e.length)]);
						}
					}
				}
				else if (k1 == 4)
				{
					aint1[j1 + i1 * par3] = Biome.getIdForBiome(field_151620_f[nextInt(field_151620_f.length)]);
				}
				else
				{
					aint1[j1 + i1 * par3] = Biome.getIdForBiome(CCBiomes.candyMountains);
				}
			}
		}

		return aint1;
	}
}