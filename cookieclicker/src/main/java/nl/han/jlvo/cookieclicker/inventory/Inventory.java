package nl.han.jlvo.cookieclicker.inventory;

import nl.han.jlvo.cookieclicker.autohelper.*;

public class Inventory {
    private final Wallet wallet;
    private final AutoHelper[] helpers;
    private boolean isHelperPowerUpActive;
    private boolean isClickPowerUpActive;

    public Inventory() {
        wallet = new Wallet();
        wallet.increaseCookiesInWallet(10000);
        helpers = new AutoHelper[]{new MouseClicker(), new Grandma(), new CookieFarm(), new CookieMine(), new CookieFactory()};
    }

    public float getTotalCookiesPerSecond() {
        float totalCookiesPerSecond = 0;
        for (AutoHelper helper : helpers) {
            totalCookiesPerSecond += helper.calculateCookiesPerSecond();
        }
        if (isHelperPowerUpActive) {
            totalCookiesPerSecond = totalCookiesPerSecond * 2;
        }
        return totalCookiesPerSecond;
    }

    public AutoHelper[] getHelpers() {
        return helpers;
    }

    public AutoHelper getHelper(AutoHelperKind kind) {
        return helpers[kind.ordinal()];
    }

    public boolean buyHelper(AutoHelper helper) {
        boolean isPurchaseSuccessful = false;

        if (helper.getHelperPrice() <= wallet.getCookiesInWallet()) {
            wallet.decreaseCookiesInWallet(helper.getHelperPrice());
            helper.increaseHelper();
            isPurchaseSuccessful = true;
        }
        return isPurchaseSuccessful;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void increaseCookieWalletByClick() {
        MouseClicker mouseClicker = (MouseClicker) helpers[0];
        float amount = 1 + mouseClicker.getAmount();
        if (isClickPowerUpActive) {
            amount = amount * 2;
        }
        wallet.increaseCookiesInWallet(amount);
    }

    public void increaseCookieWalletByAutoHelpers() {
        wallet.increaseCookiesInWallet(getTotalCookiesPerSecond());
    }

    public void setHelperPowerUpActive(boolean helperPowerUpActive) {
        isHelperPowerUpActive = helperPowerUpActive;
    }

    public void setClickPowerUpActive(boolean clickPowerUpActive) {
        isClickPowerUpActive = clickPowerUpActive;
    }
}