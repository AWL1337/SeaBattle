package org.itmo.game;

import lombok.RequiredArgsConstructor;
import org.itmo.player.Player;

@RequiredArgsConstructor
public class RuleManager {
    private int currentPlayerToHit;

    public void makeHit(GameState state, Cell cell) {
        Player player = state.getPlayers().get(currentPlayerToHit);
        if (player.hit(cell)) {

            if (!player.isAlive()) {
                state.getPlayers().remove(player);
            }

        } else {
            nextTurn(state);
        }
    }

    public boolean isGameOver(GameState state) {
        return state.getPlayers().size() == 1;
    }

    private void nextTurn(GameState state) {
        currentPlayerToHit = (currentPlayerToHit + 1) % state.getPlayers().size();
    }
}
