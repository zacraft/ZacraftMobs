package net.zakaben.zacraftmod.entity.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.zakaben.zacraftmod.ZacraftMod;
import net.zakaben.zacraftmod.entity.client.model.HororModel;
import net.zakaben.zacraftmod.entity.custom.HororEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class HororRenderer extends GeoEntityRenderer<HororEntity> {
    public HororRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HororModel());
        this.addLayer(new HororLayer<>(this));
        this.shadowRadius = 1.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(HororEntity animatable) {
        return new ResourceLocation(ZacraftMod.MOD_ID, "textures/entity/horor/horor.png");
    }

    @Override
    public RenderType getRenderType(HororEntity animatable, float partialTick, PoseStack stack,
                                    @Nullable MultiBufferSource bufferSource,
                                    @Nullable VertexConsumer buffer, int packedLight,
                                    ResourceLocation texture) {

        stack.scale(1.5f, 1.5f, 1.5f);

        return super.getRenderType(animatable, partialTick, stack, bufferSource, buffer, packedLight, texture);
    }
}
