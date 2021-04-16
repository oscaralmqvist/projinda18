package gameobjects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

/**
 * Switches several pictures so it creates an animation.
 */

public class Animation {

    private int[][] images;
    private int currentTick;
    private int currentImage;
    private int ticks;

    /**
     * @param numPictures The amount of different images.
     * @param ticks The amount of ticks between each image change.
     */

    public Animation(int numPictures, int ticks) {
        images = new int[numPictures][2];
        this.ticks = ticks;
        currentTick = 0;
        currentImage = 0;
    }

    /**
     * Add the position of the image in a spritesheet.
     * @param row the row always starts at 1.
     * @param column the column always start at 1.
     */

    public void addImage(int row, int column) {
        int i = 0;
        while(i < images.length) {
            if(images[i][0] == 0 && images[i][1] == 0) {
                images[i][0] = row;
                images[i][1] = column;
                break;
            }
            i++;
        }
    }

    /**
     * The method draws the image each time it is called. This method should be called every frame of the game.
     * @param g The canvas graphicsContext.
     * @param image The spritesheet
     * @param x The x-position in the canvas
     * @param y The y-position in the canvas
     * @param width the width of the image
     * @param height the height of the image.
     */

    public void drawImage(GraphicsContext g, Image image, float x, float y, float width, float height) {
        if(currentTick >= ticks) {
            currentImage++;
            currentTick = 0;
            if(currentImage > images.length-1) {
                currentImage = 0;
            }
        }
        Spritesheet.drawImage(g, image, images[currentImage][0], images[currentImage][1], x, y, width, height);
        currentTick++;
    }

}
