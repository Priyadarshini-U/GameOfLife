package com.tw.game;

import java.util.ArrayList;
import java.util.List;

public class DeadCell extends Cell {

    public DeadCell(List<Cell> neighbours) {
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
        if (aliveNeighbours == 3)
            return new AliveCell(nextNeighbours);
        return this;
    }
}
