package com.valentin4311.candycraft.client.entity;

import com.valentin4311.candycraft.entity.EntityNessie;

import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class LayerNessieSaddle implements LayerRenderer<EntityNessie>
{
	private static final ResourceLocation TEXTURE = new ResourceLocation("candycraftmod:textures/entity/NessieSaddle.png");
	private final RenderNessie nessieRenderer;
	private final ModelNessie nessieModel = new ModelNessie(0.5F);

	public LayerNessieSaddle(RenderNessie nessieRenderer)
	{
		this.nessieRenderer = nessieRenderer;
	}

	@Override
	public void doRenderLayer(EntityNessie nessie, float p_177155_2_, float p_177155_3_, float p_177155_4_, float p_177155_5_, float p_177155_6_, float p_177155_7_, float p_177155_8_)
	{
		if (nessie.getSaddled())
		{
			nessieRenderer.bindTexture(TEXTURE);
			nessieModel.setModelAttributes(nessieRenderer.getMainModel());
			nessieModel.render(nessie, p_177155_2_, p_177155_3_, p_177155_5_, p_177155_6_, p_177155_7_, p_177155_8_);
		}
	}

	@Override
	public boolean shouldCombineTextures()
	{
		return false;
	}
}
