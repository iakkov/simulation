package ru.iakkov.project;

import ru.iakkov.project.entities.creatures.Creature;
import ru.iakkov.project.entities.creatures.Herbivore;
import ru.iakkov.project.entities.creatures.Predator;
import ru.iakkov.project.map.WorldMap;

import java.util.ArrayList;
import java.util.List;

public class SimulationApplication {
    public static void main(String[] args) throws InterruptedException {
        WorldMap worldMap = new WorldMap(10, 10);
        List<Creature> creatures = new ArrayList<>();

        Herbivore herbivore = new Herbivore(1, 1, 1, 10);
        Predator predator = new Predator(3, 3, 1, 20, 5);

        worldMap.addEntity(herbivore, new Position(1, 1));
        worldMap.addEntity(predator, new Position(3, 3));

        creatures.add(herbivore);
        creatures.add(predator);

        Simulation sim = new Simulation(worldMap, creatures);
        sim.startSimulation(20, 500);
    }
}
