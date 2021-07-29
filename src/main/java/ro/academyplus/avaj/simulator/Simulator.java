package ro.academyplus.avaj.simulator;

import java.util.List;

import ro.academyplus.avaj.aircrafts.Flyable;
import ro.academyplus.avaj.towers.WeatherTower;

public class Simulator {

    private WeatherTower tower;
    private List<Flyable> aircrafts;
    private int numOfIterations;

    public Simulator(int n, List<Flyable> aircrafts) {
        this.numOfIterations = n;
        this.aircrafts = aircrafts;
    }

    public void run() {
        tower = new WeatherTower();
        for (Flyable aircraft : aircrafts) {
            aircraft.registerTower(tower);
        }
        for (int i = 0; i < numOfIterations; ++i) {
            tower.changeWeather();
        }
    }
}
