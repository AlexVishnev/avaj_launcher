package com.avaj_launcher.CustomExceptions;

public class LexerException extends Exception {
    private String message;

    public LexerException(String message) {
        super("Lexer Exception: " + message);
        this.message = "Lexer Exception: " + message;
    }

    public void printErrorMessage() {
        System.err.println(message);

    }

}
