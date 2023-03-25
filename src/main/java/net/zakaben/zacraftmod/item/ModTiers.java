package net.zakaben.zacraftmod.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier CACTUS = new ForgeTier(2, 150, 4f,
            2f, 14, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.CACTUS_BRANCH.get()));
}
