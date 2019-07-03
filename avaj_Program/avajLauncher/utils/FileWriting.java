package avajLauncher.utils;

import java.io.*;
import java.util.*;

import static avajLauncher.utils.CustomeErrors.*;

public class FileWriting {

    public static List<String> messages = new ArrayList <String>();

    public static void writeToFile() {

        try {
            if (!messages.isEmpty()) {
                BufferedWriter bW = new BufferedWriter(new FileWriter("simulation.txt"));
                for (String msg : messages) {
                    bW.write(msg);
                    bW.append('\n');
                }
                bW.flush();
                bW.close();
                System.out.println(GREEN + "Simulations where performed successfully!" + RESET);
            } else {
                System.out.println(RED + "Error : Line 1 must contain a number, and all other lines must have five parameters per line" + RESET);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
