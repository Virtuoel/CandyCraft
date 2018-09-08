package com.valentin4311.candycraftmod.world.generator;

import java.util.ArrayList;
import java.util.Random;

import com.valentin4311.candycraftmod.blocks.CCBlocks;
import com.valentin4311.candycraftmod.entity.EntityGingerBreadMan;
import com.valentin4311.candycraftmod.entity.boss.EntityBossSuguard;
import com.valentin4311.candycraftmod.items.CCItems;
import com.valentin4311.candycraftmod.world.WorldProviderCandy;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenUnderGroundVillage extends WorldGenerator
{
	ArrayList<ArrayBlock> blocks = new ArrayList();
	ArrayList<Entity> entities = new ArrayList();

	@Override
	public boolean generate(World world, Random random, BlockPos pos)
	{
		WorldProviderCandy.canGenVillage = 1200;
		int meta = random.nextInt(3);
		int meta2 = random.nextInt(3);
		int meta3 = random.nextInt(3);
		int meta4 = random.nextInt(3);

		int i = pos.getX();
		int j = pos.getY();
		int k = pos.getZ();

		i -= 32;
		k -= 32;

		tryCall(world, i + 32, j + 2, k + 32);

		boolean lamp = false;
		for (int i2 = i; i2 < i + 64; i2++)
		{
			lamp = !lamp;
			for (int j2 = j; j2 < j + 7; j2++)
			{
				for (int k2 = k; k2 < k + 64; k2++)
				{
					if (j2 < j + 2)
					{
						this.setBlock(world, i2, j2, k2, Blocks.STONE);
					}
					else
					{
						if (((i2 == i) || (k2 == k) || (i2 == i + 63) || (k2 == k + 63)))
						{
							this.setBlock(world, i2, j2, k2, CCBlocks.chocolateCobbleStone);
						}
						else if ((j2 == j + 2 || j2 == j + 5) && (i2 == i + 1 || k2 == k + 1 || i2 == i + 62 || k2 == k + 62))
						{
							setBlockAndMetadata(world, i2, j2, k2, CCBlocks.candyCaneBlock, 1);
						}
						else
						{
							this.setBlock(world, i2, j2, k2, (j2 < j + 6 ? null : (!lamp ? CCBlocks.chocolateCobbleStone : CCBlocks.honeyLamp)));
							lamp = !lamp;
						}
					}
				}
			}
		}
		for (int i2 = i; i2 < i + 64; i2++)
		{
			for (int j2 = j; j2 < j + 7; j2++)
			{
				for (int k2 = k; k2 < k + 64; k2++)
				{
					if (j2 == j + 1 && (i2 <= i + 5 || i2 >= i + 58 || k2 <= k + 5 || k2 >= k + 58))
					{
						this.setBlock(world, i2, j2, k2, CCBlocks.marshmallowPlanks);
					}
					else if (j2 == j + 1 && (i2 == i + 6 || i2 == i + 57 || k2 == k + 6 || k2 == k + 57))
					{
						this.setBlock(world, i2, j2, k2, CCBlocks.marshmallowLog);
					}
					else if (j2 == j + 1)
					{
						this.setBlock(world, i2, j2, k2, CCBlocks.pudding);
					}
				}
			}
		}
		for (int i2 = i + 6; i2 < i + 58; i2++)
		{
			for (int j2 = j; j2 < j + 7; j2++)
			{
				for (int k2 = k + 6; k2 < k + 58; k2++)
				{
					if (j2 == j + 1 && (i2 == i + 6 && ((k2 > k + 20 && k2 < k + 24) || (k2 > k + 39 && k2 < k + 43))))
					{
						this.setBlock(world, i2, j2, k2, CCBlocks.marshmallowWorkbench);
					}
					else if (j2 == j + 1 && (i2 == i + 57 && ((k2 > k + 20 && k2 < k + 24) || (k2 > k + 39 && k2 < k + 43))))
					{
						this.setBlock(world, i2, j2, k2, CCBlocks.marshmallowWorkbench);
					}
					else if (j2 == j + 1 && (k2 == k + 6 && ((i2 > i + 20 && i2 < i + 24) || (i2 > i + 39 && i2 < i + 43))))
					{
						this.setBlock(world, i2, j2, k2, CCBlocks.marshmallowWorkbench);
					}
					else if (j2 == j + 1 && (k2 == k + 57 && ((i2 > i + 20 && i2 < i + 24) || (i2 > i + 39 && i2 < i + 43))))
					{
						this.setBlock(world, i2, j2, k2, CCBlocks.marshmallowWorkbench);
					}
					else if (j2 == j + 1 && ((i2 >= i + 21 && i2 <= i + 23) || (i2 >= i + 40 && i2 <= i + 42) || (k2 >= k + 21 && k2 <= 23 + k) || (k2 >= k + 40 && k2 <= 42 + k)))
					{
						this.setBlock(world, i2, j2, k2, random.nextBoolean() ? CCBlocks.chocolateStone : CCBlocks.chocolateCobbleStone);
					}
					else if (j2 == j + 1 && (i2 == i + 20 || i2 == i + 43 || k2 == k + 20 || k2 == k + 43 || i2 == i + 24 || k2 == k + 24 || i2 == i + 39 || k2 == k + 39))
					{
						this.setBlock(world, i2, j2, k2, CCBlocks.marshmallowLog);
					}
				}
			}
		}
		genHouse(world, random, i + 8, j + 1, k + 8, random.nextInt(2), false);
		genHouse(world, random, i + 14, j + 1, k + 8, 1, true);
		genHouse(world, random, i + 8, j + 1, k + 14, 0, true);

		genHouse(world, random, i + 26, j + 1, k + 8, 3, random.nextBoolean());
		genHouse(world, random, i + 33, j + 1, k + 8, 3, random.nextBoolean());

		genHouse(world, random, i + 51, j + 1, k + 8, random.nextInt(2) + 1, false);
		genHouse(world, random, i + 45, j + 1, k + 8, 1, true);
		genHouse(world, random, i + 51, j + 1, k + 14, 2, true);

		genHouse(world, random, i + 26, j + 1, k + 51, 1, random.nextBoolean());
		genHouse(world, random, i + 33, j + 1, k + 51, 1, random.nextBoolean());

		genHouse(world, random, i + 51, j + 1, k + 51, random.nextInt(2) + 2, false);
		genHouse(world, random, i + 51, j + 1, k + 45, 2, true);
		genHouse(world, random, i + 45, j + 1, k + 51, 3, true);

		genHouse(world, random, i + 8, j + 1, k + 26, 2, random.nextBoolean());
		genHouse(world, random, i + 8, j + 1, k + 33, 2, random.nextBoolean());

		genHouse(world, random, i + 8, j + 1, k + 51, random.nextInt(2) == 0 ? 3 : 0, false);
		genHouse(world, random, i + 8, j + 1, k + 45, 0, true);
		genHouse(world, random, i + 14, j + 1, k + 51, 3, true);

		genHouse(world, random, i + 51, j + 1, k + 26, 0, random.nextBoolean());
		genHouse(world, random, i + 51, j + 1, k + 33, 0, random.nextBoolean());

		for (int z = 0; z < 6; z++)
		{
			this.setBlock(world, i + 26, j + 2, k + 50 - z, CCBlocks.candyCaneFence);
			this.setBlock(world, i + 37, j + 2, k + 50 - z, CCBlocks.candyCaneFence);

			this.setBlock(world, i + 26, j + 2, k + 13 + z, CCBlocks.candyCaneFence);
			this.setBlock(world, i + 37, j + 2, k + 13 + z, CCBlocks.candyCaneFence);

			this.setBlock(world, i + 50 - z, j + 2, k + 26, CCBlocks.candyCaneFence);
			this.setBlock(world, i + 50 - z, j + 2, k + 37, CCBlocks.candyCaneFence);

			this.setBlock(world, i + 13 + z, j + 2, k + 26, CCBlocks.candyCaneFence);
			this.setBlock(world, i + 13 + z, j + 2, k + 37, CCBlocks.candyCaneFence);
		}

		this.setBlock(world, i + 18, j + 2, k + 27, CCBlocks.candyCaneFence);
		this.setBlock(world, i + 18, j + 2, k + 36, CCBlocks.candyCaneFence);

		this.setBlock(world, i + 45, j + 2, k + 27, CCBlocks.candyCaneFence);
		this.setBlock(world, i + 45, j + 2, k + 36, CCBlocks.candyCaneFence);

		this.setBlock(world, i + 27, j + 2, k + 18, CCBlocks.candyCaneFence);
		this.setBlock(world, i + 36, j + 2, k + 18, CCBlocks.candyCaneFence);

		this.setBlock(world, i + 27, j + 2, k + 45, CCBlocks.candyCaneFence);
		this.setBlock(world, i + 36, j + 2, k + 45, CCBlocks.candyCaneFence);

		setBlockAndMetadata(world, i + 14, j + 2, k + 14, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 15, j + 2, k + 14, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 16, j + 2, k + 14, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 17, j + 2, k + 14, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 18, j + 2, k + 14, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 14, j + 2, k + 15, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 14, j + 2, k + 16, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 14, j + 2, k + 17, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 14, j + 2, k + 18, CCBlocks.candyLeave, meta);

		setBlockAndMetadata(world, i + 49, j + 2, k + 14, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 48, j + 2, k + 14, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 47, j + 2, k + 14, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 46, j + 2, k + 14, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 45, j + 2, k + 14, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 49, j + 2, k + 15, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 49, j + 2, k + 16, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 49, j + 2, k + 17, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 49, j + 2, k + 18, CCBlocks.candyLeave, meta);

		setBlockAndMetadata(world, i + 49, j + 2, k + 49, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 48, j + 2, k + 49, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 47, j + 2, k + 49, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 46, j + 2, k + 49, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 45, j + 2, k + 49, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 49, j + 2, k + 48, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 49, j + 2, k + 47, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 49, j + 2, k + 46, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 49, j + 2, k + 45, CCBlocks.candyLeave, meta);

		setBlockAndMetadata(world, i + 14, j + 2, k + 49, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 14, j + 2, k + 48, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 14, j + 2, k + 47, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 14, j + 2, k + 46, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 14, j + 2, k + 45, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 15, j + 2, k + 49, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 16, j + 2, k + 49, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 17, j + 2, k + 49, CCBlocks.candyLeave, meta);
		setBlockAndMetadata(world, i + 18, j + 2, k + 49, CCBlocks.candyLeave, meta);

		setBlockAndMetadata(world, i + 16, j + 2, k + 16, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 16, j + 2, k + 17, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 16, j + 2, k + 18, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 17, j + 2, k + 16, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 18, j + 2, k + 16, CCBlocks.candyLeave, meta2);

		setBlockAndMetadata(world, i + 16, j + 2, k + 47, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 16, j + 2, k + 46, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 16, j + 2, k + 45, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 17, j + 2, k + 47, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 18, j + 2, k + 47, CCBlocks.candyLeave, meta2);

		setBlockAndMetadata(world, i + 47, j + 2, k + 47, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 47, j + 2, k + 46, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 47, j + 2, k + 45, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 46, j + 2, k + 47, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 45, j + 2, k + 47, CCBlocks.candyLeave, meta2);

		setBlockAndMetadata(world, i + 47, j + 2, k + 16, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 46, j + 2, k + 16, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 45, j + 2, k + 16, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 47, j + 2, k + 17, CCBlocks.candyLeave, meta2);
		setBlockAndMetadata(world, i + 47, j + 2, k + 18, CCBlocks.candyLeave, meta2);

		setBlockAndMetadata(world, i + 18, j + 2, k + 18, CCBlocks.candyLeave, meta3);
		setBlockAndMetadata(world, i + 18, j + 2, k + 45, CCBlocks.candyLeave, meta3);
		setBlockAndMetadata(world, i + 45, j + 2, k + 18, CCBlocks.candyLeave, meta3);
		setBlockAndMetadata(world, i + 45, j + 2, k + 45, CCBlocks.candyLeave, meta3);

		setBlockAndMetadata(world, i + 26, j + 2, k + 26, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 26, j + 2, k + 27, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 26, j + 2, k + 28, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 27, j + 2, k + 26, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 28, j + 2, k + 26, CCBlocks.candyLeave, meta4);

		setBlockAndMetadata(world, i + 37, j + 2, k + 26, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 37, j + 2, k + 27, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 37, j + 2, k + 28, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 36, j + 2, k + 26, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 35, j + 2, k + 26, CCBlocks.candyLeave, meta4);

		setBlockAndMetadata(world, i + 37, j + 2, k + 37, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 37, j + 2, k + 36, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 36, j + 2, k + 37, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 35, j + 2, k + 37, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 37, j + 2, k + 35, CCBlocks.candyLeave, meta4);

		setBlockAndMetadata(world, i + 26, j + 2, k + 37, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 26, j + 2, k + 36, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 26, j + 2, k + 35, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 27, j + 2, k + 37, CCBlocks.candyLeave, meta4);
		setBlockAndMetadata(world, i + 28, j + 2, k + 37, CCBlocks.candyLeave, meta4);

		setBlockAndMetadata(world, i + 31, j + 2, k + 31, CCBlocks.pudding, meta4);
		setBlockAndMetadata(world, i + 32, j + 2, k + 31, CCBlocks.pudding, meta4);
		setBlockAndMetadata(world, i + 31, j + 2, k + 32, CCBlocks.pudding, meta4);
		setBlockAndMetadata(world, i + 32, j + 2, k + 32, CCBlocks.pudding, meta4);
		setBlockAndMetadata(world, i + 30, j + 2, k + 31, CCBlocks.pudding, meta4);
		setBlockAndMetadata(world, i + 30, j + 2, k + 32, CCBlocks.pudding, meta4);
		setBlockAndMetadata(world, i + 33, j + 2, k + 31, CCBlocks.pudding, meta4);
		setBlockAndMetadata(world, i + 33, j + 2, k + 32, CCBlocks.pudding, meta4);
		setBlockAndMetadata(world, i + 31, j + 2, k + 30, CCBlocks.pudding, meta4);
		setBlockAndMetadata(world, i + 32, j + 2, k + 30, CCBlocks.pudding, meta4);
		setBlockAndMetadata(world, i + 31, j + 2, k + 33, CCBlocks.pudding, meta4);
		setBlockAndMetadata(world, i + 32, j + 2, k + 33, CCBlocks.pudding, meta4);

		setBlockAndMetadata(world, i + 30, j + 2, k + 30, CCBlocks.marshmallowHalfStep, 0);
		setBlockAndMetadata(world, i + 33, j + 2, k + 30, CCBlocks.marshmallowHalfStep, 0);
		setBlockAndMetadata(world, i + 30, j + 2, k + 33, CCBlocks.marshmallowHalfStep, 0);
		setBlockAndMetadata(world, i + 33, j + 2, k + 33, CCBlocks.marshmallowHalfStep, 0);
		setBlockAndMetadata(world, i + 34, j + 2, k + 33, CCBlocks.marshmallowHalfStep, 0);
		setBlockAndMetadata(world, i + 33, j + 2, k + 34, CCBlocks.marshmallowHalfStep, 0);
		setBlockAndMetadata(world, i + 30, j + 2, k + 29, CCBlocks.marshmallowHalfStep, 0);
		setBlockAndMetadata(world, i + 29, j + 2, k + 30, CCBlocks.marshmallowHalfStep, 0);
		setBlockAndMetadata(world, i + 33, j + 2, k + 29, CCBlocks.marshmallowHalfStep, 0);
		setBlockAndMetadata(world, i + 34, j + 2, k + 30, CCBlocks.marshmallowHalfStep, 0);
		setBlockAndMetadata(world, i + 29, j + 2, k + 33, CCBlocks.marshmallowHalfStep, 0);
		setBlockAndMetadata(world, i + 30, j + 2, k + 34, CCBlocks.marshmallowHalfStep, 0);

		setBlockAndMetadata(world, i + 31, j + 2, k + 29, CCBlocks.marshmallowHalfStep, 0);
		setBlockAndMetadata(world, i + 32, j + 2, k + 29, CCBlocks.marshmallowHalfStep, 0);

		setBlockAndMetadata(world, i + 31, j + 2, k + 34, CCBlocks.marshmallowHalfStep, 0);
		setBlockAndMetadata(world, i + 32, j + 2, k + 34, CCBlocks.marshmallowHalfStep, 0);

		setBlockAndMetadata(world, i + 29, j + 2, k + 31, CCBlocks.marshmallowHalfStep, 0);
		setBlockAndMetadata(world, i + 29, j + 2, k + 32, CCBlocks.marshmallowHalfStep, 0);

		setBlockAndMetadata(world, i + 34, j + 2, k + 31, CCBlocks.marshmallowHalfStep, 0);
		setBlockAndMetadata(world, i + 34, j + 2, k + 32, CCBlocks.marshmallowHalfStep, 0);

		for (int p = 0; p < blocks.size(); p++)
		{
			ArrayBlock bl = blocks.get(p);
			world.setBlockState(new BlockPos(bl.x, bl.y, bl.z), bl.block.getStateFromMeta(bl.metadata), 3);
		}
		for (int p = 0; p < entities.size(); p++)
		{
			world.spawnEntity(entities.get(p));
		}
		for (int i2 = i; i2 < i + 64; i2++)
		{
			for (int k2 = k; k2 < 64 + k; k2++)
			{
				if (world.isAirBlock(new BlockPos(i2, j + 2, k2)) && CCBlocks.tallCandyGrass.canBlockStay(world, new BlockPos(i2, j + 2, k2), world.getBlockState(new BlockPos(i2, j + 2, k2))))
				{
					if (random.nextInt(3) == 0)
					{
						world.setBlockState(new BlockPos(i2, j + 2, k2), CCBlocks.tallCandyGrass.getStateFromMeta(new Random().nextInt(4)), 3);
					}
				}
			}
		}

		EntityBossSuguard boss = new EntityBossSuguard(world);
		boss.setPosition(i + 32, j + 3, k + 32);
		boss.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(boss)), (IEntityLivingData) null);
		world.spawnEntity(boss);

		return true;
	}

	private void setBlock(int x, int y, int z, Block block)
	{
		blocks.add(new ArrayBlock(x, y, z, block, 0));
	}

	private void setBlock(int x, int y, int z, Block block, int metadata)
	{
		blocks.add(new ArrayBlock(x, y, z, block, metadata));
	}

	public void setBlockAndMetadata(World world, int x, int y, int z, Block bl, int m)
	{
		if (bl != null)
		{
			this.setBlock(x, y, z, bl, m);
		}
		else
		{
			this.setBlock(x, y, z, Blocks.AIR);
		}
	}

	public void setBlock(World world, int x, int y, int z, Block bl)
	{
		if (bl != null)
		{
			this.setBlock(x, y, z, bl);
		}
		else
		{
			this.setBlock(x, y, z, Blocks.AIR);
		}
	}

	private static void tryCall(World world, int x, int y, int z)
	{
		for (int i = 0; i < world.playerEntities.size(); ++i)
		{
			Entity entity1 = world.playerEntities.get(i);
			if (entity1 instanceof EntityPlayerMP)
			{
				EntityPlayerMP player = (EntityPlayerMP) entity1;
				if (player.inventory.hasItemStack(new ItemStack(CCItems.honeyEmblem)))
				{
					player.sendMessage(new TextComponentString("\2472" + new TextComponentTranslation("Msg.HoneyEmblemFound0").getUnformattedText() + "\2472" + x + " " + y + " " + z + new TextComponentTranslation("Msg.HoneyEmblemFound1").getUnformattedText()));
				}
			}
		}
	}

	public void genHouse(World world, Random random, int i, int j, int k, int side, boolean b)
	{
		int meta = random.nextInt(3);
		for (int i2 = i; i2 < 5 + i; i2++)
		{
			for (int k2 = k; k2 < 5 + k; k2++)
			{
				this.setBlock(world, i2, j, k2, CCBlocks.chocolateStone);
				this.setBlock(world, i2, j + 3, k2, CCBlocks.marshmallowPlanks);
			}
		}

		setBlockAndMetadata(world, i, j + 1, k, CCBlocks.marshmallowLog, meta);
		setBlockAndMetadata(world, i, j + 2, k, CCBlocks.marshmallowLog, meta);
		setBlockAndMetadata(world, i + 4, j + 1, k, CCBlocks.marshmallowLog, meta);
		setBlockAndMetadata(world, i + 4, j + 2, k, CCBlocks.marshmallowLog, meta);
		setBlockAndMetadata(world, i + 4, j + 1, k + 4, CCBlocks.marshmallowLog, meta);
		setBlockAndMetadata(world, i + 4, j + 2, k + 4, CCBlocks.marshmallowLog, meta);
		setBlockAndMetadata(world, i, j + 1, k + 4, CCBlocks.marshmallowLog, meta);
		setBlockAndMetadata(world, i, j + 2, k + 4, CCBlocks.marshmallowLog, meta);
		setBlockAndMetadata(world, i + 1, j + 3, k, CCBlocks.marshmallowLog, 4 + meta);
		setBlockAndMetadata(world, i + 2, j + 3, k, CCBlocks.marshmallowLog, 4 + meta);
		setBlockAndMetadata(world, i + 3, j + 3, k, CCBlocks.marshmallowLog, 4 + meta);

		setBlockAndMetadata(world, i + 1, j + 3, k + 4, CCBlocks.marshmallowLog, 4 + meta);
		setBlockAndMetadata(world, i + 2, j + 3, k + 4, CCBlocks.marshmallowLog, 4 + meta);
		setBlockAndMetadata(world, i + 3, j + 3, k + 4, CCBlocks.marshmallowLog, 4 + meta);

		setBlockAndMetadata(world, i, j + 3, k + 1, CCBlocks.marshmallowLog, 8 + meta);
		setBlockAndMetadata(world, i, j + 3, k + 2, CCBlocks.marshmallowLog, 8 + meta);
		setBlockAndMetadata(world, i, j + 3, k + 3, CCBlocks.marshmallowLog, 8 + meta);

		setBlockAndMetadata(world, i + 4, j + 3, k + 1, CCBlocks.marshmallowLog, 8 + meta);
		setBlockAndMetadata(world, i + 4, j + 3, k + 2, CCBlocks.marshmallowLog, 8 + meta);
		setBlockAndMetadata(world, i + 4, j + 3, k + 3, CCBlocks.marshmallowLog, 8 + meta);

		setBlockAndMetadata(world, i + 1, j + 1, k, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i + 1, j + 2, k, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i + 2, j + 1, k, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i + 2, j + 2, k, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i + 3, j + 1, k, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i + 3, j + 2, k, CCBlocks.marshmallowPlanks, meta);

		setBlockAndMetadata(world, i, j + 1, k + 1, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i, j + 2, k + 1, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i, j + 1, k + 2, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i, j + 2, k + 2, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i, j + 1, k + 3, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i, j + 2, k + 3, CCBlocks.marshmallowPlanks, meta);

		setBlockAndMetadata(world, i + 4, j + 1, k + 1, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i + 4, j + 2, k + 1, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i + 4, j + 1, k + 2, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i + 4, j + 2, k + 2, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i + 4, j + 1, k + 3, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i + 4, j + 2, k + 3, CCBlocks.marshmallowPlanks, meta);

		setBlockAndMetadata(world, i + 1, j + 1, k + 4, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i + 1, j + 2, k + 4, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i + 2, j + 1, k + 4, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i + 2, j + 2, k + 4, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i + 3, j + 1, k + 4, CCBlocks.marshmallowPlanks, meta);
		setBlockAndMetadata(world, i + 3, j + 2, k + 4, CCBlocks.marshmallowPlanks, meta);

		if (b)
		{
			int window = random.nextInt(3);
			int x = i;
			int z = k;
			if (side == 2)
			{
				z = k + 1 + window;
			}
			if (side == 3)
			{
				x = i + 1 + window;
			}
			if (side == 0)
			{
				z = k + 1 + window;
				x = i + 4;
			}
			if (side == 1)
			{
				x = i + 1 + window;
				z = k + 4;
			}
			int type = random.nextInt(3);
			this.setBlock(world, x, j + 2, z, type == 0 ? CCBlocks.caramelPane0 : type == 1 ? CCBlocks.caramelPane1 : CCBlocks.caramelPane2);

		}

		int window = random.nextInt(3);
		int x = i;
		int z = k;
		if (side == 0)
		{
			z = k + 1 + window;
		}
		if (side == 1)
		{
			x = i + 1 + window;
		}
		if (side == 2)
		{
			z = k + 1 + window;
			x = i + 4;
		}
		if (side == 3)
		{
			x = i + 1 + window;
			z = k + 4;
		}
		this.setBlock(world, x, j + 1, z, null);
		setBlockAndMetadata(world, x, j + 2, z, meta == 0 ? CCBlocks.marshmallowHalfStep : meta == 1 ? CCBlocks.marshmallowHalfStep2 : CCBlocks.marshmallowHalfStep3, 1);

		this.setBlock(world, i, j + 3, k, null);
		this.setBlock(world, i + 4, j + 3, k, null);
		this.setBlock(world, i + 4, j + 3, k + 4, null);
		this.setBlock(world, i, j + 3, k + 4, null);

		EntityGingerBreadMan man = new EntityGingerBreadMan(world);
		man.setPosition(i + 2, j + 2, k + 2);
		man.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(man)), (IEntityLivingData) null);
		if (j > 100)
		{
			man.setProfession(3);
		}
		entities.add(man);
	}
}
