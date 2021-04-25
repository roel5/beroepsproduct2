package nl.han.jlvo.cookieclicker.goldencookie;

public interface IGoldenCookieListener {
    void onCookieDissolve(GoldenCookie goldenCookie);
    void onMultiplyHelperPowerUp();
    void onMultiplyClickerPowerUp();
    void onIncreaseCookieWallet(int percentage);
}
