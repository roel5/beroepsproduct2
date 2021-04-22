package nl.han.jlvo.cookieclicker.dashboards;

import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.jlvo.cookieclicker.gameobjects.IStoreDashboardClickListener;
import nl.han.jlvo.cookieclicker.inventory.Inventory;

public class StoreDashboard extends Dashboard {

    private final Inventory inventory;
    private final IStoreDashboardClickListener clickListener;

    public StoreDashboard(Inventory inventory, IStoreDashboardClickListener clickListener) {
        super(300, 175, 200, 325);
        this.inventory = inventory;
        this.clickListener = clickListener;

    }

    @Override
    public void update() {
        super.update();
    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        super.mouseClicked(x, y, button);
        if (x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight()) {
            clickListener.onBuyGrandmaClicked();
        }
    }
}
