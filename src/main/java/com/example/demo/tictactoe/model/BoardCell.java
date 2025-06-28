package com.example.demo.tictactoe.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder(toBuilder = true)
public class BoardCell {
    private int row;
    private int col;
    private GameSymbol gameSymbol;

}
