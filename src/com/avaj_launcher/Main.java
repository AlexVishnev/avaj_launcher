package com.avaj_launcher;

import com.avaj_launcher.CustomExceptions.SimulatorException;
import com.avaj_launcher.simulator.Simulator;

public class Main {
    public static void main(String[] args) {

        try {
            Simulator.run(args);
        } catch (SimulatorException e) {
            e.printErrorMessage();
        }
    }
}
