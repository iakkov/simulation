package ru.iakkov.project.entities.creatures;

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
    public void makeMove() {

    }

    @Override
    public char getSymbol() {
        return 'P';
    }
}
