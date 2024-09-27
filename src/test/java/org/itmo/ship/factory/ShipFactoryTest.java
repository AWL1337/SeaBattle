package org.itmo.ship.factory;

import org.itmo.game.Cell;
import org.itmo.exceptions.ShipOutOfBoundsException;
import org.itmo.ship.Ship;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShipFactoryTest {
    private final ShipFactory shipFactory = new ShipFactory(10, 1);
    private final Cell startCell = Cell.builder().col(0).row(0).build();

    @Test
    void createShip_ok() {
        Ship res = shipFactory.createShip(startCell, false);
        Ship expected = new Ship(Cell.builder().row(0).col(1).build(),
                Cell.builder().row(0).col(0).build(), 1);

        assertEquals(expected, res);
    }

    @Test
    void createShip_shipOutOfBounds() {

        assertThrows(ShipOutOfBoundsException.class,
                () -> shipFactory.createShip(startCell, true));
    }
}