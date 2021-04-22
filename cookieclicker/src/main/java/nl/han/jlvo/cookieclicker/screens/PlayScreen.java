package nl.han.jlvo.cookieclicker.screens;

import nl.han.jlvo.cookieclicker.CookieClickerApp;
import nl.han.jlvo.cookieclicker.dashboards.CookieDashboard;
import nl.han.jlvo.cookieclicker.gameobjects.BigCookie;
import nl.han.jlvo.cookieclicker.gameobjects.IBigCookieClickListener;
import nl.han.jlvo.cookieclicker.inventory.Inventory;

public class PlayScreen implements IBigCookieClickListener {

    Inventory inventory;
    BigCookie bigCookie;
    CookieClickerApp app;
    CookieDashboard cookieDashboard;

    public PlayScreen(CookieClickerApp app) {
        this.app = app;
        inventory = new Inventory();
        bigCookie = new BigCookie(this);
        cookieDashboard = new CookieDashboard(inventory);
        app.addGameObject(bigCookie);
        app.addDashboard(cookieDashboard);
    }

    @Override
    public void onBigCookieClicked() {
        inventory.increaseCookieWallet();
    }
}
