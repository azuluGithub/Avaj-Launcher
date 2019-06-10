package azulu.ritefile;

import java.io.*;
import java.util.*;

/* 1)-array list for storing messages
 * 2)-error hanndling in case of failure to write on file
 * 3)-buffered writer writes messages from array list to simulation.txt file
*/

public class RiteFile {
    /*1*/
	public static List<String>messages = new ArrayList <String>();

	public static void addMessageToFile() {
        /*2*/
        try {
            /*3*/
            BufferedWriter bW = new BufferedWriter(new FileWriter("simulation.txt"));
            for(String msg: messages){
                bW.write(msg);
                bW.append('\n');
            }
            bW.flush();
            bW.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
