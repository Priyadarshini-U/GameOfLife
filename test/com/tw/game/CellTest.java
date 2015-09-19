package com.tw.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {

    @Test
    public void shouldReturnDeadState(){
        Cell cell = new Cell("dead",0);
        assertEquals(cell.nextState(), "dead");
    }

    @Test
    public void shouldReturnNextStateAsCurrentState(){
        Cell cell = new Cell("alive",2);
        assertEquals(cell.nextState(), "alive");
    }

    @Test
    public void shouldReturnNextStateAsDeadIfAliveCellHasLessThanTwoAliveNeighbours(){
        Cell cell = new Cell("alive",1);
        assertEquals(cell.nextState(), "dead");
    }

    @Test
    public void shouldReturnNextStateAsDeadIfAliveCellHasMoreThanThreeAliveNeighbours(){
        Cell cell = new Cell("alive",4);
        assertEquals(cell.nextState(), "dead");
    }

    @Test
    public void shouldReturnNextStateAsAliveIfDeadCellHasExactlyThreeAliveNeighbours(){
        Cell cell = new Cell("dead",3);
        assertEquals(cell.nextState(), "alive");
    }
}