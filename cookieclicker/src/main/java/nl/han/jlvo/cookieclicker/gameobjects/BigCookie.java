package nl.han.jlvo.cookieclicker.gameobjects;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

public class BigCookie extends SpriteObject {

    private final IBigCookieClickListener clickListener;

    public BigCookie(IBigCookieClickListener clickListener) {
        super(new Sprite("cookieclicker/src/main/java/nl/han/jlvo/cookieclicker/resources/cookie.png"));
        this.clickListener = clickListener;
    }

    @Override
    public void update() {

    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        super.mouseClicked(x, y, button);
        clickListener.onBigCookieClicked();
    }
}
