package avajLauncher.main;

import avajLauncher.utils.*;
import avajLauncher.weather.Simulator;

/**
 * this is the entry point of my Avaj Launcher program
 * @author azulu
 */
public class Main {

    /**
     * main function reads from an input file (scenario.txt), run simulations based on input file, and write on outputfile (simulation.txt)
     * @param args
     */
    public static void main(String[] args) {
        FileReading fr = new FileReading();
        Simulator sim = new Simulator();

        fr.readFromFile(args);
        sim.simulate(fr);
        FileWriting.writeToFile();
    }
}
