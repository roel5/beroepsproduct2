package nl.han.jlvo.cookieclicker.screens;

import nl.han.jlvo.cookieclicker.CookieClickerApp;

public class StartScreen implements IButtonClickListener {
    private final CookieClickerApp app;

    public StartScreen(CookieClickerApp app) {
        this.app = app;
        drawPlayButton();
    }

    void drawPlayButton() {
    }

    @Override
    public void onButtonClick() {
        app.gameStateManager.setCurrentState(GameStateManager.GameState.PLAY);
    }
}
