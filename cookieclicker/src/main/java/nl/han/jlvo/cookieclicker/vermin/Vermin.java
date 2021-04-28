package nl.han.jlvo.cookieclicker.vermin;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.AnimatedSpriteObject;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.jlvo.cookieclicker.bigcookie.BigCookie;

import java.util.List;
import java.util.Random;

public class Vermin extends AnimatedSpriteObject implements ICollidableWithGameObjects {
    boolean isEating = false;
    final GameObject target;
    private Direction direction;
    private int health;
    private final int screenWidth;
    private final int screenHeight;
    private final IVerminListener verminListener;
    private final Random random;

    public Vermin(GameObject target, int screenWidth, int screenHeight, IVerminListener verminListener) {
        super(new Sprite("cookieclicker/src/main/java/nl/han/jlvo/cookieclicker/resources/spritesheet.png"), 8);
        this.target = target;
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.verminListener = verminListener;
        random = new Random();
        health = random.nextInt(10);
        setDirection();
    }

    private void setDirection() {
        int xPos;
        int yPos;
        int spriteFrameIndex;
        int position = random.nextInt(8);
        switch (position) {
            case 1:
                direction = Direction.TOP_RIGHT;
                yPos = 0;
                xPos = screenWidth;
                spriteFrameIndex = 7;
                break;
            case 2:
                direction = Direction.RIGHT;
                yPos = screenHeight / 2;
                xPos = screenWidth;
                spriteFrameIndex = 4;
                break;
            case 3:
                direction = Direction.BOTTOM_RIGHT;
                yPos = screenHeight;
                xPos = screenWidth;
                spriteFrameIndex = 1;
                break;
            case 4:
                direction = Direction.BOTTOM;
                xPos = screenWidth / 2;
                yPos = screenHeight;
                spriteFrameIndex = 2;
                break;
            case 5:
                direction = Direction.BOTTOM_LEFT;
                yPos = screenHeight;
                xPos = 0;
                spriteFrameIndex = 3;
                break;
            case 6:
                direction = Direction.LEFT;
                yPos = screenHeight / 2;
                xPos = 0;
                spriteFrameIndex = 5;
                break;
            case 7:
                direction = Direction.TOP_LEFT;
                yPos = 0;
                xPos = 0;
                spriteFrameIndex = 0;
                break;
            default:
                direction = Direction.TOP;
                yPos = 0;
                xPos = screenWidth / 2;
                spriteFrameIndex = 0;
                break;
        }
        setX(xPos);
        setY(yPos);
        setCurrentFrameIndex(spriteFrameIndex);
        setSpeed(random.nextInt(5) + 1);
    }

    @Override
    public void update() {
        setDirection(getAngleFrom(target));
        if (isEating) {
            verminListener.onCookiesEatUpdate(random.nextInt(4));
        }
    }

    @Override
    public void mouseClicked(int x, int y, int button) {
        super.mouseClicked(x, y, button);
        if (x >= this.x && x <= this.x + this.width && y >= this.y && y <= this.y + this.height) {
            health--;
            if (health <= 0) {
                verminListener.onVerminDied(this);
            }
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
