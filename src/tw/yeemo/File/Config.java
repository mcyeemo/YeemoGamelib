package tw.yeemo.File;

import org.bukkit.configuration.file.YamlConfiguration;
import tw.yeemo.YeemoGameAPI;
import tw.yeemo.utils.var;

import java.io.File;
import java.util.Set;

public class Config {

    public enum BasicFile {
        CONFIG("config.yml"),
        LANGUAGE("language.yml"),
        ARENA("arena.yml"),
        STATS("stats.yml");

        private String file;

        BasicFile(final String file) {
            this.file = file;
        }

        public void save() {
            var.yaml.get(file).save();
        }

        public void reload() {
            var.yaml.get(file).reload();
        }

        public <T> T get(String path) {
            return (T) var.yaml.get(file).get(path);
        }

        public void set(String path, Object obj) {
            var.yaml.get(file).set(path, obj);
        }

        public Set<String> getConfigurationSection(String path, Boolean key) {
            return var.yaml.get(file).getConfigurationSection(path, key);
        }
    }

    private YeemoGameAPI instance = null;
    private String fileName = null;
    private YamlConfiguration yaml = null;
    private File file = null;
    private Boolean replace = null;

    public Config(final String fileName, final boolean replace) {
        instance = YeemoGameAPI.getInstance();
        this.fileName = fileName;
        this.replace = replace;
        this.file = null;
        this.yaml = null;
        load();
    }

    public void load() {
        file = new File(instance.getDataFolder(), fileName);
        if (!file.exists()) {
            file.getParentFile().mkdir();
            instance.saveResource(fileName, replace);
        }
        yaml = new YamlConfiguration();
        try {
            yaml.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        var.yaml.put(fileName, this);
    }

    public void save() {
        try {
            yaml.save(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void reload() {
        try {
            yaml.load(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private <T> T get(String path) {
        return (T) yaml.get(path);
    }

    private void set(String path, Object obj) {
        set(path, obj);
    }

    private Set<String> getConfigurationSection(String path, Boolean key) {
        return yaml.getConfigurationSection(path).getKeys(key);
    }
}
