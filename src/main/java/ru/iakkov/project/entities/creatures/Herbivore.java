package ru.iakkov.project.entities.creatures;

public class Herbivore extends Creature {
    public Herbivore(int x, int y, int speed, int health) {
        super(x, y, speed, health);
    }

    @Override
    public void makeMove() {

    }

    @Override
    public char getSymbol() {
        return 'H';
    }
}
