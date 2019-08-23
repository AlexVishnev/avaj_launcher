package com.avaj_launcher.simulator;

import com.avaj_launcher.interfaces.Flyable;

public final class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower = null;
    private String currentWeather = null;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
        type = "JetPlane";
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
                coordinates = new Coordinates(coordinates.getLongitude() + 10,
                        coordinates.getLatitude(), coordinates.getHeight() + 2);
                blackBox("Such a nice weather");
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude(), coordinates.getHeight() - 7);
                blackBox("What!??? Seriously SNOW?? I`m out of here");
                break;

            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude() - 5, coordinates.getHeight());
                blackBox("Great... it`s fucking RAIN");
                break;

            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(),
                        coordinates.getLatitude() + 1, coordinates.getHeight());
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
