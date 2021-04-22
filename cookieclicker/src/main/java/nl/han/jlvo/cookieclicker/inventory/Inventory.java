package nl.han.jlvo.cookieclicker.inventory;

import nl.han.jlvo.cookieclicker.autohelper.*;

public class Inventory {
    private float cookieWallet;
    private final AutoHelper[] helpers;

    public Inventory() {
        cookieWallet = 0;
        helpers = new AutoHelper[]{new MouseClicker(), new Grandma(), new CookieFarm(), new CookieMine(), new CookieFactory()};
    }

    public float getTotalCookiesPerSecond() {
        float totalCookiesPerSecond = 0;
        for (AutoHelper helper : helpers) {
            totalCookiesPerSecond += helper.calculateCookiesPerSecond();
        }
        return totalCookiesPerSecond;
    }

    public float getCookieWallet() {
        return cookieWallet;
    }

    public void setCookieWallet(float cookieWallet) {
        this.cookieWallet = cookieWallet;
    }

    public void increaseCookieWallet() {
        float currentAmount = getCookieWallet();
        MouseClicker mouseClicker = (MouseClicker) helpers[0];
        currentAmount += 1 + mouseClicker.getAmount();
        setCookieWallet(currentAmount);
    }
}