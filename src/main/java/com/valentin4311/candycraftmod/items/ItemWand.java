package com.valentin4311.candycraftmod.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.World;

public class ItemWand extends Item
{
	public void renderItemUse(ItemStack par1ItemStack, EntityPlayer player)
	{
		for (int i = 0; i < 10; ++i)
		{
			Vec3d vec31 = new Vec3d((Item.itemRand.nextFloat() - 0.5D) * 0.3D, (-Item.itemRand.nextFloat()) * 0.6D - 0.3D, 0.6D);
			vec31 = vec31.rotateYaw(-(player.rotationYaw + 25) * (float) Math.PI / 180.0F);
			vec31 = vec31.add(player.posX, player.posY + player.getEyeHeight() + 0.5, player.posZ);
			player.world.spawnParticle(EnumParticleTypes.REDSTONE, vec31.x, vec31.y, vec31.z, 0.3F, 0.3F, 1.0F);
		}
	}

	@Override
	public boolean isFull3D()
	{
		return true;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 720000;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		ItemStack par1ItemStack = playerIn.getHeldItem(handIn);
		if (!playerIn.capabilities.isCreativeMode)
		{
			if (par1ItemStack.getItemDamage() == 0)
			{
				par1ItemStack.setItemDamage(par1ItemStack.getMaxDamage() - 1);
			}
			else if (par1ItemStack.getItemDamage() != 1)
			{
				par1ItemStack.setItemDamage(par1ItemStack.getItemDamage() - 1);
			}

			playerIn.setActiveHand(handIn);
			renderItemUse(par1ItemStack, playerIn);

			return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, par1ItemStack);
		}
		else
		{
			playerIn.sendMessage(new TextComponentString("\2476" + new TextComponentTranslation("chat.NoCreative").getUnformattedText()));
			return new ActionResult<ItemStack>(EnumActionResult.FAIL, par1ItemStack);
		}
	}
}
