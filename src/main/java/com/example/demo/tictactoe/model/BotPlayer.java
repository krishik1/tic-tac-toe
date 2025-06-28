package com.example.demo.tictactoe.model;

import com.example.demo.tictactoe.strategy.PlayingStrategy;
import com.example.demo.tictactoe.strategy.RandomPlayingStrategy;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class BotPlayer extends Player{
    private PlayingStrategy playingStrategy;

    @Override
    public BoardCell move(Board board) {
        BoardCell boardCell = playingStrategy.move(board);
        BoardCell newcell= BoardCell.builder().row(boardCell.getRow()).col(boardCell.getCol()).gameSymbol(getGameSymbol()).build();
        return newcell;
    }
}
