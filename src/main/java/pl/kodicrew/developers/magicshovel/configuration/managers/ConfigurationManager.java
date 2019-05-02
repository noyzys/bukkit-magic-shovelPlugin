package pl.kodicrew.developers.magicshovel.configuration.managers;

import pl.kodicrew.developers.magicshovel.configuration.impl.ConfigurationImpl;
import java.io.File;

public class ConfigurationManager {

    public static ConfigurationImpl create(File file, Class clazz) {
        return new ConfigurationImpl(file, clazz);
    }
}
