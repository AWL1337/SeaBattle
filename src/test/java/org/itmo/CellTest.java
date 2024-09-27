package org.itmo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {
    Cell cell = Cell.builder().col(5).row(5).build();

    @Test
    void between_line() {
        Cell cell1 = Cell.builder().col(2).row(5).build();
        Cell cell2 = Cell.builder().col(6).row(5).build();

        assertTrue(cell.between(cell1, cell2));
    }

    @Test
    void between_square() {
        Cell cell1 = Cell.builder().col(2).row(4).build();
        Cell cell2 = Cell.builder().col(6).row(5).build();

        assertTrue(cell.between(cell1, cell2));
    }

    @Test
    void betweenD_line() {
        Cell cell1 = Cell.builder().col(2).row(5).build();
        Cell cell2 = Cell.builder().col(6).row(5).build();

        assertTrue(cell.betweenInOneD(cell1, cell2));
    }

    @Test
    void betweenD_square() {
        Cell cell1 = Cell.builder().col(2).row(4).build();
        Cell cell2 = Cell.builder().col(6).row(5).build();

        assertFalse(cell.betweenInOneD(cell1, cell2));
    }

}