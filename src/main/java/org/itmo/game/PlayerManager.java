package org.itmo.game;

import lombok.RequiredArgsConstructor;
import org.itmo.player.Player;
import org.itmo.player.factory.PlayerFactory;

@RequiredArgsConstructor
public class PlayerManager {
    private final GameState gameState;
    private final RuleManager ruleManager;
    private final PlayerFactory playerFactory;

    public Player getPlayer() {
        return gameState.getPlayers().get(ruleManager.getCurrentPlayer(gameState));
    }

    public Player getTargetPlayer() {
        return gameState.getPlayers().get(ruleManager.getCurrentTarget());
    }

    public Player addPlayer(String name) {
        Player player = playerFactory.createPlayer(name);
        gameState.getPlayers().add(player);
        return player;
    }

    public void hit(Cell cell) {
        ruleManager.makeHit(gameState, cell);
    }

    public boolean isOver() {
        return ruleManager.isGameOver(gameState);
    }
}
