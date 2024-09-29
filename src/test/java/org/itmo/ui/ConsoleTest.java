package org.itmo.ui;

import org.itmo.game.Cell;
import org.itmo.player.Player;
import org.itmo.player.factory.PlayerFactory;
import org.itmo.ship.factory.ShipFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConsoleTest {
    private final Console console = new Console(10);
    private final PlayerFactory factory = new PlayerFactory(10);
    private final ShipFactory shipFactory = new ShipFactory(10, 2);
    private final Player player = factory.createPlayer("aa");

    @Test
    void showPlayerStatus() {
        player.addShip(List.of(shipFactory.createShip(Cell.builder().col(0).row(1).build(), false)));
        player.hit(Cell.builder().col(0).row(0).build());
        console.showPlayerStatus(player, player);
    }
}