package ru.iakkov.project;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import ru.iakkov.project.entities.Entity;
import ru.iakkov.project.map.WorldMap;

public class Renderer {
    private final WorldMap worldMap;
    private final GridPane grid;
    private final Label[][] cells;

    public Renderer(WorldMap worldMap) {
        this.worldMap = worldMap;
        this.grid = new GridPane();
        this.cells = new Label[worldMap.getWidth()][worldMap.getHeight()];
        renderInitialGrid();
    }


    public void renderInitialGrid() {
        for (int y = 0; y < worldMap.getWidth(); y++) {
            for (int x = 0; x < worldMap.getHeight(); x++) {
                Label cell = new Label(".");
                cell.setMinSize(40, 40);
                cell.setAlignment(Pos.CENTER);
                cell.setStyle("-fx-border-color: gray;");
                grid.add(cell, x, y);
                cells[x][y] = cell;
            }
        }
    }

    public void render(WorldMap worldMap) {
        for (int y = 0; y < worldMap.getHeight(); y++) {
            for (int x = 0; x < worldMap.getWidth(); x++) {
                Entity entity = worldMap.getEntityAt(x, y);
                if (entity != null) {
                    System.out.print(entity.getSymbol());
                } else {
                    System.out.print(".");
                }
            }
            System.out.println();
        }
    }

    public void startRendering() {
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(1), event -> {
                    worldMap.nextTurn();
                    render(this.worldMap);
                })
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

    }

    public GridPane getGrid() {
        return grid;
    }

    public void renderWorld() {
        for (int y = 0; y < worldMap.getHeight(); y++) {
            for (int x = 0; x < worldMap.getWidth(); x++) {
                Entity entity = worldMap.getEntityAt(x, y);
                Label label = cells[y][x];
                if (entity != null) {
                    label.setText(String.valueOf(entity.getSymbol()));
                } else {
                    label.setText(".");
                }
            }
        }
    }
}