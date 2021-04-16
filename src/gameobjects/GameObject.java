package gameobjects;

import javafx.scene.shape.Rectangle;

/**
 * This class represents every object that is seen in-game.
 * Here we gather the object's position, speed and other variables having to do with every object.
 */
public abstract class GameObject implements Texture {

    public static final float GRAVITY_CONST = 0.25f;
    public static final float FRICTION_CONST = 0.2f;
    private float x;
    private float y;
    private float dx;
    private float dy;
    private float width;
    private float height;
    private boolean collision;
    private boolean gravity;

    /**
     * @param x      The x-position.
     * @param y      The y-position.
     * @param width  The width of the object.
     * @param height The height of the object.
     */
    public GameObject(float x, float y, float width, float height) {
        collision = false;
        gravity = false;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Updates gameobject with gravity.
     */
    public void gravityTick() {
        if (!gravity)
            return;
        dy += GRAVITY_CONST;
    }

    /**
     * Updates speed in the x-axis with a friction coefficient.
     */
    public void frictionTick() {
        if (dx > 0)
            dx -= FRICTION_CONST;
        else if (dx < 0)
            dx += FRICTION_CONST;
    }

    public boolean hasCollision() {
        return collision;
    }

    public void setCollision(boolean collision) {
        this.collision = collision;
    }

    public void hasGravity(boolean gravity) {
        this.gravity = gravity;
    }

    public void setGravity(boolean gravity) {
        this.gravity = gravity;
    }


    public Rectangle getRectangle() {
        return new Rectangle(x, y, width, height);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getDx() {
        return dx;
    }

    public float getDy() {
        return dy;
    }

    public void setDx(float dx) {
        this.dx = dx;
    }

    public void setDy(float dy) {
        this.dy = dy;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
