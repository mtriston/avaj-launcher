package ro.academyplus.avaj.writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class SimulatorLogger {
    private static String logFile = "simulation.txt";
    private static SimulatorLogger simulatorLogger;

    private SimulatorLogger() {
        try {
            Files.createFile(Paths.get(logFile));
        } catch (IOException e) {
        }
    }

    public static SimulatorLogger getInstance() {
        if (simulatorLogger == null) {
            simulatorLogger = new SimulatorLogger();
        }
        return simulatorLogger;
    }

    public void log(String message) {
        try {
            Files.write(Paths.get(logFile), message.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}