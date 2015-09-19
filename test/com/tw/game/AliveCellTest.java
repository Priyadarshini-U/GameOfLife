package com.tw.game;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AliveCellTest {

    @Test
    public void shouldReturnAliveState() {
        Cell cell = new AliveCell(2, null);
        assertEquals(cell.nextState().getClass(), AliveCell.class);
    }

    @Test
    public void shouldReturnNextStateAsDeadIfAliveCellHasLessThanTwoAliveNeighbours() {
        Cell cell = new AliveCell(1, null);
        assertEquals(cell.nextState().getClass(), DeadCell.class);
    }

    @Test
    public void shouldReturnNextStateAsDeadIfAliveCellHasMoreThanThreeAliveNeighbours() {
        Cell cell = new AliveCell(4, null);
        assertEquals(cell.nextState().getClass(), DeadCell.class);
    }

    @Test
    public void shouldReturnZeroAsNoOfAliveNeighboursifNeighboursIsNull() {
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

    @Test
    public void shouldReturnNumberOfAliveNeighbours() {
        Cell cell = new AliveCell(4, new ArrayList<Cell>() {{
            add(new AliveCell(0, null));
            add(new AliveCell(0, null));
            add(new DeadCell(0, null));
        }});
        assertEquals(cell.getNumberOfAliveNeighbours(), 2);
    }
}