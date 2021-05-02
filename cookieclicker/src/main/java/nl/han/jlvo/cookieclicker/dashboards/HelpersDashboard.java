package nl.han.jlvo.cookieclicker.dashboards;

import nl.han.ica.oopg.dashboard.Dashboard;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.jlvo.cookieclicker.autohelper.AutoHelper;
import nl.han.jlvo.cookieclicker.inventory.Inventory;
import processing.core.PGraphics;

public class HelpersDashboard extends Dashboard {
    private static final int PADDING_X = 50;
    private static final int PADDING_Y = 50;

    private final Inventory inventory;

    public HelpersDashboard(Inventory inventory) {
        super(900, 0, 300, 200);
        this.inventory = inventory;
        TextObject helpersDashboardText = new TextObject("Autohelpers", 20);
        helpersDashboardText.setForeColor(255, 255, 255, 255);
        setBackground(124, 185, 232);
        addGameObject(helpersDashboardText);
    }

    @Override
    public void draw(PGraphics g) {
        super.draw(g);
        g.textAlign(CENTER);
        g.fill(0);
        g.text("Helper Overzicht", getX() + getWidth() / 2, 20);
        int x = (int) (getX() + 20);
        int y = 50;
        AutoHelper[] helpers = inventory.getHelpers();
        for (AutoHelper helper : helpers) {
            g.textSize(15);
            g.text(helper.getName(), x, y, 70, 20);
            g.text(helper.getAmount(), x + 35, y + 40);
            x += 90;
            if (x + PADDING_X - getX() > getWidth()) {
                y += PADDING_Y;
                x = (int) (getX() + PADDING_X);
            }
        }
    }
}
