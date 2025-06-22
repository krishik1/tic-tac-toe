package com.example.demo.tictactoe.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@Setter
@Getter
public class Board {
    private List<List<BoardCell>> cells=new ArrayList<>();

    public Board(int row,int col) {
        List<BoardCell> colCells = Collections.nCopies(col,new BoardCell());
        List<List<BoardCell>> rowCells = Collections.nCopies(row,colCells);
        this.cells=rowCells;
    }

}
