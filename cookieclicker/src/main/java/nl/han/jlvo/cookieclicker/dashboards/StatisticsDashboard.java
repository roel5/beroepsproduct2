package nl.han.jlvo.cookieclicker.dashboards;

import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.jlvo.cookieclicker.statistics.IPlayAgainClickListener;
import nl.han.jlvo.cookieclicker.statistics.StatisticsManager;
import processing.core.PGraphics;


public class StatisticsDashboard extends Dashboard {

    private final TextObject[] statisticsDashboardText = new TextObject[6];
    StatisticsManager stats;
    private final IPlayAgainClickListener playAgainClickListener;

    public StatisticsDashboard(StatisticsManager stats, IPlayAgainClickListener playAgainClickListener, float x, float y, float width, float height) {
        super(x, y, width, height);
        this.stats = stats;
        this.playAgainClickListener = playAgainClickListener;
        assignDashboardText();
    }

    public void assignDashboardText() {
        String[] text = {"Statistics: ", "Total amount of cookies: " + stats.getTotalAmountOfCookies(), "Total amount of helpers: " + stats.getTotalAmountOfHelpers(),
                "Total amount of clicks: " + stats.getTotalAmountOfClicks(), "Total amount of golden cookies: " + stats.getTotalAmountOfGoldenCookies(), "Total amount of vermin died: " + stats.getTotalAmountOfVerminDied()};
        int posX = 300;
        int posY = 50;

        for (int i = 0; i < statisticsDashboardText.length; i++) {
            statisticsDashboardText[i] = new TextObject(text[i], 30);
            statisticsDashboardText[i].setX(posX);
            statisticsDashboardText[i].setY(posY);
            addGameObject(statisticsDashboardText[i]);
            posY += 40;
        }
    }

    @Override
    public void update() {

    }

}
