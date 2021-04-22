package nl.han.jlvo.cookieclicker.screens;

import nl.han.jlvo.cookieclicker.CookieClickerApp;
import nl.han.jlvo.cookieclicker.dashboards.CookieDashboard;
import nl.han.jlvo.cookieclicker.dashboards.HelpersDashboard;
import nl.han.jlvo.cookieclicker.dashboards.StoreDashboard;
import nl.han.jlvo.cookieclicker.gameobjects.BigCookie;
import nl.han.jlvo.cookieclicker.gameobjects.IBigCookieClickListener;
import nl.han.jlvo.cookieclicker.gameobjects.IStoreDashboardClickListener;
import nl.han.jlvo.cookieclicker.inventory.Inventory;

public class PlayScreen implements IBigCookieClickListener, IStoreDashboardClickListener {

    Inventory inventory;
    BigCookie bigCookie;
    CookieClickerApp app;
    CookieDashboard cookieDashboard;
    HelpersDashboard helpersDashboard;
    StoreDashboard storeDashboard;

    public PlayScreen(CookieClickerApp app) {
        this.app = app;
        inventory = new Inventory();
        bigCookie = new BigCookie(this);
        cookieDashboard = new CookieDashboard(inventory);
        helpersDashboard = new HelpersDashboard(inventory);
        storeDashboard = new StoreDashboard(inventory, this);
        app.addGameObject(bigCookie);
        app.addDashboard(cookieDashboard);
        app.addDashboard(helpersDashboard);
        app.addDashboard(storeDashboard);
    }

    @Override
    public void onBigCookieClicked() {
        inventory.increaseCookieWallet();
    }

    @Override
    public void onBuyGrandmaClicked() {
        inventory.setCookieWallet(inventory.getHelpers()[1].buyHelper(inventory.getCookieWallet()));
    }
}
