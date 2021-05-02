package nl.han.jlvo.cookieclicker.autohelper;

public abstract class AutoHelper {
    private static final double PRICE_MULTIPLIER = 1.15;

    protected int basePrice;
    protected float baseCookiesPerSecond;
    protected int amount;
    protected boolean isUpgraded;
    protected String name;

    /**
     * Increase the amount of helpers by 1
     */
    public void increaseHelper() {
        amount++;
    }

    /**
     * @return price for the helper multiplied by amount of helpers
     */
    public float getHelperPrice() {
        return (float) (basePrice * Math.pow(PRICE_MULTIPLIER, amount));
    }

    /**
     * @return amount of cookies the AutoHelper generates per second
     */
    public float calculateCookiesPerSecond() {
        int multiplier = isUpgraded ? 2 : 1;
        return multiplier * (baseCookiesPerSecond * amount);
    }

    public float getBaseCookiesPerSecond(){
        return baseCookiesPerSecond;
    }

    public float getUpgradePrice() {
        return basePrice * 10;
    }

    public int getAmount() {
        return amount;
    }

    public String getName() {
        return name;
    }

    public boolean isUpgraded() {
        return isUpgraded;
    }

    public void setUpgraded(boolean upgraded) {
        isUpgraded = upgraded;
    }
}