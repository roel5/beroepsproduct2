package nl.han.jlvo.cookieclicker.screens;

import nl.han.jlvo.cookieclicker.CookieClickerApp;
import nl.han.jlvo.cookieclicker.buttons.PlayAgainButton;
import nl.han.jlvo.cookieclicker.dashboards.StatisticsDashboard;
import nl.han.jlvo.cookieclicker.statistics.IPlayAgainClickListener;

import java.util.ArrayList;

public class EndScreen implements IPlayAgainClickListener {

    private final StatisticsDashboard statisticsDashboard;
    private PlayAgainButton playAgainButton;
    private CookieClickerApp app;

    public EndScreen(CookieClickerApp app) {
        this.app = app;
        app.stats.getTotalAmountOfClicks();
        statisticsDashboard = new StatisticsDashboard(app.stats, this,0, 0, app.getWidth(), app.getHeight() - 200);
        app.addDashboard(statisticsDashboard);
        playAgainButton = new PlayAgainButton(this, 500, 650);
        app.addGameObject(playAgainButton);
    }

    @Override
    public void onPlayAgainButtonClicked() {
        app.resetStatistics();
        app.gameStateManager.setCurrentState(GameStateManager.GameState.START);
    }
}
