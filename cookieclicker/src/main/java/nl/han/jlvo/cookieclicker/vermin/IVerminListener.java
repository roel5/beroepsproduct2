package nl.han.jlvo.cookieclicker.vermin;

public interface IVerminListener {
    void onCookiesEatUpdate(float amount);
    void onVerminDied(Vermin vermin);
}
