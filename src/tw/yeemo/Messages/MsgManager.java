package tw.yeemo.Messages;

import org.bukkit.ChatColor;

public class MsgManager {

    public static String translateAlternateColorCodes(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
