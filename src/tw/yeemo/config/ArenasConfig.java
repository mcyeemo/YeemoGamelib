package tw.yeemo.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ArenasConfig {
    private FileConfiguration arenaConfig = null;
    private File arenaFile = null;
    private JavaPlugin plugin = null;

    public ArenasConfig(final JavaPlugin plugin) {
        this.plugin = plugin;
        this.getConfig().options().header("Used for saving arena details.");
        // this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }

    public FileConfiguration getConfig() {
        if (this.arenaConfig == null) {
            this.reloadConfig();
        }
        return this.arenaConfig;
    }

    public void saveConfig() {
        if (this.arenaConfig == null || this.arenaFile == null) {
            return;
        }
        try {
            this.getConfig().save(this.arenaFile);
        } catch (final IOException ex) {

        }
    }

    public void reloadConfig() {
        if (this.arenaFile == null) {
            this.arenaFile = new File(this.plugin.getDataFolder(), "arenas.yml");
        }
        this.arenaConfig = YamlConfiguration.loadConfiguration(this.arenaFile);

        final InputStream defConfigStream = this.plugin.getResource("arenas.yml");
        if (defConfigStream != null) {
            final YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream));
            this.arenaConfig.setDefaults(defConfig);
        }
    }
}
