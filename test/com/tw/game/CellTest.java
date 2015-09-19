package com.tw.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CellTest {

    @Test
    public void shouldReturnDeadState(){
        Cell cell = new Cell("dead",0,8);
        assertEquals(cell.nextState(), "dead");
    }
}