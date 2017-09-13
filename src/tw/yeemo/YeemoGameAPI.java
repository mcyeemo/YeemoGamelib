package tw.yeemo;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * -=-=-= YeemoGameLib =-=-=-
 * <p>
 * YeemoGameLib main class
 *
 * @author WenWen Yoyolee Yuanyuan
 * @version 1.1 - (2017-09-13)
 * @since 1.0 - (2017-09-12)
 *
 */
public class YeemoGameAPI extends JavaPlugin {

    YeemoGameAPI instance = null;

    /**
     * Plugin enable
     */
    @Override
    public void onEnable() {
        /*        Setup                 */
        instance = this;

        /*        Load File             */


        /*        SQL Connection        */


        /*        Commands Register     */


        /*        Events Register       */


        /*        Runnable              */

    }

    /**
     * Plugin disable
     */
    @Override
    public void onDisable() {
        instance = null;
    }

    /**
     * @return get YeemoGameAPI instance
     */
    public YeemoGameAPI getInstance() {
        return instance;
    }
}
