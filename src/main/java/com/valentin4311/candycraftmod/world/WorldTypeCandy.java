package com.valentin4311.candycraftmod.world;

import net.minecraft.world.WorldType;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class WorldTypeCandy extends WorldType
{
	public WorldTypeCandy()
	{
		super("CandyCraft");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean canBeCreated()
	{
		return false;
	}
}
