package org.itmo.ui;

import lombok.RequiredArgsConstructor;
import org.itmo.game.Cell;
import org.itmo.player.Player;

import java.util.List;
import java.util.Scanner;

@RequiredArgsConstructor
public class Console {
    private final int mapSize;

    public List<String> getNames() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1st player: ");
        String fName =  scanner.nextLine();

        System.out.println("2nd player: ");
        String SName =  scanner.nextLine();

        return List.of(fName, SName);
    }

    public Cell readCell() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("print cell to hit: ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        return new Cell(row, col);
    }


    public void showPlayerStatus(Player src, Player target) {
        System.out.println("Yours ships:");
        String[][] map = src.getHitMap();
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

        System.out.println(target.getName() + "'s map:");
        map = target.getHitMap();
        for (int i = 0; i < mapSize; i++) {
            for (int j = 0; j < mapSize; j++) {
                if (map[i][j].equals("S")) {
                    System.out.print("O");
                } else {
                    System.out.print(map[i][j]);
                }
            }
            System.out.println();
        }
    }
}
