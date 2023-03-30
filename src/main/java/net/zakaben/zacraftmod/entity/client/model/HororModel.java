package net.zakaben.zacraftmod.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.zakaben.zacraftmod.ZacraftMod;
import net.zakaben.zacraftmod.entity.custom.HororEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

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
}
