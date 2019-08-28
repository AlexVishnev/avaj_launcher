package com.avaj_launcher.simulator;

public class Coordinates {

    private final int longitude;
    private final int latitude;
    private final int height;

    public Coordinates(int longitude, int latitude, int height) {

        if (height > 100)
            height = 100;

        this.height = height < 0 ? 0 : height;
        this.latitude = latitude < 0 ? 0 : latitude;
        this.longitude = longitude < 0 ? 0 : longitude;
    }

    public int getLongitude() {
        return this.longitude;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getHeight() {
        return this.height;
    }

}
