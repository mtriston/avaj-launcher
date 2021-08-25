package ro.academyplus.avaj.exceptions;

public class InvalidWeatherException extends RuntimeException {
    public InvalidWeatherException(String message) {
        super("Unknown type of weather: " + message);
    }
}
