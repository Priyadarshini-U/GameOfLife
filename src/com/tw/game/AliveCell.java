package com.tw.game;

public class AliveCell implements Cell {
    private int aliveNeighbours;

    public AliveCell(int aliveNeighbours) {
        this.aliveNeighbours = aliveNeighbours;

    }

    public Cell nextState() {
        if ((aliveNeighbours < 2) || (aliveNeighbours > 3))
            return new DeadCell(0);
        return this;
    }
}
