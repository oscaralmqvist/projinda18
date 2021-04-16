package gameobjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * This class is handles the images used in the game and is
 *  used when drawing on the canvas
 */
public class Spritesheet {

    public static int rows = 10;
    public static int columns = 10;
    public static int subImageSize = 48;

    /**
     * Draws the image on the canvas.
     * @param gc     the canvas GraphicContext.
     * @param image  the gameobjects.Spritesheet.
     * @param row    the first row is defined as 1.
     * @param column the first column is defined as 1.
     * @param x      the position of the subimage in the x-axis.
     * @param y      the position of the subimage in the y-axis.
     * @param width  set the subimage width
     * @param height set the subimage height
     */
    public static void drawImage(GraphicsContext gc, Image image, int row, int column, float x, float y, float width, float height) {
        gc.drawImage(image, (column-1)*subImageSize, (row-1)*subImageSize, subImageSize, subImageSize, x, y, width, height);
    }

}
