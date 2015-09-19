package com.tw.game;

import java.util.List;

public class AliveCell implements Cell {
    private List<Cell> neighbours;

    public AliveCell(List<Cell> neighbours) {
        this.neighbours = neighbours;
    }

    public Cell nextState() {
        int aliveNeighbours = getNumberOfAliveNeighbours();
        if ((aliveNeighbours < 2) || (aliveNeighbours > 3))
            return new DeadCell(neighbours);
        return this;
    }

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
