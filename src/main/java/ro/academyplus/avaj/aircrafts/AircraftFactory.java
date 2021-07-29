package ro.academyplus.avaj.aircrafts;

import ro.academyplus.avaj.environment.Coordinates;
import ro.academyplus.avaj.exceptions.IllegalAircraftTypeException;
import ro.academyplus.avaj.exceptions.IllegalCoordinatesException;

public class AircraftFactory {
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        if (longitude <= 0 || latitude <= 0 || height < 0 || height > 100) {
            throw new IllegalCoordinatesException();
        }
        Coordinates coordinates = new Coordinates(longitude, latitude, height);
        switch (type.toLowerCase()) {
            case "helicopter" :
                return new Helicopter(name, coordinates);
            case "jetplane" :
                return new JetPlane(name, coordinates);
            case "baloon" :
                return new Baloon(name, coordinates);
            default :
                throw new IllegalAircraftTypeException();
        }
    }
}
