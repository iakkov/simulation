package ru.iakkov.project.entities;

abstract public class Entity {
    private int x, y;

    public Entity(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public abstract char getSymbol();
}
