package tw.yeemo;

import org.bukkit.plugin.java.JavaPlugin;
import tw.yeemo.Manager.SettingManager;
import tw.yeemo.utils.var;

public class YeemoGameAPI extends JavaPlugin {

    private static YeemoGameAPI instance = null;

    @Override
    public void onEnable() {
        /*        Setup                 */
        YeemoGameAPI.instance = this;                                   // setup plugin
        SettingManager setting = new SettingManager(this);     // Setup Arena
        setting.setupConfig();
        setting.setupArena();
        setting.setupCommand();
    }

    @Override
    public void onDisable() {
        /*        Disable               */
        var.yaml.clear();
        instance = null;
    }

    public static YeemoGameAPI getInstance() {
        return YeemoGameAPI.instance;
    }
}
