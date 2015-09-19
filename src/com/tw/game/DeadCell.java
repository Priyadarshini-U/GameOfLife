package com.tw.game;

import java.util.ArrayList;
import java.util.List;

public class DeadCell implements Cell {
    private List<Cell> neighbours;

    public DeadCell(List<Cell> neighbours) {
        this.neighbours = neighbours;
    }

    public Cell nextState() {
        List<Cell> nextNeighbours = null;
        if (neighbours != null) {
            nextNeighbours = new ArrayList<Cell>();
            nextNeighbours.add(neighbours.get(0).nextState());
        }
        int aliveNeighbours = getNumberOfAliveNeighbours();
        if (aliveNeighbours == 3)
            return new AliveCell(nextNeighbours);
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
