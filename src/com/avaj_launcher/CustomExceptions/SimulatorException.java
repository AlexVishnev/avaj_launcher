package com.avaj_launcher.CustomExceptions;

public class SimulatorException extends Exception {
    private final String message;

    public SimulatorException(String message) {
        super("Simulator Exception: " + message);
        this.message = "Simulator Exception: " + message;
    }

    public void printErrorMessage() {
        System.err.println(message);
    }
}
