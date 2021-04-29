package nl.han.jlvo.cookieclicker.dashboards;

import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.jlvo.cookieclicker.inventory.Inventory;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CookieDashboard extends Dashboard {

    DecimalFormat decimalFormat = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
    private final TextObject cookieDashboardText;
    Inventory inventory;

    public CookieDashboard(Inventory inventory) {
        super(0, 0, 900, 50);
        this.inventory = inventory;
        cookieDashboardText = new TextObject("", 25);
        drawCookieDashboardTest();
        setBackground(150, 75, 0);
        addGameObject(cookieDashboardText);
    }

    private void drawCookieDashboardTest() {
        cookieDashboardText.setForeColor(255, 255, 255, 255);
        cookieDashboardText.setX(125);
        cookieDashboardText.setY(10);
        setCookieDashboardText();
    }

    private void setCookieDashboardText() {
        cookieDashboardText.setText("Cookiewallet: " + Float.parseFloat(decimalFormat.format(inventory.getWallet().getCookiesInWallet())) + " Cookies per second: " + Float.parseFloat(decimalFormat.format(inventory.getTotalCookiesPerSecond())));
    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        super.mouseClicked(x, y, button);
    }

    @Override
    public void update() {
        setCookieDashboardText();
    }
}
