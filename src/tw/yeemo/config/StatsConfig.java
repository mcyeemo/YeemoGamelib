package tw.yeemo.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class StatsConfig {

    private FileConfiguration statsConfig = null;
    private File statsFile = null;
    private JavaPlugin plugin = null;

    public StatsConfig(final JavaPlugin plugin, final boolean custom) {
        this.plugin = plugin;
        if (!custom) {
            this.getConfig().options().header("Used for saving user statistics");
        }
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }

    public FileConfiguration getConfig() {
        if (this.statsConfig == null) {
            this.reloadConfig();
        }
        return this.statsConfig;
    }

    public void saveConfig() {
        if (this.statsConfig == null || this.statsFile == null) {
            return;
        }
        try {
            this.getConfig().save(this.statsFile);
        } catch (final IOException ex) {
            // silently ignore
        }
    }

    public void reloadConfig() {
        if (this.statsFile == null) {
            this.statsFile = new File(this.plugin.getDataFolder(), "stats.yml");
        }
        this.statsConfig = YamlConfiguration.loadConfiguration(this.statsFile);

        final InputStream defConfigStream = this.plugin.getResource("stats.yml");
        if (defConfigStream != null) {
            final YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream));
            this.statsConfig.setDefaults(defConfig);
        }
    }
}
