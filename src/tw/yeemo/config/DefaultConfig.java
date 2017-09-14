package tw.yeemo.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class DefaultConfig {
    JavaPlugin plugin;

    public DefaultConfig(final JavaPlugin plugin, final boolean custom) {
        this.plugin = plugin;
        DefaultConfig.init(plugin, custom);
    }

    private static void init(JavaPlugin plugin, boolean custom) {
        final FileConfiguration config = plugin.getConfig();
        if (!custom) {
            config.options().header("default config");
        }
        config.options().copyDefaults(true);
        plugin.saveConfig();
    }
}
