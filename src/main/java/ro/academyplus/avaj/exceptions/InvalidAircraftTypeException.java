package ro.academyplus.avaj.exceptions;

public class InvalidAircraftTypeException extends RuntimeException {
    public InvalidAircraftTypeException(String message) {
        super("Unknown type of aircraft: " + message);
    }
}
