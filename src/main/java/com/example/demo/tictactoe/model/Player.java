package com.example.demo.tictactoe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Player {
    private GameSymbol gameSymbol;

    public abstract  BoardCell move();
}
