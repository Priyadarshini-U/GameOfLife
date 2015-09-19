package com.tw.game;

import java.util.List;

public class AliveCell implements Cell {
    private int aliveNeighbours;
    private List<Cell> neighbours;

    public AliveCell(int aliveNeighbours, List<Cell> neighbours) {
        this.aliveNeighbours = aliveNeighbours;
        this.neighbours =neighbours;
    }

    public Cell nextState() {
        if ((aliveNeighbours < 2) || (aliveNeighbours > 3))
            return new DeadCell(0, neighbours);
        return this;
    }

    public int getNumberOfAliveNeighbours() {
        if(neighbours != null)
            return neighbours.size();
        return 0;
    }
}
