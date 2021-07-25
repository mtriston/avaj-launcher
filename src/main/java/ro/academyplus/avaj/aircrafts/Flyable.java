package ro.academyplus.avaj.aircrafts;

import ro.academyplus.avaj.towers.WeatherTower;

public interface Flyable {
    void updateConditions();
    void registerTower(WeatherTower weatherTower);
}
