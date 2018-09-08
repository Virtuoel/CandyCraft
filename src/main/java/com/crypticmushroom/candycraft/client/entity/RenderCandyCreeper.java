package com.crypticmushroom.candycraft.client.entity;

import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCandyCreeper extends RenderCreeper
{
	private static final ResourceLocation texture = new ResourceLocation("candycraft:textures/entity/Candycreeper.png");

	public RenderCandyCreeper(RenderManager renderManager)
	{
		super(renderManager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityCreeper par1Entity)
	{
		return RenderCandyCreeper.texture;
	}
}
