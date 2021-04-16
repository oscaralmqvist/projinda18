package inputs;

import javafx.scene.input.KeyCode;
import levels.Level;

/**
 * This class handles the keyboard input from the user.
 */
public class UserInput {

    private Level currentLevel = null;

    public void setCurrentLevel(Level currentLevel) {
        this.currentLevel = currentLevel;
    }

    /**
     * Activates when a key is clicked.
     * @param keyCode The key pressed.
     */
    public void keyboardClick(KeyCode keyCode) {
        if (currentLevel == null)
            return;
        switch(keyCode) {
            case RIGHT:
            case D:
                currentLevel.getPlayer().setMovingRight(true);
                break;
            case LEFT:
            case A:
                currentLevel.getPlayer().setMovingLeft(true);
                break;
            case UP:
            case W:
            case SPACE:
                currentLevel.getPlayer().jump();
                break;
        }

    }

    /**
     * Activates when a key is released.
     * @param keyCode The key pressed.
     */
    public void keyboardReleased(KeyCode keyCode) {
        if (currentLevel == null)
            return;
        switch(keyCode) {
            case RIGHT:
            case D:
                currentLevel.getPlayer().setMovingRight(false);
                break;
            case LEFT:
            case A:
                currentLevel.getPlayer().setMovingLeft(false);
        }
    }
}
