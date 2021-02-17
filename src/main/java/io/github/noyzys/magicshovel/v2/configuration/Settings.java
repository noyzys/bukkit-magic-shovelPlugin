package io.github.noyzys.magicshovel.v2.configuration;

import java.util.Arrays;
import java.util.List;

public final class Settings
{

    private Settings() {
    }

    public static final String CONFIGURATION$PLUGIN_LOAD = "ladowanie";
    public static final String CONFIGURATION$PLUGIN_ENABLE = "wlaczono";
    public static final String CONFIGURATION$PLUGIN_DISABLE = "wylaczono";

    public static final String CONFIGURATION$MAGIC_SHOVEL_OPTIONS$TITLES = "";
    public static final String CONFIGURATION$MAGIC_SHOVEL_OPTIONS$SUBTITLES = "&8>> &cUZYLES MAGICZNEJ LOPATY &8<<";
    public static final String CONFIGURATION$MAGIC_SHOVEL_OPTIONS$MESSAGE = "&8>> &aPomyslnie uzyles magicznej lopaty";
    public static final String CONFIGURATION$MAGIC_SHOVEL_OPTIONS$IS_NOTBLOCK = "&cBlad: Podany block, to nie jest BEDROCK";
    public static final String CONFIGURATION$MAGIC_SHOVEL_OPTIONS$NOT_BREAK = "&cBlad: Jestes na samym dole nie mozesz juz tam niszczyc bedrocka";

    public static final String CONFIGURATION$MAGIC_SHOVEL_OPTIONS$NAME = "lopata";
    public static final String CONFIGURATION$MAGIC_SHOVEL_OPTIONS$MATERIAL_TYPE = "GOLD_SPADE";
    public static final List<String> CONFIGURATION$MAGIC_SHOVEL_OPTIONS$LORE = Arrays.asList(
            "",
            "&8>> &7Uzyj: &6PPM na block bedrock",
            "&8>> &cPAMIETAJ NIE MOZNA UZYWAC NA SAMYM DOLE!",
            ""
    );

    public static final String CONFIGURATION$CRAFTING_OPTIONS$SLOT_1 = "DIAMOND";
    public static final String CONFIGURATION$CRAFTING_OPTIONS$SLOT_2 = "DIAMOND";
    public static final String CONFIGURATION$CRAFTING_OPTIONS$SLOT_3 = "DIAMOND";
    public static final String CONFIGURATION$CRAFTING_OPTIONS$SLOT_4 = "DIAMOND";
    public static final String CONFIGURATION$CRAFTING_OPTIONS$SLOT_5 = "STONE";
    public static final String CONFIGURATION$CRAFTING_OPTIONS$SLOT_6 = "DIAMOND";
    public static final String CONFIGURATION$CRAFTING_OPTIONS$SLOT_7 = "DIAMOND";
    public static final String CONFIGURATION$CRAFTING_OPTIONS$SLOT_8 = "DIAMOND";
    public static final String CONFIGURATION$CRAFTING_OPTIONS$SLOT_9 = "DIAMOND";
}
