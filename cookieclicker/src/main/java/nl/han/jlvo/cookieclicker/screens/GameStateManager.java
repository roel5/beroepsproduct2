package nl.han.jlvo.cookieclicker.screens;

public class GameStateManager {
    private GameState currentGameState;
    private final IGameStateListener stateListener;

    public GameStateManager(IGameStateListener stateListener) {
        this.stateListener = stateListener;
        setCurrentState(GameState.START);
    }

    public GameState getCurrentState() {
        return currentGameState;
    }

    public void setCurrentState(GameState currentGameState) {
        if (currentGameState == this.currentGameState) return;
        this.currentGameState = currentGameState;
        stateListener.onGameStateChanged(currentGameState);
    }

    public enum GameState {
        START, PLAY, END
    }
}
