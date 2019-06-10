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
 *   coordinates are updated on this class
 *6)-messages are stored on array list
 *7)-if height is <= 0 the aircraft unregisters from tower
 *8)-a created aircraft is registered to the tower
*/
					     /*1*/				/*2*/
public class Helicopter extends Aircraft implements Flyable {
    /*3*/
	private WeatherTower weatherTower;
	/*4*/
	Helicopter(String name, Coordinates coordinates){
		super(name, coordinates);
	}
	
	public void updateConditions() {
		/*5*/
		String theWeather = this.weatherTower.getWeather(this.coordinates);
		if (theWeather.equalsIgnoreCase("RAIN")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 5, this.coordinates.getLatitude(), this.coordinates.getHeight());
			/*6*/
			RiteFile.messages.add("Helicopter#" + this.name + "(" + this.id + ")" + ": Damn you rain! You messed up my baloon");
		} else if (theWeather.equalsIgnoreCase("FOG")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 1, this.coordinates.getLatitude(), this.coordinates.getHeight());
			RiteFile.messages.add("Helicopter#" + this.name + "(" + this.id + ")" + ": Can't see a thing!");
		} else if (theWeather.equalsIgnoreCase("SUN")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude() + 10, this.coordinates.getLatitude(), this.coordinates.getHeight() + 2);
			RiteFile.messages.add("Helicopter#" + this.name + "(" + this.id + ")" + ": This is hot.");
		} else if (theWeather.equalsIgnoreCase("SNOW")) {
			this.coordinates = new Coordinates(this.coordinates.getLongitude(), this.coordinates.getLatitude(), this.coordinates.getHeight() - 12);
			RiteFile.messages.add("Helicopter#" + this.name + "(" + this.id + ")" + ": It's snowing. We're gonna crash");
		}
		/*7*/
		unregisterTower();
	}
	/*8*/
	public void registerTower(WeatherTower weatherTower) {
		/*3*/
		this.weatherTower = weatherTower;
		this.weatherTower.addNewFlyables(this);
		RiteFile.messages.add("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " has registered to weather tower");
	}
	
	private void unregisterTower() {
		if (this.coordinates.getHeight() == 0) {
			this.weatherTower.removeFlyables(this);
			RiteFile.messages.add("Helicopter#" + this.name + "(" + this.id + ") landing.");
			RiteFile.messages.add("Tower says: Helicopter#" + this.name + "(" + this.id + ")" + " has unregistered from weather tower");
		}
	}
}

