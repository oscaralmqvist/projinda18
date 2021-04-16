package gameobjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * This class contains the Player controlled by the one playing the game.
 */
public class Player extends GameObject implements Movement {

    private float speed;
    private float jump;
    private boolean movingLeft;
    private boolean movingRight;
    private boolean canJump;

    /**
     *
     * @param x      The x-position (Spawn).
     * @param y      The y-position (Spawn).
     * @param width  The width of the Player.
     * @param height The height of the Player.
     */
    public Player(float x, float y, float width, float height) {
        super(x, y, width, height);
        speed = 8f;
        jump = 8f;
        setGravity(true);
        movingLeft = false;
        movingRight = false;
        canJump = true;
    }


    /**
     * Updates the movement.
     */
    @Override
    public void tick() {
        setY(getY() + getDy());
        setX(getX() + getDx());
        if (movingRight)
            setDx(speed);
        if (movingLeft)
            setDx(-speed);
        if (Math.abs(getDx()) < 0.5)
            setDx(0);
        frictionTick();
        gravityTick();
    }

    /**
     * Draws out the player. Different images are drawn out
     * depending on what direction the Player is running.
     * @param image The image to draw out.
     * @param gc    The canvas to draw on.
     */
    @Override
    public void draw(Image image, GraphicsContext gc) {
        if(movingLeft) {
            Spritesheet.drawImage(gc, image, 2, 1,  super.getWidth() +Math.round(super.getX()), Math.round(super.getY()), -super.getWidth(), super.getHeight());
        }
        else {
            Spritesheet.drawImage(gc, image, 2, 1, Math.round(super.getX()), Math.round(super.getY()), super.getWidth(), super.getHeight());
        }

    }

    /**
     * Makes the Player jump.
     */
    public void jump() {
        if (canJump && getDy() == 0.25) {
            setDy(getDy() - jump);
            setGravity(true);
            canJump = false;
        }
    }

    public void setCanJump(boolean canJump) {
        this.canJump = canJump;
    }

    public void setMovingLeft(boolean movingLeft) {
        setDx(-speed);
        this.movingLeft = movingLeft;
    }

    public void setMovingRight(boolean movingRight) {
        setDx(speed);
        this.movingRight = movingRight;
    }

    public float getSpeed() {
        return speed;
    }

    public float getJump() {
        return jump;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setJump(float jump) {
        this.jump = jump;
    }

}
