package tw.yeemo.game;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import tw.yeemo.File.Config;
import tw.yeemo.Manager.ArenaManager;

public class Arena {

    private final String arenaName;

    public Arena(final String name){
        arenaName = name;
    }

    public String getArenaName() {
        return arenaName;
    }

    public void copyBasic() {
        YamlConfiguration arena = Config.BasicFile.ARENA.getYamlFile();
        ConfigurationSection cs = arena.getConfigurationSection(arenaName);
        cs.set("enable", false);
        cs.set("waitingRoom", "#<world>;<x>;<y>;<z>;<yaw>;<pitch>");
        cs.set("spawns", "#<world>;<x>;<y>;<z>;<yaw>;<pitch>");
        cs.set("bounds.bound.high", "#<world>;<x>;<y>;<z>;<yaw>;<pitch>");
        cs.set("bounds.bound.low", "#<world>;<x>;<y>;<z>;<yaw>;<pitch>");
        cs.set("bounds.spec.high", "#<world>;<x>;<y>;<z>;<yaw>;<pitch>");
        cs.set("bounds.spec.low", "#<world>;<x>;<y>;<z>;<yaw>;<pitch>");
        cs.set("min_player", 4);
        cs.set("max_player", 8);
        cs.set("displayName", arenaName);
        registeredME();
    }

    public void init() {
        registeredME();
    }

    private void registeredME(){
        ArenaManager am = new ArenaManager();
        am.registered(arenaName, this);
    }
}
