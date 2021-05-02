package nl.han.jlvo.cookieclicker.buttons;

import nl.han.ica.oopg.objects.GameObject;
import processing.core.PGraphics;

public class CookieAmountButton extends GameObject {
    private static final int SIZE_BUTTON = 50;

    private boolean isSelected = false;
    private final int amount;
    private final int x;
    private final int y;
    private final ICookieAmountButtonClickListener clickListener;

    public CookieAmountButton(int x, int y, int amount, ICookieAmountButtonClickListener clickListener) {
        this.x = x;
        this.y = y;
        this.amount = amount;
        this.clickListener = clickListener;
        this.setWidth(250);
        this.setHeight(50);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(PGraphics pGraphics) {
        int textXPos = x + 60;
        int textYPos = (int) (y + getCenterY() - 12);

        if (isSelected) {
            pGraphics.fill(0);
        } else {
            pGraphics.fill(255);
        }
        pGraphics.rect(x, y, SIZE_BUTTON, SIZE_BUTTON);
        pGraphics.fill(0);
        pGraphics.text(amount + " koekjes", textXPos, textYPos);
    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        super.mouseClicked(x, y, button);
        if (x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height) {
            setSelected(true);
            clickListener.onCookieAmountButtonClicked(this);
        }
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public float getAmount() {
        return amount;
    }
}
