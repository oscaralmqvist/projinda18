package gameobjects;

import game.GameScene;
import javafx.scene.image.Image;
import levels.Level;

/**
 * If the player lands on top of the BounceTile, he should be shot up in the air.
 */

public class BounceTile extends Tile implements ActionHandler {

    /**
     *
     * @param spritesheetRow
     * @param spritesheetColumn
     * @param x
     * @param y
     * @param tilesize the size of each block in the spritesheet and game.
     */

    public BounceTile(int spritesheetRow, int spritesheetColumn, float x, float y, float tilesize) {
        super(spritesheetRow, spritesheetColumn, x, y, tilesize);
    }

    /**
     * If the player touches top he shoots up. Left and right collison just makes him not go through the block.
     * @param level the level of the game.
     * @param gameScene the canvas of the game.
     * @param side which side of the block it collided with (0-4), didn't collide,top, right, bottom and left.
     */

    @Override
    public void action(Level level, GameScene gameScene, int side) {
        switch (side) {
            case 2:
                if (level.getPlayer().getDx() < 0) {
                    level.getPlayer().setDx(0);
                    level.getPlayer().setX(getX() + Spritesheet.subImageSize);
                }

                break;
            case 4:
                if (level.getPlayer().getDx() > 0) {
                    level.getPlayer().setDx(0);
                    level.getPlayer().setX(getX() - Spritesheet.subImageSize);
                }
                break;
            case 1:
                level.getPlayer().setDy(-level.getPlayer().getDy());
                break;
        }
    }
}
