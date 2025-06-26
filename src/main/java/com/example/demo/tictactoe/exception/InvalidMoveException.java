package com.example.demo.tictactoe.exception;

public class InvalidMoveException extends RuntimeException {
    public InvalidMoveException(int r,int c) {
        super("The move is Invalid: "+r+" "+c);
    }
}
