package com.example.demo.tictactoe.strategy.winning;

import com.example.demo.tictactoe.model.Board;
import com.example.demo.tictactoe.model.BoardCell;
import com.example.demo.tictactoe.model.GameSymbol;

import java.util.List;

public class ColWinningStrategy  implements WinningStrategy {
    @Override
    public boolean checkWinner(Board board, GameSymbol gameSymbol) {
        List<List<BoardCell>> cells=board.getCells();
        for(int r=0;r<cells.size();r++) {
            boolean isWinner=true;
            for(int c=0;c<cells.get(0).size();c++) {
                if(cells.get(c).get(r).getGameSymbol()!=gameSymbol) {
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
