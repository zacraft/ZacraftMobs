package net.zakaben.zacraftmod.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.zakaben.zacraftmod.ZacraftMod;
import net.zakaben.zacraftmod.entity.custom.MuchactusEntity;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class MuchactusModel extends AnimatedGeoModel<MuchactusEntity>{

    @Override
    public ResourceLocation getModelResource(MuchactusEntity object) {
        return new ResourceLocation(ZacraftMod.MOD_ID, "geo/muchactus.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MuchactusEntity object) {
        return new ResourceLocation(ZacraftMod.MOD_ID, "textures/entity/muchactus/muchactus.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MuchactusEntity animatable) {
        return new ResourceLocation(ZacraftMod.MOD_ID, "animations/muchactus.animation.json");
    }
}
