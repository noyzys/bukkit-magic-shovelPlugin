package io.github.noyzys.magicshovel.v2.configuration.managers;

import io.github.noyzys.magicshovel.v2.configuration.impl.ConfigurationImpl;

import java.io.File;

public class ConfigurationManager {

    public static ConfigurationImpl create(File file, Class clazz) {
        return new ConfigurationImpl(file, clazz);
    }
}
