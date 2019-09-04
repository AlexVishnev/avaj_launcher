package com.avaj_launcher.simulator;

import com.avaj_launcher.interfaces.Flyable;

public final class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower = new WeatherTower();
    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        type = "Baloon";
        blackBox(" Pilot Says: Did you see anybody from Helicopter pilots? I wanna a pot!");
    }
    @Override
    public void updateConditions() {

        switch (weatherTower.getWeather(coordinates)) {
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 2,
                        coordinates.getLatitude(), coordinates.getHeight() + 4);
                blackBox("wow it`s sunny. We are getting high if you know what i mean");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude(), coordinates.getHeight() - 15);
                blackBox("What!??? Seriously SNOW?? I`m out of here");
                break;

            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude(), coordinates.getHeight() - 5);
                blackBox("Great... it`s fucking RAIN");
                break;

            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude(), coordinates.getHeight() - 3);
                blackBox("Agghr FOG! very nice view great landscapes");
                break;

            default:
                break;
        }
        if (coordinates.getHeight() <= 0) {
            positionReport();
            weatherTower.unregister(this);
        }

    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
    }
}
