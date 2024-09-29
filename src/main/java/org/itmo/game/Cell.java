package org.itmo.game;

import lombok.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode
@RequiredArgsConstructor
public class Cell {
    private final int row;
    private final int col;

    public boolean betweenInOneD(Cell cell1, Cell cell2) {
        boolean inOneRow = row == cell1.getRow() && row == cell2.getRow();
        boolean inOneCol = col == cell1.getCol() && col == cell2.getCol();

        return between(cell1, cell2) && (inOneRow || inOneCol);
    }

    public boolean between(Cell cell1, Cell cell2) {
        int minRow = Math.min(cell1.getRow(), cell2.getRow());
        int minCol = Math.min(cell1.getCol(), cell2.getCol());
        int maxRow = Math.max(cell1.getRow(), cell2.getRow());
        int maxCol = Math.max(cell1.getCol(), cell2.getCol());

        return col >= minCol && col <= maxCol && row >= minRow && row <= maxRow;
    }

    public static List<Cell> cellsBetween(Cell cell1, Cell cell2) {
        List<Cell> cells = new LinkedList<>();

        int minRow = Math.min(cell1.getRow(), cell2.getRow());
        int minCol = Math.min(cell1.getCol(), cell2.getCol());
        int maxRow = Math.max(cell1.getRow(), cell2.getRow());
        int maxCol = Math.max(cell1.getCol(), cell2.getCol());

        for (int row = minRow; row <= maxRow; row++) {
            for (int col = minCol; col <= maxCol; col++) {
                cells.add(Cell.builder().row(row).col(col).build());
            }
        }

        return cells;
    }
}
