package nl.han.jlvo.cookieclicker;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.view.View;
import nl.han.jlvo.cookieclicker.screens.PlayScreen;

public class CookieClickerApp extends GameEngine {

    public static void main(String[] args) {
        CookieClickerApp app = new CookieClickerApp();
        app.runSketch();
    }

    @Override
    public void setupGame() {
        int worldWidth = 500;
        int worldHeight = 500;

        View view = new View(worldWidth, worldHeight);
        setView(view);
        size(worldWidth, worldHeight);

        PlayScreen playScreen = new PlayScreen(this);
        playScreen.createScoreDashboard(0, 0, worldWidth, worldHeight);
    }

    @Override
    public void update() {

    }
}
