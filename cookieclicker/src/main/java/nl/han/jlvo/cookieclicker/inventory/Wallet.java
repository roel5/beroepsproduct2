package nl.han.jlvo.cookieclicker.inventory;

public class Wallet {
    private float cookiesInWallet;

    public float getCookiesInWallet() {
        return cookiesInWallet;
    }

    public void increaseCookiesInWallet(float amount) {
        cookiesInWallet += amount;
    }

    public void decreaseCookiesInWallet(float amount) {
        cookiesInWallet -= amount;
    }
}
