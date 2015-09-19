package com.tw.game;

import java.util.List;

public class AliveCell extends Cell {

    public AliveCell(List<Cell> neighbours) {
        this.neighbours = neighbours;
    }

    public Cell nextState() {
        List<Cell> nextNeighbours = nextStateNeighbours();
        int aliveNeighbours = getNumberOfAliveNeighbours();
        if ((aliveNeighbours < 2) || (aliveNeighbours > 3))
            return new DeadCell(nextNeighbours);
        return new AliveCell(nextNeighbours);
    }
}
