package com.crypticmushroom.candycraft.items;

import java.util.List;

import net.minecraft.client.resources.I18n;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemEmblem extends Item
{
	String attr = "";

	public ItemEmblem(String desc)
	{
		super();
		setMaxStackSize(1);
		attr = desc;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		String str = "\2472" + I18n.format("Desc." + attr);
		tooltip.add(str.replaceAll("Format error: ", ""));
		tooltip.add("\247a" + I18n.format("Desc.Emblem"));
	}
}
