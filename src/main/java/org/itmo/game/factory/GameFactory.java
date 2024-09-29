package org.itmo.game.factory;

import org.itmo.game.Game;
import org.itmo.game.GameState;
import org.itmo.game.PlayerManager;
import org.itmo.game.RuleManager;
import org.itmo.player.factory.PlayerFactory;
import org.itmo.ship.ShipSetup;
import org.itmo.ship.factory.ShipFactory;
import org.itmo.ui.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameFactory {
    private final int mapSize = 10;
    private final int firstTurn = 0;
    private final Integer[] shipSizes = {1, 2, 3, 4};
    private final Integer[] shipAmounts = {4, 3, 2, 1};

    public Game createGame() {
        GameState state = new GameState(new ArrayList<>());
        PlayerFactory playerFactory = new PlayerFactory(mapSize);
        PlayerManager playerManager = new PlayerManager(state, new RuleManager(firstTurn), playerFactory);

        List<ShipFactory> shipFactories = new ArrayList<>();
        for (int i = 0; i < shipSizes.length; i++) {
            shipFactories.add(new ShipFactory(mapSize, shipSizes[i]));
        }

        ShipSetup shipSetup = new ShipSetup(shipFactories, Arrays.stream(shipAmounts).toList(), mapSize);

        return new Game(playerManager, new Console(mapSize), shipSetup);
    }
}
