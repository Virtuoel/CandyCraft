package com.valentin4311.candycraft.blocks;

import java.util.Random;

import net.minecraft.block.BlockWeb;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockCandyWeb extends BlockWeb
{
	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Items.STRING;
	}
}
