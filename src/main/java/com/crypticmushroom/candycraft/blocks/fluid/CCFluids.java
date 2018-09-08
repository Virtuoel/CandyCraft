package com.crypticmushroom.candycraft.blocks.fluid;

import com.crypticmushroom.candycraft.blocks.CCBlocks;

import net.minecraftforge.fluids.FluidRegistry;

public class CCFluids
{
	public static FluidGrenadine grenadineFluid = new FluidGrenadine("candycraft:grenadine");
	public static FluidCaramel caramelFluid = new FluidCaramel("candycraft:caramel");

	public static void init()
	{
		FluidRegistry.registerFluid(grenadineFluid);
		FluidRegistry.registerFluid(caramelFluid);
	}

	public static void postInit()
	{
		grenadineFluid.setBlock(CCBlocks.grenadine);
		
		FluidRegistry.addBucketForFluid(grenadineFluid);
		// TODO drinkable caramel bucket
	//	FluidContainerRegistry.registerFluidContainer(CCFluids.caramelFluid, new ItemStack(CCItems.caramelBucket), FluidContainerRegistry.EMPTY_BUCKET);
	}
}
