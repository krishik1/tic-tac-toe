package com.example.demo.tictactoe;

import com.example.demo.tictactoe.model.*;
import com.example.demo.tictactoe.strategy.RandomPlayingStrategy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TictactoeTest {
    
    private Game game;
    @Before
    public void setUp() {
        this.game = createGame();
    }
    private static int dimension=3;
    private static int playerCount=2;

    private Game createGame() {
        HumanPlayer humanPlayer = HumanPlayer.builder().user(new User("Steve","steve@gmaol.com","url")).gameSymbol(GameSymbol.O).build();
        BotPlayer botPlayer =BotPlayer.builder().gameSymbol(GameSymbol.X).playingStrategy(new RandomPlayingStrategy()).build();
        game = Game.builder().withDimensions(dimension,dimension).withPlayer(humanPlayer)
                .withPlayer(botPlayer)
                .setGamestatus(GameStatus.IN_PROGRESS).build();
        //assertEquals(playerCount,game.getPlayers().size(),"If a game is created, it should have atleast 2 players.");
        return game;
    }
    @Test
    public void testDimension() {
        List<List<BoardCell>> board=game.getBoard().getCells();
        int rowSize = board.get(0).size();
        int colSize = board.size();
        assertEquals(dimension,rowSize);
        assertEquals(dimension,colSize);
    }
}
