package org.itmo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
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
}
