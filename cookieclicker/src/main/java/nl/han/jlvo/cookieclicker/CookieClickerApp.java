package nl.han.jlvo.cookieclicker;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.ica.oopg.view.View;

public class CookieClickerApp extends GameEngine {

    public static void main(String[] args) {
        CookieClickerApp app = new CookieClickerApp();
        app.runSketch();
    }

    @Override
    public void setupGame() {
        int worldWidth = 500;
        int worldHeight = 500;

        TextObject text = new TextObject("Time for cookies!", 40);
        text.setForeColor(255, 255, 255, 255);
        addGameObject(text, 100, 100);

        View view = new View(worldWidth, worldHeight);
        setView(view);
        size(worldWidth, worldHeight);
    }

    @Override
    public void update() {

    }
}
