package net.zakaben.zacraftmod.entity.client;

import net.minecraft.resources.ResourceLocation;
import net.zakaben.zacraftmod.ZacraftMod;
import net.zakaben.zacraftmod.entity.custom.CactusEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class CactusModel extends AnimatedGeoModel<CactusEntity>{
    @Override
    public ResourceLocation getModelResource(CactusEntity object) {
        return new ResourceLocation(ZacraftMod.MOD_ID, "geo/cactus.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CactusEntity object) {
        return new ResourceLocation(ZacraftMod.MOD_ID, "textures/entity/cactus.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CactusEntity animatable) {
        return new ResourceLocation(ZacraftMod.MOD_ID, "animations/cactus.animation.json");
    }
}
