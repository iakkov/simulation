package ru.iakkov.project.entities;

public class Grass extends Entity  {
    public Grass(int x, int y) {
        super(x, y);
    }

    @Override
    public char getSymbol() {
        return 'G';
    }
}
