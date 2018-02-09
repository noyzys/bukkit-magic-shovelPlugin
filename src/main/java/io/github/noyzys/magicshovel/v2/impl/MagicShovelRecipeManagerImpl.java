package io.github.noyzys.magicshovel.v2.impl;

import io.github.noyzys.magicshovel.v2.builders.ItemStackBuilder;
import io.github.noyzys.magicshovel.v2.configuration.Settings;
import io.github.noyzys.magicshovel.v2.utils.ChatColorUtil;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ShapedRecipe;
import io.github.noyzys.magicshovel.v2.impl.interfaces.MagicShovelManager;
import io.github.noyzys.magicshovel.v2.utils.ItemUtil;

public class MagicShovelRecipeManagerImpl implements MagicShovelManager, Listener {

    private ItemStackBuilder gold_spade = new ItemStackBuilder(Material.matchMaterial(Settings.CONFIGURATION$MAGIC_SHOVEL_OPTIONS$MATERIAL_TYPE), 1)

            .withTitle(ChatColorUtil.colored(Settings.CONFIGURATION$MAGIC_SHOVEL_OPTIONS$NAME))
            .withLore(ChatColorUtil.colored(Settings.CONFIGURATION$MAGIC_SHOVEL_OPTIONS$LORE));

    @Override
    public void createRecipe() {
        final ShapedRecipe recipe = new ShapedRecipe(this.gold_spade.build());

        recipe.shape("123", "456", "789");
        recipe.setIngredient('1', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_1))
                .setIngredient('2', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_2))
                .setIngredient('3', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_3))
                .setIngredient('4', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_4))
                .setIngredient('5', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_5))
                .setIngredient('6', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_6))
                .setIngredient('7', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_7))
                .setIngredient('8', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_8))
                .setIngredient('9', Material.matchMaterial(Settings.CONFIGURATION$CRAFTING_OPTIONS$SLOT_9));

        Bukkit.addRecipe(recipe);
    }

    @EventHandler public void onInteractShovel(PlayerInteractEvent event){
        final Player player=event.getPlayer();
        final Block block=event.getClickedBlock();

        if(player.getLocation().getY()==1){
            ChatColorUtil.sendMessage(player, Settings.CONFIGURATION$MAGIC_SHOVEL_OPTIONS$NOT_BREAK);

            return;
        }

        if(player.getItemInHand().getType()==Material.matchMaterial(Settings.CONFIGURATION$MAGIC_SHOVEL_OPTIONS$MATERIAL_TYPE) && player.getItemInHand().getItemMeta().getDisplayName().equals(Settings.CONFIGURATION$MAGIC_SHOVEL_OPTIONS$NAME))

            if (block.getType() == Material.BEDROCK) {
                block.setType(Material.AIR);

                ItemUtil.removeItems(player, this.gold_spade.build(), block);

                player.sendTitle(ChatColorUtil.colored(Settings.CONFIGURATION$MAGIC_SHOVEL_OPTIONS$TITLES), ChatColorUtil.colored(Settings.CONFIGURATION$MAGIC_SHOVEL_OPTIONS$SUBTITLES));
                ChatColorUtil.sendMessage(player, Settings.CONFIGURATION$MAGIC_SHOVEL_OPTIONS$MESSAGE);

            } else {
                ChatColorUtil.sendMessage(player, Settings.CONFIGURATION$MAGIC_SHOVEL_OPTIONS$IS_NOTBLOCK);

            }

    }
}