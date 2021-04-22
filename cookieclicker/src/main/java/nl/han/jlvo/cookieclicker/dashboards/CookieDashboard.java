package nl.han.jlvo.cookieclicker.dashboards;

import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.jlvo.cookieclicker.inventory.Inventory;

public class CookieDashboard extends Dashboard {

    private final TextObject cookieDashboardText;
    Inventory inventory;

    public CookieDashboard(Inventory inventory) {
        super(0, 0, 500, 20);
        this.inventory = inventory;
        cookieDashboardText = new TextObject("Cookiewallet: " + inventory.getCookieWallet() + "Cookies per second: " + inventory.getTotalCookiesPerSecond(), 10);
        cookieDashboardText.setForeColor(255, 255, 255, 255);
        addGameObject(cookieDashboardText);
    }



    @Override
    public void update() {
        cookieDashboardText.setText("Cookiewallet: " + inventory.getCookieWallet() + "Cookies per second: " + inventory.getTotalCookiesPerSecond());
    }
}
