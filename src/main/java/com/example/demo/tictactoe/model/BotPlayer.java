package com.example.demo.tictactoe.model;

import com.example.demo.tictactoe.strategy.PlayingStrategy;
import com.example.demo.tictactoe.strategy.RandomPlayingStrategy;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
public class BotPlayer extends Player{
    private PlayingStrategy playingStrategy;

    @Override
    public BoardCell move(Board board) {
        playingStrategy=new RandomPlayingStrategy();
        return playingStrategy.move(board);
    }
}
