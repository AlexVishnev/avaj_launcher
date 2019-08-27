package com.avaj_launcher.simulator;

import com.avaj_launcher.interfaces.Flyable;

public final class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower = null;
    private String currentWeather = null;


    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
        type = "Baloon";
    }
    @Override
    public void updateConditions() {
        if (weatherTower == null)
            System.out.println("Error: Weather tower didnt set");

        String meteoReport = weatherTower.getWeather(coordinates);

        if (currentWeather == null || currentWeather.equals(meteoReport))
            currentWeather = meteoReport;
        switch (currentWeather) {
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 2,
                        coordinates.getLatitude(), coordinates.getHeight() + 4);
                blackBox("Such a nice weather");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude(), coordinates.getHeight() - 15);
                blackBox("What!??? Seriously SNOW?? I`m out of here");
                break;

            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude(), coordinates.getHeight() - 5);
                blackBox("Great... it`s fucking RAIN (H -5)");
                break;

            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude(), coordinates.getHeight() - 3);
                blackBox("Agghr FOG! very nice view great landscapes");
                break;

            default:
                break;
        }
        if (coordinates.getHeight() == 0) {
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
