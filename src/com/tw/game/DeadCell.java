package com.tw.game;

public class DeadCell implements Cell {
    private int aliveNeighbours;

    public DeadCell(int aliveNeighbours) {
        this.aliveNeighbours = aliveNeighbours;

    }

    public Cell nextState() {
        if (aliveNeighbours == 3)
            return new AliveCell(0);
        return this;
    }
}
