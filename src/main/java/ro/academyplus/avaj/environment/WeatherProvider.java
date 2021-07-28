package ro.academyplus.avaj.environment;

public class WeatherProvider {
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private static String[] weather = {"SUN", "RAIN", "FOG", "SNOW"};

    private WeatherProvider() {
    }

    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int sum = coordinates.getLongitude() + coordinates.getLatitude() + coordinates.getHeight();
        return weather[sum % weather.length];
    }
}