package nl.han.jlvo.cookieclicker.autohelper;

public abstract class AutoHelper {
    private static final double PRICE_MULTIPLIER = 0.15;

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
        return (float) (basePrice + basePrice * (amount * PRICE_MULTIPLIER));
    }

    public float calculateCookiesPerSecond() {
        int multiplier = isUpgraded ? 2 : 1;
        return multiplier * (baseCookiesPerSecond * amount);
    }

    public int getAmount() {
        return amount;
    }
}