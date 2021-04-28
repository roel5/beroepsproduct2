package nl.han.jlvo.cookieclicker.store;

import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.jlvo.cookieclicker.autohelper.AutoHelper;
import nl.han.jlvo.cookieclicker.inventory.Inventory;
import nl.han.jlvo.cookieclicker.store.items.IStoreItemClickListener;
import nl.han.jlvo.cookieclicker.store.items.StoreItem;
import processing.core.PGraphics;

import java.util.ArrayList;

public class StoreDashboard extends Dashboard implements IStoreItemClickListener {

    private final Inventory inventory;
    private final ArrayList<StoreItem> items = new ArrayList<>();

    public StoreDashboard(Inventory inventory) {
        super(900, 200, 300, 600);
        this.inventory = inventory;
        setBackground(240, 248, 255);
        int yPos = 300;
        for (AutoHelper h : inventory.getHelpers()) {
            StoreItem item = new StoreItem(1025, yPos, h, this);
            items.add(item);
            yPos += 75;
        }
    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void draw(PGraphics g) {
        super.draw(g);
        for (StoreItem i: items) {
            i.draw(g);
        }
    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        super.mouseClicked(x, y, button);
        for (StoreItem i: items) {
            if (i.isPositionOnItem(x, y)) {
                i.mouseClicked(x, y, button);
                return;
            }
        }
    }

    @Override
    public void onStoreItemClicked(AutoHelper autoHelper) {
        inventory.buyHelper(autoHelper);
    }
}
