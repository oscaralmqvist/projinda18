package game;

import inputs.UserInput;
import javafx.scene.canvas.GraphicsContext;
import levels.Level;

/**
 * The class that holds the current level and load others.
 */

public class GameScene {

    private Level level;
    private UserInput input;
    private GameEngine ge;
    private int currentLevel = 1;
    private int numberOfLevels = 4;

    public GameScene(UserInput input) {
        this.input = input;
        nextLevel();
    }

    /**
     * Update the gameengine.
     */

    public void tick() {
        ge.tick();
    }

    /**
     * Change the current level to the next. All levels must have "level(levelnumber).txt as their filename.
     */
    public void nextLevel() {
        if (currentLevel > numberOfLevels) {
            currentLevel = 1;
        }

        level = new Level("level" + currentLevel + ".txt");
        ge = new GameEngine(level, this);
        input.setCurrentLevel(level);
        currentLevel++;
    }

    /**
     * Restartes the currentlevel by loading everything from the level(levelnumber).txt file.
     */

    public void restartLevel() {
        level = new Level("level" + (currentLevel-1) + ".txt");
        ge = new GameEngine(level, this);
        input.setCurrentLevel(level);
    }

    /**
     * Draw the whole scene.
     * @param gc the graphicalContext of the canvas.
     */

    public void draw(GraphicsContext gc) {
        level.draw(gc);
    }


}
