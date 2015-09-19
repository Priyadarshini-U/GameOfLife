package com.tw.game;

public class DeadCell implements Cell{
    private int aliveNeighbours;
    private Cell[] neighbours;

    public DeadCell(int aliveNeighbours, Cell[] neighbours) {
        this.aliveNeighbours = aliveNeighbours;
        this.neighbours = neighbours;
    }

    public Cell nextState() {
        if (aliveNeighbours == 3)
            return new AliveCell(0, neighbours);
        return this;
    }

    public int getNumberOfAliveNeighbours() {
        return 0;
    }
}
