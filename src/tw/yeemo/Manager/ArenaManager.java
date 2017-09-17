package tw.yeemo.Manager;

import tw.yeemo.game.Arena;

import java.util.HashMap;

public class ArenaManager {

    public static HashMap<String, Arena> arenas = new HashMap<>();

    public void loadArena(final String name) {
        try {
            Arena arena = new Arena(name);
            arena.init();
            System.out.print("[ArenaManager] " + name + " has been load!");
        }catch (Exception e){
            System.out.print("[ArenaManager] " + name + " load fail!");
            e.printStackTrace();
        }
    }

    public boolean addGame(final String name) {
        if(!arenas.containsKey(name)){
            Arena arena = new Arena(name);
            arena.copyBasic();
            return true;
        }
        return false;
    }

    public void registered(String name, Arena arena) {
        arenas.put(name, arena);
    }
}
