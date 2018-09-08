package com.valentin4311.candycraftmod.items;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class ItemCandyBlock extends ItemBlock
{
	private final static String[] metaNames = new String[] { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" };

	public ItemCandyBlock(Block bl)
	{
		super(bl);
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata(int damage)
	{
		return damage;
	}
	
	@Override
	public String getTranslationKey(ItemStack stack)
	{
		return super.getTranslationKey() + "." + metaNames[stack.getItemDamage()];
	}
}
