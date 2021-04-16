package gameobjects;

import game.GameScene;
import levels.Level;

/**
 * The action method should be called when the player collides with another gameobject.
 */

public interface ActionHandler {

    /**
     *
     * @param level the level of the game.
     * @param gameScene the canvas of the game.
     * @param side which side of the block it collided with (0-4), didn't collide,top, right, bottom and left.
     */
    void action(Level level, GameScene gameScene, int side);
}
