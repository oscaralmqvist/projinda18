package gameobjects;

import game.GameScene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import levels.Level;

/**
 * If the player collides with this block his stats will be changed (increased speed etc.)
 */

public class BuffTile extends Tile implements ActionHandler {

    private boolean taken = false;
    private Animation animation;
    private int buff;

    /**
     *
     * @param buff
     * @param image the spritesheet
     * @param x
     * @param y
     * @param tilesize the size of each block in the spritesheet and game.
     */

    public BuffTile(int buff, Image image, float x, float y, float tilesize) {
        super(1, 1, x, y, tilesize);
        this.buff = buff;
        animation = new Animation(3, 6);
        animation.addImage(4, 1+(buff*3));
        animation.addImage(4, 2+(buff*3));
        animation.addImage(4, 3+(buff*3));
    }

    /**
     * Depending on which buff is set for the object, the method will change the player stats. Currently the buff
     * goes from 0-2.
     * @param level
     * @param gameScene
     */
    @Override
    public void action(Level level, GameScene gameScene, int side) {
        if(taken)
            return;
        switch (buff) {
            case 0:
                level.getPlayer().setSpeed(level.getPlayer().getSpeed() - 2);
                break;
            case 1:
                level.getPlayer().setSpeed(level.getPlayer().getSpeed() + 2);

                break;
            case 2:
                level.getPlayer().setJump(level.getPlayer().getJump() + 1);
                break;
        }
        taken = true;
    }


    /**
     * Draw the image with an animation.
     * @param image the spritesheet
     * @param gc the graphicsContext in the canvas.
     */

    @Override
    public void draw(Image image, GraphicsContext gc) {
        if(taken)
            return;
        animation.drawImage(gc, image, getX(), getY(), getWidth(), getHeight());
    }
}
