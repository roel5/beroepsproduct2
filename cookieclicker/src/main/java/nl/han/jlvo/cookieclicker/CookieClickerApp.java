package nl.han.jlvo.cookieclicker;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.view.View;
import nl.han.jlvo.cookieclicker.screens.*;

public class CookieClickerApp extends GameEngine implements IGameStateListener {
    public GameStateManager gameStateManager;
    private StartScreen startScreen;
    private PlayScreen playScreen;
    private EndScreen endScreen;

    public static void main(String[] args) {
        CookieClickerApp app = new CookieClickerApp();
        app.runSketch();
    }

    @Override
    public void setupGame() {
        int worldWidth = 1200;
        int worldHeight = 800;

        View view = new View(worldWidth, worldHeight);
        view.setBackground(200, 200, 200);
        setView(view);
        size(worldWidth, worldHeight);

        gameStateManager = new GameStateManager(this);
    }

    @Override
    public void update() {
    }

    @Override
    public void onGameStateChanged(GameStateManager.GameState gameState) {
        deleteAllDashboards();
        deleteAllGameOBjects();
        startScreen = null;
        playScreen = null;
        endScreen = null;
        switch (gameState) {
            case START:
                startScreen = new StartScreen(this);
                break;
            case PLAY:
                playScreen = new PlayScreen(this);
                break;
            case END:
                endScreen = new EndScreen();
                break;
        }
    }
}
