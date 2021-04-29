package nl.han.jlvo.cookieclicker.store;

import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.jlvo.cookieclicker.autohelper.AutoHelper;
import nl.han.jlvo.cookieclicker.inventory.Inventory;
import nl.han.jlvo.cookieclicker.store.items.IStoreItemClickListener;
import nl.han.jlvo.cookieclicker.store.items.StoreItem;
import processing.core.PGraphics;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;

public class StoreDashboard extends Dashboard  {

    DecimalFormat decimalFormat = new DecimalFormat("#.#", DecimalFormatSymbols.getInstance(Locale.ENGLISH));
    private final IStoreItemClickListener clickListener;
    private final Inventory inventory;
    private final ArrayList<StoreItem> items = new ArrayList<>();
    private final TextObject title;

    public StoreDashboard(Inventory inventory, IStoreItemClickListener clickListener) {
        super(900, 200, 300, 600);
        setBackground(240, 248, 255);
        this.inventory = inventory;
        this.clickListener = clickListener;
        title = new TextObject("Shop", 30);
        drawStoreItems();
        drawTitle();
    }

    private void drawTitle() {
        addGameObject(title);
        title.setX(925);
        title.setY(225);
    }

    private void drawStoreItems() {
        int yPos = 300;
        for (AutoHelper h : inventory.getHelpers()) {
            StoreItem item = new StoreItem(925, yPos, h, clickListener, decimalFormat);
            items.add(item);
            addGameObject(item);
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
        title.draw(g);
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
}
