package com.tw.game;

public class AliveCell implements Cell {
    private int aliveNeighbours;
    private Cell[] neighbours;

    public AliveCell(int aliveNeighbours, Cell[] neighbours) {
        this.aliveNeighbours = aliveNeighbours;
        this.neighbours =neighbours;
    }

    public Cell nextState() {
        if ((aliveNeighbours < 2) || (aliveNeighbours > 3))
            return new DeadCell(0, neighbours);
        return this;
    }
}
