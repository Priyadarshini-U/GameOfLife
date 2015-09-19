package com.tw.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AliveCellTest {

    @Test
    public void shouldReturnAliveState(){
        Cell cell = new AliveCell(2, null);
        assertEquals(cell.nextState().getClass(), AliveCell.class);
    }

    @Test
    public void shouldReturnNextStateAsDeadIfAliveCellHasLessThanTwoAliveNeighbours(){
        Cell cell = new AliveCell(1, null);
        assertEquals(cell.nextState().getClass(), DeadCell.class);
    }

    @Test
    public void shouldReturnNextStateAsDeadIfAliveCellHasMoreThanThreeAliveNeighbours(){
        Cell cell = new AliveCell(4, null);
        assertEquals(cell.nextState().getClass(), DeadCell.class);
    }
}