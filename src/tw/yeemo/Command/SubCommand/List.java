package tw.yeemo.Command.SubCommand;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import tw.yeemo.Command.YeemoCommand;
import tw.yeemo.Manager.ArenaManager;
import tw.yeemo.Manager.MessageManager;
import tw.yeemo.game.Arena;

public class List extends YeemoCommand{
    public List() {
        super("List");
    }

    @Override
    public void onCommand(final Player player, final String[] args) {
        ArenaManager am = new ArenaManager();
        MessageManager.INFO.SendLine(player, ChatColor.GOLD);
        for(Arena arena : am.getArenas().values()){
            player.sendRawMessage(ChatColor.GREEN + getArena(arena) + " - " + arena.getStateColor() + arena.getStateText());
        }
        MessageManager.INFO.SendLine(player, ChatColor.GOLD);
    }

    public String getArena(final Arena arena) {
        return arena.getName() + ChatColor.GRAY + "(" + arena.getDisplayName() + ")" + ChatColor.RESET;
    }
}
