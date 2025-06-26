package com.example.demo.tictactoe.exception;

public class InvalidSymbolException extends RuntimeException {
    public InvalidSymbolException() {
        super("You Have Given Invalid Symbol . Enter O or X");
    }
}
