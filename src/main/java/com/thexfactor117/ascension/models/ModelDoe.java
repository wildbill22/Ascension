package com.thexfactor117.ascension.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelPig;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;

public class ModelDoe extends ModelBase
{
  //fields
    ModelRenderer body;
    ModelRenderer leg1;
    ModelRenderer leg2;
    ModelRenderer leg3;
    ModelRenderer leg4;
    ModelRenderer Tail;
    ModelRenderer Neck;
    ModelRenderer Head;
    ModelRenderer Snout;
    ModelRenderer Ear1;
    ModelRenderer Ear2;
    ModelRenderer Piece1;
    ModelRenderer Piece2;
  
  public ModelDoe()
  {
    textureWidth = 64;
    textureHeight = 32;
    
      body = new ModelRenderer(this, 28, 9);
      body.addBox(-5F, -10F, -7F, 8, 16, 7);
      body.setRotationPoint(1F, 6F, 3F);
      body.setTextureSize(64, 32);
      body.mirror = true;
      setRotation(body, 1.570796F, 0F, 0F);
      leg1 = new ModelRenderer(this, 0, 18);
      leg1.addBox(-2F, 0F, -2F, 3, 11, 3);
      leg1.setRotationPoint(-2F, 13F, 7F);
      leg1.setTextureSize(64, 32);
      leg1.mirror = true;
      setRotation(leg1, 0F, 0F, 0F);
      leg2 = new ModelRenderer(this, 0, 18);
      leg2.addBox(-2F, 0F, -2F, 3, 11, 3);
      leg2.setRotationPoint(3F, 13F, 7F);
      leg2.setTextureSize(64, 32);
      leg2.mirror = true;
      setRotation(leg2, 0F, 0F, 0F);
      leg3 = new ModelRenderer(this, 0, 18);
      leg3.addBox(-2F, 0F, -2F, 3, 11, 3);
      leg3.setRotationPoint(-2F, 13F, -5F);
      leg3.setTextureSize(64, 32);
      leg3.mirror = true;
      setRotation(leg3, 0F, 0F, 0F);
      leg4 = new ModelRenderer(this, 0, 18);
      leg4.addBox(-2F, 0F, -2F, 3, 11, 3);
      leg4.setRotationPoint(3F, 13F, -5F);
      leg4.setTextureSize(64, 32);
      leg4.mirror = true;
      setRotation(leg4, 0F, 0F, 0F);
      Tail = new ModelRenderer(this, 0, 11);
      Tail.addBox(-1F, -2F, 0F, 2, 2, 5);
      Tail.setRotationPoint(0F, 6F, 8.5F);
      Tail.setTextureSize(64, 32);
      Tail.mirror = true;
      setRotation(Tail, -1.291544F, 0F, 0F);
      Neck = new ModelRenderer(this, 12, 18);
      Neck.addBox(-2F, -6F, -2F, 4, 10, 4);
      Neck.setRotationPoint(0F, 7F, -6.533333F);
      Neck.setTextureSize(64, 32);
      Neck.mirror = true;
      setRotation(Neck, 0.2792527F, 0F, 0F);
      Head = new ModelRenderer(this, 0, 0);
      Head.addBox(-3F, -6F, -3F, 6, 6, 6);
      Head.setRotationPoint(0F, 4F, -9F);
      Head.setTextureSize(64, 32);
      Head.mirror = true;
      setRotation(Head, 1.570796F, 0F, 0F);
      Snout = new ModelRenderer(this, 14, 12);
      //Snout.addBox(-2F, -4F, -3F, 4, 3, 3);
      Snout.addBox(-2F, 6F, -1F, 4, 3, 3);
      Snout.setRotationPoint(0F, 1F, -11F);
      Snout.setTextureSize(64, 32);
      Snout.mirror = true;
      setRotation(Snout, 1.762782F, 0F, 0F);
      Ear1 = new ModelRenderer(this, 50, 0);
      //Ear1.addBox(0F, 0F, 2F, 3, 1, 4);
      Ear1.addBox(-2F, 9F, 5.5F, 3, 1, 4);
      Ear1.setRotationPoint(0F, 0F, -9F);
      Ear1.setTextureSize(64, 32);
      Ear1.mirror = true;
      setRotation(Ear1, 1.570796F, 0F, 0.4014257F);
      Ear2 = new ModelRenderer(this, 50, 0);
      //Ear2.addBox(-3F, 0F, 2F, 3, 1, 4);
      Ear2.addBox(-1F, 9F, 5.5F, 3, 1, 4);
      Ear2.setRotationPoint(0F, 0F, -9F);
      Ear2.setTextureSize(64, 32);
      Ear2.mirror = true;
      setRotation(Ear2, 1.570796F, 0F, -0.4014257F);
      Piece1 = new ModelRenderer(this, "Piece1");
      Piece1.setRotationPoint(0F, -2F, -9F);
      setRotation(Piece1, 0F, 0F, 0F);
      Piece1.mirror = true;
      //ModelPig.addChildModelRenderer(Piece1);
      Piece2 = new ModelRenderer(this, "Piece2");
      Piece2.setRotationPoint(0F, 2F, -12F);
      setRotation(Piece2, 0F, 0F, 0F);
      Piece2.mirror = true;
      Head.addChild(Snout);
      Head.addChild(Ear1);
      Head.addChild(Ear2);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    body.render(f5);
    leg1.render(f5);
    leg2.render(f5);
    leg3.render(f5);
    leg4.render(f5);
    Tail.render(f5);
    Neck.render(f5);
    Head.render(f5);
    //Snout.render(f5);
    //Ear1.render(f5);
    //Ear2.render(f5);
    Piece1.render(f5);
    Piece2.render(f5);
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
	  
      float f6 = (180F / (float)Math.PI);
      this.Head.rotateAngleX = f4 / (180F / (float)Math.PI);
      this.Head.rotateAngleY = f3 / (180F / (float)Math.PI);
      this.body.rotateAngleX = ((float)Math.PI / 2F);
      this.leg1.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
      this.leg2.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
      this.leg3.rotateAngleX = MathHelper.cos(f * 0.6662F + (float)Math.PI) * 1.4F * f1;
      this.leg4.rotateAngleX = MathHelper.cos(f * 0.6662F) * 1.4F * f1;
  }

}
