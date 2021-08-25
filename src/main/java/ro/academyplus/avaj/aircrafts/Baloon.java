package ro.academyplus.avaj.aircrafts;

import ro.academyplus.avaj.environment.Coordinates;
import ro.academyplus.avaj.towers.WeatherTower;
import ro.academyplus.avaj.exceptions.InvalidWeatherException;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    public Baloon(String name, Coordinates coordinates) {
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
                logger.log(this + ": Let's enjoy the good weather and take some pics.");
                longitude += 2;
                height = Math.min(height + 4, 100);
                break;
            case "RAIN" :
                logger.log(this + ": Damn you rain! You messed up my baloon.");
                height = Math.max(0, height - 5);
                break;
            case "FOG" :
                logger.log(this + ": How not to get lost ...");
                height = Math.max(0, height - 3);
                break;
            case "SNOW" :
                logger.log(this + ": Christmas is coming soon!");
                height = Math.max(0, height - 15);
                break;
            default :
                throw new InvalidWeatherException("Unknown weather '" + weather + "'");
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
        return "Baloon#" + name + "(" + id + ")";
    }
}

