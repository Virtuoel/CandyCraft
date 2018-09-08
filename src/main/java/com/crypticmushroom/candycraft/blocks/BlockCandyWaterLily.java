package com.crypticmushroom.candycraft.blocks;

import java.util.Random;

import com.crypticmushroom.candycraft.items.CCItems;

import net.minecraft.block.BlockLilyPad;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockCandyWaterLily extends BlockLilyPad
{
	public BlockCandyWaterLily()
	{
		super();
		setTickRandomly(this != CCBlocks.marshmallowFlowerBlock);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int fortune)
	{
		return Item.getItemFromBlock(CCBlocks.marshmallowSlice);
	}
	
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
	{
		if (this == CCBlocks.marshmallowFlowerBlock && !worldIn.isRemote)
		{
			worldIn.setBlockState(pos, CCBlocks.marshmallowSlice.getDefaultState());
			spawnAsEntity(worldIn, pos, new ItemStack(CCItems.marshmallowFlower, 1, 0));
		}
		return this != CCBlocks.marshmallowSlice;
	}

	@Override
	public void updateTick(World par1World, BlockPos pos, IBlockState state, Random par5Random)
	{
		if (!par1World.isRemote && this != CCBlocks.marshmallowFlowerBlock)
		{
			if (par1World.getLight(pos.up()) >= 9)
			{
				if (par5Random.nextInt(80) == 0)
				{
					par1World.setBlockState(pos, CCBlocks.marshmallowFlowerBlock.getDefaultState());
				}
			}
		}
	}
}
