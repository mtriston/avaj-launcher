package ro.academyplus.avaj.aircrafts;

import ro.academyplus.avaj.environment.Coordinates;
import ro.academyplus.avaj.writer.SimulatorLogger;

public abstract class Aircraft {
    protected long id;
    protected String name;
    protected Coordinates coordinates;
    protected SimulatorLogger logger = SimulatorLogger.getInstance();
    private static long idCounter;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    private long nextId() {
        return ++idCounter;
    }
}