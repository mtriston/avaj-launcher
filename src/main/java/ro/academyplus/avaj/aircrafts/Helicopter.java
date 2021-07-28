package ro.academyplus.avaj.aircrafts;

import ro.academyplus.avaj.environment.Coordinates;
import ro.academyplus.avaj.towers.WeatherTower;
import ro.academyplus.avaj.exceptions.IllegalWeatherException;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Helicopter(String name, Coordinates coordinates) {
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
                logger.log(this + ": This is hot.");
                longitude += 10;
                height = Math.min(height + 2, 100);
                break;
            case "RAIN" :
                logger.log(this + ": It’s raining cats and dogs!");
                longitude += 5;
                break;
            case "FOG" :
                logger.log(this + ": I can't see my own nose.");
                longitude += 1;
                break;
            case "SNOW" :
                logger.log(this + ": My rotor is going to freeze!");
                height = Math.max(0, height - 12);
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
        return "Helicopter#" + name + "(" + id + ")";
    }
    
    
}
