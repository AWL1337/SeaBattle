package org.itmo.game;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.itmo.player.Player;

import java.util.List;

@Getter
@RequiredArgsConstructor
public class GameState {
    private final List<Player> players;
}
