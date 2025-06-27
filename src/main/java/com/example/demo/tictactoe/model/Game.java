package com.example.demo.tictactoe.model;

import com.example.demo.tictactoe.exception.InvalidMoveException;
import com.example.demo.tictactoe.strategy.winning.ColWinningStrategy;
import com.example.demo.tictactoe.strategy.winning.DiagonalWinnigStrategy;
import com.example.demo.tictactoe.strategy.winning.RowWinningStrategy;
import com.example.demo.tictactoe.strategy.winning.WinningStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class Game {
    private static final int LEAST_PLAYER_RANGE=2;
    private static final GameStatus gameStatusDefault = GameStatus.YET_TO_START;
    private static int currPlayerIndex=0;
    private Board board;
    private List<Player> players=new ArrayList<>();
    private List<WinningStrategy> winningStrategy=List.of(new RowWinningStrategy(),new ColWinningStrategy(),new DiagonalWinnigStrategy());
    private GameStatus gameStatus;
    private Player winner;


    private Game() {
        //this.players=new ArrayList<>();
    }
    public void start(){
        //Assign random value to nextplayer index
        currPlayerIndex= (int) (Math.random()*players.size());
        gameStatus=GameStatus.IN_PROGRESS;
    }
    public void move() {
        //getTheNext Palyer
        //get the next Player move
        /*Get the next Move(Combo of above 2)*/
        BoardCell move = getCurrMove();
       /* // makemove -human(from terminal)/bot(strategy)  implement makeMove later*/
        //validate and move- check whether the cell is already filled or not
        validateMove(move);

        //update the board
        board.updateMove(move);
        //chcekWinner
        if(checkWinner(move.getGameSymbol())) {
            gameStatus=gameStatus.FINISHED;
            winner=getCurrPlayerByIndex();
            return;
        }
        //checkDrawn
        if(isDrawn()) {
            if(board.getEmptyCells().isEmpty()) {
                gameStatus=gameStatus.DRAWN;
            }
            return;
        }
        //toggle to next player
        currPlayerIndex = (1+currPlayerIndex)%players.size();
    }

    private boolean isDrawn() {
        return false;
    }

    private void validateMove(BoardCell move) {
        int row = move.getRow();
        int col = move.getCol();

        int rowCount = board.getCells().size();
        int colCount = board.getCells().get(0).size();

        if (row < 0 || col < 0 || row >= rowCount || col >= colCount) {
            throw new InvalidMoveException(row,col);
        }

        if (!board.isEmpty(row, col)) {
            throw new InvalidMoveException(row,col);
        }
    }

    private BoardCell getCurrMove() {
        Player currPlayer = getCurrPlayerByIndex();
        return currPlayer.move(board);
    }
    public Player getCurrPlayerByIndex() {
        return players.get(currPlayerIndex);
    }

    private boolean checkWinner(GameSymbol symbol){
        for(WinningStrategy currWinningStrategy:winningStrategy) {
            boolean hasWinner = currWinningStrategy.checkWinner(board,symbol);
            if(hasWinner) {
                return true;
            }
        }
        return false;
    }



    private boolean checkDraw(){
        return false;
    }
    public static Builder builder() {
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
