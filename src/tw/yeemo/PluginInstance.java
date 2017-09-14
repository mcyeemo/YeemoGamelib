package tw.yeemo;

import org.bukkit.plugin.java.JavaPlugin;
import tw.yeemo.config.ArenasConfig;
import tw.yeemo.config.MessagesConfig;
import tw.yeemo.config.StatsConfig;

public class PluginInstance {

    private JavaPlugin plugin = null;
    private ArenasConfig arenasconfig = null;
    private MessagesConfig messageconfig = null;
    private StatsConfig statsconfig = null;

    public PluginInstance(final JavaPlugin plugin_, final ArenasConfig arenasConfig, final MessagesConfig messageConfig, final StatsConfig statsConfig) {
        this.plugin = plugin_;
        this.arenasconfig = arenasConfig;
        this.messageconfig = messageConfig;
        this.statsconfig = statsConfig;
    }

    public ArenasConfig getArenasconfig() {
        return arenasconfig;
    }
}
