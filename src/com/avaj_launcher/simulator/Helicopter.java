package com.avaj_launcher.simulator;

import com.avaj_launcher.interfaces.Flyable;

public final class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower = null;
    private String currentWeather = null;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
        type = "Helicopter";
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
                        coordinates.getLatitude(), coordinates.getHeight() - 12);
                blackBox("What!??? Seriously SNOW??");
                break;

            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude() + 5,
                        coordinates.getLatitude(), coordinates.getHeight());
                blackBox("Ha-ha RAIN");
                break;

            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude() + 1,
                        coordinates.getLatitude(), coordinates.getHeight());
                blackBox("Yeeehaaa blind flying");
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
        this.weatherTower = weatherTower;
        weatherTower.register(this);
    }
}
