package net.zakaben.zacraftmod;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.zakaben.zacraftmod.entity.ModEntityTypes;
import net.zakaben.zacraftmod.entity.custom.CactusEntity;
import net.zakaben.zacraftmod.entity.custom.HororEntity;
import net.zakaben.zacraftmod.entity.custom.MuchactusEntity;


public class ModEvents {
    @Mod.EventBusSubscriber(modid = ZacraftMod.MOD_ID)
    public static class ForgeEvents { }


    @Mod.EventBusSubscriber(modid = ZacraftMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents {
        @SubscribeEvent
        public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
            event.put(ModEntityTypes.CACTUS.get(), CactusEntity.setAttributes());
            event.put(ModEntityTypes.HOROR.get(), HororEntity.setAttributes());
            event.put(ModEntityTypes.MUCHACTUS.get(), MuchactusEntity.setAttributes());

        }
    }
}
