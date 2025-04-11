package ru.iakkov.project.map;

import ru.iakkov.project.Position;
import ru.iakkov.project.entities.Entity;

import java.util.HashMap;
import java.util.Map;

public class WorldMap {
    private final int width;
    private final int height;
    private final Map<Position, Entity> entities;

    public WorldMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.entities = new HashMap<>();
    }

    public boolean isFree(Position p) {
        return !entities.containsKey(p);
    }

    void addEntity(Entity e, Position p) {
        if(isFree(p)) {
            entities.put(p, e);
            e.setPosition(p);
        }
    }

    Entity getEntityAt(int x, int y) {
        return entities.get(new Position(x, y));
    }

    void removeEntity(Entity e) {
        Position position = e.getPosition();
        if (entities.containsKey(position) && entities.get(position).equals(e)) {
            entities.remove(position);
        }
    }
    public boolean moveEntity(Entity e, int newX, int newY) {
        Position newPosition = new Position(newX, newY);
        if (newX < 0 || newX >= width || newY < 0 || newY >= height) { //Проверка на границы карты, чтобы потом не запутаться
            return false;
        }
        if (!isFree(newPosition)) {
            return false;
        }
        entities.remove(e.getPosition());
        e.setPosition(newPosition);
        entities.put(newPosition, e);
        return true;
    }
}
