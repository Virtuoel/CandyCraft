package valentin4311.candycraft.blocks;

import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.UniversalBucket;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import valentin4311.candycraft.blocks.fluid.CCFluids;
import valentin4311.candycraft.blocks.tileentity.TileEntityAlchemy;
import valentin4311.candycraft.items.CCItems;

public class BlockAlchemyTable extends BlockContainer
{
	public BlockAlchemyTable(Material material)
	{
		super(material);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		ItemStack grenadineBucket = FluidUtil.getFilledBucket(new FluidStack(CCFluids.grenadineFluid, 1000));
		FluidStack contained = FluidUtil.getFluidContained(player.getHeldItem(hand));
		if (contained.getFluid() == CCFluids.grenadineFluid && contained.amount == 1000)
		{
			TileEntityAlchemy table = (TileEntityAlchemy) worldIn.getTileEntity(pos);

			if (!table.isTopFilled())
			{
				table.setTopFilled(true);
				player.setHeldItem(hand, new ItemStack(Items.BUCKET));
				if (worldIn.isRemote)
				{
					table.refreshPackets();
				}
				return true;
			}
			else if (table.getLiquid() < 7)
			{
				table.setLiquid(table.getLiquid() + 1);
				player.setHeldItem(hand, new ItemStack(Items.BUCKET));
				if (worldIn.isRemote)
				{
					table.refreshPackets();
				}
				return true;
			}
			return false;
		}
		else if (player.getHeldItem(hand) != null && player.getHeldItem(hand).getItem() == Items.BUCKET)
		{
			TileEntityAlchemy table = (TileEntityAlchemy) worldIn.getTileEntity(pos);

			if (table.isTopFilled())
			{
				table.setTopFilled(false);
				player.getHeldItem(hand).shrink(1);
				if (!player.inventory.addItemStackToInventory(grenadineBucket))
				{
					player.dropItem(grenadineBucket, false);
				}
				if (worldIn.isRemote)
				{
					table.refreshPackets();
				}
				return true;
			}
			else if (table.getLiquid() > 0)
			{
				table.setLiquid(table.getLiquid() - 1);
				player.getHeldItem(hand).shrink(1);
				if (!player.inventory.addItemStackToInventory(grenadineBucket))
				{
					player.dropItem(grenadineBucket, false);
				}

				if (worldIn.isRemote)
				{
					table.refreshPackets();
				}
				return true;
			}
			return false;
		}
		else if (player.getHeldItem(hand) != null)
		{
			TileEntityAlchemy table = (TileEntityAlchemy) worldIn.getTileEntity(pos);

			if (table.isTopFilled() && table.addPotionToRecipes(player.getHeldItem(hand)))
			{
				if (player.getHeldItem(hand).getItem() != CCItems.caramelBucket)
				{
					player.getHeldItem(hand).shrink(1);
				}
				else
				{
					player.setHeldItem(hand, new ItemStack(Items.BUCKET));
				}
				table.refreshPackets();
				return true;
			}

			return false;
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2)
	{
		return new TileEntityAlchemy();
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getRenderLayer()
	{
		return BlockRenderLayer.SOLID;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(IBlockState stateIn, World world, BlockPos pos, Random random)
	{
		TileEntityAlchemy table = (TileEntityAlchemy) world.getTileEntity(pos);

		for (int l = 0; l < table.getIngredientsCount() * 2; ++l)
		{
			double d0 = pos.getX() + random.nextFloat() / 2;
			double d1 = pos.getY() + random.nextFloat();
			double d2 = pos.getZ() + random.nextFloat() / 2;

			world.spawnParticle(EnumParticleTypes.SPELL_MOB, d0 + 0.25d, d1 + 0.8d, d2 + 0.25d, random.nextDouble(), random.nextDouble(), random.nextDouble());
		}
	}
}
