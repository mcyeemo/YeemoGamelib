package tw.yeemo.Command;

import org.bukkit.entity.Player;
import tw.yeemo.File.Config;

import java.util.List;

public abstract class YeemoCommand {
    private final String description;
    private final String usage;
    private final List<String> aliases;
    private final String permission;
    private final YeemoCommand CMD;

    public abstract void onCommand(final Player player, final String[] args);

    public YeemoCommand(final String cmd) {
        this.description = Config.BasicFile.COMMANDS.get(cmd + ".Description");
        this.usage = Config.BasicFile.COMMANDS.get(cmd + ".Usage");
        this.aliases = Config.BasicFile.COMMANDS.getStringList(cmd + ".Aliases");
        this.permission = Config.BasicFile.COMMANDS.get(cmd + ".Permission");
        this.CMD = this;
    }

    public YeemoCommand getCMD() {
        return CMD;
    }

    public String getMessage() {
        return description;
    }

    public String getUsage() {
        return usage;
    }

    public String getPermission() {
        return permission;
    }

    public List<String> getAliases() {
        return aliases;
    }

}
