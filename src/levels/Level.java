package levels;

import game.Game;
import gameobjects.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.transform.Affine;
import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.util.ArrayList;

/**
 * This handles the level, the "camera" and the ability to parse a level
 * from a txt-file.
 */
public class Level {

    private final static char GRASS_GROUND = 'g';
    private final static char DIRT  = 'd';
    private final static char BOUNCE = 'b';
    private final static char METAL_GROUND = 'm';
    private final static char METAL = 'n';
    private final static char SPIKE = 'e';
    private final static char GOAL = 'o';
    private final static char PLAYER = 'p';
    private final static char JUMP_BUFF = 'j';
    private final static char SPEED_BUFF = 'f';
    private final static char SLOW_BUFF = 's';

    private Image background;
    private Image spritesheet;
    private Player player;
    private ArrayList<Tile> tiles;
    private ArrayList<Tile> tilesWithAction;

    /**
     *
     * @param filename The filename of the txt-file.
     */
    public Level(String filename) {
        tiles = new ArrayList<>();
        tilesWithAction = new ArrayList<>();
        spritesheet = new Image(getClass().getResourceAsStream("/img/spritesheet2.png"));
        background = new Image(getClass().getResourceAsStream("/img/background.png"));
        loadLevel(filename);
    }

    /**
     * Reads from a txt-file.
     * @param filename The filename of the txt-file.
     */
    private void loadLevel(String filename)  {
        ArrayList<char[]> level = new ArrayList<>();
        try {
            InputStream is = getClass().getResourceAsStream("/mapdata/" + filename);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line = "";
            int i = 0;
            while (line != null) {
                line = br.readLine();
                if (line != null)
                    level.add(i, line.toCharArray());
                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        generateMapData(level);
    }

    /**
     * Adds every tile into the tiles ArrayList.
     * @param level The matrix containing every character in the file.
     */
    private void generateMapData(ArrayList<char[]> level) {
        for(int i = 0; i < level.size(); i++) {
            for(int j = 0; j < level.get(i).length; j++) {
                addTile(j * Spritesheet.subImageSize - j,
                        i * Spritesheet.subImageSize - i,
                        level.get(i)[j]);
            }
        }
    }

    /**
     * Draws every tile in the game based on where the Player is.
     * @param gc The canvas to draw on.
     */
    public void draw(GraphicsContext gc) {
        gc.drawImage(background, 0, 0, Game.WIDTH, Game.HEIGHT);
        Affine oldTransform = gc.getTransform();
        gc.translate(Math.round(-player.getX()) + ((Game.WIDTH/2)), Math.round(-player.getY())+((Game.HEIGHT/2)));
        player.draw(spritesheet, gc);
        for(Tile tile : tiles) {
            tile.draw(spritesheet, gc);
        }
        gc.setTransform(oldTransform);
    }

    /**
     * Adds a tile specified from the id.
     * @param x  The x-position.
     * @param y  The y-position.
     * @param id The character representing a tile.
     */
    private void addTile(int x, int y, char id) {
        switch(id) {
            case GRASS_GROUND:
                tiles.add(new Tile(1, 1, x, y, Spritesheet.subImageSize) );
                tilesWithAction.add(tiles.get(tiles.size()-1));
                break;
            case DIRT:
                tiles.add(new Tile(1, 2, x, y, Spritesheet.subImageSize));
                break;
            case METAL_GROUND:
                tiles.add(new Tile(1, 3, x, y, Spritesheet.subImageSize));
                tilesWithAction.add(tiles.get(tiles.size()-1));
                break;
            case METAL:
                tiles.add(new Tile(1, 4, x, y, Spritesheet.subImageSize));
                break;
            case SPIKE:
                tiles.add(new FatalTile(2, 2, x, y, Spritesheet.subImageSize));
                tilesWithAction.add(tiles.get(tiles.size()-1));
                break;
            case GOAL:
                tiles.add(new GoalTile(3, 1, x, y, Spritesheet.subImageSize));
                tilesWithAction.add(tiles.get(tiles.size()-1));
                break;
            case BOUNCE:
                tiles.add(new BounceTile(1, 5, x, y, Spritesheet.subImageSize));
                tilesWithAction.add(tiles.get(tiles.size()-1));
                break;
            case PLAYER:
                player = new Player(x, y, Spritesheet.subImageSize, Spritesheet.subImageSize);
                break;
            case JUMP_BUFF:
                tiles.add(new BuffTile(2, spritesheet, x, y, Spritesheet.subImageSize));
                tilesWithAction.add(tiles.get(tiles.size()-1));
                break;
            case SLOW_BUFF:
                tiles.add(new BuffTile(0, spritesheet, x, y, Spritesheet.subImageSize));
                tilesWithAction.add(tiles.get(tiles.size()-1));
                break;
            case SPEED_BUFF:
                tiles.add(new BuffTile(1, spritesheet, x, y, Spritesheet.subImageSize));
                tilesWithAction.add(tiles.get(tiles.size()-1));
                break;
        }
    }

    public Player getPlayer() {
        return player;
    }

    public ArrayList<Tile> getTilesWithAction() {
        return tilesWithAction;
    }
}
