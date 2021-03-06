package com.valentin4311.candycraftmod.client.tileentity;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelAlchemy extends ModelBase
{
	ModelRenderer Shape1;
	ModelRenderer Shape2;
	ModelRenderer Shape3;
	ModelRenderer Shape4;
	ModelRenderer Shape5;
	ModelRenderer Shape6;
	ModelRenderer Shape7;
	ModelRenderer Shape8;
	ModelRenderer Shape9;
	ModelRenderer Shape10;
	ModelRenderer Shape11;
	ModelRenderer Shape12;

	public ModelAlchemy()
	{
		textureWidth = 128;
		textureHeight = 64;

		Shape1 = new ModelRenderer(this, 16, 0);
		Shape1.addBox(0F, 0F, 0F, 14, 11, 14);
		Shape1.setRotationPoint(-7F, 12F, -7F);
		Shape1.setTextureSize(96, 32);
		Shape1.mirror = true;
		setRotation(Shape1, 0F, 0F, 0F);
		Shape2 = new ModelRenderer(this, 0, 26);
		Shape2.addBox(0F, 0F, 0F, 10, 3, 2);
		Shape2.setRotationPoint(-5F, 9F, -5F);
		Shape2.setTextureSize(96, 32);
		Shape2.mirror = true;
		setRotation(Shape2, 0F, -1.570796F, 0F);
		Shape3 = new ModelRenderer(this, 0, 26);
		Shape3.addBox(0F, 0F, 0F, 10, 3, 2);
		Shape3.setRotationPoint(7F, 9F, -5F);
		Shape3.setTextureSize(96, 32);
		Shape3.mirror = true;
		setRotation(Shape3, 0F, -1.570796F, 0F);
		Shape4 = new ModelRenderer(this, 0, 26);
		Shape4.addBox(0F, 0F, 0F, 10, 3, 2);
		Shape4.setRotationPoint(-5F, 9F, -7F);
		Shape4.setTextureSize(96, 32);
		Shape4.mirror = true;
		setRotation(Shape4, 0F, 0F, 0F);
		Shape5 = new ModelRenderer(this, 0, 26);
		Shape5.addBox(0F, 0F, 0F, 10, 3, 2);
		Shape5.setRotationPoint(-5F, 9F, 5F);
		Shape5.setTextureSize(96, 32);
		Shape5.mirror = true;
		setRotation(Shape5, 0F, 0F, 0F);
		Shape6 = new ModelRenderer(this, 0, 0);
		Shape6.addBox(0F, 0F, 0F, 4, 16, 4);
		Shape6.setRotationPoint(-8F, 8F, 4F);
		Shape6.setTextureSize(96, 32);
		Shape6.mirror = true;
		setRotation(Shape6, 0F, 0F, 0F);
		Shape7 = new ModelRenderer(this, 0, 0);
		Shape7.addBox(0F, 0F, 0F, 4, 16, 4);
		Shape7.setRotationPoint(-8F, 8F, -8F);
		Shape7.setTextureSize(96, 32);
		Shape7.mirror = true;
		setRotation(Shape7, 0F, 0F, 0F);
		Shape8 = new ModelRenderer(this, 0, 0);
		Shape8.addBox(0F, 0F, 0F, 4, 16, 4);
		Shape8.setRotationPoint(4F, 8F, 4F);
		Shape8.setTextureSize(96, 32);
		Shape8.mirror = true;
		setRotation(Shape8, 0F, 0F, 0F);
		Shape9 = new ModelRenderer(this, 0, 0);
		Shape9.addBox(0F, 0F, 0F, 4, 16, 4);
		Shape9.setRotationPoint(4F, 8F, -8F);
		Shape9.setTextureSize(96, 32);
		Shape9.mirror = true;
		setRotation(Shape9, 0F, 0F, 0F);
		Shape10 = new ModelRenderer(this, 48, 0);
		Shape10.addBox(0F, 0F, 0F, 10, 0, 10);
		Shape10.setRotationPoint(-5F, 10F, -5F);
		Shape10.setTextureSize(96, 32);
		Shape10.mirror = true;
		setRotation(Shape10, 0F, 0F, 0F);
		Shape11 = new ModelRenderer(this, 58, 10);
		Shape11.addBox(0F, 0F, 0F, 14, 0, 14);
		Shape11.setRotationPoint(-7F, 21F, -7F);
		Shape11.setTextureSize(96, 32);
		Shape11.mirror = true;
		setRotation(Shape11, 0F, 0F, 0F);
		Shape12 = new ModelRenderer(this, 72, 43);
		Shape12.addBox(0F, 0F, 0F, 14, 0, 14);
		Shape12.setRotationPoint(-7F, 14F, -7F);
		Shape12.setTextureSize(128, 64);
		Shape12.mirror = true;
		setRotation(Shape12, 0F, 0F, 0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	{
		super.render(entity, f, f1, f2, f3, f4, f5);
		setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
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
	}

	public void renderAll()
	{
		float f5 = 0.0625F;
		Shape1.render(f5);
		Shape2.render(f5);
		Shape3.render(f5);
		Shape4.render(f5);
		Shape5.render(f5);
		Shape6.render(f5);
		Shape7.render(f5);
		Shape8.render(f5);
		Shape9.render(f5);
		Shape10.render(f5);
		Shape11.render(f5);
		Shape12.render(f5);
	}

}
