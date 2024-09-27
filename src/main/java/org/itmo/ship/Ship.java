package org.itmo.ship;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import org.itmo.game.Cell;

@EqualsAndHashCode
@AllArgsConstructor
public class Ship {

    private final Cell bow;
    private final Cell stern;
    private int health;

    public boolean isHit(Cell cell) {
        boolean hit = cell.between(bow, stern);
        if (hit) {
            health--;
        }
        return hit;
    }

    public boolean isAlive() {
        return health > 0;
    }
}
