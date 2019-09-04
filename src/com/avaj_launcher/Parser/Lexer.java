package com.avaj_launcher.Parser;

import com.avaj_launcher.CustomExceptions.LexerException;
import com.avaj_launcher.simulator.Coordinates;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Lexer {

    private static final Map<AirParts, Coordinates> airVehicles = new HashMap<>();
    private static int cycles = 0;
    private static boolean isCycleDefined = false;


    private Lexer() {
    }


    public static void startTokenizer(List<String> data) throws LexerException {

        if (data.size() == 0)
            throw new NullPointerException();

        for (String var : data) {
            System.out.println(var);
            analyzeData(var);
        }

    }

    private static void analyzeData(String data) throws LexerException {

        StringTokenizer lexer = new StringTokenizer(data);

        if (lexer.countTokens() != 1 && lexer.countTokens() != 5)
            if (lexer.hasMoreTokens()) {
                StringBuilder tmp = new StringBuilder();
                int i = 0;
                while (lexer.hasMoreTokens()) {
                    tmp.append(lexer.nextToken()).append(" ");
                    ++i;
                }
                throw new LexerException("Wrong format: " + tmp + "parameters amount " + i);
            } else
                throw new LexerException("Wrong amount of parameters [" + lexer.countTokens() + "] (required 5 || 1)");

        if (lexer.countTokens() == 1 && !isCycleDefined) {

            try {
                cycles = Integer.parseInt(lexer.nextToken());
                isCycleDefined = true;
            } catch (NumberFormatException e) {
                throw new LexerException("wrong amount of cycle iteration");
            }
        }
        if (lexer.countTokens() == 5) {
            AirParts airParts = new AirParts(lexer.nextToken(), lexer.nextToken());

            try {
                Coordinates coordinates = new Coordinates(
                        Integer.parseInt(lexer.nextToken()),
                        Integer.parseInt(lexer.nextToken()),
                        Integer.parseInt(lexer.nextToken())
                );
                craftScheme(airParts, coordinates);
            } catch (NumberFormatException e) {
                throw new LexerException("Invalid convert string -> int");
            }
        }
    }

    public static int getCyclesAmount() {
        return cycles;
    }

    private static void craftScheme(AirParts name, Coordinates coordinates) {

        try {
            airVehicles.put(name, coordinates);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<AirParts, Coordinates> getAirVehicles() {
        return airVehicles;
    }
}
