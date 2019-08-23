package com.avaj_launcher.simulator;

import com.avaj_launcher.CustomExceptions.FactoryException;
import com.avaj_launcher.interfaces.Flyable;

class AircraftFactory {
    static Flyable newAircraft(String type, String name, int latitude, int longitude, int height) throws FactoryException {

        switch (type) {
            case "JetPlane":
                return new JetPlane(name, new Coordinates(longitude, latitude, height));
            case "Baloon":
                return new Baloon(name, new Coordinates(longitude, latitude, height));
            case "Helicopter":
                return new Helicopter(name, new Coordinates(longitude, latitude, height));
            default:
                throw new FactoryException("", type);
        }
    }
}
