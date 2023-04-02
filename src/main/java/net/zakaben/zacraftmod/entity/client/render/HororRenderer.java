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
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.geo.render.built.GeoCube;
import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.util.RenderUtils;

public class HororRenderer extends GeoEntityRenderer<HororEntity> {
    public HororRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new HororModel());
//EMISSIVE LAYER
        this.addLayer(new HororLayer<>(this));
//ENTITY SHADOW
        this.shadowRadius = 1.5f;
    }

    @Override
    public ResourceLocation getTextureLocation(HororEntity animatable) {
        return new ResourceLocation(ZacraftMod.MOD_ID, "textures/entity/horor/horor.png");
    }

    @Override
    public void render(GeoModel model, HororEntity animatable, float partialTicks, RenderType type, PoseStack stack,
                       @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn,
                       int packedOverlayIn, float red, float green, float blue, float alpha) {
        renderEarly(animatable, stack, partialTicks, renderTypeBuffer, vertexBuilder, packedLightIn,
                packedOverlayIn, red, green, blue, alpha);

        if (renderTypeBuffer != null) {
            vertexBuilder = renderTypeBuffer.getBuffer(type);
        }
        if(animatable.isDeadOrDying()) {
            stack.pushPose();
            stack.translate(0, animatable.deathTime/80f, 0);
        }
        //Red overlay when hurt but not on death.
        for (GeoBone group : model.topLevelBones) {
            renderRecursively(animatable, group, stack, vertexBuilder, packedLightIn, OverlayTexture.pack(0,
                    OverlayTexture.v(animatable.hurtTime > 0)), red, green, blue, alpha);
        }
        if(animatable.isDeadOrDying()) stack.popPose();
    }

    public void renderRecursively(HororEntity animateble, GeoBone bone, PoseStack stack, VertexConsumer bufferIn,
                                  int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        stack.pushPose();
        RenderUtils.translate(bone, stack);
        RenderUtils.moveToPivot(bone, stack);
        RenderUtils.rotate(bone, stack);
        RenderUtils.scale(bone, stack);
        RenderUtils.moveBackFromPivot(bone, stack);

        if (!bone.isHidden) {
            for (GeoCube cube : bone.childCubes) {
                stack.pushPose();
                //Render a transparent model once dead.
//IT LOOKS LIKE YOUR GEO MODEL NAME IN BLOCKBENCH IS all - CHANGE IF NEEDED TO REAL ONE
                if(bone.getName().equals("all") && animateble.isDeadOrDying()){
                    renderCube(cube, stack, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, 1f - animateble.deathTime/35f);
                }else{
                    renderCube(cube, stack, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                }
                stack.popPose();
            }
            for (GeoBone childBone : bone.childBones) {
                //Render a transparent model once dead but exclude the head.
//MAKES NO DIFFERENCE IS SIMPLE MODELS, BUT REQUIRED
                if(!childBone.getName().equals("head") && animateble.isDeadOrDying()){
                    renderRecursively(animateble, childBone, stack, bufferIn, packedLightIn, packedOverlayIn,
                            red, green, blue, 1f - animateble.deathTime/80f);
                }else{
                    renderRecursively(animateble, childBone, stack, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
                }

            }
        }

        stack.popPose();
    }

    @Override
    public RenderType getRenderType(HororEntity animatable, float partialTick, PoseStack stack,
                                    @Nullable MultiBufferSource bufferSource,
                                    @Nullable VertexConsumer buffer, int packedLight,
                                    ResourceLocation texture) {

        stack.scale(1.5f, 1.5f, 1.5f);

        return super.getRenderType(animatable, partialTick, stack, bufferSource, buffer, packedLight, texture);
    }
    //ROTATION WHEN THE ENTITY IS KILLED/DIES - SO IT CAN HAVE A DEATH ANIMATION
    @Override
    protected float getDeathMaxRotation(HororEntity entityLivingBaseIn) {
        return 1.0F;
    }
}
