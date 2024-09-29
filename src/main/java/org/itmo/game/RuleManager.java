package org.itmo.game;

import lombok.AllArgsConstructor;
import org.itmo.player.Player;

@AllArgsConstructor
public class RuleManager {
    private int currentTarget;

    public void makeHit(GameState state, Cell cell) {
        Player player = state.getPlayers().get(currentTarget);
        if (player.hit(cell)) {

            if (!player.isAlive()) {
                state.getPlayers().remove(player);
            }

        } else {
            nextTurn(state);
        }
    }

    public int getCurrentPlayer(GameState state){
        return Math.abs(currentTarget - 1) % state.getPlayers().size();
    }

    public int getCurrentTarget(){
        return currentTarget;
    }

    public boolean isGameOver(GameState state) {
        return state.getPlayers().size() == 1;
    }

    private void nextTurn(GameState state) {
        currentTarget = (currentTarget + 1) % state.getPlayers().size();
    }
}
