package tw.yeemo.game;

import org.bukkit.ChatColor;
import tw.yeemo.File.Config;

public enum GameState {
    WAITING(true, ChatColor.GREEN, Config.BasicFile.CONFIG.get("state.WAITING")),
    FULL(false, ChatColor.DARK_PURPLE, Config.BasicFile.CONFIG.get("state.FULL")),
    IN_GAME(false, ChatColor.DARK_RED, Config.BasicFile.CONFIG.get("state.IN_GAME")),
    POST_GAME(false, ChatColor.WHITE, Config.BasicFile.CONFIG.get("state.POST_GAME")),
    RESET(false, ChatColor.DARK_BLUE, Config.BasicFile.CONFIG.get("state.RESET")),
    DISABLE(false, ChatColor.GRAY, Config.BasicFile.CONFIG.get("state.DISABLE"));

    private boolean canJoin = false;
    private ChatColor color = ChatColor.GRAY;
    private String stateName;
    private static GameState currentState;

    GameState(boolean canJoin, ChatColor color, String stateName) {
        this.canJoin = canJoin;
        this.color = color;
        this.stateName = stateName;
    }

    public ChatColor getColor() {
        return color;
    }

    public String getStateName() {
        return stateName;
    }

    public boolean canJoin() {
        return canJoin;
    }

    public static void setState(GameState state) {
        currentState = state;
    }

    public static boolean isState(GameState state) {
        return currentState == state;
    }

    public static GameState getState() {
        return currentState;
    }
}
