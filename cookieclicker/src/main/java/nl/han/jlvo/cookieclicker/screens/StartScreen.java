package nl.han.jlvo.cookieclicker.screens;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.jlvo.cookieclicker.CookieClickerApp;
import nl.han.jlvo.cookieclicker.buttons.CookieAmountButton;
import nl.han.jlvo.cookieclicker.buttons.ICookieAmountButtonClickListener;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StartScreen implements ICookieAmountButtonClickListener {
    private final CookieClickerApp app;

    public StartScreen(CookieClickerApp app) {
        this.app = app;
        drawTitle();
        drawExplanation();
        drawCookieAmountButtons();
        drawCookie();
    }

    void drawTitle() {
        TextObject title = new TextObject("Cookie Clicker", 100);
        app.addGameObject(title, 50, 50);
    }

    void drawExplanation() {
        TextObject explanation = new TextObject("Cookie Clicker is een spel waarbij je koekjes kunt bakken.\nElke klik levert een koekje op. Je kan ook koekjes investeren in helpers die de koekjesproductie automatiseren\nPas goed op voor het ongedierte wat aan je gebakken koekjes komt knagen", 18);
        app.addGameObject(explanation, 50, 200);
    }

    void drawCookie() {
        SpriteObject cookie = new SpriteObject(new Sprite("cookieclicker/src/main/java/nl/han/jlvo/cookieclicker/resources/cookie.png")) {
            @Override
            public void update() {
            }

            @Override
            public void mouseClicked(int x, int y, int button) {
                super.mouseClicked(x, y, button);
                if (x > getX() && x < getX() + getWidth() && y > getY() && y < getY() + getHeight()) {
                    List<CookieAmountButton> buttons = getCookieAmountButtons();
                    Optional<CookieAmountButton> selectedButton = Optional.empty();
                    if (buttons != null) {
                        selectedButton = buttons.stream().filter(CookieAmountButton::isSelected).findFirst();
                    }
                    if (selectedButton.isPresent()) {
                        app.setTotalCookiesNeeded(selectedButton.get().getAmount());
                        app.gameStateManager.setCurrentState(GameStateManager.GameState.PLAY);
                    }
                }
            }
        };
        app.addGameObject(cookie, app.width - 300, app.height - 300);
    }

    void drawCookieAmountButtons() {
        TextObject explanation = new TextObject("Selecteer de hoeveelheid koekjes die je wilt behalen,\nklik daarna op het koekje om te beginnen", 18);
        app.addGameObject(explanation, 50, 400);
        CookieAmountButton cookieAmount100K = new CookieAmountButton(50, 500, 100000, this);
        CookieAmountButton cookieAmount1M = new CookieAmountButton(50, 600, 1000000, this);
        CookieAmountButton cookieAmount10M = new CookieAmountButton(50, 700, 10000000, this);

        app.addGameObject(cookieAmount100K);
        app.addGameObject(cookieAmount1M);
        app.addGameObject(cookieAmount10M);
    }

    @Override
    public void onCookieAmountButtonClicked(CookieAmountButton button) {
        List<CookieAmountButton> buttons = getCookieAmountButtons();
        if (buttons != null) {
            List<CookieAmountButton> unselectedButtons = buttons.stream().filter(b -> b != button).collect(Collectors.toList());
            unselectedButtons.forEach(b -> b.setSelected(false));

        }
    }

    private List<CookieAmountButton> getCookieAmountButtons() {
        return app.getGameObjectItems().stream().filter(g -> g instanceof CookieAmountButton).map(b -> (CookieAmountButton) b).collect(Collectors.toList());
    }
}
