package de.magicbrothers.lottery.main;

import org.bukkit.plugin.java.JavaPlugin;

public class MagicLottery extends JavaPlugin {

    private static MagicLottery plugin;

    public static final String PREFIX = "§8|§b Lottery§8 |§7 ",
                                NO_PERMISSION = PREFIX + "§cDazu hast du keine Rechte.";

    public void onEnable() {

        plugin = this;

    }

    public static MagicLottery getPlugin() {
        return plugin;
    }
}
