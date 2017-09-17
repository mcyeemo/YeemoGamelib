package tw.yeemo.Command.SubCommand;

import org.bukkit.entity.Player;
import tw.yeemo.Command.YeemoCommand;
import tw.yeemo.Manager.CommandManager;

public class addGame extends YeemoCommand {

    public addGame() {
        super("addArena");
    }

    @Override
    public void onCommand(final Player player, final String[] args) {
        if(args.length == 0){
            CommandManager.sendUsage(player, getCMD());
        }
//        ArenaManager am = new ArenaManager();
//
//        if(am.addGame(args[0])){
//
//        }
    }
}
