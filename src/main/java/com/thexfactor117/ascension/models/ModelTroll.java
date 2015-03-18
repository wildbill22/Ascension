package com.thexfactor117.ascension.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelTroll extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer bodylower;
    ModelRenderer rightarmlower;
    ModelRenderer leftleglower;
    ModelRenderer rightleglower;
    ModelRenderer leftarmlower;
  
  public ModelTroll()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-5F, -10F, -4F, 10, 10, 10);
      head.setRotationPoint(0F, -19F, -1F);
      head.setTextureSize(64, 32);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 48, 27);
      body.addBox(-7F, 0F, -4F, 14, 11, 8);
      body.setRotationPoint(0F, -19F, 0F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 0, 47);
      rightarm.addBox(-6F, -2F, -3F, 6, 11, 6);
      rightarm.setRotationPoint(-7F, -16F, 0F);
      rightarm.setTextureSize(64, 32);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 0, 47);
      leftarm.addBox(0F, -2F, -2F, 6, 11, 6);
      leftarm.setRotationPoint(7F, -16F, -1F);
      leftarm.setTextureSize(64, 32);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 24, 46);
      rightleg.addBox(-3F, 0F, -3F, 6, 12, 6);
      rightleg.setRotationPoint(-4F, 0F, 0F);
      rightleg.setTextureSize(64, 32);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 24, 46);
      leftleg.addBox(-3F, 0F, -3F, 6, 12, 6);
      leftleg.setRotationPoint(4F, 0F, 0F);
      leftleg.setTextureSize(64, 32);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      bodylower = new ModelRenderer(this, 12, 32);
      bodylower.addBox(-6F, -1F, -3F, 12, 8, 6);
      bodylower.setRotationPoint(0F, -7F, 0F);
      bodylower.setTextureSize(64, 32);
      bodylower.mirror = true;
      setRotation(bodylower, 0F, 0F, 0F);
      rightarmlower = new ModelRenderer(this, 40, 0);
      rightarmlower.addBox(-3F, 0F, -3F, 6, 11, 6);
      rightarmlower.setRotationPoint(-10F, -7F, 0F);
      rightarmlower.setTextureSize(64, 32);
      rightarmlower.mirror = true;
      setRotation(rightarmlower, 0F, 0F, 0F);
      leftleglower = new ModelRenderer(this, 48, 46);
      leftleglower.addBox(-3F, 0F, -3F, 6, 12, 6);
      leftleglower.setRotationPoint(4F, 12F, 0F);
      leftleglower.setTextureSize(64, 32);
      leftleglower.mirror = true;
      setRotation(leftleglower, 0F, 0F, 0F);
      rightleglower = new ModelRenderer(this, 48, 46);
      rightleglower.addBox(-3F, 0F, -3F, 6, 12, 6);
      rightleglower.setRotationPoint(-4F, 12F, 0F);
      rightleglower.setTextureSize(64, 32);
      rightleglower.mirror = true;
      setRotation(rightleglower, 0F, 0F, 0F);
      leftarmlower = new ModelRenderer(this, 40, 0);
      leftarmlower.addBox(-3F, 0F, -3F, 6, 11, 6);
      leftarmlower.setRotationPoint(10F, -7F, 0F);
      leftarmlower.setTextureSize(64, 32);
      leftarmlower.mirror = true;
      setRotation(leftarmlower, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    head.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    bodylower.render(f5);
    rightarmlower.render(f5);
    leftleglower.render(f5);
    rightleg.render(f5);
    leftarmlower.render(f5);
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
    
    this.head.rotateAngleY = f3 / (180F / (float)Math.PI);
    this.head.rotateAngleX = f4 / (180F / (float)Math.PI);
    this.rightarm.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 2.0F * f1 * 0.5F;
    this.leftarm.rotateAngleX = MathHelper.cos(f * 0.6662F) * 2.0F * f1 * 0.5F;
    this.rightarm.rotateAngleZ = 0.0F;
    this.leftarm.rotateAngleZ = 0.0F;
    this.rightleg.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
    this.leftleg.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
    this.rightleg.rotateAngleY = 0.0F;
    this.leftleg.rotateAngleY = 0.0F;
  }

}
