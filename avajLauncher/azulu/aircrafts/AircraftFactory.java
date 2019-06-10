package azulu.aircrafts;

import azulu.aircrafts.Baloon;
import azulu.aircrafts.Helicopter;
import azulu.aircrafts.JetPlane;
import azulu.weather.Flyable;

/*1)-coordinate object is created because its used by aircrafts
 *2)-aircraft object created based on type of aircraft passed from file
 *3)-if type doesn't exist the program quits
*/

public class AircraftFactory {

	private int longitude;
	private int latitude;
	private int height;
	private String name;
	private String type;

	public Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {	
		
		this.type = type;
		this.name = name;
		this.longitude = longitude;
		this.latitude = latitude;
		this.height = height;
		/*1*/
		Coordinates coord = new Coordinates(this.longitude, this.latitude, this.height);
		/*2*/
		if (this.type.equalsIgnoreCase("Helicopter")) {
			return new Helicopter(this.name, coord);
		} else if (this.type.equalsIgnoreCase("JetPlane")) {
			return new JetPlane(this.name, coord);
		} else if (this.type.equalsIgnoreCase("Baloon")) {
			return new Baloon(this.name, coord);
		} else {
			/*3*/
			System.out.println("The type of aircraft doesnt exist.");
			System.exit(1);
		}
		return null;
	}
}
