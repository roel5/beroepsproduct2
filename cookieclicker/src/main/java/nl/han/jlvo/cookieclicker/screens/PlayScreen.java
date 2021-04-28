package nl.han.jlvo.cookieclicker.screens;

import nl.han.jlvo.cookieclicker.CookieClickerApp;
import nl.han.jlvo.cookieclicker.autohelper.AutoHelperUpdateTimer;
import nl.han.jlvo.cookieclicker.autohelper.IAutoHelperUpdateListener;
import nl.han.jlvo.cookieclicker.dashboards.CookieDashboard;
import nl.han.jlvo.cookieclicker.dashboards.HelpersDashboard;
import nl.han.jlvo.cookieclicker.goldencookie.GoldenCookie;
import nl.han.jlvo.cookieclicker.goldencookie.GoldenCookieSpawner;
import nl.han.jlvo.cookieclicker.goldencookie.IGoldenCookieListener;
import nl.han.jlvo.cookieclicker.goldencookie.IGoldenCookieSpawnerListener;
import nl.han.jlvo.cookieclicker.inventory.Wallet;
import nl.han.jlvo.cookieclicker.store.StoreDashboard;
import nl.han.jlvo.cookieclicker.gameobjects.BigCookie;
import nl.han.jlvo.cookieclicker.vermin.IVerminListener;
import nl.han.jlvo.cookieclicker.vermin.IVerminSpawnerListener;
import nl.han.jlvo.cookieclicker.vermin.Vermin;
import nl.han.jlvo.cookieclicker.gameobjects.IBigCookieClickListener;
import nl.han.jlvo.cookieclicker.inventory.Inventory;
import nl.han.jlvo.cookieclicker.vermin.VerminSpawner;

public class PlayScreen implements IBigCookieClickListener, IAutoHelperUpdateListener, IVerminSpawnerListener, IVerminListener, IGoldenCookieSpawnerListener, IGoldenCookieListener {

    private final Inventory inventory;
    private final BigCookie bigCookie;
    private final CookieClickerApp app;
    private final CookieDashboard cookieDashboard;
    private final HelpersDashboard helpersDashboard;
    private final StoreDashboard storeDashboard;
    private final AutoHelperUpdateTimer updateTimer;
    private final VerminSpawner verminSpawner;
    private final GoldenCookieSpawner goldenCookieSpawner;

    public PlayScreen(CookieClickerApp app) {
        this.app = app;
        inventory = new Inventory();
        bigCookie = new BigCookie(this);
        cookieDashboard = new CookieDashboard(inventory);
        helpersDashboard = new HelpersDashboard(inventory);
        storeDashboard = new StoreDashboard(inventory);
        updateTimer = new AutoHelperUpdateTimer(this);
        verminSpawner = new VerminSpawner(this);
        goldenCookieSpawner = new GoldenCookieSpawner(this);
        app.addGameObject(bigCookie, 350, 300);
        app.addDashboard(cookieDashboard);
        app.addDashboard(helpersDashboard);
        app.addGameObject(storeDashboard);
    }

    @Override
    public void onBigCookieClicked() {
        inventory.increaseCookieWalletByClick();
    }

    @Override
    public void onAutoHelperUpdate() {
        inventory.increaseCookieWalletByAutoHelpers();
    }

    @Override
    public void onVerminSpawnerTriggered() {
        //TODO Add objects to list
        app.addGameObject(new Vermin(bigCookie, app.getWidth(), app.getHeight(), this));
    }

    @Override
    public void onCookiesEatUpdate(float amount) {
        inventory.getWallet().decreaseCookiesInWallet(amount);
    }

    @Override
    public void onVerminDied(Vermin vermin) {
        app.deleteGameObject(vermin);
    }

    @Override
    public void onGoldenCookieSpawnerTriggered() {
        app.addGameObject(new GoldenCookie(this, app.getWidth()));
    }

    @Override
    public void onCookieDissolve(GoldenCookie goldenCookie) {
        app.deleteGameObject(goldenCookie);
    }

    @Override
    public void onIncreaseCookieWallet(int percentage) {
        Wallet wallet = inventory.getWallet();
        wallet.increaseCookiesInWallet(wallet.getCookiesInWallet() / 100 * percentage);
    }

    @Override
    public void onMultiplyClickerPowerUp() {
        inventory.setClickPowerUpActive(true);
    }

    @Override
    public void onMultiplyHelperPowerUp() {
        inventory.setHelperPowerUpActive(true);
    }
}
