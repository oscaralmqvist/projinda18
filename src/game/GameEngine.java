package game;

import gameobjects.ActionHandler;
import gameobjects.Spritesheet;
import gameobjects.Tile;
import levels.Level;
import gameobjects.Collision;

/**
 * GameEngine checks if any actions has been executed and updates the movement of all the objects.
 */

public class GameEngine {

    private Level level;
    private GameScene gamescene;

    public GameEngine(Level level, GameScene gamescene) {
        this.level = level;
        this.gamescene = gamescene;
    }

    /**
     * Update the game with gravity and their actions.
     */

    public void tick() {
        actions();
        move();
    }

    /**
     * Move the player with the players own tick-method that updates the position.
     */

    private void move() {
        level.getPlayer().tick();
    }

    /**
     * Every tile has an action. If the player collides with the block their action will be called.
     */

    private void actions() {
        for (Tile t : level.getTilesWithAction()) {
            int side = Collision.getCollisionSide(level.getPlayer(), t);
            if(side != 0) {
                t.action(level, gamescene, side);
            }
        }
    }
}
