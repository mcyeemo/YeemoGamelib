package tw.yeemo.game;

import org.bukkit.ChatColor;

public enum GameState {
    WAITING(true, ChatColor.GREEN, "state.WAITING"),
    FULL(false, ChatColor.DARK_PURPLE, "state.FULL"),
    IN_GAME(false, ChatColor.DARK_RED, "state.IN_GAME"),
    POST_GAME(false, ChatColor.WHITE, "state.POST_GAME"),
    RESET(false, ChatColor.DARK_BLUE, "state.RESET"),
    DISABLE(false, ChatColor.GRAY, "state.DISABLE");

    private boolean canJoin = false;
    private ChatColor color = ChatColor.GRAY;
    private String statePath;
    private static GameState currentState;

    GameState(boolean canJoin, ChatColor color, String statePath) {
        this.canJoin = canJoin;
        this.color = color;
        this.statePath = statePath;
    }

    public ChatColor getColor() {
        return color;
    }

    public String getStatePath() {
        return statePath;
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
