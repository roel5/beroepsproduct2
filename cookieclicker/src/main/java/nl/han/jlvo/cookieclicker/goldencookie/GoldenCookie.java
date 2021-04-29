package nl.han.jlvo.cookieclicker.goldencookie;


import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

import java.time.LocalDateTime;
import java.util.Random;

public class GoldenCookie extends SpriteObject {
    private static final int TTL = 7;

    private final Random random;
    private PowerUpKind powerUpKind;
    private final IGoldenCookieListener listener;
    private final LocalDateTime aliveSince;
    private final int screenWidth;

    public GoldenCookie(IGoldenCookieListener listener, int screenWidth) {
        super(new Sprite("cookieclicker/src/main/java/nl/han/jlvo/cookieclicker/resources/goldencookie.png"));
        this.listener = listener;
        aliveSince = LocalDateTime.now();
        this.random = new Random();
        this.screenWidth = screenWidth;
        selectPowerUp();
        setPosition();
    }

    private void setPosition() {
        setX(random.nextInt(700));
        setY(-100);
        setDirectionSpeed(180, 1);
    }

    @Override
    public void update() {
        if (aliveSince.plusSeconds(TTL).isBefore(LocalDateTime.now())) {
            listener.onCookieDissolve(this);
        }
    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        super.mouseClicked(x, y, button);
        if (x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height) {
            switch (powerUpKind) {
                case EXTRA_5:
                    listener.onIncreaseCookieWallet(5);
                    break;
                case EXTRA_10:
                    listener.onIncreaseCookieWallet(10);
                    break;
                case EXTRA_30:
                    listener.onIncreaseCookieWallet(30);
                    break;
                case MULTIPLY_HELPER:
                    listener.onMultiplyHelperPowerUp();
                    break;
                case MULTIPLY_CLICK:
                    listener.onMultiplyClickerPowerUp();
                    break;
            }
            listener.onCookieDissolve(this);
        }
    }

    private void selectPowerUp() {
        int pos = random.nextInt(5);
        switch (pos) {
            case 1:
                powerUpKind = PowerUpKind.EXTRA_5;
                break;
            case 2:
                powerUpKind = PowerUpKind.EXTRA_10;
                break;
            case 3:
                powerUpKind = PowerUpKind.EXTRA_30;
                break;
            case 4:
                powerUpKind = PowerUpKind.MULTIPLY_HELPER;
                break;
            default:
                powerUpKind = PowerUpKind.MULTIPLY_CLICK;
                break;
        }
    }
}

