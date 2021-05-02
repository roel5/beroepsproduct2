package nl.han.jlvo.cookieclicker.screens;

import nl.han.jlvo.cookieclicker.CookieClickerApp;
import nl.han.jlvo.cookieclicker.buttons.PlayAgainButton;
import nl.han.jlvo.cookieclicker.dashboards.StatisticsDashboard;
import nl.han.jlvo.cookieclicker.statistics.IPlayAgainClickListener;

public class EndScreen implements IPlayAgainClickListener {
    private final CookieClickerApp app;

    public EndScreen(CookieClickerApp app) {
        this.app = app;
        StatisticsDashboard statisticsDashboard = new StatisticsDashboard(app.stats, 0, 0, app.getWidth(), app.getHeight() - 200);
        app.addDashboard(statisticsDashboard);
        PlayAgainButton playAgainButton = new PlayAgainButton(this, 500, 650);
        app.addGameObject(playAgainButton);
    }

    @Override
    public void onPlayAgainButtonClicked() {
        app.resetStatistics();
        app.gameStateManager.setCurrentState(GameStateManager.GameState.START);
    }
}
