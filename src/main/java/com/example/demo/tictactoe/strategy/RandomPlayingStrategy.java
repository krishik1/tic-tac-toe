package com.example.demo.tictactoe.strategy;

import com.example.demo.tictactoe.model.Board;
import com.example.demo.tictactoe.model.BoardCell;

import java.util.List;

public class RandomPlayingStrategy implements  PlayingStrategy{
    @Override
    public BoardCell move(Board board) {
        //output : we need to get the list of available cells

        //Get a List of empty cells
        List<BoardCell> emptyCells = board.getEmptyCells();
        //generate a random index for the cells
        int randomIndex = (int)(Math.random()*emptyCells.size());
        //return a random cell
        BoardCell boardCell = emptyCells.get(randomIndex);
        return BoardCell.builder().row(boardCell.getRow()).col(boardCell.getCol()).build();
    }
}
