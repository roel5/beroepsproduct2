package nl.han.jlvo.cookieclicker.screens;

import nl.han.jlvo.cookieclicker.CookieClickerApp;
import nl.han.jlvo.cookieclicker.autohelper.AutoHelperUpdateTimer;
import nl.han.jlvo.cookieclicker.autohelper.IAutoHelperUpdateListener;
import nl.han.jlvo.cookieclicker.dashboards.CookieDashboard;
import nl.han.jlvo.cookieclicker.dashboards.HelpersDashboard;
import nl.han.jlvo.cookieclicker.goldencookie.*;
import nl.han.jlvo.cookieclicker.inventory.Wallet;
import nl.han.jlvo.cookieclicker.store.StoreDashboard;
import nl.han.jlvo.cookieclicker.bigcookie.BigCookie;
import nl.han.jlvo.cookieclicker.vermin.IVerminListener;
import nl.han.jlvo.cookieclicker.vermin.IVerminSpawnerListener;
import nl.han.jlvo.cookieclicker.vermin.Vermin;
import nl.han.jlvo.cookieclicker.bigcookie.IBigCookieClickListener;
import nl.han.jlvo.cookieclicker.inventory.Inventory;
import nl.han.jlvo.cookieclicker.vermin.VerminSpawner;

public class PlayScreen implements IBigCookieClickListener, IAutoHelperUpdateListener, IVerminSpawnerListener, IVerminListener, IGoldenCookieSpawnerListener, IGoldenCookieListener, IPowerUpTimerListener {

    private final Inventory inventory;
    private final BigCookie bigCookie;
    private final CookieClickerApp app;
    private AutoHelperUpdateTimer updateTimer;
    private VerminSpawner verminSpawner;
    private GoldenCookieSpawner goldenCookieSpawner;
    private final PowerUpTimer powerUpTimer;

    public PlayScreen(CookieClickerApp app) {
        this.app = app;
        inventory = new Inventory();
        bigCookie = new BigCookie(this);
        CookieDashboard cookieDashboard = new CookieDashboard(inventory);
        HelpersDashboard helpersDashboard = new HelpersDashboard(inventory);
        StoreDashboard storeDashboard = new StoreDashboard(inventory);
        updateTimer = new AutoHelperUpdateTimer(this);
        verminSpawner = new VerminSpawner(this);
        goldenCookieSpawner = new GoldenCookieSpawner(this);
        powerUpTimer = new PowerUpTimer(this);
        app.addGameObject(bigCookie, 350, 300);
        app.addGameObject(storeDashboard);
        app.addDashboard(cookieDashboard);
        app.addDashboard(helpersDashboard);
    }

    public void destroy() {
        updateTimer.stopAlarm();
        updateTimer = null;
        verminSpawner.stopAlarm();
        verminSpawner = null;
        goldenCookieSpawner.stopAlarm();
        goldenCookieSpawner = null;
    }

    @Override
    public void onBigCookieClicked() {
        inventory.increaseCookieWalletByClick();
    }

    @Override
    public void onAutoHelperUpdate() {
        inventory.increaseCookieWalletByAutoHelpers();
        if (app.getTotalCookiesNeeded() < inventory.getWallet().getCookiesInWallet()) {
            app.gameStateManager.setCurrentState(GameStateManager.GameState.END);
        }
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
        powerUpTimer.startTimerForClick();
        inventory.setClickPowerUpActive(true);
    }

    @Override
    public void onMultiplyHelperPowerUp() {
        powerUpTimer.startTimerForHelper();
        inventory.setHelperPowerUpActive(true);
    }

    @Override
    public void onHelperPowerUpEnded() {
        inventory.setHelperPowerUpActive(false);
    }

    @Override
    public void onClickPowerUpEnded() {
        inventory.setClickPowerUpActive(false);
    }
}
