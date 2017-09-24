package tw.yeemo.game;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import tw.yeemo.File.Config;
import tw.yeemo.Manager.ArenaManager;

import java.util.ArrayList;

public class Arena {

    private YamlConfiguration arena;
    private GameState state;
    private Location waitingRoom;
    private Location bound_high;
    private Location bound_low;
    private Location spec_high;
    private Location spec_low;
    private ArrayList<Location> spawns = new ArrayList<>();
    private int min_team;
    private int max_team;
    private int team_player_amount;
    private String displayName;
    private String arenaName;
    private String author;
    private String description;

    public Arena(String name) {
        arenaName = name;
        min_team = 4;
        max_team = 8;
        team_player_amount = 1;
        displayName = arenaName;
        state = GameState.DISABLE;
        arena = Config.BasicFile.ARENA.getYamlFile();
        if(!Config.BasicFile.ARENA.getYamlFile().contains(arenaName)){
            copyBasic();
        }else{
            init();
        }
    }

    private void init() {
        min_team = arena.getInt(arenaName + ".min_team");
        max_team = arena.getInt(arenaName + ".max_team");
        team_player_amount = arena.getInt(arenaName + ".team_player_amount");
        if (arena.contains(arenaName + ".waitingRoom")) {
            waitingRoom = getLocation(arena, arenaName + ".waitingRoom");
        }
        if (arena.contains(arenaName + ".spawns")) {
            for (String s : arena.getStringList(arenaName + ".spawns")) {
                spawns.add(getLocation(s));
            }
        }
        if (arena.contains(arenaName + ".bounds.bounds.high")) {
            bound_high = getLocation(arena, arenaName + ".bounds.bounds.high");
        }
        if (arena.contains(arenaName + ".bounds.bounds.low")) {
            bound_low = getLocation(arena, arenaName + ".bounds.bounds.low");
        }
        if (arena.contains(arenaName + ".bounds.spec.high")) {
            spec_high = getLocation(arena, arenaName + ".bounds.spec.high");
        }
        if (arena.contains(arenaName + ".bounds.spec.low")) {
            spec_low = getLocation(arena, arenaName + ".bounds.spec.low");
        }
        if (arena.contains(arenaName + ".displayName")) {
            displayName = arena.getString(arenaName + ".displayName");
        } else {
            displayName = arenaName;
        }
        if (arena.contains(arenaName + ".author")) {
            author = arena.getString(arenaName + ".author");
        }
        if (arena.contains(arenaName + ".description")) {
            description = arena.getString(arenaName + ".description");
        }
        if (arena.getBoolean(arenaName + ".enable")) {
            setState(GameState.WAITING);
        } else {
            setState(GameState.DISABLE);
        }
        new ArenaManager().registered(arenaName, this);
        Save();
    }

    private void Save() {
        Config.BasicFile.ARENA.reload();
        arena.set(arenaName + ".team_player_amount", team_player_amount);
        arena.set(arenaName + ".max_team", max_team);
        arena.set(arenaName + ".min_team", min_team);
        if (state == GameState.DISABLE) {
            arena.set(arenaName + ".enable", false);
        } else {
            arena.set(arenaName + ".enable", true);
        }
        if (description != null) {
            arena.set(arenaName + ".description", description);
        }
        if (author != null) {
            arena.set(arenaName + ".author", author);
        }
        if (displayName != null) {
            arena.set(arenaName + ".displayName", displayName);
        }
        if (bound_high != null) {
            setLocation(arena + ".bounds.bound.high", bound_high);
        }
        if (bound_low != null) {
            setLocation(arena + ".bounds.bound.low", bound_low);
        }
        if (spec_high != null) {
            setLocation(arena + ".bounds.spec.high", spec_high);
        }
        if (spec_low != null) {
            setLocation(arena + ".bounds.spec.low", spec_low);
        }
        if (!spawns.isEmpty()) {
            ArrayList<String> out = new ArrayList<>();
            for (Location loc : spawns) {
                out.add(getLocationText(loc));
            }
            arena.set(arenaName + ".spawns", out);
        }
        if (waitingRoom != null) {
            setLocation(arena + ".waitingRoom", waitingRoom);
        }
        Config.BasicFile.ARENA.save();
    }

    private void setLocation(String path, Location loc) {
        arena.set(path, loc.getWorld().getName() + ";" +
                loc.getX() + ";" +
                loc.getY() + ";" +
                loc.getZ() + ";" +
                loc.getYaw() + ";" +
                loc.getPitch());
    }

    private Location getLocation(String string) {
        Location loc;
        String[] split = string.split(";");
        World world = Bukkit.getWorld(split[0]);
        Double x = Double.valueOf(split[1]);
        Double y = Double.valueOf(split[2]);
        Double z = Double.valueOf(split[3]);
        Float yaw = Float.valueOf(split[4]);
        Float pitch = Float.valueOf(split[5]);
        loc = new Location(world, x, y, z, yaw, pitch);
        return loc;
    }

    private Location getLocation(YamlConfiguration arena, String path) {
        if (arena.getString(path).isEmpty()) {
            return null;
        }
        return getLocation(arena.getString(path));
    }

    private void copyBasic() {
        YamlConfiguration arena = Config.BasicFile.ARENA.getYamlFile();
        arena.set(arenaName + ".enable", false);
        arena.set(arenaName + ".min_team", 4);
        arena.set(arenaName + ".max_team", 8);
        arena.set(arenaName + ".team_player_amount", 1);
        arena.set(arenaName + ".displayName", arenaName);
        Config.BasicFile.ARENA.save();
        init();
    }

    private String getLocationText(Location loc) {
        return loc.getWorld().getName() + ";" +
                loc.getX() + ";" +
                loc.getY() + ";" +
                loc.getZ() + ";" +
                loc.getYaw() + ";" +
                loc.getPitch();
    }

    public String getName() {
        return arenaName;
    }

    public String getDisplayName() {
        return displayName;
    }
    public String getStateText() {
        return Config.BasicFile.CONFIG.get(state.getStatePath());
    }

    public ChatColor getStateColor() {
        return state.getColor();
    }

    private void setState(GameState state) {
        this.state = state;
    }
}
