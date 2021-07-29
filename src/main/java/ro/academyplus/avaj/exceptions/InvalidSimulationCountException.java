package ro.academyplus.avaj.exceptions;

public class InvalidSimulationCountException extends RuntimeException {
    public InvalidSimulationCountException(String message) {
        super("Invalid count of simulation's iterations: " + message);
    }
}