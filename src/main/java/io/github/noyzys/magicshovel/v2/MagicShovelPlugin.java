package io.github.noyzys.magicshovel.v2;

import io.github.noyzys.magicshovel.v2.configuration.Settings;
import io.github.noyzys.magicshovel.v2.configuration.managers.Configuration;
import io.github.noyzys.magicshovel.v2.configuration.managers.ConfigurationManager;
import org.bukkit.plugin.java.JavaPlugin;
import io.github.noyzys.magicshovel.v2.impl.MagicShovelRecipeManagerImpl;
import io.github.noyzys.magicshovel.v2.impl.interfaces.MagicShovelManager;

import java.io.File;

public class MagicShovelPlugin extends JavaPlugin {

    private MagicShovelManager magicShovelRecipeManager = new MagicShovelRecipeManagerImpl();

    private Configuration settings = ConfigurationManager.create(new File(this.getDataFolder(), "config.yml"), Settings.class);


    @Override
    public void onLoad() {
        this.getLogger().info(Settings.CONFIGURATION$PLUGIN_LOAD);
    }

    @Override
    public void onEnable() {
        this.registerInits();

        if (!this.getDataFolder().exists()) this.getDataFolder().mkdir();
        this.getLogger().info(Settings.CONFIGURATION$PLUGIN_ENABLE);
    }

    private void registerInits(){
        this.getServer().getPluginManager().registerEvents(new MagicShovelRecipeManagerImpl(), this);
        this.magicShovelRecipeManager.createRecipe();

    }

    @Override
    public void onDisable() {
        this.getLogger().info(Settings.CONFIGURATION$PLUGIN_DISABLE);
    }
}
