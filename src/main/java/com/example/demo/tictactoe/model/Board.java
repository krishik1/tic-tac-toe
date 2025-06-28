package com.example.demo.tictactoe.model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {
    private List<List<BoardCell>> cells=new ArrayList<>();

    public Board(int row,int col) {
        List<List<BoardCell>> rowCells = new ArrayList<>();

        for (int i = 0; i < row; i++) {
            List<BoardCell> colCells = new ArrayList<>();
            for (int j = 0; j < col; j++) {
                colCells.add(BoardCell.builder()
                        .row(i)
                        .col(j)
                        .gameSymbol(null) // or GameSymbol.EMPTY
                        .build());
            }
            rowCells.add(colCells);
        }
        this.cells=rowCells;
    }

    public boolean isEmpty(int row, int col) {
        return cells.get(row).get(col).getGameSymbol()==null;
    }

    public void updateMove(BoardCell move) {
        BoardCell cell = cells.get(move.getRow()).get(move.getCol());
        //using builder obj is immutable , toBuilder offers immutability with no settr mutation by which we reuse an existing object's state
        BoardCell updatedCell = cell.toBuilder()
                .gameSymbol(move.getGameSymbol())
                .build();
        cells.get(move.getRow()).set(move.getCol(), updatedCell);
    }

    public void printBoard() {
        for (int i = 0; i < cells.size(); ++i) {
            for (int j = 0; j < cells.size(); ++j) {
                GameSymbol symbol = cells.get(i).get(j).getGameSymbol();

                if (symbol == null) {
                    System.out.printf(" | - | ");
                } else {
                    System.out.printf(" | " + symbol + " | ");
                }
            }
            System.out.printf("\n");
        }
    }

    public List<BoardCell> getEmptyCells() {
        //Filter out the cells that !=null
        return cells.stream().flatMap(List::stream)
                .filter(cell->cell.getGameSymbol()==null)
                .toList();
    }
}
