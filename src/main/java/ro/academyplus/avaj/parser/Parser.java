package ro.academyplus.avaj.parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import ro.academyplus.avaj.aircrafts.AircraftFactory;
import ro.academyplus.avaj.aircrafts.Flyable;
import ro.academyplus.avaj.exceptions.IllegalCoordinatesException;
import ro.academyplus.avaj.exceptions.InvalidFormatException;
import ro.academyplus.avaj.exceptions.InvalidSimulationCountException;
import ro.academyplus.avaj.simulator.Simulator;

public class Parser {
    private Scanner scanner;

    public Simulator parseScenario(String filename) throws FileNotFoundException {
        scanner = new Scanner(new File(filename));
        return new Simulator(parseNumOfIterations(), parseAircrafts());
    }

    private int parseNumOfIterations() {
        int n;
        String firstLine = null;
        try {
            firstLine = scanner.nextLine();
            n = Integer.parseInt(firstLine);
        } catch (NumberFormatException e) {
            throw new InvalidSimulationCountException(firstLine);
        } catch (NoSuchElementException e) {
            throw new InvalidFormatException("scenario file is blank.");
        }
        if (n <= 0) {
            throw new InvalidSimulationCountException(firstLine);
        }
        return n;
    }

    private List<Flyable> parseAircrafts() {
        List<Flyable> aircrafts = new ArrayList<>();
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] tokens = line.split(" ");
            if (tokens.length != 5) {
                throw new InvalidFormatException(line);
            }
            try {
                aircrafts.add(
                    AircraftFactory.newAircraft(
                        tokens[0],
                        tokens[1],
                        Integer.parseInt(tokens[2]),
                        Integer.parseInt(tokens[3]),
                        Integer.parseInt(tokens[4])
                    )
                );
            } catch (NumberFormatException e) {
                throw new IllegalCoordinatesException(String.format("%s %s %s", tokens[2], tokens[3], tokens[4]));
            }
            
        }
        return aircrafts;
    }
}
