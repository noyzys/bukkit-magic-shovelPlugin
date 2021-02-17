package io.github.noyzys.magicshovel.v2.util.builder;

import io.github.noyzys.magicshovel.v2.util.ChatColorUtil;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public final class ItemStackBuilder
{
    private final ItemStack itemStack;
    private final ItemMeta itemMeta;

    public ItemStackBuilder(final ItemStack itemStack)
    {
        this.itemStack = itemStack;
        itemMeta = itemStack.getItemMeta();
    }

    public ItemStackBuilder(final Material material, final int amount) {
        this.itemStack = new ItemStack(material, amount);
        this.itemMeta = itemStack.getItemMeta();
    }

    public ItemStackBuilder setName(final String name)
    {
        itemMeta.setDisplayName(ChatColorUtil.colored(name));
        return this;
    }

    public ItemStackBuilder addLore(final List<String> lore)
    {
        itemMeta.setLore(ChatColorUtil.colored(lore));
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemStack build()
    {
        return itemStack;
    }
}

