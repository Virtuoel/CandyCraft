package com.valentin4311.candycraftmod.blocks.tileentity;

import java.util.Random;

import com.valentin4311.candycraftmod.CandyCraftPreferences;
import com.valentin4311.candycraftmod.blocks.CCBlocks;
import com.valentin4311.candycraftmod.entity.EntityDragon;
import com.valentin4311.candycraftmod.entity.EntityKingBeetle;
import com.valentin4311.candycraftmod.items.CCItems;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;

public class TileEntityEgg extends TileEntity implements ITickable
{
	Random rand = new Random();
	public int timeLeft = 300;
	public int hatchDelay = 50;

	public TileEntityEgg()
	{
		timeLeft = rand.nextInt(24000) + 48000;
	}

	@Override
	public void update()
	{
		boolean readyToHatch = true;
		for (int x = 0; x < 5; x++)
		{
			for (int z = 0; z < 5; z++)
			{
				if (x == 0 || x == 4 || z == 0 || z == 4)
				{
					if (worldObj.getBlockState(new BlockPos(pos.getX() - 2 + x, pos.getY(), pos.getZ() - 2 + z)).getBlock() != CCBlocks.sugarEssenceFlower)
					{
						readyToHatch = false;
					}
				}
			}
		}
		if (readyToHatch || timeLeft <= hatchDelay)
		{
			timeLeft--;

			if (!worldObj.isRemote)
			{
				if (timeLeft == hatchDelay)
				{
					if (worldObj.getBlockState(pos).getBlock() == CCBlocks.dragonEggBlock && CandyCraftPreferences.allowDragons)
					{
						EntityDragon dragon = new EntityDragon(worldObj);
						dragon.setPosition(pos.getX() + 0.5D, pos.getY() + 1.0D, pos.getZ());
						worldObj.spawnEntityInWorld(dragon);
					}
					else if (CandyCraftPreferences.allowBeetleKings)
					{
						EntityKingBeetle beetle = new EntityKingBeetle(worldObj);
						beetle.setPosition(pos.getX() + 0.5D, pos.getY() + 1.0D, pos.getZ());
						worldObj.spawnEntityInWorld(beetle);
						beetle.entityDropItem(new ItemStack(CCItems.chewingGumEmblem), 0.5F);
					}
				}
				if (timeLeft <= 0)
				{
					worldObj.setBlockToAir(pos);

					for (int x = 0; x < 5; x++)
					{
						for (int z = 0; z < 5; z++)
						{
							if (x == 0 || x == 4 || z == 0 || z == 4)
							{
								if (worldObj.getBlockState(new BlockPos(pos.getX() - 2 + x, pos.getY(), pos.getZ() - 2 + z)).getBlock() == CCBlocks.sugarEssenceFlower)
								{
									worldObj.setBlockState(new BlockPos(pos.getX() - 2 + x, pos.getY(), pos.getZ() - 2 + z), CCBlocks.fraiseTagadaFlower.getDefaultState());
								}
							}
						}
					}
				}
			}
		}
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
	{
		readFromNBT(pkt.getNbtCompound());
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket()
	{
		NBTTagCompound nbttagcompound = new NBTTagCompound();
		writeToNBT(nbttagcompound);
		return new SPacketUpdateTileEntity(pos, 1, nbttagcompound);
	}

	@Override
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.readFromNBT(par1NBTTagCompound);
		timeLeft = par1NBTTagCompound.getInteger("hatch");
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound par1NBTTagCompound)
	{
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("hatch", timeLeft);

		return par1NBTTagCompound;
	}
}
