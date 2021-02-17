package io.github.noyzys.magicshovel.v2.configuration.impl;

import org.bukkit.configuration.file.YamlConfiguration;
import io.github.noyzys.magicshovel.v2.configuration.manager.IConfiguration;

import java.io.File;

public final class ConfigurationImpl implements IConfiguration
{
    private final File file;
    private final Class<?> clazz;

    public ConfigurationImpl(File file, Class<?> clazz)
    {
        this.clazz = clazz;
        this.file = file;
        this.reload();
    }

    @Override
    public void reload()
    {
        File config = check(this.file);

        try
        {
            final YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);
            parse(this.clazz, yamlConfiguration);
            yamlConfiguration.save(config);

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    @Override
    public void save()
    {
        File config = check(this.file);
        try
        {
            final YamlConfiguration yamlConfiguration = YamlConfiguration.loadConfiguration(config);
            parseSave(this.clazz, yamlConfiguration);
            yamlConfiguration.save(config);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
