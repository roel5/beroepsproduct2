package nl.han.jlvo.cookieclicker.store.items;

import nl.han.ica.oopg.objects.GameObject;
import nl.han.jlvo.cookieclicker.autohelper.AutoHelper;
import processing.core.PGraphics;

import java.text.DecimalFormat;

public class StoreItem extends GameObject {
    private final AutoHelper helper;
    private final IStoreItemClickListener clickListener;
    private final int x;
    private final int y;
    private final DecimalFormat decimalFormat;

    public StoreItem(int x, int y, AutoHelper helper, IStoreItemClickListener clickListener, DecimalFormat decimalFormat) {
        this.x = x;
        this.y = y;
        this.helper = helper;
        this.clickListener = clickListener;
        this.decimalFormat = decimalFormat;
        this.setWidth(300);
        this.setHeight(50);
    }

    @Override
    public void update() {

    }

    public boolean isPositionOnItem(int x, int y) {
        return x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height;
    }

    @Override
    public void draw(PGraphics pGraphics) {
        pGraphics.textAlign(LEFT);
        writeText(pGraphics, helper.getName(), x, y, 16);
        writeText(pGraphics, Float.parseFloat(decimalFormat.format(helper.getHelperPrice())) + " Koekjes", x, y + 20, 12);
        writeText(pGraphics, helper.getBaseCookiesPerSecond() + " KPS", x, y + 36, 12);
        if (!helper.isUpgraded()) {
            pGraphics.textAlign(RIGHT);
            writeText(pGraphics, "Upgrade KPS x 2", x + 270, y + 20, 12);
            writeText(pGraphics, helper.getUpgradePrice() + " Koekjes", x + 270, y + 36, 12);
        }
    }

    private void writeText(PGraphics pGraphics, String text, int x, int y, int textSize) {
        pGraphics.fill(0);
        pGraphics.textSize(textSize);
        pGraphics.text(text, x, y);
    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        super.mouseClicked(x, y, button);
        if (x > getCenterX() + 50) {
            clickListener.onUpgradeStoreItemClick(helper);
        } else {
            clickListener.onStoreItemClicked(helper);
        }
    }
}
