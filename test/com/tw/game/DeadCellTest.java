package com.tw.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DeadCellTest {

    @Test
    public void shouldReturnDeadState() {
        Cell cell = new DeadCell(4, null);
        assertEquals(cell.nextState().getClass(), DeadCell.class);
    }

    @Test
    public void shouldReturnNextStateAsAliveIfDeadCellHasExactlyThreeAliveNeighbours() {
        Cell cell = new DeadCell(3, null);
        assertEquals(cell.nextState().getClass(), AliveCell.class);
    }

    @Test
    public void shouldReturnZeroAsNoOfAliveNeighboursifNeighboursIsNull(){
        Cell cell = new AliveCell(4, null);
        assertEquals(cell.getNumberOfAliveNeighbours(), 0);
    }
}