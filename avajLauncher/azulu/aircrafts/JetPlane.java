package azulu.aircrafts;

import azulu.aircrafts.Aircraft;
import azulu.ritefile.*;
import azulu.weather.*;

/*1)-This class is a child class so it inherits attributes
 * and methods from parent class
 *2)-it implements all flayble class methods
 *3)-we access weatherTower class which is passed in through
 *   registerTower method
 *4)-when a class constructor is called, a superClass creates a new
 *   aircraft with a unique ID
 *5)-the generated weather is used to increase/decrease aircraft's 
 *   height, latitude, longitude
 *   coords are updated on this class
 *6)-messages are stored on array list
 *7)-if height is <= 0 the aircraft unregisters from tower
 *8)-a created aircraft is registered to the tower
*/
					   /*1*/				/*2*/
public class JetPlane extends Aircraft implements Flyable {
	/*3*/
	private WeatherTower weatherTower;
	/*4*/
	JetPlane(String name, Coordinates coordinates){
		super(name, coordinates);
	}
	public void updateConditions() {
		/*5*/
		String theWeather = this.weatherTower.getWeather(this.coordinates);
		if (theWeather.equalsIgnoreCase("RAIN")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 5, this.coordinates.getHeight() - 5);
			/*6*/
			RiteFile.messages.add("JetPlane#" + this.name + "(" + this.id + ")" + ": The clouds are crying!");
		} else if (theWeather.equalsIgnoreCase("FOG")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 1, this.coordinates.getHeight() - 5);
			RiteFile.messages.add("JetPlane#" + this.name + "(" + this.id + ")" + ": Giants are smoking. Can't see clearly");
		} else if (theWeather.equalsIgnoreCase("SUN")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude() + 10, this.coordinates.getHeight() + 2);
			RiteFile.messages.add("JetPlane#" + this.name + "(" + this.id + ")" + ": Nice sun, its summertime");
		} else if (theWeather.equalsIgnoreCase("SNOW")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 7);
			RiteFile.messages.add("JetPlane#" + this.name + "(" + this.id + ")" + ": This white thingy makes me cold");
		}
		/*7*/
		unregisterTower();
	}
	/*8*/
	public void registerTower(WeatherTower weatherTower) {
		/*3*/
		this.weatherTower = weatherTower;
		this.weatherTower.addNewFlyables(this);
		RiteFile.messages.add("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " has registered to weather tower");
	}
	
	private void unregisterTower() {
		if (this.coordinates.getHeight() == 0) {
			this.weatherTower.removeFlyables(this);
			RiteFile.messages.add("JetPlane#" + this.name + "(" + this.id + ") landing.");
			RiteFile.messages.add("Tower says: JetPlane#" + this.name + "(" + this.id + ")" + " has unregistered from weather tower");
		}
	}
}
