package com.tw.game;

import java.util.List;

public class DeadCell implements Cell{
    private int aliveNeighbours;
    private List<Cell> neighbours;

    public DeadCell(int aliveNeighbours, List<Cell> neighbours) {
        this.aliveNeighbours = aliveNeighbours;
        this.neighbours = neighbours;
    }

    public Cell nextState() {
        if (aliveNeighbours == 3)
            return new AliveCell(0, neighbours);
        return this;
    }

    public int getNumberOfAliveNeighbours() {
        int numberOfAliveNeighbours = 0;
        if(neighbours != null)
            for(Cell neighbour: neighbours) {
                if(neighbour.getClass().equals(AliveCell.class))
                    numberOfAliveNeighbours++;
            }
        return numberOfAliveNeighbours;
    }
}
