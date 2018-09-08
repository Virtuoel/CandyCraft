package com.valentin4311.candycraft.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockSpikes extends Block
{
	private int damage = 0;

	protected static final AxisAlignedBB SPIKES_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.6F, 1.0F);

	public BlockSpikes(int par2)
	{
		super(Material.CIRCUITS);
		damage = par2;
	}

	public boolean canBlockStay(World par1World, BlockPos pos)
	{
		return par1World.getBlockState(pos.down()).isOpaqueCube();
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return SPIKES_AABB;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	{
		return null;
	}

	@Override
	public boolean isFullCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean isOpaqueCube(IBlockState state)
	{
		return false;
	}

	@Override
	public boolean canPlaceBlockAt(World par1World, BlockPos pos)
	{
		return canBlockStay(par1World, pos);
	}
	
	@Override
	public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{
		if (entityIn instanceof EntityLivingBase)
		{
			entityIn.attackEntityFrom(DamageSource.GENERIC, damage / 2);
		}
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (!canBlockStay(worldIn, pos))
		{
			worldIn.setBlockToAir(pos);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public BlockRenderLayer getRenderLayer()
	{
		return BlockRenderLayer.CUTOUT;
	}
}
