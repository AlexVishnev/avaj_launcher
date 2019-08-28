package com.avaj_launcher.simulator;


import com.avaj_launcher.CustomExceptions.FactoryException;
import com.avaj_launcher.CustomExceptions.LexerException;
import com.avaj_launcher.Loging.Logger;
import com.avaj_launcher.Parser.AirParts;
import com.avaj_launcher.Parser.Lexer;
import com.avaj_launcher.Parser.Parser;
import com.avaj_launcher.interfaces.Flyable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class Simulator {

    private static final ArrayList<Flyable> flyables = new ArrayList<>();
    private static final WeatherTower tower = new WeatherTower();

    public static void main(String[] args) {

        try {
            Logger.setFileToWrite("simulation.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (args.length > 0) {

            Parser.openFile(args[0]);

            try {
                Lexer.startTokenizer(Parser.getData());

            } catch (LexerException e) {
                e.printErrorMessage();
                System.exit(-2);
            } catch (Exception e) {
                e.printStackTrace();
            }

            try {
                final Map<AirParts, Coordinates> airVehicles = Lexer.getAirVehicles();

                airVehicles.forEach((vehicle, position) -> injectData(vehicle.type, vehicle.name, position));

                for (Flyable flyable : flyables) {
                    flyable.registerTower(tower);
                }

                for (int i = 0; i < Lexer.getCyclesAmount(); i++) {
                    tower.changeWeather();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private static void injectData(String type, String name, Coordinates c) {

        try {
            flyables.add(AircraftFactory.newAircraft(type, name,
                    c.getLatitude(), c.getLongitude(), c.getHeight())
            );
        } catch (FactoryException e) {
            e.printErrorMessage();
            System.exit(-1);
        }
    }
}
