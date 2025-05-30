package ru.iakkov.project.map;

import ru.iakkov.project.Position;
import ru.iakkov.project.entities.Entity;
import ru.iakkov.project.entities.creatures.Creature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    public int getWidth() {
        return width;
    }
    public int getHeight() {
        return height;
    }

    public boolean isFree(Position p) {
        return !entities.containsKey(p);
    }

    public void addEntity(Entity e, Position p) {
        if(isFree(p)) {
            entities.put(p, e);
            e.setPosition(p);
        }
    }

    public Entity getEntityAt(int x, int y) {
        return entities.get(new Position(x, y));
    }

    public void removeEntity(Entity e) {
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

    public void nextTurn() {
        List<Entity> allEntities = new ArrayList<>(entities.values());
        for (Entity entity : allEntities) {
            if (entity instanceof Creature creature) {
                creature.makeMove(this);
            }
        }
    }
}