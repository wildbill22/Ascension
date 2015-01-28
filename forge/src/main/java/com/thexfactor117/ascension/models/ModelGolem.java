package com.thexfactor117.ascension.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGolem extends ModelBase
{
  //fields
    ModelRenderer Leg1;
    ModelRenderer Leg2;
    ModelRenderer Body_3;
    ModelRenderer Body_2;
    ModelRenderer Body_1;
    ModelRenderer Head;
    ModelRenderer Arm_top_1;
    ModelRenderer Arm_top_2;
    ModelRenderer Arm_middle_1;
    ModelRenderer Arm_middle_2;
    ModelRenderer Arm_bottom_1;
    ModelRenderer Arm_bottom_2;
  
  public ModelGolem()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      Leg1 = new ModelRenderer(this, 0, 0);
      Leg1.addBox(-2.5F, 0F, -2.5F, 5, 15, 5);
      Leg1.setRotationPoint(-7F, 9F, 0F);
      Leg1.setTextureSize(128, 64);
      Leg1.mirror = true;
      setRotation(Leg1, 0F, 0F, 0F);
      Leg2 = new ModelRenderer(this, 0, 0);
      Leg2.addBox(-2.5F, 0F, -2.5F, 5, 15, 5);
      Leg2.setRotationPoint(7F, 9F, 0F);
      Leg2.setTextureSize(128, 64);
      Leg2.mirror = true;
      setRotation(Leg2, 0F, 0F, 0F);
      Body_3 = new ModelRenderer(this, 36, 47);
      Body_3.addBox(-9F, -3F, -4F, 18, 7, 10);
      Body_3.setRotationPoint(0F, 5F, -1F);
      Body_3.setTextureSize(128, 64);
      Body_3.mirror = true;
      setRotation(Body_3, 0F, 0F, 0F);
      Body_2 = new ModelRenderer(this, 0, 48);
      Body_2.addBox(-4F, -2F, -5F, 10, 8, 8);
      Body_2.setRotationPoint(-1F, -4F, 1F);
      Body_2.setTextureSize(128, 64);
      Body_2.mirror = true;
      setRotation(Body_2, 0F, 0F, 0F);
      Body_1 = new ModelRenderer(this, 0, 22);
      Body_1.addBox(-9F, -3F, -4F, 22, 13, 12);
      Body_1.setRotationPoint(-2F, -16F, -2F);
      Body_1.setTextureSize(128, 64);
      Body_1.mirror = true;
      setRotation(Body_1, 0F, 0F, 0F);
      Head = new ModelRenderer(this, 20, 7);
      Head.addBox(-3.5F, -7F, -3.5F, 7, 8, 7);
      Head.setRotationPoint(0F, -20F, 0F);
      Head.setTextureSize(128, 64);
      Head.mirror = true;
      setRotation(Head, 0F, 45F, 0F);
      Arm_top_1 = new ModelRenderer(this, 48, 9);
      Arm_top_1.addBox(0F, 0F, -2F, 7, 7, 6);
      Arm_top_1.setRotationPoint(10F, -18F, -1F);
      Arm_top_1.setTextureSize(128, 64);
      Arm_top_1.mirror = true;
      setRotation(Arm_top_1, 0F, 0F, 45F);
      Arm_top_2 = new ModelRenderer(this, 48, 9);
      Arm_top_2.addBox(-7F, 0F, -3F, 7, 7, 6);
      Arm_top_2.setRotationPoint(-10F, -18.4F, 0F);
      Arm_top_2.setTextureSize(128, 64);
      Arm_top_2.mirror = true;
      setRotation(Arm_top_2, 0F, 0F, 45F);
      Arm_middle_1 = new ModelRenderer(this, 74, 0);
      Arm_middle_1.addBox(-2F, 0F, -1F, 4, 15, 4);
      Arm_middle_1.setRotationPoint(15F, -15F, -1F);
      Arm_middle_1.setTextureSize(128, 64);
      Arm_middle_1.mirror = true;
      setRotation(Arm_middle_1, 0F, 0F, 0F);
      Arm_middle_2 = new ModelRenderer(this, 74, 0);
      Arm_middle_2.addBox(-2F, 0F, -2F, 4, 15, 4);
      Arm_middle_2.setRotationPoint(-15F, -15F, 0F);
      Arm_middle_2.setTextureSize(128, 64);
      Arm_middle_2.mirror = true;
      setRotation(Arm_middle_2, 0F, 0F, 0F);
      Arm_bottom_1 = new ModelRenderer(this, 68, 23);
      Arm_bottom_1.addBox(-4F, 0F, -4F, 8, 16, 8);
      Arm_bottom_1.setRotationPoint(15F, 0F, 0F);
      Arm_bottom_1.setTextureSize(128, 64);
      Arm_bottom_1.mirror = true;
      setRotation(Arm_bottom_1, 0F, 0F, 0F);
      Arm_bottom_2 = new ModelRenderer(this, 68, 23);
      Arm_bottom_2.addBox(-4F, 0F, -4F, 8, 16, 8);
      Arm_bottom_2.setRotationPoint(-15F, 0F, 0F);
      Arm_bottom_2.setTextureSize(128, 64);
      Arm_bottom_2.mirror = true;
      setRotation(Arm_bottom_2, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Leg1.render(f5);
    Leg2.render(f5);
    Body_3.render(f5);
    Body_2.render(f5);
    Body_1.render(f5);
    Head.render(f5);
    Arm_top_1.render(f5);
    Arm_top_2.render(f5);
    Arm_middle_1.render(f5);
    Arm_middle_2.render(f5);
    Arm_bottom_1.render(f5);
    Arm_bottom_2.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
	  super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	  
      this.Head.rotateAngleY = f3 / (180F / (float)Math.PI);
      this.Head.rotateAngleX = f4 / (180F / (float)Math.PI);
      this.Arm_top_1.rotateAngleZ = -0.35F;
      this.Arm_top_2.rotateAngleZ = 0.35F;
      this.Leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.Leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
      this.Leg1.rotateAngleY = 0.0F;
      this.Leg2.rotateAngleY = 0.0F;
  }
}
