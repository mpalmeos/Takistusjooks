package Takistusjooks.MainGame;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Created by Maie on 08/10/2016.
 */
public class Game extends Application {
    @Override

    public void start(Stage primaryStage) throws Exception {
        StackPane stack = new StackPane();
        Scene scene = new Scene(stack, 150, 150);
        primaryStage.setScene(scene);

        Circle ring = new Circle(30);
        stack.getChildren().add(ring);

        primaryStage.show();
    }
}
