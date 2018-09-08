package valentin4311.candycraft.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import valentin4311.candycraft.CandyCraft;
import valentin4311.candycraft.CandyCraftPreferences;
import valentin4311.candycraft.items.CCItems;

public class BlockSugar extends Block
{
	public BlockSugar(Material par2Material)
	{
		super(par2Material);
	}

	@Override
	public int quantityDroppedWithBonus(int par1, Random par2Random)
	{
		return MathHelper.clamp(this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1), 1, 4);
	}

	@Override
	public int quantityDropped(Random par1Random)
	{
		return 2 + par1Random.nextInt(3);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random par2Random, int par3)
	{
		return Items.SUGAR;
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if ((playerIn.getHeldItem(hand).getItem() == Items.LAVA_BUCKET && CandyCraftPreferences.canOpenPortalWithLava) || (playerIn.getHeldItem(hand).getItem() == CCItems.caramelBucket && CandyCraftPreferences.canOpenPortalWithCaramel) && (worldIn.provider.getDimension() == 0 || worldIn.provider.getDimension() == CandyCraft.getCandyDimensionID()))
		{
			boolean isActivated = false;
			enable: for (int x = -1; x < 2; x++)
			{
				for (int y = -1; y < 2; y++)
				{
					for (int z = -1; z < 2; z++)
					{
						isActivated = CCBlocks.candyPortal.trySpawnPortal(worldIn, new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z));
						if (isActivated)
						{
							playerIn.setHeldItem(hand, new ItemStack(Items.BUCKET));
							break enable;
						}
					}
				}
			}
			return isActivated;
		}
		else
		{
			return false;
		}
	}
}
