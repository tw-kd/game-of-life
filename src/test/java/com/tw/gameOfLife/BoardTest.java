package com.tw.gameOfLife;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

public class BoardTest {
    @Test
    void shouldPassTestcase1() {
//        Input A:
//        (Block pattern - Still life)
//        1, 1
//        1, 2
//        2, 1
//        2, 2
//        Output A:
//        1, 1
//        1, 2
//        2, 1
//        2, 2
        ArrayList<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(1, 1));
        aliveCells.add(new Cell(1, 2));
        aliveCells.add(new Cell(2, 1));
        aliveCells.add(new Cell(2, 2));
        ArrayList<Cell> nextGenerationAliveCells = new ArrayList<>();
        nextGenerationAliveCells.add(new Cell(1, 1));
        nextGenerationAliveCells.add(new Cell(1, 2));
        nextGenerationAliveCells.add(new Cell(2, 1));
        nextGenerationAliveCells.add(new Cell(2, 2));

        Board gameOfLifeBoard = new Board(aliveCells);
        Board nextGenerationBoard = new Board(nextGenerationAliveCells);

        gameOfLifeBoard.generateNextGeneration();

        assertThat(gameOfLifeBoard, is(equalTo(nextGenerationBoard)));
    }

    @Test
    void shouldPassTestcase2() {
//        Input B
//        (Boat pattern - Still life)
//        0, 1
//        1, 0
//        2, 1
//        0, 2
//        1, 2
//        Output B
//        0, 1
//        1, 0
//        2, 1
//        0, 2
//        1, 2
        ArrayList<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(0, 1));
        aliveCells.add(new Cell(1, 0));
        aliveCells.add(new Cell(2, 1));
        aliveCells.add(new Cell(0, 2));
        aliveCells.add(new Cell(1, 2));
        ArrayList<Cell> nextGenerationAliveCells = new ArrayList<>();
        nextGenerationAliveCells.add(new Cell(0, 1));
        nextGenerationAliveCells.add(new Cell(1, 0));
        nextGenerationAliveCells.add(new Cell(2, 1));
        nextGenerationAliveCells.add(new Cell(0, 2));
        nextGenerationAliveCells.add(new Cell(1, 2));

        Board gameOfLifeBoard = new Board(aliveCells);
        Board nextGenerationBoard = new Board(nextGenerationAliveCells);

        gameOfLifeBoard.generateNextGeneration();
        gameOfLifeBoard.generateNextGeneration();

        assertThat(gameOfLifeBoard, is(equalTo(nextGenerationBoard)));
    }

    @Test
    void shouldPassTestcase3() {
//        Input C
//        (Blinker pattern - oscillator)
//        1, 1
//        1, 0
//        1, 2
//        Output C
//        1, 1
//        0, 1
//        2, 1
        ArrayList<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(1, 1));
        aliveCells.add(new Cell(1, 0));
        aliveCells.add(new Cell(1, 2));
        ArrayList<Cell> nextGenerationAliveCells = new ArrayList<>();
        nextGenerationAliveCells.add(new Cell(1, 1));
        nextGenerationAliveCells.add(new Cell(0, 1));
        nextGenerationAliveCells.add(new Cell(2, 1));

        Board gameOfLifeBoard = new Board(aliveCells);
        Board nextGenerationBoard = new Board(nextGenerationAliveCells);

        gameOfLifeBoard.generateNextGeneration();

        assertThat(gameOfLifeBoard, is(equalTo(nextGenerationBoard)));
    }

    @Test
    void shouldPassTestcase4() {
//        Input D
//        (Toad pattern - two phase oscillator)
//        1, 1
//        1, 2
//        1, 3
//        2, 2
//        2, 3
//        2, 4
//        Output D
//        0, 2
//        1, 1
//        1, 4
//        2, 1
//        2, 4
//        3, 3
        ArrayList<Cell> aliveCells = new ArrayList<>();
        aliveCells.add(new Cell(1, 1));
        aliveCells.add(new Cell(1, 2));
        aliveCells.add(new Cell(1, 3));
        aliveCells.add(new Cell(2, 2));
        aliveCells.add(new Cell(2, 3));
        aliveCells.add(new Cell(2, 4));
        ArrayList<Cell> nextGenerationAliveCells = new ArrayList<>();
        nextGenerationAliveCells.add(new Cell(0, 2));
        nextGenerationAliveCells.add(new Cell(1, 1));
        nextGenerationAliveCells.add(new Cell(1, 4));
        nextGenerationAliveCells.add(new Cell(2, 1));
        nextGenerationAliveCells.add(new Cell(2, 4));
        nextGenerationAliveCells.add(new Cell(3, 3));

        Board gameOfLifeBoard = new Board(aliveCells);
        Board nextGenerationBoard = new Board(nextGenerationAliveCells);

        gameOfLifeBoard.generateNextGeneration();

        assertThat(gameOfLifeBoard, is(equalTo(nextGenerationBoard)));
    }
}
