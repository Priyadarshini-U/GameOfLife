package com.tw.game;

import java.util.List;

public abstract class Cell {
    protected List<Cell> neighbours;

    abstract Cell nextState();

    public int getNumberOfAliveNeighbours() {
        int numberOfAliveNeighbours = 0;
        if (neighbours != null)
            for (Cell neighbour : neighbours) {
                if (neighbour.getClass().equals(AliveCell.class))
                    numberOfAliveNeighbours++;
            }
        return numberOfAliveNeighbours;
    }
}
