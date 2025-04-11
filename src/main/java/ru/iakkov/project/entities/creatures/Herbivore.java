package ru.iakkov.project.entities.creatures;

import ru.iakkov.project.Position;
import ru.iakkov.project.map.WorldMap;

public class Herbivore extends Creature {
    public Herbivore(int x, int y, int speed, int health) {
        super(x, y, speed, health);
    }

    @Override
    public void makeMove(WorldMap worldMap) {
        int x = getX();
        int y = getY();

        int newX = x;
        int newY = y;

        int side = (int) (Math.random() * 4);
        switch (side) {
            case 0 -> newY--;
            case 1 -> newY++;
            case 2 -> newX--;
            case 3 -> newX++;
        }
        Position newPosition = new Position(newX, newY);
        if (worldMap.isFree(newPosition)) {
            worldMap.moveEntity(this, newX, newY);
        }
    }

    @Override
    public char getSymbol() {
        return 'H';
    }
}
