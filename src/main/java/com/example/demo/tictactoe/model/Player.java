package com.example.demo.tictactoe.model;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public abstract class Player {
    private GameSymbol gameSymbol;

    public abstract  BoardCell move(Board board);
}
