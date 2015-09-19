package com.tw.game;

import java.util.ArrayList;
import java.util.List;

public class InputMaze {
    private char[][] inputState;

    public InputMaze(char[][] inputState) {
        this.inputState = inputState;
    }

    public Cell getCell(int i, int j) {
        try {
            char c = inputState[i][j];
            if (c == 'x')
                return new AliveCell(null);
            else
                return new DeadCell(null);
        } catch (Exception exception) {
            return null;
        }
    }

    public List<Cell> getCellNeighbours(int i, int j) {
        try {
            char c = inputState[i][j];
            return new ArrayList<Cell>();
        } catch (Exception exception) {
            return null;
        }
    }
}
