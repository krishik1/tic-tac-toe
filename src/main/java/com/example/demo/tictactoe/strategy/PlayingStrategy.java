package com.example.demo.tictactoe.strategy;

import com.example.demo.tictactoe.model.Board;
import com.example.demo.tictactoe.model.BoardCell;

public interface PlayingStrategy {
    BoardCell move(Board board);
}
