package com.example.demo.tictactoe.model;

import com.example.demo.tictactoe.strategy.WinningStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
@Getter
@AllArgsConstructor
public class Game {
    private static final int LEAST_PLAYER_RANGE=2;
    private static final GameStatus gameStatusDefault = GameStatus.YET_TO_START;
    private Board board;
    private List<Player> players=new ArrayList<>();
    private WinningStrategy winningStrategy;
    private GameStatus gameStatus;

    private Game(){

    }
    public void start(){}
    public void move() {}
    private Player checkWinner(){
        return null;
    }
    private boolean checkDraw(){
        return false;
    }
    public static Builder getBuilder() {
        return new Builder();
    }
    public static class Builder {
        private Game game;

        Builder() {
            game=new Game();
        }

        public Builder withDimensions(int row,int col) {
            game.board=new Board(row,col);
            return this;
        }

        public Builder withPlayer(Player player) {
            game.players.add(player);
            return this;
        }
        public Builder setGamestatus(GameStatus gameStatus) {
            game.gameStatus=gameStatus;
            return this;
        }

        public Game build() {
            boolean isValid=validate();
            if(!isValid) {
                throw new RuntimeException();
            }
            return game;
        }

        private boolean validate() {
            List<Player> players =game.players;
            if(game.players.size()< LEAST_PLAYER_RANGE) return false;
            Set<GameSymbol> symbols = players.stream().map(Player::getGameSymbol)
                    .collect(Collectors.toSet());
            return symbols.size()==players.size();
        }

    }


}
