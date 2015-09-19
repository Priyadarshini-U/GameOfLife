package com.tw.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {

    @Test
    public void shouldReturnDeadState(){
        Cell cell = new Cell("dead",0,8);
        assertEquals(cell.nextState(), "dead");
    }

    @Test
    public void shouldReturnNextStateAsCurrentState(){
        Cell cell = new Cell("alive",2,6);
        assertEquals(cell.nextState(), "alive");
    }

    @Test
    public void shouldReturnNextStateAsDeadIfAliveCellHasLessThanTwoAliveNeighbours(){
        Cell cell = new Cell("alive",1,6);
        assertEquals(cell.nextState(), "dead");
    }
}