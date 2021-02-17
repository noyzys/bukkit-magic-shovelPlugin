package io.github.noyzys.magicshovel.v2.impl;

import io.github.noyzys.magicshovel.v2.util.builder.ItemStackBuilder;
import org.bukkit.inventory.ItemStack;

public interface MagicShovelManager
{
    void createRecipe();

    ItemStackBuilder getGoldSpadeItem();
}
