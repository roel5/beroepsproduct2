package nl.han.jlvo.cookieclicker.inventory;

import nl.han.jlvo.cookieclicker.autohelper.*;

public class Inventory {
    private final Wallet wallet;
    private final AutoHelper[] helpers;

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

    public void increaseCookieWallet() {
        MouseClicker mouseClicker = (MouseClicker) helpers[0];
        float amount = 1 + mouseClicker.getAmount();
        wallet.increaseCookiesInWallet(amount);
    }
}