package com.tw.game;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DeadCellTest {

    @Test
    public void shouldReturnDeadState() {
        Cell cell = new DeadCell(null);
        assertEquals(cell.nextState().getClass(), DeadCell.class);
    }

    @Test
    public void shouldReturnNextStateAsAliveIfDeadCellHasExactlyThreeAliveNeighbours() {
        Cell cell = new DeadCell(new ArrayList<Cell>() {{
            add(new AliveCell(null));
            add(new AliveCell(null));
            add(new AliveCell(null));
            add(new DeadCell(null));
        }});
        assertEquals(cell.nextState().getClass(), AliveCell.class);
    }

    @Test
    public void shouldReturnZeroAsNoOfAliveNeighboursifNeighboursIsNull(){
        Cell cell = new DeadCell(null);
        assertEquals(cell.getNumberOfAliveNeighbours(), 0);
    }

    @Test
    public void shouldReturnNeighbourListLenghtIfAllAreAliveCells() {
        Cell cell = new DeadCell(new ArrayList<Cell>() {{
            add(new AliveCell(null));
            add(new AliveCell(null));
        }});
        assertEquals(cell.getNumberOfAliveNeighbours(), 2);
    }

    @Test
    public void shouldReturnNumberOfAliveNeighbours() {
        Cell cell = new DeadCell(new ArrayList<Cell>() {{
            add(new AliveCell(null));
            add(new AliveCell(null));
            add(new DeadCell(null));
        }});
        assertEquals(cell.getNumberOfAliveNeighbours(), 2);
    }

    @Test
    public void shouldReflectNextStateOfFirstNeighbour() {
        final Cell neighbour = mock(AliveCell.class);
        Cell cell = new AliveCell(new ArrayList<Cell>() {{
            add(neighbour);
        }});

        cell.nextState();
        verify(neighbour).nextState();
    }
}