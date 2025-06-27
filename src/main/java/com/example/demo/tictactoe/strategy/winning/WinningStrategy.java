package com.example.demo.tictactoe.strategy.winning;

import com.example.demo.tictactoe.model.Board;
import com.example.demo.tictactoe.model.GameSymbol;
import com.example.demo.tictactoe.model.Player;

import java.util.List;

public interface WinningStrategy {
    boolean checkWinner(Board board,  GameSymbol gameSymbol);
}
