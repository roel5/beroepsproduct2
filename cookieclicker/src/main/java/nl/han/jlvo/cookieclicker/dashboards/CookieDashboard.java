package nl.han.jlvo.cookieclicker.dashboards;

import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.jlvo.cookieclicker.goldencookie.PowerUpTimer;
import nl.han.jlvo.cookieclicker.inventory.Inventory;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class CookieDashboard extends Dashboard {
    private static final int TEXT_X_POS = 125;
    private static final int COOKIE_TEXT_Y_POS = 10;
    private static final int POWERUP_TEXT_Y_POS = 400;

    private final DecimalFormat decimalFormat = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
    private final PowerUpTimer powerUpTimer;
    private final TextObject cookieDashboardText;
    private final TextObject powerUpText;
    private final Inventory inventory;

    public CookieDashboard(Inventory inventory, PowerUpTimer powerUpTimer) {
        super(0, 0, 900, 80);
        this.inventory = inventory;
        this.powerUpTimer = powerUpTimer;
        cookieDashboardText = new TextObject("", 25);
        powerUpText = new TextObject("", 14);
        drawCookieDashboardTest();
        setBackground(150, 75, 0);
        addGameObject(cookieDashboardText);
        addGameObject(powerUpText);
    }

    private void drawCookieDashboardTest() {
        cookieDashboardText.setForeColor(255, 255, 255, 255);
        cookieDashboardText.setX(TEXT_X_POS);
        cookieDashboardText.setY(COOKIE_TEXT_Y_POS);
        powerUpText.setForeColor(255, 255, 255, 255);
        powerUpText.setX(TEXT_X_POS);
        powerUpText.setY(POWERUP_TEXT_Y_POS);
        setCookieDashboardText();
    }

    private void setCookieDashboardText() {
        cookieDashboardText.setText("Cookiewallet: " + Float.parseFloat(decimalFormat.format(inventory.getWallet().getCookiesInWallet())) + " Cookies per second: " + Float.parseFloat(decimalFormat.format(inventory.getTotalCookiesPerSecond())));
        StringBuilder sb = new StringBuilder();
        if (inventory.isHelperPowerUpActive()) {
            sb.append("Helper verdubbelaar actief voor ").append(powerUpTimer.getRemainingSecondForHelperPowerUp());
        }
        if (inventory.getIsClickPowerUpActive()) {
            sb.append(" Klik verdubbelaar actief voor ").append(powerUpTimer.getRemainingSecondForClickPowerUp());
        }
        powerUpText.setText(sb.toString());

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
