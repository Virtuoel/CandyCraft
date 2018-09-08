package valentin4311.candycraft.client.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import valentin4311.candycraft.entity.boss.EntityKingSlime;

@SideOnly(Side.CLIENT)
public class RenderKingJelly extends RenderJelly
{
	private static final ResourceLocation slimeTexture = new ResourceLocation("candycraftmod:textures/entity/CandyBoss6.png");
	private static final ResourceLocation sleepTexture = new ResourceLocation("candycraftmod:textures/entity/CandyBoss4.png");

	public RenderKingJelly(RenderManager rm, ModelBase par1ModelBase)
	{
		super(rm, par1ModelBase);
	}

	@Override
	protected ResourceLocation getJellyTexture(EntityLiving par1EntityKingSlime)
	{
		return ((EntityKingSlime) par1EntityKingSlime).getAwake() ? sleepTexture : slimeTexture;
	}
}
