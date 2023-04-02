package net.zakaben.zacraftmod.entity.client.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.zakaben.zacraftmod.ZacraftMod;
import net.zakaben.zacraftmod.entity.client.model.HororModel;
import net.zakaben.zacraftmod.entity.custom.HororEntity;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;
import software.bernie.geckolib3.renderers.geo.IGeoRenderer;

public class HororLayer<T extends HororEntity> extends GeoLayerRenderer<T> {
    //EMISSIVE TEXTURE - GOOD
    protected static final ResourceLocation HOROR_GLOW = new ResourceLocation(ZacraftMod.MOD_ID,"textures/entity/horor/horor_glow.png");
    //POINTING TO THE PROPER GEO MODEL - GOOD
    protected static final ResourceLocation HOROR = new ResourceLocation(ZacraftMod.MOD_ID,"geo/horor.geo.json");

    public HororLayer(IGeoRenderer<T> entityRendererIn){
        super(entityRendererIn);
    }
    //THIS OVERRIDE IS CORRECT - GOOD
    @Override
    public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, T entityLivingBaseIn,
                       float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch){
        RenderType glow = RenderType.entityTranslucentEmissive(HOROR_GLOW);
        this.getRenderer().render(this.getEntityModel().getModel(HOROR),entityLivingBaseIn,partialTicks,glow,
                matrixStackIn,bufferIn,bufferIn.getBuffer(glow),packedLightIn, OverlayTexture.NO_OVERLAY,1f,1f,1f,1f
        );
    }
}
