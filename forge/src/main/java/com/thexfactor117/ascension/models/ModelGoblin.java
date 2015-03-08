package com.thexfactor117.ascension.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelGoblin extends ModelBase
{
  //fields
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer belly;
    ModelRenderer cloth;
    ModelRenderer nose;
    ModelRenderer head1;
  
  public ModelGoblin()
  {
    textureWidth = 64;
    textureHeight = 64;
    
      head = new ModelRenderer(this, 0, 0);
      head.addBox(-3.5F, -7.5F, -3.5F, 7, 7, 7);
      head.setRotationPoint(0F, 6.5F, 0F);
      head.setTextureSize(64, 64);
      head.mirror = true;
      setRotation(head, 0F, 0F, 0F);
      body = new ModelRenderer(this, 16, 16);
      body.addBox(-4F, 0F, -2F, 8, 9, 4);
      body.setRotationPoint(0F, 6F, 0F);
      body.setTextureSize(64, 64);
      body.mirror = true;
      setRotation(body, 0F, 0F, 0F);
      rightarm = new ModelRenderer(this, 40, 16);
      rightarm.addBox(-3F, -2F, -2F, 3, 9, 4);
      rightarm.setRotationPoint(-4F, 8F, 0F);
      rightarm.setTextureSize(64, 64);
      rightarm.mirror = true;
      setRotation(rightarm, 0F, 0F, 0F);
      leftarm = new ModelRenderer(this, 40, 16);
      leftarm.addBox(0F, -2F, -2F, 3, 9, 4);
      leftarm.setRotationPoint(4F, 8F, 0F);
      leftarm.setTextureSize(64, 64);
      leftarm.mirror = true;
      setRotation(leftarm, 0F, 0F, 0F);
      rightleg = new ModelRenderer(this, 0, 29);
      rightleg.addBox(-2F, 0F, -2F, 3, 9, 4);
      rightleg.setRotationPoint(-2F, 15F, 0F);
      rightleg.setTextureSize(64, 64);
      rightleg.mirror = true;
      setRotation(rightleg, 0F, 0F, 0F);
      leftleg = new ModelRenderer(this, 0, 16);
      leftleg.addBox(-1F, 0F, -2F, 3, 9, 4);
      leftleg.setRotationPoint(2F, 15F, 0F);
      leftleg.setTextureSize(64, 64);
      leftleg.mirror = true;
      setRotation(leftleg, 0F, 0F, 0F);
      belly = new ModelRenderer(this, 16, 29);
      belly.addBox(-3F, -3F, 1F, 8, 5, 1);
      belly.setRotationPoint(-1F, 12F, -4F);
      belly.setTextureSize(64, 64);
      belly.mirror = true;
      setRotation(belly, 0F, 0F, 0F);
      cloth = new ModelRenderer(this, 14, 35);
      cloth.addBox(-4.5F, -1.5F, -2.5F, 9, 5, 5);
      cloth.setRotationPoint(0F, 15F, 0F);
      cloth.setTextureSize(64, 64);
      cloth.mirror = true;
      setRotation(cloth, 0F, 0F, 0F);
      nose = new ModelRenderer(this, 28, 0);
      nose.addBox(-1F, -1F, 6F, 2, 3, 2);
      nose.setRotationPoint(0F, 3F, -2.5F);
      nose.setTextureSize(64, 64);
      nose.mirror = true;
      setRotation(nose, -17.049F, 0F, 0F);
      head1 = new ModelRenderer(this, 28, 8);
      //head1.addBox(-8F, -1F, 0F, 16, 3, 1); original
      head1.addBox(-8F, -6F, 0F, 16, 3, 1);
      head1.setRotationPoint(0F, 0.5F, 0F);
      head1.setTextureSize(64, 64);
      head1.mirror = true;
      setRotation(head1, 0F, 0F, 0F);
      head.addChild(nose);
      head.addChild(head1);
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
    belly.render(f5);
    cloth.render(f5);
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
