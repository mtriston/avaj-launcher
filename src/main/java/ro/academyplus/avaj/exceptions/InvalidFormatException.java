package ro.academyplus.avaj.exceptions;

public class InvalidFormatException extends RuntimeException {
    public InvalidFormatException(String message) {
        super("Invalid format of simulation's case: " + message);
    }
}
