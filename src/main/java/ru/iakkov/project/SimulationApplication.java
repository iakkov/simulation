package ru.iakkov.project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.iakkov.project.map.WorldMap;

public class SimulationApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        WorldMap worldMap = new WorldMap(10, 10);
        Renderer renderer = new Renderer(worldMap);

        Scene scene = new Scene(renderer.getGrid(), 600, 600);

        primaryStage.setTitle("Симуляция мира");
        primaryStage.setScene(scene);
        primaryStage.show();

        renderer.startRendering();
    }
}
