package ru.iakkov.project.entities.creatures;

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

    }

    @Override
    public char getSymbol() {
        return 'P';
    }
}
