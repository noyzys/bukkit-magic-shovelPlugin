package pl.kodicrew.developers.magicshovel;

import org.bukkit.plugin.java.JavaPlugin;
import pl.kodicrew.developers.magicshovel.configuration.Settings;
import pl.kodicrew.developers.magicshovel.configuration.managers.Configuration;
import pl.kodicrew.developers.magicshovel.configuration.managers.ConfigurationManager;
import pl.kodicrew.developers.magicshovel.impl.MagicShovelRecipeManagerImpl;
import pl.kodicrew.developers.magicshovel.impl.interfaces.MagicShovelManager;

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
