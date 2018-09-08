package valentin4311.candycraft.blocks.fluid;

import net.minecraftforge.fluids.FluidRegistry;
import valentin4311.candycraft.blocks.CCBlocks;

public class CCFluids
{
	public static FluidGrenadine grenadineFluid = new FluidGrenadine("candycraftmod:grenadine");
	public static FluidCaramel caramelFluid = new FluidCaramel("candycraftmod:caramel");

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
