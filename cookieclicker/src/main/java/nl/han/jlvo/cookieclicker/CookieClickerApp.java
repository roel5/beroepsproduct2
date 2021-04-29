package nl.han.jlvo.cookieclicker;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.view.View;
import nl.han.jlvo.cookieclicker.screens.EndScreen;
import nl.han.jlvo.cookieclicker.screens.PlayScreen;
import nl.han.jlvo.cookieclicker.statistics.StatisticsManager;

public class CookieClickerApp extends GameEngine {
    private PlayScreen playScreen;
    private EndScreen endScreen;
    public StatisticsManager stats;

    public static void main(String[] args) {
        CookieClickerApp app = new CookieClickerApp();
        app.runSketch();
    }

    @Override
    public void setupGame() {
        int worldWidth = 1200;
        int worldHeight = 800;

        View view = new View(worldWidth, worldHeight);
        view.setBackground(200,200,200);
        setView(view);
        size(worldWidth, worldHeight);

//        playScreen = new PlayScreen(this);
        stats = new StatisticsManager();
        endScreen = new EndScreen(this);

    }

    @Override
    public void update() {
    }
}
