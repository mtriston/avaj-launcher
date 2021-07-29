package ro.academyplus.avaj.exceptions;

public class IllegalAircraftTypeException extends RuntimeException {
    public IllegalAircraftTypeException(String message) {
        super("Unknown type of aircraft: " + message);
    }
}
