package gameobjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * This interface is implemented by everything that needs to be drawn out on the canvas.
 */
public interface Texture {

    /**
     * Draw the image on the canvas.
     * @param image             The image.
     * @param graphicsContext   The canvas.
     */
    void draw(Image image, GraphicsContext graphicsContext);
}
