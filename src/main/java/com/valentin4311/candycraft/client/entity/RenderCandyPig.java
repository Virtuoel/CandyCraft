package com.valentin4311.candycraft.client.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPig;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCandyPig extends RenderLiving<EntityPig>
{
	private static final ResourceLocation texture = new ResourceLocation("candycraft:textures/entity/CandyPig.png");

	public RenderCandyPig(RenderManager renderManager, ModelBase par2ModelBase, float par3)
	{
		super(renderManager, par2ModelBase, par3);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityPig par1Entity)
	{
		return RenderCandyPig.texture;
	}
}
