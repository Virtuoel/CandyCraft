package com.crypticmushroom.candycraft.client.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderKamikazeJelly extends RenderJelly
{
	private static final ResourceLocation slimeTextures = new ResourceLocation("candycraft:textures/entity/KamikazeJelly.png");

	public RenderKamikazeJelly(RenderManager rm, ModelBase par1ModelBase)
	{
		super(rm, par1ModelBase);
	}

	@Override
	protected ResourceLocation getJellyTexture(EntityLiving par1EntityKamikazeSlime)
	{
		return slimeTextures;
	}
}
