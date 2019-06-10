package azulu.ritefile;

import java.io.*;
import java.util.*;
import azulu.aircrafts.AircraftFactory;
import azulu.weather.Flyable;

/* 1)-array list stores created aircrafts
 * 2)-error handling in case of failure to read from scenario file
 * 3)-buffered reader used to read from a file
 * 4)-number of simulations to be run which are read from scenario file
 * 5)-aircraft created using Factory method and stored on array list
*/

public class RidFile {
	
	/*1*/
	public List<Flyable> f = new ArrayList<Flyable>();
	public int numOfCycles;
	
	public void ridFile(String[] array) {
		/*2*/
		try {
			/*3*/
			BufferedReader br = new BufferedReader( new InputStreamReader(new FileInputStream(array[0])));
			String s = br.readLine();
			/*4*/
			numOfCycles = Integer.parseInt(s.split(" ")[0]);
			if (s != null) {
				while ((s = br.readLine()) != null) {
					/*5*/
					f.add(new AircraftFactory().newAircraft(s.split(" ")[0],
							s.split(" ")[1],
							Integer.parseInt(s.split(" ")[2]),
							Integer.parseInt(s.split(" ")[3]),
							Integer.parseInt(s.split(" ")[4])));
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("No such file or directory " + array[0]);
		} catch (IOException e) {
			System.out.println("There was an error while reading the file ");
		} catch (ArrayIndexOutOfBoundsException e) {
	        System.out.println("Specify simulation file");	
		} catch (Exception e) {
	        System.out.println(e.getMessage());
		}
	}
}
