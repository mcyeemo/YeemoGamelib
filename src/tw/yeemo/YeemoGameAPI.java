package tw.yeemo;

import org.bukkit.plugin.java.JavaPlugin;
import tw.yeemo.config.ArenasConfig;
import tw.yeemo.config.DefaultConfig;
import tw.yeemo.config.MessagesConfig;
import tw.yeemo.config.StatsConfig;

import java.util.HashMap;

public class YeemoGameAPI extends JavaPlugin {

    private static YeemoGameAPI instance = null;
    public static HashMap<JavaPlugin, PluginInstance> pinstances = new HashMap<>();

    @Override
    public void onEnable() {
        /*        Setup                 */
        YeemoGameAPI.instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }

    public static YeemoGameAPI getAPI() {
        return YeemoGameAPI.instance;
    }

    public static YeemoGameAPI setupAPI(final JavaPlugin plugin_, final String game, final Class<?> arenaclass, final ArenasConfig arenaConfig, final MessagesConfig messageConfigm, final StatsConfig statsConfig, final DefaultConfig defaultConfig) {
        YeemoGameAPI.pinstances.put(plugin_, new PluginInstance(plugin_, arenaConfig, messageConfigm, statsConfig));
        return YeemoGameAPI.instance;
    }
}
