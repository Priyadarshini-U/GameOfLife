package com.tw.game;

import java.util.ArrayList;
import java.util.List;

public class AliveCell extends Cell {

    public AliveCell(List<Cell> neighbours) {
        this.neighbours = neighbours;
    }

    public Cell nextState() {
        List<Cell> nextNeighbours = null;
        if (neighbours != null) {
            nextNeighbours = new ArrayList<Cell>();
            for (Cell neighbour : neighbours)
                nextNeighbours.add(neighbour.nextState());
        }
        int aliveNeighbours = getNumberOfAliveNeighbours();
        if ((aliveNeighbours < 2) || (aliveNeighbours > 3))
            return new DeadCell(nextNeighbours);
        return this;
    }
}
