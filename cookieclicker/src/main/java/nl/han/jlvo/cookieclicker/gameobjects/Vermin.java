package nl.han.jlvo.cookieclicker.gameobjects;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import processing.core.PGraphics;
import java.util.List;

public class Vermin extends GameObject implements ICollidableWithGameObjects {

    @Override
    public void update() {

    }

    @Override
    public void draw(PGraphics pGraphics) {

    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject g : collidedGameObjects) {
            if (g instanceof BigCookie) {
                // TODO Eat cookies
            }
        }
    }
}
