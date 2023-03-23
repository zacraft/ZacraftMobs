package net.zakaben.zacraftmod.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.zakaben.zacraftmod.ZacraftMod;
import net.zakaben.zacraftmod.entity.custom.CactusEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class CactusRenderer extends GeoEntityRenderer<CactusEntity> {
    public CactusRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CactusModel());
        this.shadowRadius = 0.4f;

    }

    @Override
    public ResourceLocation getTextureLocation(CactusEntity animatable) {
        return new ResourceLocation(ZacraftMod.MOD_ID, "textures/entity/cactus.png");
    }

    @Override
    public RenderType getRenderType(CactusEntity animatable, float partialTick, PoseStack stack,
                                    @Nullable MultiBufferSource bufferSource,
                                    @Nullable VertexConsumer buffer, int packedLight,
                                    ResourceLocation texture) {

        stack.scale(1.5f, 1.5f, 1.5f);

        return super.getRenderType(animatable, partialTick, stack, bufferSource, buffer, packedLight, texture);
    }
}
