package gameobjects;

/**
 * This interface is to be implemented by classes that move.
 * (For now only the Player class).
 */
public interface Movement {

    /**
     * Updates the movement.
     */
    void tick();
}
