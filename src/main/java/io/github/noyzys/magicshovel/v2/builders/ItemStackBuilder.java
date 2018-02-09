package io.github.noyzys.magicshovel.v2.builders;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStackBuilder {

    private Material mat;
    private int amount;
    private short data;
    private String title;
    private List<String> lore;

    public ItemStackBuilder(Material mat) {
        this(mat, 1);
    }

    public ItemStackBuilder(Material mat, int amount) {
        this(mat, amount, (short) 0);
    }

    public ItemStackBuilder(Material mat, short data) {
        this(mat, 1, data);
    }

    public ItemStackBuilder(Material mat, int amount, short data) {
        this.title = null;
        this.lore = new ArrayList<>();
        this.mat = mat;
        this.amount = amount;
        this.data = data;
    }

    public ItemStackBuilder withTitle(String title) {
        if (title == null) return this;
        this.title = title;
        return this;
    }

    public ItemStackBuilder withLore(String lore) {
        if (lore == null) return this;
        this.lore.add(lore);
        return this;
    }

    public ItemStackBuilder withLore(List<String> lore) {
        if (lore == null) return this;
        this.lore.addAll(lore);
        return this;
    }

    public ItemStack build() {
        ItemStack item = new ItemStack(mat, amount, data);
        ItemMeta meta = item.getItemMeta();
        if (title != null) meta.setDisplayName(title);
        if (!this.lore.isEmpty()) meta.setLore(lore);
        item.setItemMeta(meta);
        return item;
    }
}

