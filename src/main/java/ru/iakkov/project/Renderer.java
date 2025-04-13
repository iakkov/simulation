package ru.iakkov.project;

import ru.iakkov.project.entities.Entity;
import ru.iakkov.project.map.WorldMap;

public class Renderer {
    public void render(WorldMap worldMap) {
        for (int y = 0; y < worldMap.getWidth(); y++) {
            for (int x = 0; x < worldMap.getHeight(); x++) {
                Entity entity = worldMap.getEntityAt(x, y);
                if (entity != null) {
                    System.out.println(entity.getSymbol() + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
