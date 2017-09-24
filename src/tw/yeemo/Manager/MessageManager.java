package tw.yeemo.Manager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import tw.yeemo.File.Config;

public enum MessageManager {
    INFO(ChatColor.YELLOW),
    SUCC(ChatColor.GREEN),
    WARN(ChatColor.RED),
    ERRO(ChatColor.DARK_RED);

    private ChatColor color;

    MessageManager(ChatColor color) {
        this.color = color;
    }

    public void SendMessage(Player player, String msg){
        player.sendMessage(color + msg);
    }

    public void SendMessage(CommandSender sender, String msg) {
        sender.sendMessage(color + msg);
    }

    public void SendMessageFromLanguage(Player player, String path) {
        player.sendRawMessage(color + (String) Config.BasicFile.LANGUAGE.get(path));
    }

    public void SendLine(Player player, ChatColor color) {
        player.sendRawMessage(color + "---------------------------------------");
    }
}
