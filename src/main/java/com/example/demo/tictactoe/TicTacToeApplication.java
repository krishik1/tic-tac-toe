package com.example.demo.tictactoe;

import com.example.demo.tictactoe.exception.InvalidSymbolException;
import com.example.demo.tictactoe.model.*;
import com.example.demo.tictactoe.strategy.RandomPlayingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class TicTacToeApplication {
    private static final int size=3;
    public static void main(String[] args) {

        /*SpringApplication.run(TicTacToeApplication.class, args);*/
        System.out.println("Welcome To Tic-Tac-Toe");
        /*Game Cretaion Steps*/
        //1. Ask for user input - name,email,photo
        HumanPlayer player1 = getUserInput();
        System.out.println("Player 1 Selected The Symbol : "+player1.getGameSymbol());
        //2.create a Game
        //3.Select the opponent -bot or human player
        Game game = createGame(player1);
        //4.Start Game
        //5.Assign First Player
        game.start();
        //iteratively call make move
        //until->game is drawn or won
        //6.Mark the game in progress
        //7.Start Playing
        while (game.getGameStatus()==GameStatus.IN_PROGRESS) {
            Player player = game.getCurrPlayerByIndex();
            System.out.println("Curr Player Symbol : "+player.getGameSymbol());
            game.move();
            game.getBoard().printBoard();
        }





    }
    private static Game createGame(HumanPlayer player) {
        return Game.builder().withPlayer(player).withDimensions(size,size).withPlayer(BotPlayer.builder().
                gameSymbol(selectSymbol(player.getGameSymbol())).playingStrategy(new RandomPlayingStrategy()).build()).setGamestatus(GameStatus.YET_TO_START).build();
    }

    // As this design is intended for 2 players, we have used a ternary operator.
    // For better extensibility, a factory pattern can be used instead.
    private static GameSymbol selectSymbol(GameSymbol symbol) {
        return symbol==GameSymbol.O ? GameSymbol.X:GameSymbol.O;
    }

    private static HumanPlayer getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter User Name : ");
        String name = sc.nextLine();
        System.out.println("Enter User Email : ");
        String email = sc.nextLine();
        System.out.println("Enter User Symbol : ");
        GameSymbol symbol = null;
        try {
            symbol = GameSymbol.valueOf(sc.next());
        } catch (IllegalArgumentException e) {
            //System.out.println("Invalid Symbol . Enter O or X");
            throw new InvalidSymbolException();
        }
        User user = new User(name,email,"url/pic");
        return HumanPlayer.builder().gameSymbol(symbol).user(user).build();
    }

}
