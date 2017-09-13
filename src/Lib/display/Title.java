package Lib.display;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutTitle;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import tw.yeemo.Messages.MsgManager;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

/**
 * Title
 * <p>
 * Display Title
 *
 * @author WenWen
 * @version 1.0 - (2017-09-13)
 * @since 1.1 - (2017-09-13)
 * @see tw.yeemo.Messages.MsgManager
 */
public class Title {

    private int runnable = 0;
    private int perTick = 20;
    private int delay = 0;
    private boolean enable = false;
    private boolean random = false;
    private Plugin plugin;
    private HashSet<Player> players = new HashSet<>();
    private HashMap<String, String> textList = new HashMap<>();
    private Random r = new Random();
    private int i;

    /**
     * Title
     * <p>
     *  Use Runnable
     *
     * @param plugin_ plugin instance
     * @param random enable random list display
     * @param delay set delay ?Tick Do
     * @param perTick set display perTick
     */
    public Title(Plugin plugin_, boolean random, int delay, int perTick) {
        this.perTick = perTick;
        this.plugin = plugin_;
        this.delay = delay;
        this.random = random;
        regRunnable(plugin_);
        i = 0;
    }

    /**
     * Title
     * <p>
     * Not use Runnable
     *
     * @param plugin_ input plugin instance
     */
    public Title(Plugin plugin_) {
        this.plugin = plugin_;
    }

    /**
     * Runnable to Display title
     *
     * @param plugin_ input plugin
     */
    private void regRunnable(Plugin plugin_) {
        runnable = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin_, () -> {
            if (enable) {
                for (Player player : players) {
                    if (!Bukkit.getServer().getOnlinePlayers().contains(player)) {
                        continue;
                    }
                    if (random) {
                        int s = r.nextInt(textList.size());
                        sendTitle(player, (String) textList.keySet().toArray()[r.nextInt(textList.keySet().toArray().length)], 5, 30, 15);
                        sendSubTitle(player, (String) textList.values().toArray()[r.nextInt(textList.keySet().toArray().length)], 5, 30, 15);
                    } else {
                        if (!textList.isEmpty()) {
                            if (textList.keySet().size() == i) i = 0;
                            sendTitle(player, (String) textList.keySet().toArray()[i], 5, 30, 15);
                            sendSubTitle(player, textList.get(textList.keySet().toArray()[i]), 5, 30, 15);
                            i++;
                        }
                    }
                }
            }
        }, this.delay, this.perTick);
    }

    /**
     * Send title to player
     *
     * @param player send to who
     * @param title title text
     * @param fadein fade in tick
     * @param stay stay tick
     * @param fadeout fade out tick
     */
    public void sendTitle(Player player, String title, int fadein, int stay, int fadeout) {
        PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
        title = MsgManager.translateAlternateColorCodes(title);
        IChatBaseComponent t = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + title + "\"}");
        PacketPlayOutTitle titleTime = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, t, fadein, stay, fadeout);
        PacketPlayOutTitle packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, t);
        connection.sendPacket(titleTime);
        connection.sendPacket(packet);
    }

    /**
     * Send subtitle to player
     *
     * @param player send to who
     * @param subtitle title text
     * @param fadein fade in tick
     * @param stay stay tick
     * @param fadeout fade out tick
     */
    public void sendSubTitle(Player player, String subtitle, int fadein, int stay, int fadeout) {
        PlayerConnection connection = ((CraftPlayer) player).getHandle().playerConnection;
        subtitle = MsgManager.translateAlternateColorCodes(subtitle);
        IChatBaseComponent s = IChatBaseComponent.ChatSerializer.a("{\"text\": \"" + subtitle + "\"}");
        PacketPlayOutTitle subtitleTime = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TIMES, s, fadein, stay, fadeout);
        PacketPlayOutTitle packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, s);
        connection.sendPacket(subtitleTime);
        connection.sendPacket(packet);
    }

    /**
     * start runnable
     */
    public void start() {
        enable = true;
    }

    /**
     * stop runnable
     */
    public void stop() {
        enable = false;
    }

    /**
     * cancel when you are no longer in use
     */
    public void cancel() {
        Bukkit.getServer().getScheduler().cancelTask(runnable);
    }

    /**
     * @param perTick change runnable tick
     */
    public void setPerTick(int perTick) {
        this.perTick = perTick;
        cancel();
        regRunnable(plugin);
    }

    /**
     * @param players put player HashSet
     */
    public void setPlayers(HashSet<Player> players) {
        this.players = players;
    }

    /**
     * @param player add player in HashSet
     */
    public void addPlayer(Player player) {
        players.add(player);
    }

    /**
     * @param player remove player from HashSet
     */
    public void removePlayer(Player player) {
        players.remove(player);
    }

    /**
     * @param textList set display title HashMap
     */
    public void setTextList(HashMap<String, String> textList) {
        this.textList = textList;
    }
}
