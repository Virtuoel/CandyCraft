package com.crypticmushroom.candycraft.items;

import com.crypticmushroom.candycraft.entity.EntityCandyArrow;
import com.crypticmushroom.candycraft.misc.CCEnchantments;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHoneyArrow extends ItemArrow
{
	boolean isBolt;
	public ItemHoneyArrow(boolean isBolt)
	{
		this.isBolt = isBolt;
	}
	
	@Override
	public EntityArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
	{
		EntityCandyArrow a = new EntityCandyArrow(worldIn);
		a.setBolt(isBolt);
		
		int l2 = EnchantmentHelper.getEnchantmentLevel(CCEnchantments.honey_glue, stack);
		if (l2 > 0)
		{
			// TODO Candy Arrow
		//	entityarrow.slow = l2;
		}
		
		return a;
	}
}
