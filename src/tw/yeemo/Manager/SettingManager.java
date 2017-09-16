package tw.yeemo.Manager;

import tw.yeemo.File.Config;
import tw.yeemo.YeemoGameAPI;
import tw.yeemo.utils.var;

import java.util.Set;

public class SettingManager {

    private YeemoGameAPI instance = null;

    public SettingManager(YeemoGameAPI instance) {
        this.instance = instance;
    }

    public void setupArena() {
        Set<String> cs = Config.BasicFile.ARENA.getConfigurationSection("", false);
        ArenaManager am = new ArenaManager();
        cs.forEach(arena -> am.addArena(arena));
    }

    public void setupConfig() {
        new Config("arena.yml", true);
        new Config("config.yml", true);
        new Config("language.yml", true);
        new Config("stats.yml", true);
        var.yaml.keySet().forEach(key -> var.yaml.get(key).save());
    }
}
