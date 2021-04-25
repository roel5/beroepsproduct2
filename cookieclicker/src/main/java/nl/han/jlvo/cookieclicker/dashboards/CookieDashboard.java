package nl.han.jlvo.cookieclicker.dashboards;

import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.jlvo.cookieclicker.inventory.Inventory;

public class CookieDashboard extends Dashboard {

    private final TextObject cookieDashboardText;
    Inventory inventory;

    public CookieDashboard(Inventory inventory) {
        super(0, 0, 300, 20);
        this.inventory = inventory;
        cookieDashboardText = new TextObject("Cookiewallet: " + inventory.getWallet().getCookiesInWallet() + "Cookies per second: " + inventory.getTotalCookiesPerSecond(), 10);
        cookieDashboardText.setForeColor(255, 255, 255, 255);
        setBackground(500, 0, 0);
        addGameObject(cookieDashboardText);
    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        super.mouseClicked(x, y, button);
    }

    @Override
    public void update() {
        cookieDashboardText.setText("Cookiewallet: " + inventory.getWallet().getCookiesInWallet() + "Cookies per second: " + inventory.getTotalCookiesPerSecond());
    }
}