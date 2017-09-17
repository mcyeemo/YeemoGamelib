package tw.yeemo.Manager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tw.yeemo.Command.YeemoCommand;
import tw.yeemo.File.Config;
import tw.yeemo.YeemoGameAPI;
import tw.yeemo.utils.var;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandManager implements CommandExecutor {

    private YeemoGameAPI main;

    public CommandManager(YeemoGameAPI main) {
        this.main = main;
    }

    public void addSubCommand(YeemoCommand sub) {
        var.subCommand.add(sub);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            MessageManager.WARN.SendMessage(sender, Config.BasicFile.LANGUAGE.get("command.YOU_NOT_A_PLAYER"));
            return false;
        }
        Player player = (Player) sender;
        if (args.length == 0) {
            sendUsage(player);
            return false;
        }

        YeemoCommand target = get(args[0]);

        if (target == null) {
            MessageManager.WARN.SendMessage(player, Config.BasicFile.LANGUAGE.get("command.THIS_SUBCMD_IS_INVALID"));
            return false;
        }
        ArrayList<String> sub = new ArrayList<>();
        sub.addAll(Arrays.asList(args));
        sub.remove(0);
        args = sub.toArray(new String[sub.size()]);
        if(!player.hasPermission(target.getPermission())){
            MessageManager.WARN.SendMessage(player, Config.BasicFile.LANGUAGE.get("command.YOU_DONT_HAS_PERMISSION"));
            return false;
        }
        target.onCommand(player, args);
        return false;
    }

    public static void sendUsage(Player player) {
        MessageManager.INFO.SendMessage(player, ChatColor.GOLD + "---------------------------------------");
        MessageManager.INFO.SendMessage(player, ChatColor.GREEN + "YeemoGame Command:");
        for (YeemoCommand c : var.subCommand) {
            if (player.hasPermission(c.getPermission())) {
                sendUsage(player, c);
            }
        }
        MessageManager.INFO.SendMessage(player, ChatColor.GOLD + "---------------------------------------");
    }

    private static String getAliases(List<String> aliases) {
        String out = null;
        for (String s : aliases) {
            if (out == null) {
                out = s;
            } else {
                out += " | " + s;
            }
        }
        out = "<" + out + ">";
        return out;
    }

    private YeemoCommand get(String name) {
        for (YeemoCommand cmd : var.subCommand) {
            for (String aliases : cmd.getAliases()) {
                if (aliases.equalsIgnoreCase(name)) {
                    return cmd;
                }
            }
        }
        return null;
    }

    public static void sendUsage(Player player, YeemoCommand c) {
        MessageManager.INFO.SendMessage(player, "/yg " + getAliases(c.getAliases()) + " " + c.getUsage() + ChatColor.AQUA + " - " + c.getMessage());
    }
}
