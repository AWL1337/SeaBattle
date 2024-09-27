package org.itmo.ships.factory;

import lombok.RequiredArgsConstructor;
import org.itmo.Cell;
import org.itmo.ships.Ship;

@RequiredArgsConstructor
public class ShipFactory {
    private final int mapSize;
    private final int shipSize;

    public Ship createShip(Cell stern, boolean vertical) {
        return null;
    }
}
