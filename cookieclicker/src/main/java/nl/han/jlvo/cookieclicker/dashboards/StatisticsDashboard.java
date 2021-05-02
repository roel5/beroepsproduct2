package nl.han.jlvo.cookieclicker.dashboards;

import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.jlvo.cookieclicker.statistics.StatisticsManager;

public class StatisticsDashboard extends Dashboard {
    private static final int PADDING_Y = 40;

    private final TextObject[] statisticsDashboardText = new TextObject[6];
    private final StatisticsManager stats;

    public StatisticsDashboard(StatisticsManager stats, float x, float y, float width, float height) {
        super(x, y, width, height);
        this.stats = stats;
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
            posY += PADDING_Y;
        }
    }

    @Override
    public void update() {
    }

}
