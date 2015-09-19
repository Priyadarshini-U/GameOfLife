//cell has neighbours and gives its next state
package com.tw.game;

import java.util.ArrayList;
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

    public List<Cell> nextStateNeighbours() {
        List<Cell> nextNeighbours = null;
        if (neighbours != null) {
            nextNeighbours = new ArrayList<Cell>();
            for (Cell neighbour : neighbours)
                nextNeighbours.add(neighbour.nextState());
        }
        return nextNeighbours;
    }
}
