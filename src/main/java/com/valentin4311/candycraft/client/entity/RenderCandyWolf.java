package valentin4311.candycraft.client.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderWolf;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import valentin4311.candycraft.entity.EntityCandyWolf;

@SideOnly(Side.CLIENT)
public class RenderCandyWolf extends RenderLiving<EntityWolf>
{
	private static final ResourceLocation wolfTexture = new ResourceLocation("candycraftmod:textures/entity/wolfCandy.png");
	private static final ResourceLocation tameTexture = new ResourceLocation("candycraftmod:textures/entity/wolf_tameCandy.png");
	private static final ResourceLocation angryTexture = new ResourceLocation("candycraftmod:textures/entity/wolf_angryCandy.png");
	private static final ResourceLocation caramelTexture = new ResourceLocation("candycraftmod:textures/entity/wolf_tameCandy2.png");
	private static final ResourceLocation collarTexture = new ResourceLocation("textures/entity/wolf/wolf_collar.png");

	public RenderCandyWolf(RenderManager rm, ModelBase par1ModelBase, float par3)
	{
		super(rm, par1ModelBase, par3);
	}

	protected ResourceLocation getEntityTexture(EntityCandyWolf par1EntityWolf)
	{
		return par1EntityWolf.isTamed() ? (par1EntityWolf.getFurTime() < 1 ? caramelTexture : tameTexture) : (par1EntityWolf.isAngry() ? angryTexture : wolfTexture);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityWolf entity)
	{
		return this.getEntityTexture((EntityCandyWolf) entity);
	}
}
