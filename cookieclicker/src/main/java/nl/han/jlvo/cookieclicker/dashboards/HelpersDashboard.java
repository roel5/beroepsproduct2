package nl.han.jlvo.cookieclicker.dashboards;

import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.jlvo.cookieclicker.inventory.Inventory;
import processing.core.PGraphics;

public class HelpersDashboard extends Dashboard {

    private final TextObject helpersDashboardText;
    Inventory inventory;

    public HelpersDashboard(Inventory inventory) {
        super(900, 0, 300, 200);
        this.inventory = inventory;
        helpersDashboardText = new TextObject("Autohelpers", 20);
        helpersDashboardText.setForeColor(255, 255, 255, 255);
        setBackground(0, 255, 0);
        addGameObject(helpersDashboardText);
    }

    @Override
    public void draw(PGraphics g) {
        super.draw(g);
        int x = (int) (getX() + 10);
        int y = 20;
        for (int i = 0; i < inventory.getHelpers().length; i++) {
            g.rect(x, y, 40, 40);
            x += 50;
            if (x + 60 - getX() > getWidth()) {
                y += 50;
                x = (int) (getX() + 10);
            }
        }
    }
}
