package com.avaj_launcher.CustomExceptions;

public class LexerException extends Exception {
    public LexerException(String message){
        super("Lexer Exception: " + message);
    }
}
