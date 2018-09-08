package valentin4311.candycraft.client.entity;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderDragon extends RenderLiving
{
	private static final ResourceLocation texture = new ResourceLocation("candycraftmod:textures/entity/Dragons.png");

	public RenderDragon(RenderManager rm, ModelBase par1ModelBase, float par2)
	{
		super(rm, par1ModelBase, par2);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase par1EntityLivingBase, float par2)
	{
		GL11.glTranslatef(-0.0625F, 0F, 0F);
		if (par1EntityLivingBase.getControllingPassenger() != null)
		{
			GL11.glTranslatef(0F, (float) ModelDragon.heightOverlay, 0F);
		}
		GL11.glScalef(1.5F, 1.5F, 1.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity var1)
	{
		return texture;
	}
}
