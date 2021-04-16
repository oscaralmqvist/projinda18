package gameobjects;

import game.GameScene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import levels.Level;

/**
 * Default tile with basic collision.
 */
public class Tile extends GameObject implements ActionHandler {
    private int spritesheetRow;
    private int spritesheetColumn;

    /**
     *
     * @param spritesheetRow    The row in which it's located in the spritesheet.
     * @param spritesheetColumn The column in which it's located in the spritesheet.
     * @param x                 The x-position.
     * @param y                 The y-position.
     * @param tilesize          The size of the tile.
     */
    public Tile(int spritesheetRow, int spritesheetColumn, float x, float y, float tilesize) {
        super(x, y, tilesize, tilesize);
        this.spritesheetRow = spritesheetRow;
        this.spritesheetColumn = spritesheetColumn;
        super.setCollision(true);
        super.setGravity(false);
    }

    /**
     * Draw out on the canvas.
     * @param image The image.
     * @param gc    The canvas.
     */
    @Override
    public void draw(Image image, GraphicsContext gc) {
        Spritesheet.drawImage(gc, image, spritesheetRow, spritesheetColumn, getX(), getY(), getWidth(), getHeight());
    }

    /**
     * Makes the tile have collision.
     * @param level     The current level.
     * @param gameScene The gamescene.
     * @param side      What side the collision happened on.
     */
    @Override
    public void action(Level level, GameScene gameScene, int side) {
        switch (side) {
            case 2:
                if(level.getPlayer().getDx() < 0) {
                    level.getPlayer().setDx(0);
                    level.getPlayer().setX(getX() + Spritesheet.subImageSize);
                }
                break;
            case 4:
                if(level.getPlayer().getDx() > 0) {
                    level.getPlayer().setDx(0);
                    level.getPlayer().setX(getX()- Spritesheet.subImageSize);
                }
                break;
            case 1:
                if(level.getPlayer().getDy() >= 0) {
                    level.getPlayer().setDy(0);
                    level.getPlayer().setY(getY()- Spritesheet.subImageSize);
                    level.getPlayer().setCanJump(true);
                }
                break;
        }
    }
}
