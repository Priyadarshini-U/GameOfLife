package com.tw.game;

import org.junit.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.inOrder;
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

    @Test
    public void shouldReflectNextStateOfAllNeighbours() {
        final Cell neighbour1 = mock(AliveCell.class);
        final Cell neighbour2 = mock(AliveCell.class);
        final Cell neighbour3 = mock(AliveCell.class);
        Cell cell = new AliveCell(new ArrayList<Cell>() {{
            add(neighbour1);
            add(neighbour2);
            add(neighbour3);
        }});

        InOrder inOrder = inOrder(neighbour1, neighbour2, neighbour3);
        cell.nextState();
        inOrder.verify(neighbour1).nextState();
        inOrder.verify(neighbour2).nextState();
        inOrder.verify(neighbour3).nextState();
    }

    @Test
    public void shouldReflectNextStateOfAllNeighboursWhenNextStateIsAlive() {
        List<Cell> neighbours = new ArrayList<Cell>() {{
            add(new AliveCell(null));
            add(new AliveCell(null));
            add(new AliveCell(null));
        }};
        Cell cell = new DeadCell(neighbours);

        List<Cell> nextNeighbours = null;
        if (neighbours != null) {
            nextNeighbours = new ArrayList<Cell>();
            for (Cell neighbour : neighbours)
                nextNeighbours.add(neighbour.nextState());
        }
        Cell nextState = cell.nextState();
        assertEquals(new DeadCell(nextNeighbours).getNumberOfAliveNeighbours(), nextState.getNumberOfAliveNeighbours());
    }

    @Test
    public void shouldReflectNextStateOfAllNeighboursWhenNextStateIsDead() {
        List<Cell> neighbours = new ArrayList<Cell>() {{
            add(new AliveCell(null));
            add(new AliveCell(null));
            add(new AliveCell(null));
            add(new AliveCell(null));
        }};
        Cell cell = new DeadCell(neighbours);

        List<Cell> nextNeighbours = null;
        if (neighbours != null) {
            nextNeighbours = new ArrayList<Cell>();
            for (Cell neighbour : neighbours)
                nextNeighbours.add(neighbour.nextState());
        }
        Cell nextState = cell.nextState();
        assertEquals(new DeadCell(nextNeighbours).getNumberOfAliveNeighbours(), nextState.getNumberOfAliveNeighbours());
    }
}