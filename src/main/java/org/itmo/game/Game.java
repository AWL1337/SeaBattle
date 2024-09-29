package org.itmo.game;

import lombok.RequiredArgsConstructor;
import org.itmo.exceptions.CellAlreadyHitException;
import org.itmo.ship.ShipSetup;
import org.itmo.ui.Console;

@RequiredArgsConstructor
public class Game {
    private final PlayerManager playerManager;
    private final Console console;
    private final ShipSetup shipSetup;


    public void start() {
        console.getNames().forEach(name -> {
            playerManager.addPlayer(name).addShip(shipSetup.getShips());
        });


        while (!playerManager.isOver()) {
            console.showPlayerStatus(playerManager.getPlayer(), playerManager.getTargetPlayer());
            try {
                playerManager.hit(console.readCell());
            } catch (CellAlreadyHitException e) {
                console.Print(e.getMessage());
                continue;
            }
            console.Wait();
        }
    }
}
