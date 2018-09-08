package valentin4311.candycraft.blocks;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCrops;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import valentin4311.candycraft.items.CCItems;

public class BlockDragibus extends BlockCrops
{
	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune)
	{
		return getCrop();
	}

	@Override
	public int quantityDropped(Random random)
	{
		return random.nextInt(3) + 1;
	}

	@Override
	protected boolean canSustainBush(IBlockState state)
	{
		return state.getBlock() == CCBlocks.candySoil;
	}

	@Override
	protected Item getCrop()
	{
		return CCItems.dragibus;
	}

	@Override
	protected Item getSeed()
	{
		return CCItems.dragibus;
	}

	@Override
	public ArrayList<ItemStack> getDrops(IBlockAccess blockAccess, BlockPos pos, IBlockState state, int fortune)
	{
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

		int metadata = getMetaFromState(state);
		int count = quantityDropped(state, fortune, Block.RANDOM);
		if (metadata < 7)
		{
			count = 1;
		}
		for (int i = 0; i < count; i++)
		{
			Item item = getItemDropped(state, Block.RANDOM, fortune);
			if (item != null)
			{
				ret.add(new ItemStack(item, 1, damageDropped(state)));
			}
		}
		return ret;
	}
}
