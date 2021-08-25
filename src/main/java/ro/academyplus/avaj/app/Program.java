package ro.academyplus.avaj.app;

import ro.academyplus.avaj.simulator.Simulator;

import java.io.FileNotFoundException;

import ro.academyplus.avaj.parser.Parser;

public class Program {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Expected path to file with scenario.");
            System.exit(-1);
        }
        try {
            Simulator simulator = new Parser().parseScenario(args[0]);
            simulator.run();
        } catch (FileNotFoundException e) {
            System.err.println("Invalid scenario file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }
}
