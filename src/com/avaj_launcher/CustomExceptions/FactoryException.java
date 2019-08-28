package com.avaj_launcher.CustomExceptions;

public class FactoryException extends Exception {
    private String message;
    public FactoryException(String message, String type) {
        super("Factory error: crash when trying to create airVehicle type[" + type + "]" + message);
        this.message = "Factory error: crash when trying to create airVehicle type[" + type + "]" + message;
    }

    public void printErrorMessage(){
        System.err.println(message);
    }

}
