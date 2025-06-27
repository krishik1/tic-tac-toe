package com.example.demo.tictactoe.strategy.winning;

import com.example.demo.tictactoe.model.Board;
import com.example.demo.tictactoe.model.BoardCell;
import com.example.demo.tictactoe.model.GameSymbol;
import com.example.demo.tictactoe.model.Player;

import java.util.List;

public class RowWinningStrategy implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, GameSymbol gameSymbol) {
        List<List<BoardCell>> cells=board.getCells();
        for(List<BoardCell> row : cells) {
            boolean isWinner=true;
            for(BoardCell cell:row) {
                if(cell.getGameSymbol()!=gameSymbol) {
                    isWinner=false;
                }
            }
            if(isWinner) {
                return true;
            }
        }
        return false;
    }
}
