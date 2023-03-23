package net.zakaben.zacraftmod.item.custom;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zakaben.zacraftmod.ZacraftMod;
import net.zakaben.zacraftmod.entity.ModEntityTypes;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ZacraftMod.MOD_ID);

    public static final RegistryObject<Item> CACTUS_SPAWN_EGG = ITEMS.register("cactus_spawn_egg",
            ()-> new ForgeSpawnEggItem(ModEntityTypes.CACTUS, 0x22b341, 0x19732e,
                    new Item.Properties().tab(ModCreativeModTab.ZACRAFT_TAB)));

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus); }
}
