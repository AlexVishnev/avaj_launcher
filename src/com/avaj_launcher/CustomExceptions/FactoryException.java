package com.avaj_launcher.CustomExceptions;

public class FactoryException extends Exception {
public FactoryException(String message, String type){
    super("Factory error: crash when trying to create airVehicle type[" + type + "]" + message);
}

}
