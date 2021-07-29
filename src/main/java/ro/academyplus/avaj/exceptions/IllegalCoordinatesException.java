package ro.academyplus.avaj.exceptions;

public class IllegalCoordinatesException extends IllegalArgumentException {
    public IllegalCoordinatesException(String message) {
        super("Invalid coordinates: " + message);
    }
}
