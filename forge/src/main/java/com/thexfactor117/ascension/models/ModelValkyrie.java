package com.thexfactor117.ascension.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelValkyrie extends ModelBase
{
  //fields
    ModelRenderer headmid;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer chest;
    ModelRenderer Hair;
    ModelRenderer Wing1;
    ModelRenderer Wing2;
    ModelRenderer bodytop;
    ModelRenderer body1;
  
  public ModelValkyrie()
  {
    textureWidth = 128;
    textureHeight = 64;
    
      headmid = new ModelRenderer(this, 0, 0);
      headmid.addBox(-4F, -8F, -4F, 8, 8, 8);
      headmid.setRotationPoint(0F, 0F, 0F);
      headmid.setTextureSize(128, 64);
      headmid.mirror = true;
      setRotation(headmid, 0F, 0F, 0F);
      body = new ModelRenderer(this, 32, 7);
      body.addBox(-4F, 0F, -2F, 7, 3, 4);
      body.setRotationPoint(0.5F, 5F, 0F);
      body.setTextureSize(128, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-2F, -2F, -1.5F, 3, 12, 3);
      rightarm.setRotationPoint(-5F, 2F, 0F);
      rightarm.setTextureSize(128, 64);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(-1F, -2F, -1.5F, 3, 12, 3);
      leftarm.setRotationPoint(5F, 2F, 0F);
      leftarm.setTextureSize(128, 64);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 16);
      rightleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      rightleg.setRotationPoint(-2F, 12F, 0F);
      rightleg.setTextureSize(128, 64);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-2F, 0F, -2F, 4, 12, 4);
      leftleg.setRotationPoint(2F, 12F, 0F);
      leftleg.setTextureSize(128, 64);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      chest = new ModelRenderer(this, 34, 32);
      chest.addBox(-4F, 0F, 0F, 8, 4, 4);
      chest.setRotationPoint(0F, 1F, -2F);
      chest.setTextureSize(128, 64);
      chest.mirror = true;
      setRotation(chest, -0.2230717F, 0F, 0F);
      Hair = new ModelRenderer(this, 0, 32);
      Hair.addBox(-4.5F, 0.5F, 0.5F, 9, 12, 8);
      Hair.setRotationPoint(0F, -9F, -4F);
      Hair.setTextureSize(128, 64);
      Hair.mirror = true;
      setRotation(Hair, 0F, 0F, 0F);
      Wing1 = new ModelRenderer(this, 52, 16);
      Wing1.addBox(0F, -1F, 0F, 14, 10, 0);
      Wing1.setRotationPoint(0F, -1F, 2.1F);
      Wing1.setTextureSize(128, 64);
      Wing1.mirror = true;
      setRotation(Wing1, 0F, 0F, 0F);
      Wing2 = new ModelRenderer(this, 52, 16);
      Wing2.addBox(0F, -1F, 0F, 14, 10, 0);
      Wing2.setRotationPoint(0F, -1F, 2.1F);
      Wing2.setTextureSize(128, 64);
      Wing2.mirror = true;
      setRotation(Wing2, 0F, -3.155555F, 0F);
      bodytop = new ModelRenderer(this, 16, 16);
      bodytop.addBox(-4F, 0F, -2F, 8, 5, 4);
      bodytop.setRotationPoint(0F, 0F, 0F);
      bodytop.setTextureSize(128, 64);
      bodytop.mirror = true;
      setRotation(bodytop, 0F, 0F, 0F);
      body1 = new ModelRenderer(this, 54, 7);
      body1.addBox(-4F, 0F, -2F, 8, 4, 4);
      body1.setRotationPoint(0F, 8F, 0F);
      body1.setTextureSize(128, 64);
      body1.mirror = true;
      setRotation(body1, 0F, 0F, 0F);
      headmid.addChild(Hair);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    headmid.render(f5);
    body.render(f5);
    rightarm.render(f5);
    leftarm.render(f5);
    rightleg.render(f5);
    leftleg.render(f5);
    chest.render(f5);
    Wing1.render(f5);
    Wing2.render(f5);
    bodytop.render(f5);
    body1.render(f5);
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
    
      this.headmid.rotateAngleY = f3 / (180F / (float)Math.PI);
      this.headmid.rotateAngleX = f4 / (180F / (float)Math.PI);
      this.Hair.rotateAngleY = this.headmid.rotateAngleY;
      this.Hair.rotateAngleX = this.headmid.rotateAngleX;
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
