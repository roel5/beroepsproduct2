package nl.han.jlvo.cookieclicker.screens;

import nl.han.jlvo.cookieclicker.CookieClickerApp;
import nl.han.jlvo.cookieclicker.dashboards.CookieDashboard;
import nl.han.jlvo.cookieclicker.dashboards.HelpersDashboard;
import nl.han.jlvo.cookieclicker.store.StoreDashboard;
import nl.han.jlvo.cookieclicker.gameobjects.BigCookie;
import nl.han.jlvo.cookieclicker.gameobjects.IBigCookieClickListener;
import nl.han.jlvo.cookieclicker.inventory.Inventory;

public class PlayScreen implements IBigCookieClickListener {

    private final Inventory inventory;
    private final BigCookie bigCookie;
    private final CookieClickerApp app;
    private final CookieDashboard cookieDashboard;
    private final HelpersDashboard helpersDashboard;
    private final StoreDashboard storeDashboard;

    public PlayScreen(CookieClickerApp app) {
        this.app = app;
        inventory = new Inventory();
        bigCookie = new BigCookie(this);
        cookieDashboard = new CookieDashboard(inventory);
        helpersDashboard = new HelpersDashboard(inventory);
        storeDashboard = new StoreDashboard(inventory);
        app.addGameObject(bigCookie);
        app.addDashboard(cookieDashboard);
        app.addDashboard(helpersDashboard);
        app.addGameObject(storeDashboard);
    }

    @Override
    public void onBigCookieClicked() {
        inventory.increaseCookieWallet();
    }
}
