package ru.iakkov.project.entities.creatures;

import ru.iakkov.project.Position;
import ru.iakkov.project.entities.Entity;
import ru.iakkov.project.map.WorldMap;

public class Predator extends Creature {
    private int attackPower;
    public Predator(int x, int y, int speed, int health, int powerAttack) {
        super(x, y, speed, health);
        this.attackPower = powerAttack;
    }
    public void attack(Herbivore aim) {
        aim.takeDamage(attackPower);
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
        Entity entityAtTarget = worldMap.getEntityAt(newX, newY);
        if (entityAtTarget instanceof Herbivore herbivore) {
            attack(herbivore);
            if (herbivore.getHealth() <= 0) {
                worldMap.removeEntity(herbivore);
            }
        } else if (worldMap.isFree(newPosition)) {
            worldMap.moveEntity(this, newX, newY);
        }
    }

    @Override
    public char getSymbol() {
        return 'P';
    }
}
