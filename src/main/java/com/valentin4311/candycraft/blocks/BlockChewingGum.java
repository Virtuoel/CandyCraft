package com.valentin4311.candycraft.blocks;

import com.valentin4311.candycraft.entity.EntityBeetle;
import com.valentin4311.candycraft.entity.EntityKingBeetle;
import com.valentin4311.candycraft.entity.boss.EntityBossBeetle;
import com.valentin4311.candycraft.items.CCItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockChewingGum extends Block
{
	protected static final AxisAlignedBB GUM_AABB = new AxisAlignedBB(0.0F, 0.0F, 0.0F, 1.0F, 0.875F, 1.0F);

	public BlockChewingGum(Material material)
	{
		super(material);
	}

	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return GUM_AABB;
	}
	
	@Override
	public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{
		if (!(entityIn instanceof EntityBeetle) && !(entityIn instanceof EntityBossBeetle) && !(entityIn instanceof EntityKingBeetle))
		{
			if (entityIn instanceof EntityPlayer && ((EntityPlayer) entityIn).inventory.hasItemStack(new ItemStack(CCItems.chewingGumEmblem)))
			{
				return;
			}

			entityIn.motionX *= 0.2D;
			entityIn.motionZ *= 0.2D;
			entityIn.motionY = 0;
		}
	}
}
