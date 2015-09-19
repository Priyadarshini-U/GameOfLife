package com.tw.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeadCellTest {

    @Test
    public void shouldReturnDeadState() {
        Cell cell = new DeadCell(4);
        assertEquals(cell.nextState().getClass(), DeadCell.class);
    }

    @Test
    public void shouldReturnNextStateAsAliveIfDeadCellHasExactlyThreeAliveNeighbours() {
        Cell cell = new DeadCell(3);
        assertEquals(cell.nextState().getClass(), AliveCell.class);
    }
}