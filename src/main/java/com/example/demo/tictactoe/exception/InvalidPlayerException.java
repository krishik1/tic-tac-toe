package com.example.demo.tictactoe.exception;

public class InvalidPlayerException extends RuntimeException{
    public InvalidPlayerException() {
        super("User is Invalid. ");
    }
}
