package com.valentin4311.candycraft.world.generator;

import java.util.Random;

import com.valentin4311.candycraft.blocks.CCBlocks;
import com.valentin4311.candycraft.world.WorldProviderCandy;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenWaterTemple extends WorldGenerator
{
	World world;

	@Override
	public boolean generate(World world, Random random, BlockPos pos)
	{
		this.world = world;
		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();

		WorldProviderCandy.canGenTemple = 400;
		j = j + 10;
		for (int o = 0; world.getBlockState(new BlockPos(i, j - 1, k)).getBlock() != CCBlocks.flour; j--)
		{
			if (j < 20)
			{
				return false;
			}
		}
		if (world.getBlockState(new BlockPos(i, j + 12, k)).getBlock() != Blocks.WATER)
		{
			return false;
		}

		for (int v = 0; v <= 3; v++)
		{
			world.setBlockToAir(new BlockPos(i, j + v, k));
			world.setBlockToAir(new BlockPos(i - 1, j + v, k));
			world.setBlockToAir(new BlockPos(i + 1, j + v, k));
			world.setBlockToAir(new BlockPos(i, j + v, k - 1));
			world.setBlockToAir(new BlockPos(i, j + v, k + 1));
			world.setBlockToAir(new BlockPos(i - 1, j + v, k - 1));
			world.setBlockToAir(new BlockPos(i - 1, j + v, k + 1));
			world.setBlockToAir(new BlockPos(i + 1, j + v, k - 1));
			world.setBlockToAir(new BlockPos(i + 1, j + v, k + 1));
			world.setBlockToAir(new BlockPos(i - 2, j + v, k));
			world.setBlockToAir(new BlockPos(i + 2, j + v, k));
			world.setBlockToAir(new BlockPos(i, j + v, k + 2));
			world.setBlockToAir(new BlockPos(i, j + v, k - 2));
			world.setBlockToAir(new BlockPos(i - 2, j + v, k + 1));
			world.setBlockToAir(new BlockPos(i - 2, j + v, k - 1));
			world.setBlockToAir(new BlockPos(i + 2, j + v, k - 1));
			world.setBlockToAir(new BlockPos(i + 2, j + v, k + 1));
			world.setBlockToAir(new BlockPos(i - 1, j + v, k + 2));
			world.setBlockToAir(new BlockPos(i - 1, j + v, k - 2));
			world.setBlockToAir(new BlockPos(i + 1, j + v, k + 2));
			world.setBlockToAir(new BlockPos(i + 1, j + v, k - 2));
			world.setBlockToAir(new BlockPos(i, j + v, k - 3));
			world.setBlockToAir(new BlockPos(i, j + v, k + 3));
			world.setBlockToAir(new BlockPos(i + 3, j + v, k));
			world.setBlockToAir(new BlockPos(i - 3, j + v, k));
			world.setBlockToAir(new BlockPos(i - 3, j + v, k + 1));
			world.setBlockToAir(new BlockPos(i - 3, j + v, k - 1));
			world.setBlockToAir(new BlockPos(i + 3, j + v, k + 1));
			world.setBlockToAir(new BlockPos(i + 3, j + v, k - 1));
			world.setBlockToAir(new BlockPos(i - 1, j + v, k - 3));
			world.setBlockToAir(new BlockPos(i + 1, j + v, k - 3));
			world.setBlockToAir(new BlockPos(i - 1, j + v, k + 3));
			world.setBlockToAir(new BlockPos(i + 1, j + v, k + 3));
			world.setBlockToAir(new BlockPos(i + 2, j + v, k - 2));
			world.setBlockToAir(new BlockPos(i + 2, j + v, k + 2));
			world.setBlockToAir(new BlockPos(i - 2, j + v, k - 2));
			world.setBlockToAir(new BlockPos(i - 2, j + v, k + 2));
		}
		this.setBlock(i, j, k, CCBlocks.marshmallowChest, 0, 2);
		this.setBlock(i, j - 1, k, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i - 1, j - 1, k, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i + 1, j - 1, k, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i, j - 1, k - 1, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i, j - 1, k + 1, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i - 1, j - 1, k - 1, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i - 1, j - 1, k + 1, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i + 1, j - 1, k - 1, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i + 1, j - 1, k + 1, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i - 2, j - 1, k, CCBlocks.honeyLamp, 0, 3);
		this.setBlock(i + 2, j - 1, k, CCBlocks.honeyLamp, 0, 3);
		this.setBlock(i, j - 1, k + 2, CCBlocks.honeyLamp, 0, 3);
		this.setBlock(i, j - 1, k - 2, CCBlocks.honeyLamp, 0, 3);
		this.setBlock(i - 2, j - 1, k + 1, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i - 2, j - 1, k - 1, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i + 2, j - 1, k - 1, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i + 2, j - 1, k + 1, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i - 1, j - 1, k + 2, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i - 1, j - 1, k - 2, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i + 1, j - 1, k + 2, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i + 1, j - 1, k - 2, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i, j - 1, k - 3, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i, j - 1, k + 3, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i + 3, j - 1, k, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i - 3, j - 1, k, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i - 3, j - 1, k + 1, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i - 3, j - 1, k - 1, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i + 3, j - 1, k + 1, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i + 3, j - 1, k - 1, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i - 1, j - 1, k - 3, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i + 1, j - 1, k - 3, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i - 1, j - 1, k + 3, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i + 1, j - 1, k + 3, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i + 2, j - 1, k - 2, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i + 2, j - 1, k + 2, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i - 2, j - 1, k - 2, CCBlocks.chocolateStone, 0, 2);
		this.setBlock(i - 2, j - 1, k + 2, CCBlocks.chocolateStone, 0, 2);

		this.setBlock(i, j - 1, k + 4, CCBlocks.flour, 0, 3);
		this.setBlock(i + 1, j - 1, k + 4, CCBlocks.flour, 0, 3);
		this.setBlock(i - 1, j - 1, k + 4, CCBlocks.flour, 0, 3);
		this.setBlock(i, j - 1, k - 4, CCBlocks.flour, 0, 3);
		this.setBlock(i + 1, j - 1, k - 4, CCBlocks.flour, 0, 3);
		this.setBlock(i - 1, j - 1, k - 4, CCBlocks.flour, 0, 3);
		this.setBlock(i + 4, j - 1, k, CCBlocks.flour, 0, 3);
		this.setBlock(i + 4, j - 1, k + 1, CCBlocks.flour, 0, 3);
		this.setBlock(i + 4, j - 1, k - 1, CCBlocks.flour, 0, 3);
		this.setBlock(i - 4, j - 1, k, CCBlocks.flour, 0, 3);
		this.setBlock(i - 4, j - 1, k + 1, CCBlocks.flour, 0, 3);
		this.setBlock(i - 4, j - 1, k - 1, CCBlocks.flour, 0, 3);

		this.setBlock(i + 2, j - 1, k + 3, CCBlocks.flour, 0, 2);
		this.setBlock(i - 2, j - 1, k + 3, CCBlocks.flour, 0, 2);
		this.setBlock(i + 2, j - 1, k - 3, CCBlocks.flour, 0, 2);
		this.setBlock(i - 2, j - 1, k - 3, CCBlocks.flour, 0, 2);

		this.setBlock(i + 3, j - 1, k - 2, CCBlocks.flour, 0, 2);
		this.setBlock(i + 3, j - 1, k + 2, CCBlocks.flour, 0, 2);
		this.setBlock(i - 3, j - 1, k - 2, CCBlocks.flour, 0, 2);
		this.setBlock(i - 3, j - 1, k + 2, CCBlocks.flour, 0, 2);
		for (int y = 0; y <= 1; y++)
		{
			this.setBlock(i, j + (y * 2), k + 4, CCBlocks.chocolateCobbleStone, 0, 3);
			this.setBlock(i + 1, j + (y * 2), k + 4, CCBlocks.chocolateCobbleStone, 0, 3);
			this.setBlock(i - 1, j + (y * 2), k + 4, CCBlocks.chocolateCobbleStone, 0, 3);
			this.setBlock(i, j + (y * 2), k - 4, CCBlocks.chocolateCobbleStone, 0, 3);
			this.setBlock(i + 1, j + (y * 2), k - 4, CCBlocks.chocolateCobbleStone, 0, 3);
			this.setBlock(i - 1, j + (y * 2), k - 4, CCBlocks.chocolateCobbleStone, 0, 3);
			this.setBlock(i + 4, j + (y * 2), k, CCBlocks.chocolateCobbleStone, 0, 3);
			this.setBlock(i + 4, j + (y * 2), k + 1, CCBlocks.chocolateCobbleStone, 0, 3);
			this.setBlock(i + 4, j + (y * 2), k - 1, CCBlocks.chocolateCobbleStone, 0, 3);
			this.setBlock(i - 4, j + (y * 2), k, CCBlocks.chocolateCobbleStone, 0, 3);
			this.setBlock(i - 4, j + (y * 2), k + 1, CCBlocks.chocolateCobbleStone, 0, 3);
			this.setBlock(i - 4, j + (y * 2), k - 1, CCBlocks.chocolateCobbleStone, 0, 3);
		}
		this.setBlock(i, j + 1, k + 4, CCBlocks.honeyLamp, 0, 3);
		this.setBlock(i + 1, j + 1, k + 4, CCBlocks.caramelGlass1, 0, 2);
		this.setBlock(i - 1, j + 1, k + 4, CCBlocks.caramelGlass1, 0, 2);
		this.setBlock(i, j + 1, k - 4, CCBlocks.honeyLamp, 0, 3);
		this.setBlock(i + 1, j + 1, k - 4, CCBlocks.caramelGlass1, 0, 2);
		this.setBlock(i - 1, j + 1, k - 4, CCBlocks.caramelGlass1, 0, 2);
		this.setBlock(i + 4, j + 1, k, CCBlocks.honeyLamp, 0, 3);
		this.setBlock(i + 4, j + 1, k + 1, CCBlocks.caramelGlass1, 0, 2);
		this.setBlock(i + 4, j + 1, k - 1, CCBlocks.caramelGlass1, 0, 2);
		this.setBlock(i - 4, j + 1, k, CCBlocks.honeyLamp, 0, 3);
		this.setBlock(i - 4, j + 1, k + 1, CCBlocks.caramelGlass1, 0, 2);
		this.setBlock(i - 4, j + 1, k - 1, CCBlocks.caramelGlass1, 0, 2);

		this.setBlock(i + 2, j, k + 3, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i - 2, j, k + 3, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i + 2, j, k - 3, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i - 2, j, k - 3, CCBlocks.chocolateCobbleStone, 0, 2);

		this.setBlock(i + 3, j, k - 2, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i + 3, j, k + 2, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i - 3, j, k - 2, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i - 3, j, k + 2, CCBlocks.chocolateCobbleStone, 0, 2);

		this.setBlock(i + 2, j + 3, k + 3, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i - 2, j + 3, k + 3, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i + 2, j + 3, k - 3, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i - 2, j + 3, k - 3, CCBlocks.chocolateCobbleStone, 0, 2);

		this.setBlock(i + 3, j + 3, k - 2, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i + 3, j + 3, k + 2, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i - 3, j + 3, k - 2, CCBlocks.chocolateCobbleStone, 0, 2);
		this.setBlock(i - 3, j + 3, k + 2, CCBlocks.chocolateCobbleStone, 0, 2);

		for (int z = 0; z <= 1; z++)
		{
			this.setBlock(i + 2, j + z + 1, k + 3, CCBlocks.caramelGlass1, 0, 2);
			this.setBlock(i - 2, j + z + 1, k + 3, CCBlocks.caramelGlass1, 0, 2);
			this.setBlock(i + 2, j + z + 1, k - 3, CCBlocks.caramelGlass1, 0, 2);
			this.setBlock(i - 2, j + z + 1, k - 3, CCBlocks.caramelGlass1, 0, 2);

			this.setBlock(i + 3, j + z + 1, k - 2, CCBlocks.caramelGlass1, 0, 2);
			this.setBlock(i + 3, j + z + 1, k + 2, CCBlocks.caramelGlass1, 0, 2);
			this.setBlock(i - 3, j + z + 1, k - 2, CCBlocks.caramelGlass1, 0, 2);
			this.setBlock(i - 3, j + z + 1, k + 2, CCBlocks.caramelGlass1, 0, 2);
		}
		this.setBlock(i + 3, j + 3, k, CCBlocks.honeyLamp, 0, 3);
		this.setBlock(i - 3, j + 3, k, CCBlocks.honeyLamp, 0, 3);
		this.setBlock(i, j + 3, k + 3, CCBlocks.honeyLamp, 0, 3);
		this.setBlock(i, j + 3, k - 3, CCBlocks.honeyLamp, 0, 3);
		this.setBlock(i + 3, j + 3, k + 1, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i + 3, j + 3, k - 1, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i - 3, j + 3, k + 1, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i - 3, j + 3, k - 1, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i - 1, j + 3, k + 3, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i + 1, j + 3, k + 3, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i - 1, j + 3, k - 3, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i + 1, j + 3, k - 3, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i + 2, j + 3, k - 2, CCBlocks.chocolateCobbleStone, 0, 3);
		this.setBlock(i + 2, j + 3, k + 2, CCBlocks.chocolateCobbleStone, 0, 3);
		this.setBlock(i - 2, j + 3, k - 2, CCBlocks.chocolateCobbleStone, 0, 3);
		this.setBlock(i - 2, j + 3, k + 2, CCBlocks.chocolateCobbleStone, 0, 3);
		this.setBlock(i, j + 4, k, CCBlocks.caramelGlass2, 0, 3);
		this.setBlock(i, j + 4, k + 1, CCBlocks.caramelGlass2, 0, 3);
		this.setBlock(i, j + 4, k - 1, CCBlocks.caramelGlass2, 0, 3);
		this.setBlock(i - 1, j + 4, k, CCBlocks.caramelGlass2, 0, 3);
		this.setBlock(i + 1, j + 4, k, CCBlocks.caramelGlass2, 0, 3);
		this.setBlock(i, j + 4, k + 2, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i, j + 4, k - 2, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i - 2, j + 4, k, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i + 2, j + 4, k, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i + 1, j + 4, k + 2, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i - 1, j + 4, k + 2, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i + 1, j + 4, k - 2, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i - 1, j + 4, k - 2, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i + 2, j + 4, k - 1, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i + 2, j + 4, k + 1, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i - 2, j + 4, k - 1, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i - 2, j + 4, k + 1, CCBlocks.chocolateStone, 0, 3);

		this.setBlock(i + 1, j + 4, k + 1, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i - 1, j + 4, k + 1, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i + 1, j + 4, k - 1, CCBlocks.chocolateStone, 0, 3);
		this.setBlock(i - 1, j + 4, k - 1, CCBlocks.chocolateStone, 0, 3);

		TileEntityChest chest = (TileEntityChest) world.getTileEntity(new BlockPos(i, j, k));
		int time = random.nextInt(7) + 5;
		for (int chestTime = 0; chestTime <= time; chestTime++)
		{
			Item it = WorldGenCandyHouse.itemToStock[random.nextInt(WorldGenCandyHouse.itemToStock.length)];
			int stack = random.nextInt(7) + 4;
			ItemStack st = new ItemStack(it);
			st.setCount(stack > st.getMaxStackSize() ? st.getMaxStackSize() : stack);

			chest.setInventorySlotContents(random.nextInt(27), new ItemStack(st.getItem(), st.getCount()));
		}
		return true;
	}

	public void setBlock(int x, int y, int z, Block bl)
	{
		world.setBlockState(new BlockPos(x, y, z), bl.getDefaultState());
	}

	public void setBlock(int x, int y, int z, Block bl, int meta, int flag)
	{
		world.setBlockState(new BlockPos(x, y, z), bl.getStateFromMeta(meta), flag);
	}

	public void setBlock(int x, int y, int z, Block bl, int flag)
	{
		world.setBlockState(new BlockPos(x, y, z), bl.getDefaultState(), flag);
	}
}
