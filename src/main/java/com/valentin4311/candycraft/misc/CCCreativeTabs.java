package com.valentin4311.candycraft.misc;

import com.valentin4311.candycraft.blocks.CCBlocks;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class CCCreativeTabs extends CreativeTabs
{

	public CCCreativeTabs(String label)
	{
		super(label);
	}

	@Override
	public ItemStack createIcon()
	{
		return new ItemStack(CCBlocks.marshmallowWorkbench);
	}
}
