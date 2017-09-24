package tw.yeemo.Command.SubCommand;

import org.bukkit.entity.Player;
import tw.yeemo.Command.YeemoCommand;
import tw.yeemo.Manager.ArenaManager;
import tw.yeemo.Manager.CommandManager;
import tw.yeemo.Manager.MessageManager;

public class addGame extends YeemoCommand {

    public addGame() {
        super("addArena");
    }

    @Override
    public void onCommand(final Player player, final String[] args) {
        if(args.length == 0){
            CommandManager.sendUsage(player, getCMD());
            return;
        }
        ArenaManager am = new ArenaManager();
        if(am.addGame(args[0])){
            MessageManager.SUCC.SendMessageFromLanguage(player, "command.ADD_GAME_SUCCESS");
            return;
        }
        MessageManager.ERRO.SendMessageFromLanguage(player, "command.ADD_GAME_FAIL");
    }
}
