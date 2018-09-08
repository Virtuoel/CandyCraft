package com.valentin4311.candycraftmod.items;

import net.minecraft.item.ItemRecord;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;

public class ItemCandyRecord extends ItemRecord
{
	public ItemCandyRecord(String name, String par2Str, String par3)
	{
		// TODO actual sound events
		super(par2Str, new SoundEvent(new ResourceLocation("candycraft", name)));
	}
}
