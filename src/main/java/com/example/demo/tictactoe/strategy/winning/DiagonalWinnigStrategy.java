package com.example.demo.tictactoe.strategy.winning;

import com.example.demo.tictactoe.model.Board;
import com.example.demo.tictactoe.model.BoardCell;
import com.example.demo.tictactoe.model.GameSymbol;

import java.util.List;

public class DiagonalWinnigStrategy implements WinningStrategy{
    @Override
    public boolean checkWinner(Board board, GameSymbol gameSymbol) {
        List<List<BoardCell>> cells=board.getCells();
        int n=cells.size();
        boolean isWinner=true;
        for(int r=0;r<n;r++) {
            if(cells.get(r).get(r).getGameSymbol()!=gameSymbol) {
                isWinner=false;
                break;
            }
        }
        if(isWinner) return true;
        isWinner=true;
        for(int r=0;r<n;r++) {
            if(cells.get(r).get(n-1-r).getGameSymbol()!=gameSymbol) {
                isWinner=false;
                break;
            }
        }
        return isWinner;
    }
}
