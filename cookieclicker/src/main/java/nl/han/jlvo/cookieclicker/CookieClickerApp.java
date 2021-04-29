package nl.han.jlvo.cookieclicker;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.view.View;
import nl.han.jlvo.cookieclicker.screens.EndScreen;
import nl.han.jlvo.cookieclicker.screens.*;
import nl.han.jlvo.cookieclicker.statistics.StatisticsManager;

public class CookieClickerApp extends GameEngine implements IGameStateListener {
    public GameStateManager gameStateManager;
    private StartScreen startScreen;
    private PlayScreen playScreen;
    private EndScreen endScreen;
    public StatisticsManager stats;
    private float totalCookiesNeeded;

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
        stats = new StatisticsManager();
    }

    @Override
    public void update() {
    }

    @Override
    public void onGameStateChanged(GameStateManager.GameState gameState) {
        deleteAllDashboards();
        deleteAllGameOBjects();
        if (playScreen != null) {
            playScreen.destroy();
            playScreen = null;
        }
        startScreen = null;
        endScreen = null;
        switch (gameState) {
            case START:
                startScreen = new StartScreen(this);
                break;
            case PLAY:
                playScreen = new PlayScreen(this);
                break;
            case END:
                endScreen = new EndScreen(this);
                break;
        }
    }

    public float getTotalCookiesNeeded() {
        return totalCookiesNeeded;
    }

    public void setTotalCookiesNeeded(float totalCookiesNeeded) {
        this.totalCookiesNeeded = totalCookiesNeeded;
    }
}
