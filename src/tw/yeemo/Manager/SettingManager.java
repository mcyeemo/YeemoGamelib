package tw.yeemo.Manager;

import tw.yeemo.Command.SubCommand.Help;
import tw.yeemo.Command.SubCommand.addGame;
import tw.yeemo.File.Config;
import tw.yeemo.YeemoGameAPI;
import tw.yeemo.utils.var;

import java.util.Set;

public class SettingManager {

    private YeemoGameAPI main = null;

    public SettingManager(YeemoGameAPI instance) {
        main = instance;
    }

    public void setupArena() {
        Set<String> cs = Config.BasicFile.ARENA.getConfigurationSection("", false);
        ArenaManager am = new ArenaManager();
        cs.forEach(arena -> am.loadArena(arena));
    }

    public void setupConfig() {
        new Config("arena.yml", true);
        new Config("config.yml", true);
        new Config("language.yml", true);
        new Config("stats.yml", true);
        new Config("commands.yml", true);
        var.yaml.keySet().forEach(key -> var.yaml.get(key).save());
    }

    public void setupCommand() {
        CommandManager cm = new CommandManager(main);
        main.getCommand("yg").setExecutor(new CommandManager(main));
        cm.addSubCommand(new Help());
        cm.addSubCommand(new addGame());
    }
}
