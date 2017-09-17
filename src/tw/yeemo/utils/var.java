package tw.yeemo.utils;

import tw.yeemo.Command.YeemoCommand;
import tw.yeemo.File.Config;
import tw.yeemo.game.Arena;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class var {

    public static HashMap<String, Config> yaml = new HashMap<>();
    public static HashMap<String, Arena> arenas = new HashMap<>();
    public static Set<YeemoCommand> subCommand = new HashSet<>();
}
