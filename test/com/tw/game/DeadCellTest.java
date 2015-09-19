package com.tw.game;

import org.junit.Test;

import java.util.ArrayList;

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

    @Test
    public void shouldReturnNeighbourListLenghtIfAllAreAliveCells() {
        Cell cell = new AliveCell(4, new ArrayList<Cell>() {{
            add(new AliveCell(0, null));
            add(new AliveCell(0, null));
        }});
        assertEquals(cell.getNumberOfAliveNeighbours(), 2);
    }
}