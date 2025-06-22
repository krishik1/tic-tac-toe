package com.example.demo.tictactoe.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HumanPlayer extends Player {
    private User user;

    @Override
    public BoardCell move() {
        return null;
    }
}
