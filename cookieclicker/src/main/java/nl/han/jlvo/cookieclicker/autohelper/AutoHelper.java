package nl.han.jlvo.cookieclicker.autohelper;

public abstract class AutoHelper {
    protected int basePrice;
    protected int baseCookiesPerSecond;
    protected int amount;
    protected boolean isUpgraded;

    float buyHelper(float cookieWallet) {
        float price = getHelperPrice();
        if (cookieWallet < price) return cookieWallet;
        amount++;
        return cookieWallet - price;
    }

    float getHelperPrice() {
        return (float) (basePrice + basePrice * (amount * 0.15));
    }

    float calculateCookiesPerSecond() {
        int multiplier = isUpgraded ? 2 : 1;
        return multiplier * (baseCookiesPerSecond * amount);
    }
}