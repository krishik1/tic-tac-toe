package com.example.demo.tictactoe.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Scanner;

//extrensic class
@Getter
@SuperBuilder
public class HumanPlayer extends Player {
    private User user;
//    @Builder.Default
//    Scanner sc= new Scanner(System.in);

    @Override
    public BoardCell move(Board board) {
        System.out.println("Enter row and column : ");
        Scanner sc= new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        GameSymbol symbol = getGameSymbol();
        System.out.println("symb is : "+symbol);
        return new BoardCell(row,col,symbol);
    }
}
