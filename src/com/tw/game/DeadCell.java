//Dead cell is dead currently
package com.tw.game;

import java.util.List;

public class DeadCell extends Cell {

    public DeadCell(List<Cell> neighbours) {
        this.neighbours = neighbours;
    }

    public Cell nextState() {
        List<Cell> nextNeighbours = nextStateNeighbours();
        int aliveNeighbours = getNumberOfAliveNeighbours();
        if (aliveNeighbours == 3)
            return new AliveCell(nextNeighbours);
        return new DeadCell(nextNeighbours);
    }
}
