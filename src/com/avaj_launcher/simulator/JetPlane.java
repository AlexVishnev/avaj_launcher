package com.avaj_launcher.simulator;

import com.avaj_launcher.interfaces.Flyable;

public final class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower = new WeatherTower();

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        type = "JetPlane";

//        blackBox(" Driver Says: Emmm... guys i`m not a pilot!");
    }

    @Override
    public void updateConditions() {

        switch (weatherTower.getWeather(coordinates)) {
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 10,
                        coordinates.getLatitude(), coordinates.getHeight() + 2);
                blackBox("Ok, maybe it`s not scary that i think. Sunny weather colored buttons.");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude(), coordinates.getHeight() - 7);
                blackBox("Houston, we have a problem! There is snowing and I`M NOT A PILOT!");
                break;

            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude() - 5, coordinates.getHeight());
                blackBox("Hello! Anybody there? It`s rainy? what i suppose to do?");
                break;

            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude() + 1, coordinates.getHeight());
                blackBox("i can`t see anything, what have to do? Why everyone doesnt answer?");
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
