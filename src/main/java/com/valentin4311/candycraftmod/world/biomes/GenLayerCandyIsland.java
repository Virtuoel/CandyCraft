package com.valentin4311.candycraftmod.world.biomes;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.IntCache;

public class GenLayerCandyIsland extends GenLayer
{
	public GenLayerCandyIsland(long par1)
	{
		super(par1);
	}

	/**
	 * Returns a list of integer values generated by this layer. These may be
	 * interpreted as temperatures, rainfall amounts, or biomeList[] indices
	 * based on the particular GenLayer subclass.
	 */
	@Override
	public int[] getInts(int par1, int par2, int par3, int par4)
	{
		int[] aint = IntCache.getIntCache(par3 * par4);

		for (int i1 = 0; i1 < par4; ++i1)
		{
			for (int j1 = 0; j1 < par3; ++j1)
			{
				initChunkSeed(par1 + j1, par2 + i1);
				aint[j1 + i1 * par3] = nextInt(10) == 0 ? Biome.getIdForBiome(CCBiomes.candyPlains) : Biome.getIdForBiome(CCBiomes.candyOcean);
			}
		}

		if (par1 > -par3 && par1 <= 0 && par2 > -par4 && par2 <= 0)
		{
			aint[-par1 + -par2 * par3] = Biome.getIdForBiome(CCBiomes.candyPlains);
		}

		return aint;
	}
}
