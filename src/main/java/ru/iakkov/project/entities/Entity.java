package ru.iakkov.project.entities;

import ru.iakkov.project.Position;

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
    public void setPosition(Position p) {
        this.x = p.getX();
        this.y = p.getY();
    }
    public abstract char getSymbol();


    public Position getPosition() {
        return new Position(x, y);
    }
}
