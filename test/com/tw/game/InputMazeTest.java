package com.tw.game;

import org.junit.Test;

import static org.junit.Assert.*;

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
}