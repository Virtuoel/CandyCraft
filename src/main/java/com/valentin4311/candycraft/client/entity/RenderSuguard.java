package valentin4311.candycraft.client.entity;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import valentin4311.candycraft.entity.EntitySuguard;
import valentin4311.candycraft.items.CCItems;

@SideOnly(Side.CLIENT)
public class RenderSuguard extends RenderLiving<EntitySuguard>
{
	private static final ResourceLocation suguard = new ResourceLocation("candycraftmod:textures/entity/SuGarde.png");
	private static final ResourceLocation orangeSuguard = new ResourceLocation("candycraftmod:textures/entity/SuguardeSoldier.png");

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
