package com.valentin4311.candycraft.items;

import com.valentin4311.candycraft.entity.EntityCandyCreeper;
import com.valentin4311.candycraft.misc.CCAchievements;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;

public class ItemLollipop extends ItemFood
{
	public ItemLollipop()
	{
		super(1, false);
	}

	@Override
	public boolean itemInteractionForEntity(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, EntityLivingBase par2EntityLiving, EnumHand hand)
	{
		if (par2EntityLiving instanceof EntityLivingBase)
		{
			double d0 = par2EntityPlayer.world.rand.nextGaussian() * 0.02D;
			double d1 = par2EntityPlayer.world.rand.nextGaussian() * 0.02D;
			double d2 = par2EntityPlayer.world.rand.nextGaussian() * 0.02D;

			if (!par2EntityLiving.world.isRemote)
			{
				if (par2EntityLiving instanceof EntityCandyCreeper)
				{
					// TODO advancements
				//	par2EntityPlayer.addStat(CCAchievements.lollipopCreep);
				}
				par2EntityLiving.heal(1);
			}

			if (par2EntityLiving.getHealth() < par2EntityLiving.getMaxHealth())
			{
				par2EntityLiving.world.spawnParticle(EnumParticleTypes.HEART, par2EntityLiving.posX + par2EntityPlayer.world.rand.nextFloat() * par2EntityLiving.width * 2.0F - par2EntityLiving.width, par2EntityLiving.posY + 0.5D + par2EntityPlayer.world.rand.nextFloat() * par2EntityLiving.height, par2EntityLiving.posZ + par2EntityPlayer.world.rand.nextFloat() * par2EntityLiving.width * 2.0F - par2EntityLiving.width, d0, d1, d2);
			}
			else
			{
				par2EntityLiving.world.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, par2EntityLiving.posX + par2EntityPlayer.world.rand.nextFloat() * par2EntityLiving.width * 2.0F - par2EntityLiving.width, par2EntityLiving.posY + 0.5D + par2EntityPlayer.world.rand.nextFloat() * par2EntityLiving.height, par2EntityLiving.posZ + par2EntityPlayer.world.rand.nextFloat() * par2EntityLiving.width * 2.0F - par2EntityLiving.width, d0, d1, d2);
			}

			par1ItemStack.shrink(1);
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 32;
	}
}
