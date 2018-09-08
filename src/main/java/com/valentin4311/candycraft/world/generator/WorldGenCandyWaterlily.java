package valentin4311.candycraft.world.generator;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;
import valentin4311.candycraft.blocks.CCBlocks;

public class WorldGenCandyWaterlily extends WorldGenerator
{
	public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
	{
		for (int l = 0; l < 10; ++l)
		{
			int i1 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
			int j1 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
			int k1 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);

			if (par1World.isAirBlock(new BlockPos(i1, j1, k1)) && CCBlocks.marshmallowSlice.canPlaceBlockAt(par1World, new BlockPos(i1, j1, k1)))
			{
				par1World.setBlockState(new BlockPos(i1, j1, k1), par2Random.nextInt(15) == 0 ? CCBlocks.marshmallowFlowerBlock.getDefaultState() : CCBlocks.marshmallowSlice.getDefaultState());
			}
		}

		return true;
	}

	@Override
	public boolean generate(World par1World, Random par2Random, BlockPos pos)
	{
		return generate(par1World, par2Random, pos.getX(), pos.getY(), pos.getZ());
	}
}
