//InputMaze has input and corresponding cells
package com.tw.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InputMaze {
    private char[][] inputState;
    private HashMap<Integer,ArrayList<Cell>> cellCache;

    public InputMaze(char[][] inputState) {
        this.inputState = inputState;
        if (inputState == null)
            cellCache = null;
        else
            cellCache = new HashMap<Integer,ArrayList<Cell>>();
    }

    public Cell getCell(int i, int j) {
        if(cellCache == null)
            return null;
        try {
            return cellCache.get(i).get(j);
        } catch (Exception exception) {
            ArrayList<Cell> listCells= cellCache.containsKey(i) ? cellCache.get(i) : new ArrayList<Cell>();
            try {
                Cell cell;
                char c = inputState[i][j];
                if (c == 'x')
                    cell = new AliveCell(getCellNeighbours(i, j));
                else
                    cell = new DeadCell(getCellNeighbours(i, j));
                listCells.add(cell);
                cellCache.put(i,listCells);
                return cell;
            } catch (Exception exception2) {
                return null;
            }
        }

    }


    public List<Cell> getCellNeighbours(int i, int j) {
        try {
            char c = inputState[i][j];
            List<Cell> neighbours = new ArrayList<Cell>();
            addToListIfObjectAddedNotNull(neighbours, getCell(i + 1, j));
            addToListIfObjectAddedNotNull(neighbours, getCell(i + 1, j + 1));
            addToListIfObjectAddedNotNull(neighbours, getCell(i + 1, j - 1));
            addToListIfObjectAddedNotNull(neighbours, getCell(i, j - 1));
            addToListIfObjectAddedNotNull(neighbours, getCell(i, j + 1));
            addToListIfObjectAddedNotNull(neighbours, getCell(i - 1, j));
            addToListIfObjectAddedNotNull(neighbours, getCell(i - 1, j + 1));
            addToListIfObjectAddedNotNull(neighbours, getCell(i - 1, j - 1));
            return neighbours;
        } catch (Exception exception) {
            return null;
        }
    }

    private List<Cell> addToListIfObjectAddedNotNull(List<Cell> list, Cell cell) {
        if (cell != null)
            list.add(cell);
        return list;
    }
}
