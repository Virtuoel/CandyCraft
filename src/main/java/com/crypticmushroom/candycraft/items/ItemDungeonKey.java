package com.crypticmushroom.candycraft.items;

import java.util.List;

import com.crypticmushroom.candycraft.CandyCraftPreferences;
import com.crypticmushroom.candycraft.blocks.CCBlocks;
import com.crypticmushroom.candycraft.blocks.tileentity.TileEntityTeleporter;
import com.crypticmushroom.candycraft.world.generator.ThreadCheckDungeon;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDungeonKey extends Item
{
	public final int keyId;

	public ItemDungeonKey(int key)
	{
		super();
		keyId = key;
		setMaxStackSize(1);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldRotateAroundWhenRendering()
	{
		return true;
	}

	@Override
	public EnumActionResult onItemUse(EntityPlayer par2EntityPlayer, World par3World, BlockPos pos, EnumHand hand, EnumFacing side, float par8, float par9, float par10)
	{
		ItemStack par1ItemStack = par2EntityPlayer.getHeldItem(hand);
		if (keyId <= 1)
		{
			if (!par2EntityPlayer.canPlayerEdit(pos.offset(side), side, par1ItemStack) || !CandyCraftPreferences.canGenerateDungeon)
			{
				return EnumActionResult.FAIL;
			}
			else
			{
				IBlockState bl = par3World.getBlockState(pos);
				if (bl.isOpaqueCube() && par3World.isAirBlock(pos.up()) && !par3World.isRemote)
				{
					par3World.setBlockState(pos.up(), CCBlocks.blockTeleporter.getStateFromMeta(keyId));
					par2EntityPlayer.setHeldItem(hand, null);
					par2EntityPlayer.sendMessage(new TextComponentString("\247e" + new TextComponentTranslation("chat.generating").getUnformattedText()));
					ThreadCheckDungeon d = new ThreadCheckDungeon(keyId);
					d.teleport = (TileEntityTeleporter) par3World.getTileEntity(pos.up());
					d.player = par2EntityPlayer;
					d.px = pos.getX();
					d.py = pos.getY() + 1;
					d.pz = pos.getZ();
					d.dim = par3World.provider.getDimension();
					d.start();
					return EnumActionResult.SUCCESS;
				}
				return EnumActionResult.FAIL;
			}
		}
		return EnumActionResult.FAIL;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		if (this == CCItems.orangeKey || this == CCItems.blueKey)
		{
			tooltip.add("\247a" + I18n.format("Desc.key"));
		}
	}
}
