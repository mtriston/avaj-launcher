package ro.academyplus.avaj.exceptions;

public class IllegalWeatherException extends RuntimeException {
    public IllegalWeatherException(String message) {
        super("Unknown type of weather: " + message);
    }
}
