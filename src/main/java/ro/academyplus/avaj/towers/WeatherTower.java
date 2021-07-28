package ro.academyplus.avaj.towers;

import ro.academyplus.avaj.environment.Coordinates;
import ro.academyplus.avaj.environment.WeatherProvider;

public class WeatherTower extends Tower {
    public String getWeather(Coordinates coordinates) {
        return WeatherProvider.getProvider().getCurrentWeather(coordinates);
    }

    public void changeWeather() {
        super.conditionsChanged();
    }
}
