package nl.han.jlvo.cookieclicker.screens;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.ica.oopg.userinput.IMouseInput;
import nl.han.jlvo.cookieclicker.CookieClickerApp;
import nl.han.jlvo.cookieclicker.inventory.Inventory;

public class PlayScreen implements IMouseInput {

    Inventory inventory;
    CookieClickerApp app;
    private TextObject dashboardText;

    public PlayScreen(CookieClickerApp app) {
        this.app = app;
        inventory = new Inventory();
    }

    public void createScoreDashboard(int x, int y, int dashboardWidth, int dashboardHeight) {
        Dashboard dashboard = new Dashboard(x, y, dashboardWidth, dashboardHeight);
        dashboardText = new TextObject("Cookiewallet: " + inventory.getCookieWallet() + "Cookies per second: " + inventory.getTotalCookiesPerSecond(), 10);
        dashboardText.setForeColor(255, 255, 255, 255);
        dashboard.addGameObject(dashboardText);
        app.addDashboard(dashboard);
    }

    @Override
    public void mousePressed(int i, int i1, int i2) {

    }

    @Override
    public void mouseReleased(int i, int i1, int i2) {

    }

    @Override
    public void mouseClicked(int i, int i1, int i2) {

    }

    @Override
    public void mouseMoved(int i, int i1) {

    }

    @Override
    public void mouseDragged(int i, int i1, int i2) {

    }

    @Override
    public void mouseWheel(int i) {

    }
}
