package sample;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Sphere;
import javafx.stage.Stage;

public class Main extends Application {

    private static final int WIDTH = 1400;
    private static final int HEIGHT = 800;
    private static final String TITLE = "3D JAVAFX ENGINE";

    @Override
    public void start(Stage primaryStage) {
        Sphere box = new Sphere(50);
        Group group1 = new Group();
        group1.getChildren().addAll(box);
        Camera cam = new PerspectiveCamera();
        Scene sc = new Scene(group1,WIDTH,HEIGHT);
        sc.setCamera(cam);
        sc.setFill(Color.ROYALBLUE);
        box.translateXProperty().set(WIDTH/2);
        box.translateYProperty().set(HEIGHT/2);
        primaryStage.setScene(sc);
        primaryStage.setTitle(TITLE);
        primaryStage.show();

        primaryStage.addEventHandler(javafx.scene.input.KeyEvent.KEY_PRESSED,event ->
        {
            switch (event.getCode())
            {
                case Q:
                    box.translateZProperty().set(box.getTranslateZ() -10);
                    break;
                case E:
                    box.translateZProperty().set(box.getTranslateZ() +10);
                    break;
                case W:
                    box.translateYProperty().set(box.getTranslateY() -10);
                    break;
                case S:
                    box.translateYProperty().set(box.getTranslateY() +10);
                    break;
                case A:
                    box.translateXProperty().set(box.getTranslateX() -10);
                    break;
                case D:
                    box.translateXProperty().set(box.getTranslateX() +10);
                    break;
            }
        });
    }


    public static void main(String[] args) {
        launch(args);
    }
}
