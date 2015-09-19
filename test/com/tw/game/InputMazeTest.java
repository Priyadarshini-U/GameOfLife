package com.tw.game;

import org.junit.Test;

import static org.junit.Assert.*;

public class InputMazeTest {

    @Test
    public void shouldReturnCellThatIsBeyondInputSizeAsNull(){
        assertEquals(new InputMaze(null).getCell(1,1), null);
    }
}