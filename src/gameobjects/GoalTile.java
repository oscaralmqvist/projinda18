package gameobjects;

import game.GameScene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import levels.Level;

/**
 * Represents the tile that makes the player win.
 */
public class GoalTile extends Tile implements ActionHandler {

    private Animation goalAnimation;

    /**
     *
     * @param spritesheetRow    The row in which it's located in the spritesheet.
     * @param spritesheetColumn The column in which it's located in the spritesheet.
     * @param x                 The x-position.
     * @param y                 The y-position.
     * @param tilesize          The size of the tile.
     */
    public GoalTile(int spritesheetRow, int spritesheetColumn, float x, float y, float tilesize) {
        super(spritesheetRow, spritesheetColumn, x, y, tilesize);
        goalAnimation = new Animation(4,3);
        goalAnimation.addImage(3, 1);
        goalAnimation.addImage(3, 2);
        goalAnimation.addImage(3, 3);
        goalAnimation.addImage(3, 4);
    }

    /**
     * Changes to the next level.
     * @param level     The current level.
     * @param gameScene The current gamescene.
     * @param side      The side that this tile is touched on.
     */
    @Override
    public void action(Level level, GameScene gameScene, int side) {
        gameScene.nextLevel();
    }


    /**
     * Draws the object inside the game.
     * @param image
     * @param gc
     */
    @Override
    public void draw(Image image, GraphicsContext gc) {
        goalAnimation.drawImage(gc, image, getX(), getY(), getWidth(), getHeight());
    }
}
