package org.itmo;

import org.itmo.game.factory.GameFactory;

public class Main {
    public static void main(String[] args) {

        GameFactory gameFactory = new GameFactory();

        gameFactory.createGame().start();
    }
}