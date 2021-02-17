package io.github.noyzys.magicshovel.v2.configuration.manager;

import org.apache.commons.lang.StringUtils;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public interface IConfiguration
{

    default void parseSave(Class<?> clazz, YamlConfiguration config)
    {
        try
        {
            for (Field field : clazz.getFields())
            {
                if (Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers()))
                {
                    String path = field.getName().toLowerCase();
                    path = StringUtils.replace(path, "$", ".");
                    path = StringUtils.replace(path, "_", "-");

                    Object value = field.get(null);
                    config.set(path, value);
                }
            }
        } catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    default void parse(Class<?> clazz, YamlConfiguration config)
    {
        try
        {
            for (Field field : clazz.getFields())
            {
                if (Modifier.isStatic(field.getModifiers()) && Modifier.isPublic(field.getModifiers()))
                {
                    String path = field.getName().toLowerCase();
                    path = StringUtils.replace(path, "$", ".");
                    path = StringUtils.replace(path, "_", "-");

                    Object def = field.get(null);
                    Object value = config.get(path, def);

                    config.set(path, value);
                    field.set(null, value);
                }

            }
        } catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }

    default File check(File file)
    {
        if (!file.exists())
        {
            file.getParentFile().mkdirs();

            try
            {
                file.createNewFile();
            } catch (IOException ignored)
            {
                ignored.printStackTrace();
            }
        }

        return file;
    }

    void reload();

    void save();
}
