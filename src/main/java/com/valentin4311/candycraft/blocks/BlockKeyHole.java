package valentin4311.candycraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import valentin4311.candycraft.items.ItemBossKey;

public class BlockKeyHole extends Block
{
	private int keyId;

	public BlockKeyHole(Material par2Material, int id)
	{
		super(par2Material);
		keyId = id;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (!worldIn.isRemote && playerIn.getHeldItem(hand).getItem() instanceof ItemBossKey && ((ItemBossKey) playerIn.getHeldItem(hand).getItem()).keyId == keyId)
		{
			worldIn.setBlockToAir(pos);
			if (worldIn.getBlockState(pos.up()).getBlock() == this)
			{
				worldIn.setBlockToAir(pos.up());
			}
			if (worldIn.getBlockState(pos.down()).getBlock() == this)
			{
				worldIn.setBlockToAir(pos.down());
			}
			playerIn.getHeldItem(hand).shrink(1);

			return true;
		}
		else
		{
			return true;
		}
	}
}
