package ru.iakkov.project.actions;

import ru.iakkov.project.entities.Entity;
import ru.iakkov.project.map.WorldMap;
import java.util.function.Supplier;

public class InitAction extends Action {
    private final WorldMap worldMap;
    private final Supplier<Entity> entitySupplier;
    private final int count;

    public InitAction(WorldMap worldMap, Supplier<Entity> entitySupplier, int count) {
        this.worldMap = worldMap;
        this.entitySupplier = entitySupplier;
        this.count = count;
    }

    @Override
    public void perform() {

    }
}