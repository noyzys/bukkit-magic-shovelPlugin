package io.github.noyzys.magicshovel.v2.configuration.manager;

import io.github.noyzys.magicshovel.v2.configuration.impl.ConfigurationImpl;

import java.io.File;

public final class ConfigurationFactory
{

    public static ConfigurationImpl create(File file, Class<?> clazz)
    {
        return new ConfigurationImpl(file, clazz);
    }
}
