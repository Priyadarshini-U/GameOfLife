package com.tw.game;

public class InputMaze {
    private char[][] inputState;

    public InputMaze(char[][] inputState){
        this.inputState = inputState;
    }

    public Cell getCell(int i, int j){
        try {
            char c = inputState[i][j];
            return new AliveCell(null);
        }catch (Exception exception) {
            return null;
        }
    }
}
