package com.avaj_launcher.simulator;

import java.util.Random;

public class WeatherProvider {

    private final String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};
    private static final WeatherProvider weatherProvider = new WeatherProvider();

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return WeatherProvider.weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int random = new Random().nextInt(weather.length);

        if (coordinates.getHeight() > 90){
            random = random == 2 ? 3 : random;
        }
        return weather[random];
    }

}
