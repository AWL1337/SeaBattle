package org.itmo.player;

import lombok.RequiredArgsConstructor;
import org.itmo.game.Cell;
import org.itmo.exceptions.CellAlreadyHitException;
import org.itmo.ship.Ship;

import java.util.HashMap;
import java.util.List;

@RequiredArgsConstructor
public class Player {
    private final String name;
    private final List<Ship> ships;
    private final HashMap<Cell, Boolean> hitMap;

    public boolean hit(Cell cell) {
        if (hitMap.containsKey(cell)) {
            throw new CellAlreadyHitException("cell is already hit: " + cell);
        }

        hitMap.put(cell, true);
        return ships.stream().anyMatch(ship -> {
            boolean res = ship.isHit(cell);
            if (res) {

                if (!ship.isAlive()) {
                    ships.remove(ship);
                }

            }
            return res;
        });
    }

    public boolean isAlive() {
        return !ships.isEmpty();
    }
}
