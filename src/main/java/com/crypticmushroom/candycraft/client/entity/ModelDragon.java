package com.crypticmushroom.candycraft.client.entity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

public class ModelDragon extends ModelBase
{
	public static double heightOverlay;

	ModelRenderer FrontLeftFeet;
	ModelRenderer FrontRightFeet;
	ModelRenderer BackLeftFeet;
	ModelRenderer BackRightFeet;
	ModelRenderer Body1;
	ModelRenderer Neck1;
	ModelRenderer Body2;
	ModelRenderer Body3;
	ModelRenderer Body4;
	ModelRenderer Body5;
	ModelRenderer Body6;
	ModelRenderer Body7;
	ModelRenderer Neck2;
	ModelRenderer RightFrontLegBase;
	ModelRenderer RightFrontLegTop;
	ModelRenderer LeftFrontLegTop;
	ModelRenderer LeftFrontLegBase;
	ModelRenderer RightBackLegTop;
	ModelRenderer LeftBackLegTop;
	ModelRenderer RightBackLegBase;
	ModelRenderer LeftBackLegBase;
	ModelRenderer Scale0;
	ModelRenderer Scale1;
	ModelRenderer Scale2;
	ModelRenderer Scale3;
	ModelRenderer Scale4;
	ModelRenderer LeftWing;
	ModelRenderer RightScale;
	ModelRenderer LeftScale;
	ModelRenderer RightWing;
	ModelRenderer Horn2;
	ModelRenderer Mouth;
	ModelRenderer Head;
	ModelRenderer Head2;
	ModelRenderer Horn1;
	ModelRenderer Crystal;

	public ModelDragon()
	{
		textureWidth = 128;
		textureHeight = 64;

		FrontLeftFeet = new ModelRenderer(this, 0, 0);
		FrontLeftFeet.addBox(0F, 0F, -4F, 3, 1, 4);
		FrontLeftFeet.setRotationPoint(-0.5F, 6F, 2.5F);
		FrontLeftFeet.setTextureSize(128, 64);
		FrontLeftFeet.mirror = true;
		setRotation(FrontLeftFeet, 0.3490659F, 0F, 0F);
		FrontRightFeet = new ModelRenderer(this, 0, 0);
		FrontRightFeet.addBox(0F, 0F, -4F, 3, 1, 4);
		FrontRightFeet.setRotationPoint(-0.5F, 6F, 2.5F);
		FrontRightFeet.setTextureSize(128, 64);
		FrontRightFeet.mirror = true;
		setRotation(FrontRightFeet, 0.3490659F, 0F, 0F);
		BackLeftFeet = new ModelRenderer(this, 0, 0);
		BackLeftFeet.addBox(0F, 0F, -4F, 3, 1, 4);
		BackLeftFeet.setRotationPoint(-0.5F, 5F, 2.5F);
		BackLeftFeet.setTextureSize(128, 64);
		BackLeftFeet.mirror = true;
		setRotation(BackLeftFeet, 0.3490659F, 0F, 0F);
		BackRightFeet = new ModelRenderer(this, 0, 0);
		BackRightFeet.addBox(0F, 0F, -4F, 3, 1, 4);
		BackRightFeet.setRotationPoint(-0.5F, 5F, 2.5F);
		BackRightFeet.setTextureSize(128, 64);
		BackRightFeet.mirror = true;
		setRotation(BackRightFeet, 0.3490659F, 0F, 0F);
		Body1 = new ModelRenderer(this, 0, 14);
		Body1.addBox(0F, 0F, 0F, 7, 7, 11);
		Body1.setRotationPoint(-3F, 9F, -11F);
		Body1.setTextureSize(128, 64);
		Body1.mirror = true;
		setRotation(Body1, 0F, 0F, 0F);
		Neck1 = new ModelRenderer(this, 63, 0);
		Neck1.addBox(0F, 0F, 0F, 4, 15, 3);
		Neck1.setRotationPoint(-1.5F, 4F, -19F);
		Neck1.setTextureSize(128, 64);
		Neck1.mirror = true;
		setRotation(Neck1, 0.6457718F, 0F, 0F);
		Body2 = new ModelRenderer(this, 36, 19);
		Body2.addBox(0F, 0F, 0F, 6, 6, 7);
		Body2.setRotationPoint(-2.5F, 9.5F, 0F);
		Body2.setTextureSize(128, 64);
		Body2.mirror = true;
		setRotation(Body2, -0.1396263F, 0F, 0F);
		Body3 = new ModelRenderer(this, 62, 21);
		Body3.addBox(0F, 0F, 0F, 5, 5, 6);
		Body3.setRotationPoint(-2F, 11F, 6.8F);
		Body3.setTextureSize(128, 64);
		Body3.mirror = true;
		setRotation(Body3, -0.2617994F, 0F, 0F);
		Body4 = new ModelRenderer(this, 99, 14);
		Body4.addBox(0F, 0F, 0F, 4, 4, 5);
		Body4.setRotationPoint(-1.5F, 13F, 12F);
		Body4.setTextureSize(128, 64);
		Body4.mirror = true;
		setRotation(Body4, -0.3839724F, 0F, 0F);
		Body5 = new ModelRenderer(this, 26, 18);
		Body5.addBox(0F, 0F, 0F, 3, 3, 4);
		Body5.setRotationPoint(-1F, 15F, 16F);
		Body5.setTextureSize(128, 64);
		Body5.mirror = true;
		setRotation(Body5, -0.2094395F, 0F, 0F);
		Body6 = new ModelRenderer(this, 99, 23);
		Body6.addBox(0F, 0F, 0F, 2, 2, 5);
		Body6.setRotationPoint(-0.5F, 16.5F, 19F);
		Body6.setTextureSize(128, 64);
		Body6.mirror = true;
		setRotation(Body6, -0.0371786F, 0F, 0F);
		Body7 = new ModelRenderer(this, 56, 21);
		Body7.addBox(0F, 0F, 0F, 1, 1, 4);
		Body7.setRotationPoint(0F, 17.2F, 23.5F);
		Body7.setTextureSize(128, 64);
		Body7.mirror = true;
		setRotation(Body7, 0.2602503F, 0F, 0F);
		Neck2 = new ModelRenderer(this, 85, 14);
		Neck2.addBox(0F, 0F, 0F, 5, 10, 2);
		Neck2.setRotationPoint(-2F, 3F, -17F);
		Neck2.setTextureSize(128, 64);
		Neck2.mirror = true;
		setRotation(Neck2, 0.6457718F, 0F, 0F);
		RightFrontLegBase = new ModelRenderer(this, 117, 14);
		RightFrontLegBase.addBox(0F, 0F, 0F, 2, 7, 2);
		RightFrontLegBase.setRotationPoint(0.9F, 4.3F, +1.4F);
		RightFrontLegBase.setTextureSize(128, 64);
		RightFrontLegBase.mirror = true;
		setRotation(RightFrontLegBase, -0.3490659F - 0.4059698F, 0F, 0F);
		RightFrontLegTop = new ModelRenderer(this, 64, 32);
		RightFrontLegTop.addBox(0F, 0F, 0F, 3, 7, 3);
		RightFrontLegTop.setRotationPoint(-5.5F, 12F, -10F);
		RightFrontLegTop.setTextureSize(128, 64);
		RightFrontLegTop.mirror = true;
		setRotation(RightFrontLegTop, 0.4059698F, 0F, 0F);
		LeftFrontLegTop = new ModelRenderer(this, 64, 32);
		LeftFrontLegTop.addBox(0F, 0F, 0F, 3, 7, 3);
		LeftFrontLegTop.setRotationPoint(3.5F, 12F, -10F);
		LeftFrontLegTop.setTextureSize(128, 64);
		LeftFrontLegTop.mirror = true;
		setRotation(LeftFrontLegTop, 0.4059698F, 0F, 0F);
		LeftFrontLegBase = new ModelRenderer(this, 117, 14);
		LeftFrontLegBase.addBox(0F, 0F, 0F, 2, 7, 2);
		LeftFrontLegBase.setRotationPoint(0.1F, 4.3F, +1.4F);
		LeftFrontLegBase.setTextureSize(128, 64);
		LeftFrontLegBase.mirror = true;
		setRotation(LeftFrontLegBase, -0.3490659F - 0.4059698F, 0F, 0F);
		RightBackLegTop = new ModelRenderer(this, 64, 32);
		RightBackLegTop.addBox(0F, 0F, 0F, 3, 7, 3);
		RightBackLegTop.setRotationPoint(-5F, 13F, 3F);
		RightBackLegTop.setTextureSize(128, 64);
		RightBackLegTop.mirror = true;
		setRotation(RightBackLegTop, 0.4059698F, 0F, 0F);
		LeftBackLegTop = new ModelRenderer(this, 64, 32);
		LeftBackLegTop.addBox(0F, 0F, 0F, 3, 7, 3);
		LeftBackLegTop.setRotationPoint(3F, 13F, 3F);
		LeftBackLegTop.setTextureSize(128, 64);
		LeftBackLegTop.mirror = true;
		setRotation(LeftBackLegTop, 0.4059698F, 0F, 0F);
		RightBackLegBase = new ModelRenderer(this, 117, 14);
		RightBackLegBase.addBox(0F, 0F, 0F, 2, 6, 2);
		RightBackLegBase.setRotationPoint(0.9F, 5.3F, +1.4F);
		RightBackLegBase.setTextureSize(128, 64);
		RightBackLegBase.mirror = true;
		setRotation(RightBackLegBase, -0.3490659F - 0.4059698F, 0F, 0F);
		LeftBackLegBase = new ModelRenderer(this, 117, 14);
		LeftBackLegBase.addBox(0F, 0F, 0F, 2, 6, 2);
		LeftBackLegBase.setRotationPoint(0.1F, 5.3F, +1.4F);
		LeftBackLegBase.setTextureSize(128, 64);
		LeftBackLegBase.mirror = true;
		setRotation(LeftBackLegBase, -0.3490659F - 0.4059698F, 0F, 0F);
		Scale0 = new ModelRenderer(this, 76, 26);
		Scale0.addBox(0F, 0F, 0F, 0, 3, 6);
		Scale0.setRotationPoint(0.5F, 6F, -8F);
		Scale0.setTextureSize(128, 64);
		Scale0.mirror = true;
		setRotation(Scale0, 0F, 0F, 0F);
		Scale1 = new ModelRenderer(this, 88, 21);
		Scale1.addBox(0F, 0F, 0F, 0, 2, 5);
		Scale1.setRotationPoint(0.5F, 7.5F, 1F);
		Scale1.setTextureSize(128, 64);
		Scale1.mirror = true;
		setRotation(Scale1, -0.1396263F, 0F, 0F);
		Scale2 = new ModelRenderer(this, 24, -4);
		Scale2.addBox(0F, 0F, 0F, 0, 2, 4);
		Scale2.setRotationPoint(0.5F, 9.5F, 8F);
		Scale2.setTextureSize(128, 64);
		Scale2.mirror = true;
		setRotation(Scale2, -0.2617994F, 0F, 0F);
		Scale3 = new ModelRenderer(this, 57, 9);
		Scale3.addBox(0F, 0F, 0F, 0, 2, 3);
		Scale3.setRotationPoint(0.5F, 12F, 14F);
		Scale3.setTextureSize(128, 64);
		Scale3.mirror = true;
		setRotation(Scale3, -0.3839724F, 0F, 0F);
		Scale4 = new ModelRenderer(this, 20, -2);
		Scale4.addBox(0F, 0F, 0F, 0, 2, 2);
		Scale4.setRotationPoint(0.5F, 14F, 17.5F);
		Scale4.setTextureSize(128, 64);
		Scale4.mirror = true;
		setRotation(Scale4, -0.2094395F, 0F, 0F);
		LeftWing = new ModelRenderer(this, 88, 28);
		LeftWing.addBox(-1.9F, -20F, 0F, 2, 21, 2);
		LeftWing.setRotationPoint(4F, 11F, -9F);
		LeftWing.setTextureSize(128, 64);
		LeftWing.mirror = true;
		setRotation(LeftWing, 0F, 0F, 1.570796F);
		RightScale = new ModelRenderer(this, -14, 47);
		RightScale.addBox(-20F, -1F, 0F, 21, 0, 14);
		RightScale.setRotationPoint(-3F, 11F, -9F);
		RightScale.setTextureSize(128, 64);
		RightScale.mirror = true;
		setRotation(RightScale, 0F, 0F, 0F);
		LeftScale = new ModelRenderer(this, 72, 0);
		LeftScale.addBox(-1F, -1F, 0F, 21, 0, 14);
		LeftScale.setRotationPoint(4F, 11F, -9F);
		LeftScale.setTextureSize(128, 64);
		LeftScale.mirror = true;
		setRotation(LeftScale, 0F, 0F, 0F);
		RightWing = new ModelRenderer(this, 88, 28);
		RightWing.addBox(-0.1F, -20F, 0F, 2, 21, 2);
		RightWing.setRotationPoint(-3F, 11F, -9F);
		RightWing.setTextureSize(128, 64);
		RightWing.mirror = true;
		setRotation(RightWing, 0F, 0F, -1.570796F);
		Horn2 = new ModelRenderer(this, 25, 0);
		Horn2.addBox(-3.6F, -5F, 0F, 1, 1, 7);
		Horn2.setRotationPoint(0.5F, 3F, -17F);
		Horn2.setTextureSize(128, 64);
		Horn2.mirror = true;
		setRotation(Horn2, 0.4712389F, 0F, 0F);
		Mouth = new ModelRenderer(this, 33, 0);
		Mouth.addBox(-3F, -1F, -7F, 6, 2, 9);
		Mouth.setRotationPoint(0.5F, 3F, -17F);
		Mouth.setTextureSize(128, 64);
		Mouth.mirror = true;
		setRotation(Mouth, 0.0371786F, 0F, 0F);
		Head = new ModelRenderer(this, 0, 32);
		Head.addBox(-3.5F, -5F, -8F, 7, 5, 10);
		Head.setRotationPoint(0.5F, 3F, -17F);
		Head.setTextureSize(128, 64);
		Head.mirror = true;
		setRotation(Head, 0.2268928F, 0F, 0F);
		Head2 = new ModelRenderer(this, 34, 32);
		Head2.addBox(-3F, -5.5F, -6.8F, 6, 2, 9);
		Head2.setRotationPoint(0.5F, 3F, -17F);
		Head2.setTextureSize(128, 64);
		Head2.mirror = true;
		setRotation(Head2, 0.2974289F, 0F, 0F);
		Horn1 = new ModelRenderer(this, 25, 0);
		Horn1.addBox(2.6F, -5F, 0F, 1, 1, 7);
		Horn1.setRotationPoint(0.5F, 3F, -17F);
		Horn1.setTextureSize(128, 64);
		Horn1.mirror = true;
		setRotation(Horn1, 0.4712389F, 0F, 0F);
		Crystal = new ModelRenderer(this, 0, 5);
		Crystal.addBox(2.9F, -4.5F, -3.9F, 1, 1, 1);
		Crystal.setRotationPoint(0.5F, 3F, -17F);
		Crystal.setTextureSize(128, 64);
		Crystal.mirror = true;
		setRotation(Crystal, 0F, 0.7853982F, 0F);

		LeftBackLegTop.addChild(LeftBackLegBase);
		LeftBackLegBase.addChild(BackLeftFeet);
		RightBackLegTop.addChild(RightBackLegBase);
		RightBackLegBase.addChild(BackRightFeet);

		LeftFrontLegTop.addChild(LeftFrontLegBase);
		LeftFrontLegBase.addChild(FrontLeftFeet);
		RightFrontLegTop.addChild(RightFrontLegBase);
		RightFrontLegBase.addChild(FrontRightFeet);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Body1.render(f5);
		Neck1.render(f5);
		Body2.render(f5);
		Body3.render(f5);
		Body4.render(f5);
		Body5.render(f5);
		Body6.render(f5);
		Body7.render(f5);
		Neck2.render(f5);
		RightFrontLegTop.render(f5);
		LeftFrontLegTop.render(f5);
		RightBackLegTop.render(f5);
		LeftBackLegTop.render(f5);
		Scale0.render(f5);
		Scale1.render(f5);
		Scale2.render(f5);
		Scale3.render(f5);
		Scale4.render(f5);
		LeftWing.render(f5);
		RightScale.render(f5);
		LeftScale.render(f5);
		RightWing.render(f5);
		Horn2.render(f5);
		Mouth.render(f5);
		Head.render(f5);
		Head2.render(f5);
		Horn1.render(f5);
		Crystal.render(f5);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	@Override
	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
	{
		super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);

		if (entity.getControllingPassenger() != null)
		{
			float rotationSpeed = 0.3F;
			RightWing.rotateAngleZ = ((MathHelper.sin(entity.ticksExisted * rotationSpeed) + 1) * 0.6F) - 1.570796F;
			LeftWing.rotateAngleZ = -((MathHelper.sin(entity.ticksExisted * rotationSpeed) + 1) * 0.6F) + 1.570796F;

			LeftScale.rotateAngleZ = -((MathHelper.sin(entity.ticksExisted * rotationSpeed) + 1) * 0.6F);
			RightScale.rotateAngleZ = ((MathHelper.sin(entity.ticksExisted * rotationSpeed) + 1) * 0.6F);

			LeftFrontLegTop.rotateAngleX = 1.570796F / 2F;
			RightFrontLegTop.rotateAngleX = 1.570796F / 2F;
			RightBackLegTop.rotateAngleX = 1.570796F / 2F;
			LeftBackLegTop.rotateAngleX = 1.570796F / 2F;

			RightBackLegBase.rotateAngleX = 0;
			RightFrontLegBase.rotateAngleX = 0;
			LeftBackLegBase.rotateAngleX = 0;
			LeftFrontLegBase.rotateAngleX = 0;
		}
		else
		{
			LeftFrontLegTop.rotateAngleX = ((MathHelper.sin(f) + 1) * 1.0F) * -1 * f1 + 0.4059698F;
			RightFrontLegTop.rotateAngleX = ((MathHelper.cos(f) + 1) * 1.0F) * -1 * f1 + 0.4059698F;
			RightBackLegTop.rotateAngleX = ((MathHelper.sin(f) + 1) * 1.0F) * -1 * f1 + 0.4059698F;
			LeftBackLegTop.rotateAngleX = ((MathHelper.cos(f) + 1) * 1.0F) * -1 * f1 + 0.4059698F;

			RightBackLegBase.rotateAngleX = -((MathHelper.sin(f) + 1) * 1.0F) * -1 * f1 - 0.3490659F - 0.4059698F;
			RightFrontLegBase.rotateAngleX = -((MathHelper.cos(f) + 1) * 1.0F) * -1 * f1 - 0.3490659F - 0.4059698F;
			LeftBackLegBase.rotateAngleX = -((MathHelper.cos(f) + 1) * 1.0F) * -1 * f1 - 0.3490659F - 0.4059698F;
			LeftFrontLegBase.rotateAngleX = -((MathHelper.sin(f) + 1) * 1.0F) * -1 * f1 - 0.3490659F - 0.4059698F;
		}

		if (entity.getControllingPassenger() == null)
		{
			RightWing.isHidden = true;
			LeftWing.isHidden = true;
			RightScale.isHidden = true;
			LeftScale.isHidden = true;
			heightOverlay = 0;
		}
		else
		{
			RightWing.isHidden = false;
			LeftWing.isHidden = false;
			RightScale.isHidden = false;
			LeftScale.isHidden = false;
			heightOverlay = Math.sin(entity.ticksExisted * 0.05F) / 6;
		}
	}

}
