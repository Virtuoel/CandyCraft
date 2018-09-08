package com.crypticmushroom.candycraft.items;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class ItemCaramelBucket extends Item
{
	public ItemCaramelBucket()
	{
		super();
		setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemUseFinish(ItemStack itemstack, World world, EntityLivingBase entity)
	{
		if (entity instanceof EntityPlayer)
		{
			EntityPlayer player = (EntityPlayer) entity;
			if (!player.capabilities.isCreativeMode)
			{
				itemstack.shrink(1);;
			}

			if (!world.isRemote)
			{
				player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 600, 1));
			}
		}

		return itemstack.getCount() <= 0 ? new ItemStack(Items.BUCKET) : itemstack;
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 32;
	}

	@Override
	public EnumAction getItemUseAction(ItemStack par1ItemStack)
	{
		return EnumAction.DRINK;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
	{
		ItemStack stack = playerIn.getHeldItem(handIn);
		playerIn.setActiveHand(handIn);
		return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, stack);
	}
}
