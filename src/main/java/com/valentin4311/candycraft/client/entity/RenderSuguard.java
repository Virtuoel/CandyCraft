package com.valentin4311.candycraft.client.entity;

import com.valentin4311.candycraft.entity.EntitySuguard;
import com.valentin4311.candycraft.items.CCItems;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSuguard extends RenderLiving<EntitySuguard>
{
	private static final ResourceLocation suguard = new ResourceLocation("candycraft:textures/entity/SuGarde.png");
	private static final ResourceLocation orangeSuguard = new ResourceLocation("candycraft:textures/entity/SuguardeSoldier.png");

	public RenderSuguard(RenderManager rm)
	{
		super(rm, new ModelSuguard(), 0.5F);
		shadowSize = 0.5f;
		addLayer(new LayerSuguardHeldItem(this));
	}

	@Override
	protected ResourceLocation getEntityTexture(EntitySuguard entity)
	{
		EntityLivingBase b = (EntityLivingBase) entity;
		return b.getHeldItemMainhand().getItem() == CCItems.dynamite ? RenderSuguard.orangeSuguard : RenderSuguard.suguard;
	}
}
