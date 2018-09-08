package com.crypticmushroom.candycraft.items;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemNougatPowder extends ItemFood
{
	public ItemNougatPowder(int foodAmount, boolean dogLike)
	{
		super(foodAmount, dogLike);
	}

	@Override
	protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
	{
		if (worldIn.rand.nextInt(4) == 0)
		{
			worldIn.createExplosion(null, player.posX, player.posY, player.posZ, 1.0F, true);
		}
	}
}
