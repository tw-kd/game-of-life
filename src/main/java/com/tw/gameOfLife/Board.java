package com.tw.gameOfLife;

import java.util.ArrayList;

public class Board {
    private final int boardSize;
    private int[][] cells;

    public Board(ArrayList<Cell> aliveCells) {
        this.boardSize = calculateBoardSize(aliveCells);
        this.cells = new int[this.boardSize][this.boardSize];
        setAliveCells(aliveCells);
    }

    private int calculateBoardSize(ArrayList<Cell> aliveCells) {
        int size = 0;
        for (Cell cell : aliveCells) {
            if (cell.getRow() > size)
                size = cell.getRow();
            if (cell.getColumn() > size)
                size = cell.getColumn();
        }
        return size+1;
    }

    private void setAliveCells(ArrayList<Cell> aliveCells) {
        for (Cell cell : aliveCells) {
            cells[cell.getRow()][cell.getColumn()] = 1;
        }
    }

    public void generateNextGeneration() {
        int[][] nextGeneration = new int[boardSize][boardSize];
        for (int row = 0; row < boardSize; row++) {
            for (int column = 0; column < boardSize; column++) {
                nextGeneration[row][column] = calculateNextGenerationCellStatus(row, column);
            }
        }
        cells = nextGeneration;
    }

    private int calculateNextGenerationCellStatus(int row, int column) {
        int aliveNeighbours = countAliveNeighbours(row, column);

        if (aliveNeighbours < 2 || aliveNeighbours > 3) return 0;
        if (aliveNeighbours == 3) return 1;
        return cells[row][column];
    }

    private int countAliveNeighbours(int row, int column) {
        int initialRow = row == 0 ? 0 : row - 1;
        int initialColumn = column == 0 ? 0 : column - 1;
        int finalRow = row == boardSize - 1 ? boardSize - 1 : row + 1;
        int finalColumn = column == boardSize - 1 ? boardSize - 1 : column + 1;

        int aliveNeighbours = 0;

        for (int i = initialRow; i <= finalRow; i++)
            for (int j = initialColumn; j <= finalColumn; j++)
                if (cells[i][j] == 1) aliveNeighbours++;

        return aliveNeighbours - cells[row][column];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;
        if (!(obj instanceof Board)) return false;
        Board other = (Board) obj;
        return other.boardSize == boardSize && isCellsEqual(other);
    }

    private boolean isCellsEqual(Board other) {
        for (int row = 0; row < boardSize; row++) {
            for (int column = 0; column < boardSize; column++) {
                if (cells[row][column] != other.cells[row][column]) return false;
            }
        }
        return true;
    }
}
