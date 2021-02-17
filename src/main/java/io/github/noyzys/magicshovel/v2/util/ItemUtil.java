package io.github.noyzys.magicshovel.v2.util;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public final class ItemUtil
{

    private ItemUtil() {
    }

    public static void removeItems(Player player, ItemStack itemStack, Block block)
    {

        if (player.getInventory().firstEmpty() == -1)
        {
            block.getWorld().dropItemNaturally(block.getLocation(), itemStack);
        } else
        {
            player.getInventory().removeItem(itemStack);
        }
    }
}

