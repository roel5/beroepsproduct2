package nl.han.jlvo.cookieclicker;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.view.View;
import nl.han.jlvo.cookieclicker.screens.PlayScreen;

public class CookieClickerApp extends GameEngine {
    private PlayScreen playScreen;

    public static void main(String[] args) {
        CookieClickerApp app = new CookieClickerApp();
        app.runSketch();
    }

    @Override
    public void setupGame() {
        int worldWidth = 1200;
        int worldHeight = 800;

        View view = new View(worldWidth, worldHeight);
        setView(view);
        size(worldWidth, worldHeight);

        playScreen = new PlayScreen(this);
    }

    @Override
    public void update() {

    }
}
