package ru.iakkov.project.entities;

public class Tree extends Entity {
    public Tree(int x, int y) {
        super(x, y);
    }

    @Override
    public char getSymbol() {
        return 'T';
    }
}