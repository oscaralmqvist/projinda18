package game;

import gameobjects.Spritesheet;
import inputs.UserInput;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * This class starts the whole game by creating the tick-system and the gameloop.
 */

public class Game extends Application {

    public static String NAME;
    public static int WIDTH;
    public static int HEIGHT;

    public static void main(String[] args) {
        NAME = "DEMO 2D-platformer";
        WIDTH = 1280;
        HEIGHT = 720;
        Spritesheet.subImageSize = 48;
        Spritesheet.columns = 10;
        Spritesheet.rows = 10;
        launch(args);
    }

    /**
     * This method sets up the game-loop and the JavaFX-window. There is only one stage, scene and canvas.
     */

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle(NAME);
        primaryStage.setWidth(WIDTH);
        primaryStage.setHeight(HEIGHT);

        Group root = new Group();
        Scene primaryScene = new Scene(root);
        primaryStage.setScene(primaryScene);

        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        root.getChildren().add(canvas);

        GraphicsContext gc = canvas.getGraphicsContext2D();
        UserInput input = new UserInput();

        primaryScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                input.keyboardClick(e.getCode());
            }
        });

        primaryScene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                input.keyboardReleased(e.getCode());
            }
        });

        GameScene gamescene = new GameScene(input);

        final long startNanoTime = System.nanoTime();


        new AnimationTimer() {
            double lastTime = 0;
            public void handle(long currentNanoTime) {
                double t = (currentNanoTime - startNanoTime) / 1000000000.0;
                // background image clears canvas
                gc.clearRect(0, 0, WIDTH, HEIGHT);
                gc.fillRect(0, 0, 48, 48);
                gamescene.tick();
                gamescene.draw(gc);
                lastTime = t;

            }
        }.start();


        primaryStage.show();

    }
}
