package com.avaj_launcher.simulator;

import com.avaj_launcher.Loging.Logger;

public class Aircraft {
    private final long id;
    private final String name;
    protected String type;
    protected Coordinates coordinates;

    private static long idCounter = 0;

    Aircraft(String name, Coordinates coordinates){
        this.name = name;
        this.coordinates = coordinates;
        this.id = this.nextId();
    }

    private long nextId() {
        Aircraft.idCounter++;
        return Aircraft.idCounter - 1;
    }

    protected void blackBox(String speech) {
        Logger.log(getInfo() + ": " +  speech);
    }
    public String getInfo() {
        return this.type + '#' + this.name + '(' + this.id + ')';
    }

    protected void positionReport() {
        Logger.log("Report: " + getInfo() + "last seems at " + ": ([" + coordinates.getLatitude() + "] ["
                + coordinates.getLongitude() + "] [" + coordinates.getHeight() +"])" + " Rest In Peace" );
    }

}
