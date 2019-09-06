package com.avaj_launcher.simulator;

import com.avaj_launcher.interfaces.Flyable;

public final class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower = new WeatherTower();

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        type = "Helicopter";
//        blackBox(" Pilot Says: Yeah bitch im high as shit!");
    }

    @Override
    public void updateConditions() {

        switch (weatherTower.getWeather(coordinates)) {
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 10,
                        coordinates.getLatitude(), coordinates.getHeight() + 2);
                blackBox("Sunrise Sunrise looks like morning in yours eyes!");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude(), coordinates.getHeight() - 12);
                blackBox("And since we`ve no place to go, Let it snow Let it snow Let it snow");
                break;

            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude() + 5,
                        coordinates.getLatitude(), coordinates.getHeight());
                blackBox("Riders on the storm ... tun-tun-tudun");
                break;

            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude() + 1,
                        coordinates.getLatitude(), coordinates.getHeight());
                blackBox("Yeeahaaa! Blind flying");
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
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
