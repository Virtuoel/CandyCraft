package com.crypticmushroom.candycraft.blocks;

import java.util.Arrays;
import java.util.Random;

import com.crypticmushroom.candycraft.CandyCraft;
import com.crypticmushroom.candycraft.blocks.tileentity.TileEntityTeleporter;
import com.crypticmushroom.candycraft.world.TeleporterDungeon;

import net.minecraft.block.Block;
import net.minecraft.block.BlockCactus;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTeleporter extends BlockContainer
{
	public static final PropertyEnum PROPERTIES = PropertyEnum.create("metadata", BlockTeleporter.EnumType.class, Arrays.asList(Arrays.copyOf(BlockTeleporter.EnumType.values(), 2)));
	protected static final AxisAlignedBB TELEPORTER_AABB = new AxisAlignedBB(0.2F, 0.0F, 0.2F, 0.8F, 0.06F, 0.8F);

	public BlockTeleporter(Material par2Material)
	{
		super(par2Material);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return TELEPORTER_AABB;
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
	public int quantityDropped(Random par1Random)
	{
		return 0;
	}

	@Override
	public boolean canPlaceBlockAt(World par1World, BlockPos pos)
	{
		return par1World.getBlockState(pos.down()).isOpaqueCube();
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		TileEntityTeleporter tileentityportal = (TileEntityTeleporter) worldIn.getTileEntity(pos);
		if (!worldIn.isRemote && playerIn.getRidingEntity() == null && playerIn.getControllingPassenger() == null && playerIn instanceof EntityPlayerMP && tileentityportal.generated)
		{
			EntityPlayerMP mp_player = (EntityPlayerMP) playerIn;
			playerIn.setPositionAndUpdate(tileentityportal.x, tileentityportal.y, tileentityportal.z);
			if (worldIn.provider.getDimension() != CandyCraft.getDungeonDimensionID())
			{
				mp_player.server.getPlayerList().transferPlayerToDimension(mp_player, CandyCraft.getDungeonDimensionID(), new TeleporterDungeon(mp_player.server.getWorld(CandyCraft.getDungeonDimensionID()), tileentityportal));
			}
			else
			{
				mp_player.server.getPlayerList().transferPlayerToDimension(mp_player, tileentityportal.dim, new TeleporterDungeon(mp_player.server.getWorld(tileentityportal.dim), tileentityportal));
			}
		}
		return true;
	}
	
	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (!worldIn.getBlockState(pos.down()).isOpaqueCube())
		{
			worldIn.setBlockToAir(pos);
		}
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2)
	{
		return new TileEntityTeleporter();
	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return ((BlockTeleporter.EnumType) state.getValue(PROPERTIES)).getMeta();
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return getDefaultState().withProperty(PROPERTIES, BlockTeleporter.EnumType.getState(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((BlockTeleporter.EnumType) state.getValue(PROPERTIES)).getMeta();
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] { PROPERTIES });
	}

	@Override
	@SideOnly(Side.CLIENT)
	public EnumBlockRenderType getRenderType(IBlockState state)
	{
		return EnumBlockRenderType.MODEL;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ItemStack getItem(World world, BlockPos pos, IBlockState state)
	{
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getRenderLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}

	public static enum EnumType implements IStringSerializable
	{
		TYPE0(0, "0"), TYPE1(1, "1");

		private static final BlockTeleporter.EnumType[] enumList = new BlockTeleporter.EnumType[values().length];
		private final int meta;
		private final String name;

		private EnumType(int m, String n)
		{
			meta = m;
			name = n;
		}

		public int getMeta()
		{
			return meta;
		}

		public static BlockTeleporter.EnumType getState(int meta)
		{
			if (meta < 0 || meta >= enumList.length)
			{
				meta = 0;
			}

			return enumList[meta];
		}

		@Override
		public String toString()
		{
			return name;
		}

		@Override
		public String getName()
		{
			return name;
		}

		static
		{
			BlockTeleporter.EnumType[] var0 = values();
			int var1 = var0.length;

			for (int var2 = 0; var2 < var1; ++var2)
			{
				BlockTeleporter.EnumType var3 = var0[var2];
				enumList[var3.getMeta()] = var3;
			}
		}
	}
}
