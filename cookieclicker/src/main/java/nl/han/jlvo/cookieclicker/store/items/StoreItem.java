package nl.han.jlvo.cookieclicker.store.items;

import nl.han.ica.oopg.objects.GameObject;
import nl.han.jlvo.cookieclicker.autohelper.AutoHelper;
import processing.core.PGraphics;

public class StoreItem extends GameObject {
    private final AutoHelper helper;
    private final IStoreItemClickListener clickListener;
    private final int x;
    private final int y;

    public StoreItem(int x, int y, AutoHelper helper, IStoreItemClickListener clickListener) {
        this.x = x;
        this.y = y;
        this.helper = helper;
        this.clickListener = clickListener;
        this.setWidth(50);
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
        pGraphics.rect(x, y, 50, 50);
        pGraphics.color(0);
        pGraphics.text(String.valueOf(helper.getHelperPrice()), x, y);
    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        super.mouseClicked(x, y, button);
        clickListener.onStoreItemClicked(helper);
    }
}
