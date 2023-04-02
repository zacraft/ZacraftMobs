package net.zakaben.zacraftmod.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.zakaben.zacraftmod.ZacraftMod;
import net.zakaben.zacraftmod.entity.custom.HororEntity;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;

public class HororModel extends AnimatedGeoModel<HororEntity>{
    @Override
    public ResourceLocation getModelResource(HororEntity object) {
        return new ResourceLocation(ZacraftMod.MOD_ID, "geo/horor.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HororEntity object) {
        return new ResourceLocation(ZacraftMod.MOD_ID, "textures/entity/horor/horor.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HororEntity animatable) {
        return new ResourceLocation(ZacraftMod.MOD_ID, "animations/horor.animation.json");
    }
//ADD THIS FOR HEAD RIGHT/LEFT ROTATION

    @Override
    public void setLivingAnimations(HororEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
//THIS IS THE NAME OF THE HEAD BONE
        IBone head = this.getAnimationProcessor().getBone("head");
        LivingEntity entityIn = (LivingEntity) entity;
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
//ROTATION EQUATION
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }
}
