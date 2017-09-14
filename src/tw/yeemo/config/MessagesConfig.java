package tw.yeemo.config;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MessagesConfig {

    private FileConfiguration messagesConfig = null;
    private File messagesFile = null;
    private JavaPlugin plugin = null;

    public MessagesConfig(final JavaPlugin plugin) {
        this.plugin = plugin;
        this.init();
    }

    private void init() {
        this.getConfig().options().header("All Messages");
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
    }

    public FileConfiguration getConfig() {
        if (this.messagesConfig == null) {
            this.reloadConfig();
        }
        return this.messagesConfig;
    }

    public void saveConfig() {
        if (this.messagesConfig == null || this.messagesFile == null) {
            return;
        }
        try {
            this.getConfig().save(this.messagesFile);
        } catch (final IOException ex) {
            // silently ignore
        }
    }

    public void reloadConfig() {
        if (this.messagesFile == null) {
            this.messagesFile = new File(this.plugin.getDataFolder(), "messages.yml");
        }
        this.messagesConfig = YamlConfiguration.loadConfiguration(this.messagesFile);

        final InputStream defConfigStream = this.plugin.getResource("messages.yml");
        if (defConfigStream != null) {
            final YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(new InputStreamReader(defConfigStream));
            this.messagesConfig.setDefaults(defConfig);
        }
    }
}
