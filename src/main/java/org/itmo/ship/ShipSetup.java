package org.itmo.ship;

import lombok.RequiredArgsConstructor;
import org.itmo.game.Cell;
import org.itmo.ship.factory.ShipFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RequiredArgsConstructor
public class ShipSetup {
    private final List<ShipFactory> factories;
    private final List<Integer> amount;
    private final int mapSize;


    public List<Ship> getShips() {
        Random random = new Random();
        List<Ship> ships = new ArrayList<>();

        for (int type = 0; type < amount.size(); type++) {
            for (int i = 0; i < amount.get(type); i++) {
                Ship ship = null;
                while (checkCollision(ships, ship)) {
                    Cell cell = Cell.builder()
                            .row(random.nextInt(mapSize))
                            .col(random.nextInt(mapSize))
                            .build();

                    boolean vert = random.nextBoolean();

                    try {
                        ship = factories.get(type).createShip(cell, vert);
                    } catch (Exception e) {
                        ship = null;
                    }
                }
                ships.add(ship);
            }
        }

        return ships;
    }

    private boolean checkCollision(List<Ship> ships, Ship ship) {
        if (ship == null) return true;

        return ships.stream().anyMatch(s -> s.checkCollision(ship));
    }

}
