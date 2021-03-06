package com.tw.game;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class InputMazeTest {

    @Test
    public void shouldReturnCellThatIsBeyondInputSizeAsNull() {
        assertEquals(new InputMaze(null).getCell(1, 1), null);
    }

    @Test
    public void shouldReturnAliveCellThatIsWithInInputSize() {
        char input[][] = {
                {'x', '-'},
                {'x', '-'}
        };
        InputMaze inputMaze = new InputMaze(input);
        Cell cell = inputMaze.getCell(0, 0);
        assertEquals(cell.getClass(), AliveCell.class);
    }

    @Test
    public void shouldReturnDeadCellThatIsWithInInputSizeAndCharIsHyphen() {
        char input[][] = {
                {'x', '-'},
                {'x', '-'}
        };
        assertEquals(new InputMaze(input).getCell(1, 1).getClass(), DeadCell.class);
    }

    @Test
    public void shouldReturnCellNeighboursThatIsBeyondInputSizeAsNull() {
        assertEquals(new InputMaze(null).getCellNeighbours(1, 1), null);
    }

    @Test
    public void shouldReturnNonNullCellNeighboursThatIsWithInInputSize() {
        char input[][] = {
                {'x', '-'},
                {'x', '-'}
        };
        assertFalse(new InputMaze(input).getCellNeighbours(1, 1) == null);
    }

    @Test
    public void shouldReturnWithRightNeighbor() {
        char input[][] = {
                {'x', '-'},
                {'x', '-'}
        };

        InputMaze inputMaze = spy(new InputMaze(input));
        inputMaze.getCellNeighbours(0, 1);

        verify(inputMaze).getCell(1, 1);
    }

    @Test
    public void shouldReturnWithRightUpNeighbor() {
        char input[][] = {
                {'x', '-'},
                {'x', '-'}
        };

        InputMaze inputMaze = spy(new InputMaze(input));
        inputMaze.getCellNeighbours(0, 1);

        verify(inputMaze).getCell(1, 2);
    }

    @Test
    public void shouldReturnWithRightDownNeighbor() {
        char input[][] = {
                {'x', '-'},
                {'x', '-'}
        };

        InputMaze inputMaze = spy(new InputMaze(input));
        inputMaze.getCellNeighbours(0, 1);

        verify(inputMaze).getCell(1, 0);
    }

    @Test
    public void shouldReturnWithDownNeighbor() {
        char input[][] = {
                {'x', '-'},
                {'x', '-'}
        };

        InputMaze inputMaze = spy(new InputMaze(input));
        inputMaze.getCellNeighbours(0, 1);

        verify(inputMaze).getCell(0, 0);
    }

    @Test
    public void shouldReturnWithUpNeighbor() {
        char input[][] = {
                {'x', '-'},
                {'x', '-'}
        };

        InputMaze inputMaze = spy(new InputMaze(input));
        inputMaze.getCellNeighbours(0, 1);

        verify(inputMaze).getCell(0, 2);
    }

    @Test
    public void shouldReturnWithLeftNeighbor() {
        char input[][] = {
                {'x', '-'},
                {'x', '-'}
        };

        InputMaze inputMaze = spy(new InputMaze(input));
        inputMaze.getCellNeighbours(1, 1);

        verify(inputMaze).getCell(0, 1);
    }

    @Test
    public void shouldReturnWithLeftUpNeighbor() {
        char input[][] = {
                {'x', '-'},
                {'x', '-'}
        };

        InputMaze inputMaze = spy(new InputMaze(input));
        inputMaze.getCellNeighbours(1, 1);

        verify(inputMaze).getCell(0, 2);
    }

    @Test
    public void shouldReturnWithLeftDownNeighbor() {
        char input[][] = {
                {'x', '-'},
                {'x', '-'}
        };

        InputMaze inputMaze = spy(new InputMaze(input));
        inputMaze.getCellNeighbours(1, 1);

        verify(inputMaze).getCell(0, 0);
    }

    @Test
    public void shouldReturnAliveCellWithNeighboursOfInputWithInInputSize() {
        char input[][] = {
                {'x'}
        };
        InputMaze inputMaze = spy(new InputMaze(input));
        inputMaze.getCell(0, 0);

        verify(inputMaze).getCellNeighbours(0, 0);
    }

    @Test
    public void shouldReturnDeadCellWithNeighboursThatIsWithInInputSizeAndCharIsHyphen() {
        char input[][] = {
                {'-', '-'}
        };
        InputMaze inputMaze = spy(new InputMaze(input));
        inputMaze.getCell(0, 0);

        verify(inputMaze).getCellNeighbours(0,0);
    }

    @Test
    public void shouldCacheResultsAndNotCallAgainGetCellNeighboursAgain() {
        char input[][] = {
                {'x', '-'},
                {'x', '-'}
        };
        InputMaze inputMaze = spy(new InputMaze(input));
        inputMaze.getCell(0, 0);
        inputMaze.getCell(0, 0);

        verify(inputMaze, times(1)).getCellNeighbours(0,0);
    }
}