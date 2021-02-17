package io.github.noyzys.magicshovel.v2;

import io.github.noyzys.magicshovel.v2.configuration.Settings;
import io.github.noyzys.magicshovel.v2.configuration.manager.IConfiguration;
import io.github.noyzys.magicshovel.v2.configuration.manager.ConfigurationFactory;
import io.github.noyzys.magicshovel.v2.impl.MagicShovelRecipeManagerImpl;
import io.github.noyzys.magicshovel.v2.impl.MagicShovelManager;
import io.github.noyzys.magicshovel.v2.listener.MagicShovelListener;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class MagicShovelPlugin extends JavaPlugin
{

    private final IConfiguration configuration = ConfigurationFactory.create(new File(getDataFolder(), "config.yml"), Settings.class);
    private MagicShovelManager magicShovelRecipeManager;


    @Override
    public void onLoad()
    {
        getLogger().info(Settings.CONFIGURATION$PLUGIN_LOAD);
    }

    @Override
    public void onEnable()
    {
        magicShovelRecipeManager = new MagicShovelRecipeManagerImpl();
        magicShovelRecipeManager.createRecipe();

        new MagicShovelListener(this);
        getLogger().info(Settings.CONFIGURATION$PLUGIN_ENABLE);
    }
    @Override
    public void onDisable()
    {
        getLogger().info(Settings.CONFIGURATION$PLUGIN_DISABLE);
    }

    public MagicShovelManager getMagicShovelRecipeManager()
    {
        return magicShovelRecipeManager;
    }
}
