package org.itmo.player.factory;

import lombok.RequiredArgsConstructor;
import org.itmo.player.Player;

import java.util.LinkedList;

@RequiredArgsConstructor
public class PlayerFactory {
    private final int mapSize;
    public Player createPlayer(String name) {
        String[][] map = new String[mapSize][mapSize];

        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                map[i][j] = "O";
            }
        }

        return new Player(name, new LinkedList<>(), map);
    }
}
