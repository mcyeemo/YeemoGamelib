package tw.yeemo.Manager;

import tw.yeemo.game.Arena;

import java.util.HashMap;

public class ArenaManager {

    private static HashMap<String, Arena> arenas = new HashMap<>();

    public HashMap<String, Arena> getArenas() {
        return arenas;
    }

    void loadArena(String name) {
        System.out.print(name);
        try {
            new Arena(name);
            System.out.print("[ArenaManager] " + name + " has been load!");
        } catch (Exception e) {
            System.out.print("[ArenaManager] " + name + " load fail!");
            e.printStackTrace();
        }
    }

    public boolean addGame(String name) {
        try {
            if (!arenas.containsKey(name)) {
                new Arena(name);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void registered(String name, Arena arena) {
        arenas.put(name, arena);
    }

    public void reset() {
        arenas.clear();
        arenas = new HashMap<>();
    }
}
