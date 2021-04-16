package gameobjects;

import game.GameScene;
import javafx.scene.image.Image;
import levels.Level;

/**
 * This class represents the tiles that kill you.
 */
public class FatalTile extends Tile implements ActionHandler {

    /**
     * @param spritesheetRow    What row in the spritesheet it's located in.
     * @param spritesheetColumn What column in the spritesheet it's located in.
     * @param x                 The x-position in-game.
     * @param y                 The y-position in-game.
     * @param tilesize          The size of the tile.
     */
    public FatalTile(int spritesheetRow, int spritesheetColumn, float x, float y, float tilesize) {
        super(spritesheetRow,spritesheetColumn, x, y, tilesize);
    }

    /**
     * Restarts the level.
     * @param level
     * @param gameScene
     * @param side
     */
    @Override
    public void action(Level level, GameScene gameScene, int side) {
        gameScene.restartLevel();
    }
}
