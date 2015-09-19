package com.tw.game;

public class Cell {
    private String currentState;
    private int aliveNeighbours;

    public Cell(String currentState, int aliveNeighbours) {
        this.currentState = currentState;
        this.aliveNeighbours = aliveNeighbours;
    }

    public String nextState() {
        if (currentState.equals("alive"))
            if ((aliveNeighbours < 2) || (aliveNeighbours > 3))
                return "dead";
        if (currentState.equals("dead") && (aliveNeighbours == 3))
            return "alive";
        return currentState;
    }
}
