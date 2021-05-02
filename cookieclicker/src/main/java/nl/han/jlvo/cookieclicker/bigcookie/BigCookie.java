package nl.han.jlvo.cookieclicker.bigcookie;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class BigCookie extends SpriteObject {
    private static final int POWER = 2;
    private static final String SPRITE_FILE_LOCATION = "cookieclicker/src/main/java/nl/han/jlvo/cookieclicker/resources/cookie.png";

    private final IBigCookieClickListener clickListener;

    public BigCookie(IBigCookieClickListener clickListener) {
        super(new Sprite(SPRITE_FILE_LOCATION));

        this.clickListener = clickListener;
    }

    @Override
    public void update() {
    }

    /**
     * Calculate if the mouse position is actually on the round cookie
     */
    @Override
    public void mouseClicked(int x, int y, int button) {
        super.mouseClicked(x, y, button);
        double a = Math.pow(x - getCenterX(), POWER);
        double b = Math.pow(y - getCenterY(), POWER);
        if (Math.sqrt(a + b) < getWidth() / 2) {
            clickListener.onBigCookieClicked();
        }
    }
}
