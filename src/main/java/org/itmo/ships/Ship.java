package org.itmo.ships;

import lombok.RequiredArgsConstructor;
import org.itmo.Cell;

@RequiredArgsConstructor
public class Ship {

    private final Cell bow;
    private final Cell stern;

    public boolean checkHit(Cell cell) {
        return false;
    }
}
