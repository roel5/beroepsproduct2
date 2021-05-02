package nl.han.jlvo.cookieclicker.buttons;

import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.jlvo.cookieclicker.statistics.IPlayAgainClickListener;
import processing.core.PGraphics;

public class PlayAgainButton extends GameObject {
    private final IPlayAgainClickListener clickListener;
    private final int x;
    private final int y;
    private final int width;
    private final int height;
    private Boolean isMouseOnButton = false;

    public PlayAgainButton(IPlayAgainClickListener clickListener, int x, int y) {
        this.x = x;
        this.y = y;
        this.width = 200;
        this.height = 75;
        this.clickListener = clickListener;
        TextObject buttonText = new TextObject("Play Again", 20);
        buttonText.setForeColor(255, 255, 255, 255);
    }

    @Override
    public void update() {
    }

    @Override
    public void draw(PGraphics pGraphics) {
        if (isMouseOnButton) {
            pGraphics.fill(100,150, 100);
        } else {
            pGraphics.fill(200, 255, 200);
        }
        pGraphics.rect(x, y, width, height);
        pGraphics.textAlign(CENTER);
        pGraphics.textSize(20);
        pGraphics.fill(0);
        pGraphics.text("Play Again", x + width / 2, y + height / 2);
    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        super.mouseClicked(x, y, button);
        if (isMouseOnButton(x, y)) {
            clickListener.onPlayAgainButtonClicked();
        }
    }

    @Override
    public void mouseMoved(int x, int y) {
        super.mouseMoved(x, y);
        isMouseOnButton = isMouseOnButton(x, y);
    }

    /**
     * @param mouseX x position of the mouse
     * @param mouseY y position of the mouse
     * @return if the mouse position is actually on the button
     */
    private boolean isMouseOnButton(int mouseX, int mouseY) {
        return mouseX >= this.x && mouseX <= this.x + width && mouseY >= this.y && mouseY <= this.y + height;
    }
}
