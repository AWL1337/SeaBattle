package org.itmo.ship;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.itmo.game.Cell;

import java.util.List;

@Getter
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

    public List<Cell> getCells() {
        return Cell.cellsBetween(bow, stern);
    }

    public boolean checkCollision(Ship ship) {
        Cell newBow = Cell.builder()
                .row(bow.getRow() - 1)
                .col(bow.getCol() + 1)
                .build();

        Cell newStern = Cell.builder()
                .row(stern.getRow() + 1)
                .col(stern.getCol() - 1)
                .build();

        return ship.getBow().between(newBow, newStern) || ship.getStern().between(newBow, newStern);
    }
}
