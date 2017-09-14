package tw.yeemo;

import org.bukkit.plugin.java.JavaPlugin;

public class YeemoGameAPI extends JavaPlugin {

    YeemoGameAPI instance = null;

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

    @Override
    public void onDisable() {
        instance = null;
    }
}
