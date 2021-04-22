package nl.han.jlvo.cookieclicker.autohelper;

public abstract class AutoHelper {
    protected int basePrice;
    protected float baseCookiesPerSecond;
    protected int amount;
    protected boolean isUpgraded;

    public float buyHelper(float cookieWallet) {
        float price = getHelperPrice();
        if (cookieWallet < price) return cookieWallet;
        amount++;
        return cookieWallet - price;
    }

    public float getHelperPrice() {
        return (float) (basePrice + basePrice * (amount * 0.15));
    }

    public float calculateCookiesPerSecond() {
        int multiplier = isUpgraded ? 2 : 1;
        return multiplier * (baseCookiesPerSecond * amount);
    }
}