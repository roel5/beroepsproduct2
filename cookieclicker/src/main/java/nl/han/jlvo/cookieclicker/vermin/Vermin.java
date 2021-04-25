package nl.han.jlvo.cookieclicker.vermin;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.jlvo.cookieclicker.gameobjects.BigCookie;

import java.util.List;
import java.util.Random;

public class Vermin extends AnimatedSpriteObject implements ICollidableWithGameObjects {
    private static final int SPEED = 3;

    boolean isEating = false;
    final GameObject target;
    Direction direction;
    int health;
    int screenWidth;
    int screenHeight;

    public Vermin(GameObject target, int screenWidth, int screenHeight) {
        super(new Sprite("cookieclicker/src/main/java/nl/han/jlvo/cookieclicker/resources/spritesheet.png"), 8);
        this.target = target;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        generateDirection();
    }

    private void generateDirection() {
        int xPos = 600;
        int yPos = 400;
        int random = new Random().nextInt(8);
        switch (random) {
            case 0:
                direction = Direction.TOP;
                yPos = 0;
                xPos = screenWidth / 2;
                setCurrentFrameIndex(7);
                break;
            case 1:
                direction = Direction.TOP_RIGHT;
                yPos = 0;
                xPos = screenWidth;
                setCurrentFrameIndex(6);
                break;
            case 2:
                direction = Direction.RIGHT;
                yPos = screenHeight / 2;
                xPos = screenWidth;
                setCurrentFrameIndex(4);
                break;
            case 3:
                direction = Direction.BOTTOM_RIGHT;
                yPos = screenHeight;
                xPos = screenWidth;
                setCurrentFrameIndex(1);
                break;
            case 4:
                direction = Direction.BOTTOM;
                xPos = screenWidth / 2;
                yPos = screenHeight;
                setCurrentFrameIndex(2);
                break;
            case 5:
                direction = Direction.BOTTOM_LEFT;
                yPos = screenHeight;
                xPos = 0;
                setCurrentFrameIndex(0);
                break;
            case 6:
                direction = Direction.LEFT;
                yPos = screenHeight / 2;
                xPos = 0;
                setCurrentFrameIndex(3);
                break;
            case 7:
                direction = Direction.TOP_LEFT;
                yPos = 0;
                xPos = 0;
                setCurrentFrameIndex(5);
                break;
        }
        setX(xPos);
        setY(yPos);
        setSpeed(SPEED);
    }


    @Override
    public void update() {
        setDirection(getAngleFrom(target));
        if (isEating) {
            //TODO decrease cookies
        }
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject g : collidedGameObjects) {
            if (g instanceof BigCookie) {
                isEating = true;
                setDirectionSpeed(0, 0);
            }
        }
    }

    private enum Direction {
        TOP, TOP_RIGHT, RIGHT, BOTTOM_RIGHT, BOTTOM, BOTTOM_LEFT, LEFT, TOP_LEFT
    }
}
