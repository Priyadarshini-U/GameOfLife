package com.tw.game;

public interface Cell {
    Cell nextState();
    int getNumberOfAliveNeighbours();
}
