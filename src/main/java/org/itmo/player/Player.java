package org.itmo.player;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.itmo.game.Cell;
import org.itmo.exceptions.CellAlreadyHitException;
import org.itmo.ship.Ship;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class Player {
    private final String name;
    private final List<Ship> ships;
    private final String[][] hitMap;

    public boolean hit(Cell cell) {
        String cellState = hitMap[cell.getRow()][cell.getCol()];
        if (cellState.equals("0") || cellState.equals("X")) {
            throw new CellAlreadyHitException("cell is already hit: " + cell);
        }

        hitMap[cell.getRow()][cell.getCol()] = "0";

        Ship hitShip = ships.stream().filter(ship -> ship.isHit(cell)).findAny().orElse(null);

        if (hitShip == null) {
            return false;
        }

        hitMap[cell.getRow()][cell.getCol()] = "X";

        if (!hitShip.isAlive()) {
            ships.remove(hitShip);
        }

        return true;
    }

    public void addShip(List<Ship> ships) {
        ships.forEach(ship -> {
            ship.getCells().forEach(c -> hitMap[c.getRow()][c.getCol()] = "S");
            this.ships.add(ship);
        });
    }

    public boolean isAlive() {
        return !ships.isEmpty();
    }
}
