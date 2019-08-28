package com.avaj_launcher.simulator;

public class Coordinates {

    private final int longitude;
    private final int latitude;
    private final int height;

    public Coordinates(int longitude, int latitude, int height) {

        if (height > 100)
            height = 100;
        else if (height < 0)
            height = 0;

        this.height = height;

        if (latitude < 0)
            latitude = 0;

        this.latitude = latitude;

        if (longitude < 0)
            longitude = 0;

        this.longitude = longitude;

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
