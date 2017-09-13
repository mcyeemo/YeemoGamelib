package tw.yeemo.Messages;

import org.bukkit.ChatColor;

/**
 * MsgManager
 * <p>
 * Message Manager
 *
 * @author WenWen
 * @version 1.0 - (2017-09-13)
 * @since 1.1 - (2017-09-13)
 *
 * @see org.bukkit.ChatColor
 */
public class MsgManager {

    /**
     * @param msg put the msg that you want to change
     * @return translate alternate color code msg
     */
    public static String translateAlternateColorCodes(String msg){
        return ChatColor.translateAlternateColorCodes('&', msg);
    }
}
