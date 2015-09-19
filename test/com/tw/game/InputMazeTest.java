package com.tw.game;

import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class InputMazeTest {

    @Test
    public void shouldReturnCellThatIsBeyondInputSizeAsNull(){
        assertEquals(new InputMaze(null).getCell(1,1), null);
    }

    @Test
    public void shouldReturnAliveCellThatIsWithInInputSize(){
        char input[][] = {
                {'x','-'},
                {'x','-'}
        };
        assertEquals(new InputMaze(input).getCell(0,0).getClass(), AliveCell.class);
    }

    @Test
    public void shouldReturnDeadCellThatIsWithInInputSizeAndCharIsHyphen(){
        char input[][] = {
                {'x','-'},
                {'x','-'}
        };
        assertEquals(new InputMaze(input).getCell(1,1).getClass(), DeadCell.class);
    }

    @Test
    public void shouldReturnCellNeighboursThatIsBeyondInputSizeAsNull(){
        assertEquals(new InputMaze(null).getCellNeighbours(1, 1), null);
    }

    @Test
    public void shouldReturnNonNullCellNeighboursThatIsWithInInputSize(){
        char input[][] = {
                {'x','-'},
                {'x','-'}
        };
        assertFalse(new InputMaze(input).getCellNeighbours(1, 1) == null);
    }

    @Test
    public void shouldReturnWithRightNeighbor(){
        char input[][] = {
                {'x','-'},
                {'x','-'}
        };

        InputMaze inputMaze = spy(new InputMaze(input));
        inputMaze.getCellNeighbours(0, 1);

        verify(inputMaze).getCell(1, 1);
    }

    @Test
    public void shouldReturnWithRightUpNeighbor(){
        char input[][] = {
                {'x','-'},
                {'x','-'}
        };

        InputMaze inputMaze = spy(new InputMaze(input));
        inputMaze.getCellNeighbours(0, 1);

        verify(inputMaze).getCell(1, 2);
    }
}