package ru.iakkov.project;

import ru.iakkov.project.entities.creatures.Creature;
import ru.iakkov.project.map.WorldMap;
import java.util.List;

public class Simulation {
    private final WorldMap worldMap;
    private final Renderer renderer;
    private final List<Creature> creatures;

    public Simulation(WorldMap worldMap, List<Creature> creatures) {
        this.worldMap = worldMap;
        this.renderer = new Renderer();
        this.creatures = creatures;
    }
    public void nextTurn() {
        for (Creature creature : creatures) {
            creature.makeMove(worldMap);
        }
        renderer.render(worldMap);
    }
    public void startSimulation(int steps, long delayMs) throws InterruptedException {
        for (int i = 0; i < steps; i++) {
            System.out.println("Ход " + (i + 1));
            nextTurn();
            Thread.sleep(delayMs);
        }
    }
}
