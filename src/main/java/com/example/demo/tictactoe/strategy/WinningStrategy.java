package com.example.demo.tictactoe.strategy;

import com.example.demo.tictactoe.model.Board;
import com.example.demo.tictactoe.model.Player;

import java.util.List;

public interface WinningStrategy {
    Player checkWinner(Board board, List<Player> players);
}
