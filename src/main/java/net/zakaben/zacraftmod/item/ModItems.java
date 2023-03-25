package net.zakaben.zacraftmod.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.zakaben.zacraftmod.ZacraftMod;
import net.zakaben.zacraftmod.entity.ModEntityTypes;
import net.zakaben.zacraftmod.entity.custom.CactusSwordItem;


public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ZacraftMod.MOD_ID);

    public static final RegistryObject<Item> CACTUS_BRANCH = ITEMS.register("cactus_branch",
            () -> new Item(new Item.Properties().tab(ModCreativeModTab.ZACRAFT_TAB)));

    public static final RegistryObject<Item> CACTUS_SWORD = ITEMS.register("cactus_sword",
            () -> new CactusSwordItem(ModTiers.CACTUS, 2, 3f,
                    new Item.Properties().tab(ModCreativeModTab.ZACRAFT_TAB)));


    public static final RegistryObject<Item> CACTUS_SPAWN_EGG = ITEMS.register("cactus_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntityTypes.CACTUS, 0x49711d, 0xbcc294,
                    new Item.Properties().tab(ModCreativeModTab.ZACRAFT_TAB)));

    public static void register(IEventBus eventBus) {ITEMS.register(eventBus); }
}
