package tw.yeemo;

import org.bukkit.plugin.java.JavaPlugin;
import tw.yeemo.Manager.SettingManager;

public class YeemoGameAPI extends JavaPlugin {

    private static YeemoGameAPI instance;

    @Override
    public void onEnable() {
        /*        Setup                 */
        YeemoGameAPI.instance = this;                                   // setup plugin
        SettingManager setting = new SettingManager(this);     // Setup Arena
        setting.setupConfig();
        setting.setupArena();
        setting.setupCommand();
    }

    public static YeemoGameAPI getInstance() {
        return YeemoGameAPI.instance;
    }
}
