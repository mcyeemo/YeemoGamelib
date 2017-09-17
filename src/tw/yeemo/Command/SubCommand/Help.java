package tw.yeemo.Command.SubCommand;

import org.bukkit.entity.Player;
import tw.yeemo.Command.YeemoCommand;
import tw.yeemo.Manager.CommandManager;

public class Help extends YeemoCommand{
    public Help() {
        super("Help");
    }

    @Override
    public void onCommand(final Player player, final String[] args) {
        CommandManager.sendUsage(player);
    }
}
