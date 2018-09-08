package valentin4311.candycraft.blocks;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import valentin4311.candycraft.items.CCItems;

public class BlockHoneyOre extends BlockCandyBase
{
	public BlockHoneyOre(Material material)
	{
		super(material);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return CCItems.honeyShard;
	}

	@Override
	public int quantityDropped(Random random)
	{
		return 2 + (random.nextInt(2));
	}
}
