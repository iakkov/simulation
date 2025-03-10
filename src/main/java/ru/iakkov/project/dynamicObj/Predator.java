package ru.iakkov.project.dynamicObj;

public class Predator extends Creature {
    private int powerAttack;
    public Predator(int x, int y, int speed, int health, int powerAttack) {
        super(x, y, speed, health);
        this.powerAttack = powerAttack;
    }
    public void toAttack(Herbivore aim) {
        aim.setHealth(aim.getHealth() - powerAttack);
    }
}
