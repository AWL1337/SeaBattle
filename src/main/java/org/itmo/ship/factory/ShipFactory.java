package org.itmo.ship.factory;

import lombok.RequiredArgsConstructor;
import org.itmo.game.Cell;
import org.itmo.exceptions.ShipOutOfBoundsException;
import org.itmo.ship.Ship;

@RequiredArgsConstructor
public class ShipFactory {
    private final int mapSize;
    private final int shipSize;

    public Ship createShip(Cell stern, boolean vertical) {
        Cell mapStart = Cell.builder().row(0).col(0).build();
        Cell mapEnd = Cell.builder().row(mapSize - 1).col(mapSize - 1).build();

        Cell bow;
        if (vertical) {
            bow = Cell.builder().row(stern.getRow() - shipSize).col(stern.getCol()).build();
        } else {
            bow = Cell.builder().row(stern.getRow()).col(stern.getCol() + shipSize).build();
        }

        if (!stern.between(mapStart, mapEnd)) {
            throw new ShipOutOfBoundsException("stern is out of bounds: " + stern);
        }

        if (!bow.between(mapStart, mapEnd)) {
            throw new ShipOutOfBoundsException("bow is out of bounds: " + bow);
        }

        return new Ship(bow, stern, shipSize);
    }
}
