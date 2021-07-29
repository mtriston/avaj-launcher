package ro.academyplus.avaj.aircrafts;

import ro.academyplus.avaj.environment.Coordinates;
import ro.academyplus.avaj.exceptions.IllegalWeatherException;
import ro.academyplus.avaj.towers.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {
    
    private WeatherTower weatherTower;

    public JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    @Override
    public void updateConditions() {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();
        String weather = weatherTower.getWeather(coordinates);
        switch (weather) {
            case "SUN" :
                logger.log(this + ": The sun shines directly into the eyes");
                latitude += 10;
                height = Math.min(height + 2, 100);
                break;
            case "RAIN" :
                logger.log(this + ":  It's raining. Better watch out for lightings.");
                latitude += 5;
                break;
            case "FOG" :
                logger.log(this + ": I must go in, the fog is rising.");
                latitude += 1;
                break;
            case "SNOW" :
                logger.log(this + ": : OMG! Winter is coming!");
                height = Math.max(0, height - 7);
                break;
            default :
                throw new IllegalWeatherException("Unknown weather '" + weather + "'");
        }
        this.coordinates.setCoordinates(longitude, latitude, height);
        if (height == 0) {
            logger.log(this + " landing.");
            weatherTower.unregister(this);
        }
    }

    @Override
    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        this.weatherTower = weatherTower;
    }

    @Override
    public String toString() {
        return "JetPlane#" + name + "(" + id + ")";
    }
}
