package com.valentin4311.candycraftmod.items;

import net.minecraft.item.ItemStack;

public class ItemCandyCrossbow extends ItemCandyBow
{
	public ItemCandyCrossbow()
	{
		setMaxDamage(160);
	}
	
	@Override
	protected boolean isArrow(ItemStack stack)
	{
		return stack.getItem() == CCItems.honeyBolt;
	}
}
