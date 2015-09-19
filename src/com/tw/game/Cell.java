package com.tw.game;

public class Cell {
    private String currentState;
    private int aliveNeighbours;
    private int deadNeighbours;

    public Cell(String currentState, int aliveNeighbours, int deadNeighbours){
        this.currentState = currentState;
        this.aliveNeighbours = aliveNeighbours;
        this.deadNeighbours = deadNeighbours;
    }

    public String nextState() {
        if(currentState.equals("alive") && aliveNeighbours < 2)
            return "dead";
        return currentState;
    }
}
