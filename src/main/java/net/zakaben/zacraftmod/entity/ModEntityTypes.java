package net.zakaben.zacraftmod.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zakaben.zacraftmod.ZacraftMod;
import net.zakaben.zacraftmod.entity.custom.CactusEntity;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ZacraftMod.MOD_ID);

    public static final RegistryObject<EntityType<CactusEntity>> CACTUS =
            ENTITY_TYPES.register("cactus",
                    ()-> EntityType.Builder.of(CactusEntity::new, MobCategory.MONSTER)
                            .sized(0.4f, 1.5f) //hitbox
                            .build(new ResourceLocation(ZacraftMod.MOD_ID, "cactus").toString()));
    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
