package io.github.noyzys.magicshovel.v2.impl;

import io.github.noyzys.magicshovel.v2.util.builder.ItemStackBuilder;
import io.github.noyzys.magicshovel.v2.configuration.Settings;
import io.github.noyzys.magicshovel.v2.util.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ShapedRecipe;

public final class MagicShovelRecipeManagerImpl implements MagicShovelManager
{

    private final ItemStackBuilder goldSpadeItem = new ItemStackBuilder(Material.matchMaterial(Settings.CONFIGURATION$MAGIC_SHOVEL_OPTIONS$MATERIAL_TYPE), 1)
            .setName(ChatColorUtil.colored(Settings.CONFIGURATION$MAGIC_SHOVEL_OPTIONS$NAME))
            .addLore(ChatColorUtil.colored(Settings.CONFIGURATION$MAGIC_SHOVEL_OPTIONS$LORE));

    @Override
    public void createRecipe()
    {
        final ShapedRecipe magicShovelRecipe = new ShapedRecipe(goldSpadeItem.build());

        magicShovelRecipe.shape("123", "456", "789");
        magicShovelRecipe.setIngredient('1', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_1))
                .setIngredient('2', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_2))
                .setIngredient('3', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_3))
                .setIngredient('4', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_4))
                .setIngredient('5', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_5))
                .setIngredient('6', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_6))
                .setIngredient('7', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_7))
                .setIngredient('8', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_8))
                .setIngredient('9', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_9));

        Bukkit.addRecipe(magicShovelRecipe);
    }

    public ItemStackBuilder getGoldSpadeItem()
    {
        return goldSpadeItem;
    }
}