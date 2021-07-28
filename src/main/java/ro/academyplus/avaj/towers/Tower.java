package ro.academyplus.avaj.towers;

import java.util.LinkedList;
import java.util.List;

import ro.academyplus.avaj.aircrafts.Flyable;
import ro.academyplus.avaj.writer.SimulatorLogger;

public abstract class Tower {
    private SimulatorLogger logger = SimulatorLogger.getInstance();
    private List<Flyable> observers = new LinkedList<>();
    private List<Flyable> unregistered = new LinkedList<>();

    public void register(Flyable flyable) {
        logger.log("Tower says: " + flyable + " registered to weather tower.");
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        logger.log("Tower says: " + flyable + " unregistered to weather tower.");
        unregistered.add(flyable);
    }

    protected void conditionsChanged() {
        for (Flyable flyable : observers) {
            flyable.updateConditions();
        }
        observers.removeAll(unregistered);
        unregistered.clear();
    }
}
