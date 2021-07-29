package ro.academyplus.avaj.environment;

import java.util.Random;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int i = new Random().nextInt(coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight());
        return weather[i % weather.length];
    }
}