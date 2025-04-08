package ru.iakkov.project.entities.creatures;

import ru.iakkov.project.entities.Entity;

public abstract class Creature extends Entity {
    private int speed;
    private int health;

    public Creature(int x, int y, int speed, int health) {
        super(x, y);
        this.speed = speed;
        this.health = health;
    }
    public int getHealth() {
        return health;
    }
    public int getSpeed() {
        return speed;
    }
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void makeMove() {

    }
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health <= 0) {
            die();
        }
    }
}
