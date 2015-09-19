package com.tw.game;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputMazeTest {

    @Test
    public void shouldReturnCellThatIsBeyondInputSizeAsNull(){
        assertEquals(new InputMaze(null).getCell(1,1), null);
    }

    @Test
    public void shouldReturnAliveCellThatIsWithInInputSizeAsNull(){
        char input[][] = {
                {'x','-'},
                {'x','-'}
        };
        assertEquals(new InputMaze(input).getCell(1,1).getClass(), AliveCell.class);
    }
}