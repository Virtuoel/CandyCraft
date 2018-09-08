package valentin4311.candycraft.client.entity;

import net.minecraft.client.renderer.entity.RenderArrow;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import valentin4311.candycraft.entity.EntityCandyArrow;

@SideOnly(Side.CLIENT)
public class RenderCandyArrow extends RenderArrow
{
	private static final ResourceLocation arrowTextures = new ResourceLocation("candycraftmod:textures/entity/candyArrow.png");
	private static final ResourceLocation boltTextures = new ResourceLocation("candycraftmod:textures/entity/candyBolt.png");

	public RenderCandyArrow(RenderManager renderManager)
	{
		super(renderManager);
	}

	protected ResourceLocation getArrowTextures(EntityCandyArrow par1EntityArrow)
	{
		return par1EntityArrow.isBolt() ? boltTextures : arrowTextures;
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity)
	{
		return getArrowTextures((EntityCandyArrow) par1Entity);
	}
}
