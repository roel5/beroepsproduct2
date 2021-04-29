package nl.han.jlvo.cookieclicker.screens;

import nl.han.jlvo.cookieclicker.CookieClickerApp;
import nl.han.jlvo.cookieclicker.autohelper.AutoHelper;
import nl.han.jlvo.cookieclicker.autohelper.AutoHelperUpdateTimer;
import nl.han.jlvo.cookieclicker.autohelper.IAutoHelperUpdateListener;
import nl.han.jlvo.cookieclicker.dashboards.CookieDashboard;
import nl.han.jlvo.cookieclicker.dashboards.HelpersDashboard;
import nl.han.jlvo.cookieclicker.goldencookie.*;
import nl.han.jlvo.cookieclicker.inventory.Wallet;
import nl.han.jlvo.cookieclicker.store.StoreDashboard;
import nl.han.jlvo.cookieclicker.bigcookie.BigCookie;
import nl.han.jlvo.cookieclicker.store.items.IStoreItemClickListener;
import nl.han.jlvo.cookieclicker.vermin.IVerminListener;
import nl.han.jlvo.cookieclicker.vermin.IVerminSpawnerListener;
import nl.han.jlvo.cookieclicker.vermin.Vermin;
import nl.han.jlvo.cookieclicker.bigcookie.IBigCookieClickListener;
import nl.han.jlvo.cookieclicker.inventory.Inventory;
import nl.han.jlvo.cookieclicker.vermin.VerminSpawner;

import java.time.LocalDateTime;

public class PlayScreen implements IBigCookieClickListener, IAutoHelperUpdateListener, IVerminSpawnerListener, IVerminListener, IGoldenCookieSpawnerListener, IGoldenCookieListener, IPowerUpTimerListener, IStoreItemClickListener {

    private final Inventory inventory;
    private final BigCookie bigCookie;
    private final CookieClickerApp app;
    private AutoHelperUpdateTimer updateTimer;
    private VerminSpawner verminSpawner;
    private GoldenCookieSpawner goldenCookieSpawner;
    private PowerUpTimer powerUpTimer;

    public PlayScreen(CookieClickerApp app) {
        this.app = app;
        inventory = new Inventory();
        bigCookie = new BigCookie(this);
        updateTimer = new AutoHelperUpdateTimer(this);
        verminSpawner = new VerminSpawner(this);
        goldenCookieSpawner = new GoldenCookieSpawner(this);
        powerUpTimer = new PowerUpTimer(this);
        CookieDashboard cookieDashboard = new CookieDashboard(inventory, powerUpTimer);
        HelpersDashboard helpersDashboard = new HelpersDashboard(inventory);
        StoreDashboard storeDashboard = new StoreDashboard(inventory, this);
        app.addGameObject(bigCookie, 350, 300);
        app.addDashboard(cookieDashboard);
        app.addDashboard(helpersDashboard);
        app.addGameObject(storeDashboard, 1);
        app.stats.setGameStartTime(LocalDateTime.now());
    }

    public void destroy() {
        updateTimer.stopAlarm();
        updateTimer = null;
        verminSpawner.stopAlarm();
        verminSpawner = null;
        goldenCookieSpawner.stopAlarm();
        goldenCookieSpawner = null;
        powerUpTimer.stopAlarm();
        powerUpTimer = null;
    }

    @Override
    public void onBigCookieClicked() {
        inventory.increaseCookieWalletByClick();
        app.stats.increaseTotalAmountOfClicks(inventory.getTotalCookiesPerClick());
    }

    @Override
    public void onAutoHelperUpdate() {
        inventory.increaseCookieWalletByAutoHelpers();
        app.stats.increaseTotalAmountOfCookies(inventory.getTotalCookiesPerSecond());
        if (app.getTotalCookiesNeeded() < inventory.getWallet().getCookiesInWallet()) {
            app.gameStateManager.setCurrentState(GameStateManager.GameState.END);
        }
    }

    @Override
    public void onVerminSpawnerTriggered() {
        app.addGameObject(new Vermin(bigCookie, app.getWidth(), app.getHeight(), this));
    }

    @Override
    public void onCookiesEatUpdate(float amount) {
        inventory.getWallet().decreaseCookiesInWallet(amount);
        app.stats.increaseTotalAmountOfCookiesEatenByVermin(amount);
    }

    @Override
    public void onVerminDied(Vermin vermin) {
        app.stats.IncreaseTotalAmountOfVerminDied();
        app.deleteGameObject(vermin);
    }

    @Override
    public void onGoldenCookieSpawnerTriggered() {
        app.addGameObject(new GoldenCookie(this, app.getWidth()));
        app.stats.increaseTotalAmountOfGoldenCookies();
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
    public void onStoreItemClicked(AutoHelper autoHelper) {
        app.stats.increaseTotalAmountOfHelpers();
        inventory.buyHelper(autoHelper);
    }

    @Override
    public void onUpgradeStoreItemClick(AutoHelper autoHelper) {
        inventory.buyUpgradeForHelper(autoHelper);
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
