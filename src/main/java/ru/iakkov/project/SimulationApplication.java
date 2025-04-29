package ru.iakkov.project;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.iakkov.project.entities.creatures.Herbivore;
import ru.iakkov.project.entities.creatures.Predator;
import ru.iakkov.project.map.WorldMap;

public class SimulationApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        WorldMap worldMap = new WorldMap(10, 10);
        Renderer renderer = new Renderer(worldMap);

        Herbivore h = new Herbivore(1, 1, 1, 10);
        Predator p = new Predator(3, 3, 1, 15, 5);
        worldMap.addEntity(h, new Position(1, 1));
        worldMap.addEntity(p, new Position(3, 3));

        Scene scene = new Scene(renderer.getGrid(), 600, 600);

        primaryStage.setTitle("Симуляция мира");
        primaryStage.setScene(scene);
        primaryStage.show();

        renderer.renderWorld();

        renderer.startRendering();
    }
}