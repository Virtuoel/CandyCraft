package com.valentin4311.candycraftmod.world.biomes;

import net.minecraft.world.biome.Biome;

public class BiomePropertiesCandy extends Biome.BiomeProperties
{
	public BiomePropertiesCandy(String nameIn)
	{
		super(nameIn);
		setWaterColor(0xFFFF66);
		setRainDisabled();
	}
}
